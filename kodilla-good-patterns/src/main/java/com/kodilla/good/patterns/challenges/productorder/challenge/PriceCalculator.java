package com.kodilla.good.patterns.challenges.productorder.challenge;

public class PriceCalculator {
    private Item item;
    private DeliveryService delivery;

//TODO zależności od obiektow do metody
    public double calculateTotalPrice(Item item, DeliveryService delivery) {
        return item.getPrice();// + delivery.deliverBy();
    }
}
