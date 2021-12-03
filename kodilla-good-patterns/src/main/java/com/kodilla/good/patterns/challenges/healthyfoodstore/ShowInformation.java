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

//        System.out.println("Is product ordered: " + inventory.isAvaliable(product));
//        if (inventory.isAvaliable(product)) {
//            System.out.println("Ordered items: ");
//            order.showProducts();
//            System.out.println("Item ordered form: " + shop.getShopName());
//            System.out.println("Items ordered by: " + user.getName() + " " + user.getLastName());
//            //shop.process(order, product);
//            inventory.deleteItem(product);
//        } else {
//            System.out.println("Item is not avaliable");
//        }
    }
}
