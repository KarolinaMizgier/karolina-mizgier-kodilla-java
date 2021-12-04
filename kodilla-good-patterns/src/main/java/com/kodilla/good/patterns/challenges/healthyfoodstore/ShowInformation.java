package com.kodilla.good.patterns.challenges.healthyfoodstore;

import java.util.Map;

public class ShowInformation {
    public static void showInfo(Order order) {
        Map<Product,Integer> products = order.getProducts();
        System.out.println("---------------------------------------------");
        products.entrySet().forEach(entry->{
            System.out.println("Producer: " + entry.getKey().getProducerName());
            System.out.println("Order product: " + entry.getKey().getProductName());
            System.out.println("Order quantity: " + entry.getValue());
        });
        System.out.println("Total price: " + order.getTotalPrice());
        UserProfile user = order.getUser();
        System.out.println("Customer: " + user.getName() + " " + user.getLastName());
        System.out.println("---------------------------------------------");
    }
}
