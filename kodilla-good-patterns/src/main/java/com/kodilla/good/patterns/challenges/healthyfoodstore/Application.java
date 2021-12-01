package com.kodilla.good.patterns.challenges.healthyfoodstore;

public class Application {
    public static void main(String args[]) {

        Product potatos = new Product("potatos", 20);
        UserProfile adam = new UserProfile("Adam", "Nowak", "Mickiewicza 5, 80-284 Gdansk");
        Order order = new Order(potatos, 3, adam);

        Product bread = new Product("bread", 9.6);
        UserProfile magda = new UserProfile("Magdalena", "Kowalska", "Grunwaldzka 39, 80-284 Gdansk");
        Order order2 = new Order(bread, 5, magda);

        Product salad = new Product("salad", 20);
        UserProfile ania = new UserProfile("Anna", "Nowak", "Lotnicza 7, 80-284 Gdansk");
        Order order3 = new Order(salad, 6, ania);

        String extraFoodShop = "./kodilla-good-patterns/src/main/resources/ExtraFoodShop.txt";
        String GlutenFreeShop = "./kodilla-good-patterns/src/main/resources/GlutenFreeShop.txt";
        String HealthyShop = "./kodilla-good-patterns/src/main/resources/HealthyShop.txt";

        ProductInventory inventory = new ProductInventory(extraFoodShop, order);
        ProductInventory inventory1 = new ProductInventory(GlutenFreeShop, order2);
        ProductInventory inventory2 = new ProductInventory(HealthyShop, order3);
        OrderProcessor shop = new ExtraFoodShop(order, potatos);
        OrderProcessor shop2 = new GlutenFreeShop(order2, bread);
        OrderProcessor shop3 = new HealthyShop(order3, salad);

        ShowInformation.showInfo(inventory, order, potatos, shop, adam);
        ShowInformation.showInfo(inventory1, order2, bread, shop2, magda);
        ShowInformation.showInfo(inventory2, order3, salad, shop3, ania);


    }
}
