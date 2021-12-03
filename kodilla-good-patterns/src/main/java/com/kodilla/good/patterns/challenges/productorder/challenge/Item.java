package com.kodilla.good.patterns.challenges.productorder.challenge;

public class Item {
    private String productName;
    private double price;

    public Item(String productName, double price) {
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
