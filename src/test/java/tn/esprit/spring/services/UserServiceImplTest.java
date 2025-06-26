package tn.esprit.spring.services;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserServiceImplTest {

    @Autowired
    IUserService userService;

    @Test
    @Order(1)
    public void testAddUser() {
        User u = new User("Mohamed", "Salah", new Date(), Role.CHEF_DEPARTEMENT);
        User saved = userService.addUser(u);
        assertNotNull(saved.getId());
    }

    @Test
    @Order(2)
    public void testRetrieveAllUsers() {
        List<User> users = userService.retrieveAllUsers();
        assertTrue(users.size() > 0);
    }
}
