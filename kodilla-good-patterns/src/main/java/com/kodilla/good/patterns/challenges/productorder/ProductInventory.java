package com.kodilla.good.patterns.challenges.productorder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductInventory {
    private List<String> products = new ArrayList<>();
    String path = "./kodilla-good-patterns/src/main/resources/products.txt";
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
