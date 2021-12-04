package com.kodilla.good.patterns.challenges.healthyfoodstore;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class ExtraFoodShop implements Producer {
    public static final String SHOP_NAME = "Extra Food Shop";
    private double shippingPrice = 15;
    private int shippingDays = 3;
    double tempSum;
    Map<Product, Integer> products;

    private Map<String, ItemInfo> prices = new HashMap<>() {{
        put("honey", new ItemInfo(BigDecimal.valueOf(20.50), 5));
        put("potatos", new ItemInfo(BigDecimal.valueOf(15.95), 10));
        put("selery", new ItemInfo(BigDecimal.valueOf(12.25), 3));
        put("cheese", new ItemInfo(BigDecimal.valueOf(20.49), 1));
        put("carrot", new ItemInfo(BigDecimal.valueOf(17.78), 0));
    }};

    public void updateInventory(Order order) {
        products.entrySet().forEach(entry -> {
            String name = entry.getKey().getProductName();
            ItemInfo itemInfo = prices.get(name);
            itemInfo.setQuantity(itemInfo.getQuantity() - entry.getValue());
            prices.put(name, itemInfo);
        });

    }

    @Override
    public void process(Order order) {
        double price = calculateTotalPrice(order);
        order.setTotalPrice(BigDecimal.valueOf(price).setScale(2, RoundingMode.CEILING));
        updateInventory(order);

        System.out.println("Updated inventory: ");
        for (Map.Entry entry : prices.entrySet()) {
            System.out.println("Product name: " + entry.getKey() + " Product quantity: " +
                    prices.get(entry.getKey()).getQuantity());
        }
    }

    private double calculateTotalPrice(Order order) {
        products = order.getProducts();
        products.entrySet().forEach(entry -> {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            String productName = product.getProductName();

            if (prices.containsKey(productName)) {
                if (quantity <= prices.get(productName).getQuantity()) {
                    ItemInfo productInfo = prices.get(productName);
                    BigDecimal price = productInfo.getPrice();
                    tempSum += quantity * price.doubleValue();
                } else {
                    System.out.println("Not enough products available in store");
                }
            } else {
                System.out.println(String.format("INFO: Cannot calculate total price shop %s does not offer product: %s",
                        SHOP_NAME, productName));
                tempSum += 0.0;
            }
        });
        return tempSum + shippingPrice;
    }

    private class ItemInfo {
        private BigDecimal price;
        private Integer quantity;

        public ItemInfo(BigDecimal price, Integer quantity) {
            this.price = price;
            this.quantity = quantity;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }
}
