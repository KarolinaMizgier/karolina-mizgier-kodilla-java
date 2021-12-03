package com.kodilla.good.patterns.challenges.healthyfoodstore;

public class ShowInformation {
    public static void showInfo(Order order) {
        System.out.println("---------------------------------------------");
        System.out.println("Producer: " + order.getProduct().getProducerName());
        System.out.println("Order product: " + order.getProduct().getProductName());
        System.out.println("Order quantity: " + order.getQuantity());
        System.out.println("Total price: " + order.getTotalPrice());
        UserProfile user = order.getUser();
        System.out.println("Customer: " + user.getName() + " " + user.getLastName());
        System.out.println("---------------------------------------------");
    }
}
