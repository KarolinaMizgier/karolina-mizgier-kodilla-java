package com.kodilla.good.patterns.challenges.healthyfoodstore;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class HealthyShop implements Producer {
    public static final String SHOP_NAME = "Healthy Shop";
    private double shippingPrice = 10.8;
    private int shippingDays = 2;

    private Map<String, ItemInfo> prices = new HashMap<>() {{
        put("smoothie", new ItemInfo(BigDecimal.valueOf(5.80), 1));
        put("eggs", new ItemInfo(BigDecimal.valueOf(11.40), 3));
        put("salad", new ItemInfo(BigDecimal.valueOf(6.24), 4));
        put("chips", new ItemInfo(BigDecimal.valueOf(10.05), 2));
        put("carrotJuice", new ItemInfo(BigDecimal.valueOf(8.25), 99));
    }};


    public void updateInventory(Order order) {
        String name = order.getProduct().getProductName();
        ItemInfo itemInfo = prices.get(name);
        itemInfo.setQuantity(itemInfo.getQuantity() - order.getQuantity());
        prices.put(name, itemInfo);
    }

    public void process(Order order) {
        ItemInfo productInfo = prices.get(order.getProduct().getProductName());
        if (order.getQuantity() <= productInfo.getQuantity()) {
            double price = calculateTotalPrice(order);
            if (order.getQuantity() > 10) {
                price = price - 20;
                System.out.println("When buying over 10 items, you got 20 zl dicount!");
                order.setTotalPrice(BigDecimal.valueOf(price).setScale(2, RoundingMode.CEILING));
            } else {
                order.setTotalPrice(BigDecimal.valueOf(price).setScale(2, RoundingMode.CEILING));
            }
            updateInventory(order);

            System.out.println("Updated inventory: ");
            for (Map.Entry entry : prices.entrySet()) {
                System.out.println("Product name: " + entry.getKey() + " Product quantity: " +
                        prices.get(entry.getKey()).getQuantity());
            }
        }
        System.out.println("Not enough products available in store");
    }

    private double calculateTotalPrice(Order order) {
        Product product = order.getProduct();
        String productName = product.getProductName();
        if (prices.containsKey(productName)) {
            ItemInfo productInfo = prices.get(productName);
            BigDecimal price = productInfo.getPrice();
            return order.getQuantity() * price.doubleValue() + shippingPrice;
        }
        System.out.println(String.format("INFO: Cannot calculate total price shop %s does not offer product: %s",
                SHOP_NAME, productName));
        return 0.0;
    }
}
