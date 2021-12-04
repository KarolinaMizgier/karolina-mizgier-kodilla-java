package com.kodilla.good.patterns.challenges.productorder.challenge;

import java.math.BigDecimal;
import java.util.*;

public class ProductInventory {
    String path = "./kodilla-good-patterns/src/main/resources/products.txt";


    private static Map<String, ItemInfo> itemsInStore = new HashMap<>() {{
        put("mug", new ItemInfo(BigDecimal.valueOf(30.50), 8));
        put("socks blue", new ItemInfo(BigDecimal.valueOf(10.95), 10));
        put("socks red", new ItemInfo(BigDecimal.valueOf(10.25), 32));
        put("notebook", new ItemInfo(BigDecimal.valueOf(8.49), 11));
        put("pen", new ItemInfo(BigDecimal.valueOf(4.78), 10));
    }};

    public static Map<String, ItemInfo> getItemsInStore() {
        return itemsInStore;
    }

    public static void updateInventory(OrderItem order) {
        Map<Item, Integer> items = order.getItems();
        items.entrySet().forEach(entry -> {
            String itemName = entry.getKey().getProductName();
            int orderedQuantity = entry.getValue();

            itemsInStore.entrySet().forEach(entry2 -> {
                String itemNameInStore = entry2.getKey();
                int itemQuantityInStore = entry2.getValue().getQuantity();

                if (itemName.equals(itemNameInStore)) {
                    int newQuantity = itemQuantityInStore - orderedQuantity;
                    entry2.getValue().setQuantity(newQuantity);
                }
            });
        });
    }

}

