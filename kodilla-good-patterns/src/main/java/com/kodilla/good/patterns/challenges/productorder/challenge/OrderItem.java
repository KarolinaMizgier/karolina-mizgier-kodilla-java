package com.kodilla.good.patterns.challenges.productorder.challenge;

import com.kodilla.good.patterns.challenges.healthyfoodstore.Product;

public class OrderItem {
    private final Item item;
    private final int quantity;
    private final User user;
    private DeliveryService delivery;
    private UserNotification notification;

    public OrderItem(Item item, int quantity, User user, DeliveryService delivery, UserNotification notification) {
        this.item = item;
        this.quantity = quantity;
        this.user = user;
        this.delivery = delivery;
        this.notification = notification;
    }

    public DeliveryService getDelivery() {
        return delivery;
    }

    public UserNotification getNotification() {
        return notification;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public User getUser() {
        return user;
    }
}
