package com.kodilla.good.patterns.challenges.productorder.challenge;

public class DhlDelivery implements DeliveryService {
    private double price = 18.5;

    public double deliveryPrice() {
        return price;
    }
    public String deliveredBy(){
        return "DHL Delivery";
    }
}

