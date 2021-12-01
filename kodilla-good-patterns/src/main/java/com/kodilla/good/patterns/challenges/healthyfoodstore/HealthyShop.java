package com.kodilla.good.patterns.challenges.healthyfoodstore;

public class HealthyShop implements OrderProcessor {
    private double shippingPrice = 10.8;
    private int shippingDays = 2;
    Order order;
    Product product;

    public HealthyShop(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    public double calculateTotalPrice() {
        return (order.quantity * product.getPrice()) + shippingPrice;
    }

    public void process() {
        System.out.println("Shipping price: " + shippingPrice);
        System.out.println("Shipping days: " + shippingDays);
        System.out.println("Total proce: " + calculateTotalPrice());
    }

    public String getShopName() {
        return "Healthy Shop";
    }
}
