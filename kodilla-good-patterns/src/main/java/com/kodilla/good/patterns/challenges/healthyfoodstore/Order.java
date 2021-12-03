package com.kodilla.good.patterns.challenges.healthyfoodstore;

import java.math.BigDecimal;

public class Order {
    private final Product product;
    private BigDecimal totalPrice;
    private final int quantity;
    private final UserProfile user;

    public Order(Product product, int quantity, UserProfile user) {
        this.product = product;
        this.quantity = quantity;
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public UserProfile getUser() {
        return user;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
