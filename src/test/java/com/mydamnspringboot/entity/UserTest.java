package com.mydamnspringboot.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserCreation() {
        User user = new User("John Doe", "john.doe@example.com");
        
        assertEquals("John Doe", user.getName());
        assertEquals("john.doe@example.com", user.getEmail());
    }

    @Test
    void testUserSetters() {
        User user = new User();
        user.setName("Jane Smith");
        user.setEmail("jane.smith@example.com");
        
        assertEquals("Jane Smith", user.getName());
        assertEquals("jane.smith@example.com", user.getEmail());
    }

    @Test
    void testUserToString() {
        User user = new User("Bob Johnson", "bob@example.com");
        String result = user.toString();
        
        assertTrue(result.contains("Bob Johnson"));
        assertTrue(result.contains("bob@example.com"));
    }
}
