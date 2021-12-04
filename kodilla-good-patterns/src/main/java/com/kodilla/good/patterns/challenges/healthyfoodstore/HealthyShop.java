package com.kodilla.good.patterns.challenges.healthyfoodstore;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class HealthyShop implements Producer {
    public static final String SHOP_NAME = "Healthy Shop";
    private double shippingPrice = 10.8;
    private int shippingDays = 2;
    Map<Product, Integer> products;
    private double tempSum;

    private Map<ItemInfo, BigDecimal> inventory = new HashMap<>() {{
        put(new ItemInfo("smoothie", 30), BigDecimal.valueOf(5.80));
        put(new ItemInfo("eggs", 20), BigDecimal.valueOf(11.40));
        put(new ItemInfo("salad", 20), BigDecimal.valueOf(6.24));
        put(new ItemInfo("chips", 30), BigDecimal.valueOf(10.05));
        put(new ItemInfo("carrotJuice", 35), BigDecimal.valueOf(8.25));
    }};

    public void updateInventory(Order order) {
        products = order.getProducts();
        products.entrySet().forEach(entry -> {
            String name = entry.getKey().getProductName();
            int quantity = entry.getValue();

            inventory.entrySet().forEach(entry2 -> {
                if (name.equals(entry2.getKey().getProductName())) {
                    int quantityInStore = entry2.getKey().getQuantity();
                    entry2.getKey().setQuantity(quantityInStore - quantity);
                }
            });
        });
    }

    public void process(Order order) {
        double price = calculateTotalPrice(order);
        order.setTotalPrice(BigDecimal.valueOf(price).setScale(2, RoundingMode.CEILING));
        updateInventory(order);

        System.out.println("Updated inventory: ");
        inventory.entrySet().forEach(entry -> {
            System.out.println("Product: " + entry.getKey().getProductName() + " Quantity: " + entry.getKey().getQuantity());
        });
    }

    private double calculateTotalPrice(Order order) {
        products = order.getProducts();
        products.entrySet().forEach(entry -> {
            String name = entry.getKey().getProductName();
            int quantity = entry.getValue();

            inventory.entrySet().forEach(entry2 -> {
                int quantityInStore = entry2.getKey().getQuantity();

                if (quantity <= quantityInStore) {
                    ItemInfo itemInfo = entry2.getKey();
                    if (name.equals(itemInfo.getProductName())) {
                        BigDecimal price = inventory.get(itemInfo);
                        tempSum += quantity * price.doubleValue();
                    }
                } else {
                    System.out.println("Not enough products in store.");
                }
            });
        });
        return tempSum + shippingPrice;
    }

    private class ItemInfo {
        private String productName;
        private Integer quantity;

        public ItemInfo(String productName, Integer quantity) {
            this.productName = productName;
            this.quantity = quantity;
        }
        public String getProductName() {
            return productName;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }
}

