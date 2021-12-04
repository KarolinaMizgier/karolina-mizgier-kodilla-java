package com.kodilla.good.patterns.challenges.healthyfoodstore;

public class Product {
    private String productName;
    private String producerName;

    public Product(String productName, String producerName) {
        this.productName = productName;
        this.producerName = producerName;
    }

    public String getProductName() {
        return productName;
    }

    public String getProducerName() {
        return producerName;
    }
}

