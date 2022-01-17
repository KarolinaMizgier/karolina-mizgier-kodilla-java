package com.kodilla.hibernate.invoice;

import com.kodilla.hibernate.task.Task;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ITEMS")
public class Item {
    private Integer id;
    private Product product;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;
    private Invoice invoice;

    public Item() {

    }

    public Item(Product product, BigDecimal price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.value = price.multiply(BigDecimal.valueOf(quantity));
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Integer getId() {
        return id;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "PRODUCTS_ID")
    public Product getProduct() {
        return product;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "INVOICE_ID")
    public Invoice getInvoice() {
        return invoice;
    }

    @NotNull
    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    @NotNull
    @Column(name = "QUANTITY")
    public int getQuantity() {
        return quantity;
    }

    @NotNull
    @Column(name = "VALUE")
    public BigDecimal getValue() {
        return value;
    }

    private void setId(int id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private void setValue(BigDecimal value) {
        this.value = value;
    }

    private void setPrice(BigDecimal price) {
        this.price = price;
    }

    private void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
