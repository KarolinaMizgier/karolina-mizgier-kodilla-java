package com.kodilla.invoice.simple;

import com.kodilla.stream.invoice.simple.SimpleInvoice;
import com.kodilla.stream.invoice.simple.SimpleItem;
import com.kodilla.stream.invoice.simple.SimpleProduct;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleInvoiceTestSuite {
    @Test
    void testGetValueToPay() {
        //Given
        SimpleInvoice invoice = new SimpleInvoice();
        double x;
        SimpleProduct product1 = new SimpleProduct("Product 1", 17.28);
        SimpleProduct product2 = new SimpleProduct("Product 2", 11.99);
        SimpleProduct product3 = new SimpleProduct("Product 3",  6.49);

        SimpleItem item1 = new SimpleItem(product1, 2.0);
        SimpleItem item2 = new SimpleItem(product2, 3.5);
        SimpleItem item3 = new SimpleItem(product3, 5.0);
        //When
        invoice.addItem(item1);
        invoice.addItem(item2);
        invoice.addItem(item3);

        //boolean b = invoice.getItems().stream().map(SimpleItem::getProduct).anyMatch(sp -> sp.getProductName().equals("Product 2"));
        //Then
        x = invoice.getValueToPay();
        assertEquals(108.975, x, 0.001);
    }
}
