package com.kodilla.good.patterns.challenges.healthyfoodstore;

public class Product {
    private String productName;
    private double price;
    private boolean isAvaliable;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}
