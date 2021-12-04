package com.kodilla.good.patterns.challenges.healthyfoodstore;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String args[]) {

        Producer healthyShop = new HealthyShop();
        Producer glutenFree = new GlutenFreeShop();
        Producer extraFoodShop = new ExtraFoodShop();

        UserProfile adam = new UserProfile("Adam", "Nowak", "Mickiewicza 5, 80-284 Gdansk");

        Product extraPotatos = new Product("potatos", ExtraFoodShop.SHOP_NAME);
        Product honey = new Product("honey", ExtraFoodShop.SHOP_NAME);
        Map<Product, Integer> products1 = new HashMap<>() {{
            put(extraPotatos, 3);
            put(honey, 2);
        }};
        Product cookiesChoco = new Product("cookiesChoco", GlutenFreeShop.SHOP_NAME);
        Product cookies = new Product("cookies", GlutenFreeShop.SHOP_NAME);
        Map<Product, Integer> products2 = new HashMap<>() {{
            put(cookiesChoco, 10);
            put(cookies, 10);
        }};

        Product carrotJuice = new Product("carrotJuice", HealthyShop.SHOP_NAME);
        Product chips = new Product("chips", HealthyShop.SHOP_NAME);
        Map<Product, Integer> products3 = new HashMap<>() {{
            put(carrotJuice, 5);
            put(chips, 10);
        }};

        Order order1 = new Order(products1, adam);
        Order order2 = new Order(products2, adam);
        Order order3 = new Order(products3, adam);

        extraFoodShop.process(order1);
        ShowInformation.showInfo(order1);

        glutenFree.process(order2);
        ShowInformation.showInfo(order2);

        healthyShop.process(order3);
        ShowInformation.showInfo(order3);
    }
}
