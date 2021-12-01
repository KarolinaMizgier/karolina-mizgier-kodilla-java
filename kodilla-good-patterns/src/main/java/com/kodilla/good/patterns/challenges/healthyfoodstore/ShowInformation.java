package com.kodilla.good.patterns.challenges.healthyfoodstore;

public class ShowInformation {
    public static void showInfo(ProductInventory inventory, Order order, Product product, OrderProcessor shop, UserProfile user) {
        System.out.println("Is product ordered: " + inventory.isAvaliable(product));
        if (inventory.isAvaliable(product)) {
            System.out.println("Ordered items: ");
            order.showProducts();
            System.out.println("Item ordered form: " + shop.getShopName());
            System.out.println("Items ordered by: " + user.getName() + " " + user.getLastName());
            shop.process();
            inventory.deleteItem(product);
        } else {
            System.out.println("Item is not avaliable");
        }
    }
}
