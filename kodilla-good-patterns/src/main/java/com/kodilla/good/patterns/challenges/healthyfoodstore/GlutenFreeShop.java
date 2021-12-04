package com.kodilla.good.patterns.challenges.healthyfoodstore;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class GlutenFreeShop implements Producer {
    public static final String SHOP_NAME = "Gluten Free Shop";
    private double shippingPrice = 18;
    private int shippingDays = 4;
    Map<Product, Integer> products;
    private double tempSum;

    private Map<String, BigDecimal> prices = new HashMap<>() {{
        put("pizzaDough", BigDecimal.valueOf(9.50));
        put("bread", BigDecimal.valueOf(6.95));
        put("cake", BigDecimal.valueOf(12.25));
        put("cookiesChoco", BigDecimal.valueOf(20.25));
        put("cookies", BigDecimal.valueOf(17.78));
    }};
    private Map<String, Integer> inventory = new HashMap<>() {{
        put("pizzaDough", 10);
        put("bread", 20);
        put("cake", 15);
        put("cookiesChoco", 20);
        put("cookies", 30);
    }};

    public void updateInventory(Order order) {
        products = order.getProducts();
        products.entrySet().forEach(entry -> {
            String name = entry.getKey().getProductName();
            int quantity = inventory.get(name);
            int newQuantity = quantity - entry.getValue();
            inventory.put(name, newQuantity);
        });

    }

    public void process(Order order) {
        double price = calculateTotalPrice(order);
        if (price >= 200) {
            price = price * 0.7;
            System.out.println("When you buy products for over 200 zl you get 30% discount!");
        }
        order.setTotalPrice(BigDecimal.valueOf(price).setScale(2, RoundingMode.CEILING));
        updateInventory(order);
        System.out.println("Updated inventory: ");
        inventory.entrySet().forEach(entry -> {
            System.out.println("Product: " + entry.getKey() + " Quantity: " + entry.getValue());
        });
    }

    private double calculateTotalPrice(Order order) {
        products = order.getProducts();
        products.entrySet().forEach(entry -> {
            String productName = entry.getKey().getProductName();
            int quantity = entry.getValue();
            if (prices.containsKey(productName)) {
                if (quantity <= inventory.get(productName)) {
                    BigDecimal price = prices.get(productName);
                    tempSum += quantity * price.doubleValue();
                } else {
                    System.out.println("Not enough product in store.");
                }
            }else {
                System.out.println(String.format("INFO: Cannot calculate total price shop %s does not offer product: %s",
                        SHOP_NAME, productName));
                tempSum += 0;
            }

        });
        return tempSum + shippingPrice;
    }
}

