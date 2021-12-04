package com.kodilla.good.patterns.challenges.healthyfoodstore;

import java.math.BigDecimal;
import java.util.Map;

public class Order {
    private final Map<Product,Integer> products;
    private BigDecimal totalPrice;
    private final UserProfile user;

    public Order(Map<Product,Integer> products, UserProfile user) {
        this.products = products;
        this.user = user;
    }

    public Map<Product,Integer> getProducts(){
        return products;
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

