package com.mydamnspringboot.entity;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testProductCreation() {
        Product product = new Product("Laptop", "High-performance laptop", 
                new BigDecimal("999.99"), 10);
        
        assertEquals("Laptop", product.getName());
        assertEquals("High-performance laptop", product.getDescription());
        assertEquals(new BigDecimal("999.99"), product.getPrice());
        assertEquals(10, product.getQuantity());
    }

    @Test
    void testProductSetters() {
        Product product = new Product();
        product.setName("Phone");
        product.setDescription("Smartphone");
        product.setPrice(new BigDecimal("599.99"));
        product.setQuantity(5);
        
        assertEquals("Phone", product.getName());
        assertEquals("Smartphone", product.getDescription());
        assertEquals(new BigDecimal("599.99"), product.getPrice());
        assertEquals(5, product.getQuantity());
    }

    @Test
    void testProductToString() {
        Product product = new Product("Tablet", "Android tablet", 
                new BigDecimal("299.99"), 15);
        String result = product.toString();
        
        assertTrue(result.contains("Tablet"));
        assertTrue(result.contains("299.99"));
    }
}
