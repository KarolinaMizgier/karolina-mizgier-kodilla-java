package com.kodilla.good.patterns.challenges.productorder.challenge;

public class PcztaPolskaDelivery implements DeliveryService {
    Double price = 10.4;

    public double deliveryPrice() {
        return price;
    }
}
