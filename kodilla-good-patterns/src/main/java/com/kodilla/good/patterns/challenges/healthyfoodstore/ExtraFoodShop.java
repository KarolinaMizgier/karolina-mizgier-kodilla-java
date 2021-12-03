package com.kodilla.good.patterns.challenges.healthyfoodstore;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class ExtraFoodShop implements Producer {
    public static final String SHOP_NAME = "Extra Food Shop";
    private double shippingPrice = 15;
    private int shippingDays = 3;

    private Map<String, ItemInfo> prices = new HashMap<>() {{
        put("honey", new ItemInfo(BigDecimal.valueOf(20.50), 5));
        put("potatos", new ItemInfo(BigDecimal.valueOf(15.95), 10));
        put("selery", new ItemInfo(BigDecimal.valueOf(12.25), 3));
        put("cheese", new ItemInfo(BigDecimal.valueOf(20.49), 1));
        put("carrot", new ItemInfo(BigDecimal.valueOf(17.78), 0));
    }};

    public void updateInventory(Order order) {
        String name = order.getProduct().getProductName();
        ItemInfo itemInfo = prices.get(name);
        itemInfo.setQuantity(itemInfo.getQuantity() - order.getQuantity());
        prices.put(name, itemInfo);
    }

    @Override
    public void process(Order order) {
        Product product = order.getProduct();
        ItemInfo productInfo = prices.get(product.getProductName());
        if (order.getQuantity() <= productInfo.getQuantity()) {
            double price = calculateTotalPrice(order);
            order.setTotalPrice(BigDecimal.valueOf(price).setScale(2, RoundingMode.CEILING));
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
