package com.kodilla.good.patterns.challenges.healthyfoodstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ProductInventory {
    private List<String> products = new ArrayList<>();
    private Map<String, Integer> map = new HashMap<>();
    String path;
    Scanner s;
    Order order;
    int quantity;

    public ProductInventory(String path, Order order) {
        this.path = path;
        this.order = order;
    }

    public void makeProductMap() {
        {
            try {
                s = new Scanner(new File(path));
                while (s.hasNext()) {
                    map.put(s.next(), s.nextInt());
                }
                s.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isAvaliable(Product product) {
        makeProductMap();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (Objects.equals(product.getProductName(), entry.getKey())) {
                quantity = entry.getValue();
            }
        }
        if (quantity >= order.quantity) {
            return true;
        } else {
            return false;
        }
    }

    public void deleteItem(Product product) {
        String name = product.getProductName();
        int newQuantity = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (Objects.equals(name, entry.getKey())) {
                newQuantity = entry.getValue() - order.quantity;
            }
        }
        if (newQuantity > 0) {
            map.replace(name, newQuantity);
        } else {
            map.remove(name);
        }

        List<String> names = new ArrayList<>(map.keySet());
        List<Integer> numbers = new ArrayList<>(map.values());
        List<String> productsNew = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            productsNew.add(names.get(i) + " " + numbers.get(i).toString());
        }

        try {
            FileWriter writer = new FileWriter(path);
            productsNew.stream().forEach(line -> {
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
