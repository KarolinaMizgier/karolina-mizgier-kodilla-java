package com.kodilla.good.patterns.challenges.healthyfoodstore;

public class GlutenFreeShop implements OrderProcessor {
    private double shippingPrice = 18;
    private int shippingDays = 4;
    Order order;
    Product product;

    public GlutenFreeShop(Order order, Product product) {
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
        return "Gluten Free Shop";
    }
}
