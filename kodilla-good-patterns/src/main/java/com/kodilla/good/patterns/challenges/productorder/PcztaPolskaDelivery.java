package com.kodilla.good.patterns.challenges.productorder;

public class PcztaPolskaDelivery implements DeliveryService {
    Double price = 10.4;

    public double deliverBy() {
        return price;
    }
}
