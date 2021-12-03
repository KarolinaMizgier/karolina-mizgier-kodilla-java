package com.kodilla.good.patterns.challenges.healthyfoodstore;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class GlutenFreeShop implements Producer {
    public static final String SHOP_NAME = "Gluten Free Shop";
    private double shippingPrice = 18;
    private int shippingDays = 4;

    private Map<String, ItemInfo> prices = new HashMap<>(){{
        put("pizzaDough", new ItemInfo(BigDecimal.valueOf(9.50), 5));
        put("bread", new ItemInfo(BigDecimal.valueOf(6.95), 10));
        put("cake", new ItemInfo(BigDecimal.valueOf(12.25), 3));
        put("cookiesChoco", new ItemInfo(BigDecimal.valueOf(20.49), 1));
        put("cookies", new ItemInfo(BigDecimal.valueOf(17.78), 0));
    }};

    public double calculateTotalPrice(Order order) {
        String productName = order.getProduct().getProductName();
        ItemInfo productInfo = prices.get(productName);
        return order.getQuantity() * productInfo.getPrice().doubleValue() + shippingPrice;
    }

    public void process(Order order) {
        String producerName = order.getProduct().getProducerName();
        if(prices.containsKey(producerName)) {
            double price = calculateTotalPrice(order);
            order.setTotalPrice(BigDecimal.valueOf(price));
            return;
        }
        System.out.println(String.format("INFO: Producer %s does not have product %s in offer.",
                SHOP_NAME, producerName));
        order.setTotalPrice(BigDecimal.ZERO);
    }
}
