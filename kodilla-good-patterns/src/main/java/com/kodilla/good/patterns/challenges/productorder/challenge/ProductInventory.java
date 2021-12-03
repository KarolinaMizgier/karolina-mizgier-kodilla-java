package com.kodilla.good.patterns.challenges.productorder.challenge;

import com.kodilla.good.patterns.challenges.healthyfoodstore.ItemInfo;
import com.kodilla.good.patterns.challenges.healthyfoodstore.Order;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class ProductInventory {
    private List<String> products = new ArrayList<>();
    String path = "./kodilla-good-patterns/src/main/resources/products.txt";

    private Map<String, ItemInfo> items = new HashMap<>(){{
        put("mug", new ItemInfo(BigDecimal.valueOf(30.50), 8));
        put("socks blue", new ItemInfo(BigDecimal.valueOf(10.95), 10));
        put("socks red", new ItemInfo(BigDecimal.valueOf(10.25), 32));
        put("notebook", new ItemInfo(BigDecimal.valueOf(8.49), 11));
        put("pen", new ItemInfo(BigDecimal.valueOf(4.78), 10));
    }};
    public void updateInventory(Order order){
        String name = order.getProduct().getProductName();
        int newQuantity = 0;
        ItemInfo  updatedInfo = null;
        for (Map.Entry<String, ItemInfo> entry : items.entrySet()) {
            if (Objects.equals(name, entry.getKey())) {
                newQuantity = entry.getValue().getQuantity() - order.getQuantity();
                updatedInfo = new ItemInfo(entry.getValue().getPrice(), newQuantity);
            }
        }
        if (newQuantity > 0) {
            items.replace(name,updatedInfo);
        } else {
            items.remove(name);
        }
    }

    Scanner s;
    {
        try {
            s = new Scanner(new File(path));
            while (s.hasNext()) {
                products.add(s.nextLine());
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ProductInventory() {
    }

    public boolean isAvaliable(Product product) {
        if (products.contains(product.getProductName())) {
            return true;
        } else {
            return false;
        }
    }

    public void deleteItem(Product product) {
        String name = product.getProductName();
        products.remove(name);
        try {
            FileWriter writer = new FileWriter(path);
            products.stream().forEach(line -> {
                try {
                    writer.append(line + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
