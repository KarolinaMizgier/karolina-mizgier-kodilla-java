package com.kodilla.good.patterns.challenges.healthyfoodstore;

public class Application {
    public static void main(String args[]) {

        Producer healthyShop = new HealthyShop();
        Producer glutenFree = new GlutenFreeShop();
        Producer extraFoodShop = new ExtraFoodShop();

        UserProfile adam = new UserProfile("Adam", "Nowak", "Mickiewicza 5, 80-284 Gdansk");

        Product extraPotatos = new Product("potatos", ExtraFoodShop.SHOP_NAME);
        Product cookiesChoco = new Product("cookiesChoco", GlutenFreeShop.SHOP_NAME);
        Product carrotJuice = new Product("carrotJuice", HealthyShop.SHOP_NAME);
        Order order1 = new Order(extraPotatos, 7, adam);
        Order order2 = new Order(cookiesChoco, 10, adam);
        Order order3 = new Order(carrotJuice,20,adam);

        extraFoodShop.process(order1);
        ShowInformation.showInfo(order1);

       glutenFree.process(order2);
        ShowInformation.showInfo(order2);

        healthyShop.process(order3);
        ShowInformation.showInfo(order3);

    }
}
