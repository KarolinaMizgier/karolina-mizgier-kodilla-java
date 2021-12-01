package com.kodilla.good.patterns.challenges.productorder;

public class ProductOrderService {
    private Product product;
    private User user;
    private ProductInventory inventory;

    public ProductOrderService(Product product, User user, ProductInventory inventory) {
        this.product = product;
        this.user = user;
        this.inventory = inventory;
    }

    public boolean isOrdered() {
        if (inventory.isAvaliable(product)) {
            return true;
        } else {
            return false;
        }
    }
}
