package com.kodilla.good.patterns.challenges.healthyfoodstore;

import java.math.BigDecimal;

public class ItemInfo {
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
