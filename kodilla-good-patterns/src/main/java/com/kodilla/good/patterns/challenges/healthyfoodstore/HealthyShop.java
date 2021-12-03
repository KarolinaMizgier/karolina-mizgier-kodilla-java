package com.kodilla.good.patterns.challenges.healthyfoodstore;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class HealthyShop implements Producer {
    public static final String SHOP_NAME = "Healthy Shop";
    private double shippingPrice = 10.8;
    private int shippingDays = 2;

    private Map<String, ItemInfo> prices = new HashMap<>() {{
        put("smoothie", new ItemInfo(BigDecimal.valueOf(5.80), 1));
        put("eggs", new ItemInfo(BigDecimal.valueOf(11.40), 3));
        put("salad", new ItemInfo(BigDecimal.valueOf(6.24),4));
        put("chips", new ItemInfo(BigDecimal.valueOf(10.05), 2));
        put("carrotJuice", new ItemInfo(BigDecimal.valueOf(8.25), 99));
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
