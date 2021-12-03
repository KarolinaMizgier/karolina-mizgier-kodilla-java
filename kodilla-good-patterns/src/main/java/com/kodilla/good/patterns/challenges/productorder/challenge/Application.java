package com.kodilla.good.patterns.challenges.productorder.challenge;

public class Application {
    public static void main(String[] args) {
        ProductInventory inventory = new ProductInventory();
        Product mug = new Product("mug blue", 20);
        User adam = new User("Adam", "Nowak", "Mickiewicza 5, 80-284 Gdansk");
        DeliveryService delivery = new PcztaPolskaDelivery();
        UserNotification notification = new EmailNotification();



    }
}
