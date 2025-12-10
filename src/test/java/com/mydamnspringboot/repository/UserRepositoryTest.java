package com.mydamnspringboot.repository;

import com.mydamnspringboot.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveAndFindUser() {
        User user = new User("Alice Wonder", "alice@example.com");
        User savedUser = userRepository.save(user);
        
        assertNotNull(savedUser.getId());
        assertEquals("Alice Wonder", savedUser.getName());
        
        Optional<User> foundUser = userRepository.findById(savedUser.getId());
        assertTrue(foundUser.isPresent());
        assertEquals("alice@example.com", foundUser.get().getEmail());
    }

    @Test
    void testFindByEmail() {
        User user = new User("Bob Smith", "bob@example.com");
        userRepository.save(user);
        
        Optional<User> foundUser = userRepository.findByEmail("bob@example.com");
        assertTrue(foundUser.isPresent());
        assertEquals("Bob Smith", foundUser.get().getName());
    }

    @Test
    void testExistsByEmail() {
        User user = new User("Charlie Brown", "charlie@example.com");
        userRepository.save(user);
        
        assertTrue(userRepository.existsByEmail("charlie@example.com"));
        assertFalse(userRepository.existsByEmail("nonexistent@example.com"));
    }
}
