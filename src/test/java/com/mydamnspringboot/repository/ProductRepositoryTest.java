package com.mydamnspringboot.repository;

import com.mydamnspringboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testSaveAndFindProduct() {
        Product product = new Product("Mouse", "Wireless mouse", 
                new BigDecimal("29.99"), 50);
        Product savedProduct = productRepository.save(product);
        
        assertNotNull(savedProduct.getId());
        assertEquals("Mouse", savedProduct.getName());
        
        Optional<Product> foundProduct = productRepository.findById(savedProduct.getId());
        assertTrue(foundProduct.isPresent());
        assertEquals(new BigDecimal("29.99"), foundProduct.get().getPrice());
    }

    @Test
    void testFindByNameContainingIgnoreCase() {
        productRepository.save(new Product("Gaming Keyboard", "Mechanical keyboard", 
                new BigDecimal("89.99"), 20));
        productRepository.save(new Product("Keyboard Cover", "Protective cover", 
                new BigDecimal("9.99"), 100));
        
        List<Product> products = productRepository.findByNameContainingIgnoreCase("keyboard");
        assertEquals(2, products.size());
    }

    @Test
    void testFindByQuantityGreaterThan() {
        productRepository.save(new Product("Monitor", "4K Monitor", 
                new BigDecimal("399.99"), 5));
        productRepository.save(new Product("Headset", "Gaming headset", 
                new BigDecimal("79.99"), 30));
        
        List<Product> products = productRepository.findByQuantityGreaterThan(10);
        assertEquals(1, products.size());
        assertEquals("Headset", products.get(0).getName());
    }
}
