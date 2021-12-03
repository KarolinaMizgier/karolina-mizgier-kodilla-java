package com.kodilla.good.patterns.challenges.healthyfoodstore;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ExtraFoodShop implements Producer {
    public static final String SHOP_NAME = "Extra Food Shop";
    private double shippingPrice = 15;
    private int shippingDays = 3;

    private Map<String, ItemInfo> prices = new HashMap<>(){{
        put("honey", new ItemInfo(BigDecimal.valueOf(20.50), 5));
        put("potatos", new ItemInfo(BigDecimal.valueOf(15.95), 10));
        put("selery", new ItemInfo(BigDecimal.valueOf(12.25), 3));
        put("cheese", new ItemInfo(BigDecimal.valueOf(20.49), 1));
        put("carrot", new ItemInfo(BigDecimal.valueOf(17.78), 0));
    }};

    public void updateInventory(Order order){
        String name = order.getProduct().getProductName();
        int newQuantity = 0;
        ItemInfo  updatedInfo = null;
        for (Map.Entry<String, ItemInfo> entry : prices.entrySet()) {
            if (Objects.equals(name, entry.getKey())) {
                newQuantity = entry.getValue().getQuantity() - order.getQuantity();
                updatedInfo = new ItemInfo(entry.getValue().getPrice(), newQuantity);
            }
        }
        if (newQuantity > 0) {
            prices.replace(name,updatedInfo);
        } else {
            prices.remove(name);
        }
    }

    @Override
    public void process(Order order) {
        Product product = order.getProduct();
        double price = calculateTotalPrice(order);
        order.setTotalPrice( BigDecimal.valueOf(price));
        updateInventory(order);
    }

    private double calculateTotalPrice(Order order) {
        Product product = order.getProduct();
        String productName = product.getProductName();
        if(prices.containsKey(productName)) {
            ItemInfo productInfo = prices.get(productName);
            BigDecimal price = productInfo.getPrice();
            return order.getQuantity() * price.doubleValue() + shippingPrice;
        }
        System.out.println(String.format("INFO: Cannot calculate total price shop %s does not offer product: %s",
                SHOP_NAME, productName));
        return 0.0;
    }
}
