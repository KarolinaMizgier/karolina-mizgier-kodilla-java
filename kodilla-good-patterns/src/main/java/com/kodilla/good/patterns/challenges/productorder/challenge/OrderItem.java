package com.kodilla.good.patterns.challenges.productorder.challenge;

import java.util.Map;

public class OrderItem {
    private final Map<Item, Integer> items;
    private final User user;
    private DeliveryService delivery;
    private UserNotification notification;

    public OrderItem(Map<Item, Integer> items, User user, DeliveryService delivery, UserNotification notification) {
        this.items = items;
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

    public Map<Item, Integer> getItems() {
        return items;
    }


    public User getUser() {
        return user;
    }
}
