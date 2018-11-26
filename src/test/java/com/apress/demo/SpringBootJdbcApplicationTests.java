package com.apress.demo;

import com.apress.demo.domain.User;
import com.apress.demo.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJdbcApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAllUsers() {
        List<User> users = userRepository.findAll();
        assertNotNull(users);
        assertTrue(!users.isEmpty());
    }

    @Test
    public void findUserById() {
        User user = userRepository.findUserById(1);
        assertNotNull(user);
    }

    @Test
    public void createUser() {
        User user = new User(0, "Johnson", "johnson@gmail.com");
        User savedUser = userRepository.create(user);
        User newUser = userRepository.findUserById(savedUser.getId());
        assertNotNull(newUser);
        assertEquals("Johnson", newUser.getName());
        assertEquals("johnson@gmail.com", newUser.getEmail());
    }

}
