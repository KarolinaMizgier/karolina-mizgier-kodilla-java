package com.kodilla.good.patterns.challenges.productorder.challenge;

public class PriceCalculator {
    private Product product;
    private DeliveryService delivery;

//TODO zależności od obiektow do metody
    public double calculateTotalPrice(Product product, DeliveryService delivery) {
        return product.getPrice() + delivery.deliverBy();
    }
}
