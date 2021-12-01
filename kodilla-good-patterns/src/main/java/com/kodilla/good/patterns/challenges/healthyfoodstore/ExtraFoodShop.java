package com.kodilla.good.patterns.challenges.healthyfoodstore;

import com.kodilla.good.patterns.challenges.productorder.User;

import java.util.List;
import java.util.Map;

public class ExtraFoodShop implements OrderProcessor {

    private double shippingPrice = 15.5;
    private int shippingDays = 3;
    Order order;
    Product product;

    public ExtraFoodShop(Order order, Product product) {
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
        return "Extra Food Shop";
    }
}
