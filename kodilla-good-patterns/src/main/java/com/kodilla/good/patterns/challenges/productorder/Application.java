package com.kodilla.good.patterns.challenges.productorder;

public class Application {
    public static void main(String[] args) {
        ProductInventory inventory = new ProductInventory();
        Product mug = new Product("mug blue", 15);
        User adam = new User("Adam", "Nowak", "Mickiewicza 5, 80-284 Gdansk");
        DeliveryService delivery = new PcztaPolskaDelivery();
        UserNotification notification = new EmailNotification();
        ProductOrderService orderService = new ProductOrderService(mug, adam, inventory);
        PriceCalculator priceCalculator = new PriceCalculator(mug, delivery);
        boolean isOrdered = orderService.isOrdered();

        System.out.println("Is product ordered: " + isOrdered);
        if (isOrdered) {
            System.out.println(notification.notifyUser());
            System.out.println("Total price: " + priceCalculator.calculateTotalPrice());
            inventory.deleteItem(mug);
        } else {
            System.out.println("Item is not avaliable");
        }


    }
}
