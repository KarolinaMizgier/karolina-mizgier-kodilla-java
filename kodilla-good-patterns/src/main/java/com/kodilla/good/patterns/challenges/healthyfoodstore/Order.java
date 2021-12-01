package com.kodilla.good.patterns.challenges.healthyfoodstore;

import java.util.HashMap;
import java.util.Map;

public class Order {
    Map<String, Integer> products = new HashMap<>();
    Product product;
    int quantity;
    UserProfile user;

    public Order(Product product, int quantity, UserProfile user) {
        this.product = product;
        this.quantity = quantity;
        this.user = user;
    }

    public void addProduct(Product product) {
        products.put(product.getProductName(), quantity);
    }

    public void showProducts() {
        addProduct(product);
        products.entrySet().forEach(entry -> {
            System.out.println("Item: " + entry.getKey() + " Quantity: " + entry.getValue());
        });
    }

    public Product getProduct() {
        return product;
    }

    public UserProfile getUser() {
        return user;
    }
}
