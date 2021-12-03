package com.kodilla.good.patterns.challenges.productorder.challenge;

import com.kodilla.good.patterns.challenges.healthyfoodstore.Product;

public class Order {
    private final Product product;

    private final int quantity;
    private final User user;
    private DeliveryService;
    private UserNotification;

    public Order(Product product, int quantity, User user) {
        this.product = product;
        this.quantity = quantity;
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public User getUser() {
        return user;
    }
}
