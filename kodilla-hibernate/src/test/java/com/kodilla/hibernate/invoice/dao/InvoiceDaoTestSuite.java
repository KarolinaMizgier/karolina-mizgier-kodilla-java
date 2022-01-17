package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Pen");
        Product product2 = new Product("Notebook");
        Product product3 = new Product("Crayons");
        Item item1 = new Item(product1, BigDecimal.valueOf(0.76), 3);
        Item item2 = new Item(product2, BigDecimal.valueOf(3.55), 2);
        Item item3 = new Item(product3, BigDecimal.valueOf(4.77), 3);
        Invoice invoice = new Invoice("234234");
        List<Item> items = List.of(item1, item2, item3);
        invoice.setItems(items);
        //When
        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);
        itemDao.save(item1);
        itemDao.save(item2);
        itemDao.save(item3);
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();
        //Then
        assertNotEquals(0, invoiceId);
        //ClearUp
        try {
            itemDao.deleteAll();
            productDao.deleteAll();
            invoiceDao.deleteAll();
        } catch (Exception e) {
            //do nothing
        }

    }
}
