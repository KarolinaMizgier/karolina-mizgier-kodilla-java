package com.kodilla.good.patterns.challenges.productorder.challenge;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Item mug = new Item("mug");
        Item socks_blue = new Item("socks blue");
        Map<Item, Integer> items = new HashMap<>() {{
            put(mug, 4);
            put(socks_blue, 5);
        }};
        User adam = new User("Adam", "Nowak", "Mickiewicza 5, 80-284 Gdansk");
        DeliveryService poczta = new PcztaPolskaDelivery();
        UserNotification email = new EmailNotification();
        OrderItem order = new OrderItem(items, adam, poczta, email);
        OrderService.service(order);
    }
}

