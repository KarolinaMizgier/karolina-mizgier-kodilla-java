package com.kodilla.good.patterns.challenges.healthyfoodstore;

public class Application {
    public static void main(String args[]) {

        String efs = "Extra Food Shop";
        String gfs = "Gluten Free Shop";
        String hs = "Healthy Shop";

        Producer healthyShop = new HealthyShop();
        Producer glutenFree = new GlutenFreeShop();
        Producer extraFoodShop = new ExtraFoodShop();

        UserProfile adam = new UserProfile("Adam", "Nowak", "Mickiewicza 5, 80-284 Gdansk");

        Product extraPotatos = new Product("potatos", ExtraFoodShop.SHOP_NAME);
        Product healthyPotatos = new Product("potatos", HealthyShop.SHOP_NAME);
        Order order1 = new Order(extraPotatos, 3, adam);
        Order order2 = new Order(healthyPotatos, 3, adam);

        extraFoodShop.process(order1);
        ShowInformation.showInfo(order1);

        healthyShop.process(order1);
        ShowInformation.showInfo(order1);


        //zrobic zamowienie na kilka produktow Map

//        Product bread = new Product("bread",gfs);
//        UserProfile magda = new UserProfile("Magdalena", "Kowalska", "Grunwaldzka 39, 80-284 Gdansk");
//        Order order2 = new Order(bread, 5, magda);
//
//        Product salad = new Product("salad", hs);
//        UserProfile ania = new UserProfile("Anna", "Nowak", "Lotnicza 7, 80-284 Gdansk");
//        Order order3 = new Order(salad, 6, ania);
//
//        String extraFoodShop = "./kodilla-good-patterns/src/main/resources/ExtraFoodShop.txt";
//        String GlutenFreeShop = "./kodilla-good-patterns/src/main/resources/GlutenFreeShop.txt";
//        String HealthyShop = "./kodilla-good-patterns/src/main/resources/HealthyShop.txt";
//
//        ProductInventory inventory = new ProductInventory(extraFoodShop, order);
//        ProductInventory inventory1 = new ProductInventory(GlutenFreeShop, order2);
//        ProductInventory inventory2 = new ProductInventory(HealthyShop, order3);
//        Producer shop1 = new ExtraFoodShop();
//        Producer shop2 = new GlutenFreeShop();
//        Producer shop3 = new HealthyShop();
//
//        //umiescic w produkcje informacje z którego sklepu pochodzi i z niego  pobierac metode process dla danego produktu
//
//
//
//        ShowInformation.showInfo(inventory, order, potatos, shop1, adam);
//        ShowInformation.showInfo(inventory1, order2, bread, shop2, magda);
//        ShowInformation.showInfo(inventory2, order3, salad, shop3, ania);


    }
}
