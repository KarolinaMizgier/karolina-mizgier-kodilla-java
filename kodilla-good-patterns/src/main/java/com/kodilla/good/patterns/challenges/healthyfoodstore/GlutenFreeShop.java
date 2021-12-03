package com.kodilla.good.patterns.challenges.healthyfoodstore;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class GlutenFreeShop implements Producer {
    public static final String SHOP_NAME = "Gluten Free Shop";
    private double shippingPrice = 18;
    private int shippingDays = 4;

    private Map<String, ItemInfo> prices = new HashMap<>() {{
        put("pizzaDough", new ItemInfo(BigDecimal.valueOf(9.50), 5));
        put("bread", new ItemInfo(BigDecimal.valueOf(6.95), 10));
        put("cake", new ItemInfo(BigDecimal.valueOf(12.25), 3));
        put("cookiesChoco", new ItemInfo(BigDecimal.valueOf(20.25), 40));
        put("cookies", new ItemInfo(BigDecimal.valueOf(17.78), 0));
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
            if (price >= 150) {
                price = price * 0.7;
                System.out.println("Shopping over 150 zl, You got 20% discount!");
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
