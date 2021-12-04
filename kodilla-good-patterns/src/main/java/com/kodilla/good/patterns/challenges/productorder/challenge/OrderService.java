package com.kodilla.good.patterns.challenges.productorder.challenge;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderService {
    private static List<String> info = new ArrayList<>();
    private static Map<Item, Integer> items;
    private static boolean temp = false;
    private static double tempPrice;
    private static String path = "./kodilla-good-patterns/src/main/resources/notification.txt";

    private static double calculateTotalPrice(OrderItem order) {
        items = order.getItems();
        items.entrySet().forEach(entry -> {
            String itemName = entry.getKey().getProductName();
            ItemInfo itemInfo = ProductInventory.getItemsInStore().get(itemName);
            BigDecimal itemPrice = itemInfo.getPrice();
            tempPrice = itemPrice.doubleValue() * entry.getValue();
        });
        return tempPrice + order.getDelivery().deliveryPrice();
    }

    private static boolean isOrdered(OrderItem order) {
        Map<String, ItemInfo> itemsInStore = ProductInventory.getItemsInStore();
        items = order.getItems();
        items.entrySet().forEach(entry -> {
            String itemName = entry.getKey().getProductName();
            int itemQuantity = entry.getValue();
            itemsInStore.entrySet().forEach(entry2 -> {
                if (itemName.equals(entry2.getKey())) {
                    if (itemQuantity <= entry2.getValue().getQuantity()) {
                        temp = true;
                    } else {
                        temp = false;
                    }
                }
            });
        });
        return temp;
    }

    public static void service(OrderItem order) {
        items = order.getItems();
        if (isOrdered(order)) {
            items.entrySet().forEach(entry -> {
                info.add("Ordered item: " + entry.getKey().getProductName());
                info.add("Items quantity: " + entry.getValue());
            });
            info.add("Item(s) ordered by: " + order.getUser().getName() + " " + order.getUser().getLastName());
            info.add("Total price: " + BigDecimal.valueOf(calculateTotalPrice(order)).setScale(2, RoundingMode.CEILING));
            info.add("Delivery: " + order.getDelivery().deliveredBy());
            info.add("Notification sent by: " + order.getNotification().notifyUser());
            ProductInventory.updateInventory(order);
            for (int i = 0; i < info.size(); i++) {
                System.out.println(info.get(i));
            }
            saveInfoToFile();
        } else {
            info.add("Not enough products available in store");
            System.out.println("Not enough products available in store");
        }
    }

    public static void saveInfoToFile() {
        try {
            FileWriter writer = new FileWriter(path);
            info.stream().forEach(line -> {
                try {
                    writer.append(line + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

