package com.kodilla.good.patterns.challenges.productorder;

public class PriceCalculator {
    private Product product;
    private DeliveryService delivery;

    public PriceCalculator(Product product, DeliveryService delivery) {
        this.product = product;
        this.delivery = delivery;
    }

    public double calculateTotalPrice() {
        return product.getPrice() + delivery.deliverBy();
    }
}
