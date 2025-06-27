package tn.esprit.spring.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.services.UserServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("test")
@SpringBootTest(classes = tn.esprit.spring.TimesheetDevopsApplication.class)
public class UserServiceIntegrationTest {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;
    @Test
    public void testAddUserReal() {
        User user = new User("Ali", "Ben Ali", new Date(), Role.ADMINISTRATEUR);
        User savedUser = userService.addUser(user);

        assertNotNull(savedUser.getId());
        assertEquals("Ali", savedUser.getPrenom());

        Optional<User> found = userRepository.findById(savedUser.getId());
        assertTrue(found.isPresent());
    }

    @Test
    public void testRetrieveUserByIdReal() {
        User user = new User("Sara", "Kefi", new Date(), Role.INGENIEUR);
        User savedUser = userService.addUser(user);

        User retrievedUser = userService.retrieveUser(savedUser.getId().toString());
        assertNotNull(retrievedUser);
        assertEquals("Sara", retrievedUser.getPrenom());
    }

    @Test
    public void testUpdateUserReal() {
        User user = new User("Mohamed", "Ali", new Date(), Role.ADMINISTRATEUR);
        User savedUser = userService.addUser(user);

        savedUser.setPrenom("MohamedUpdated");
        User updatedUser = userService.updateUser(savedUser);

        assertEquals("MohamedUpdated", updatedUser.getPrenom());

        User fromDb = userRepository.findById(updatedUser.getId()).orElse(null);
        assertNotNull(fromDb);
        assertEquals("MohamedUpdated", fromDb.getPrenom());
    }

    @Test
    public void testDeleteUserReal() {
        User user = new User("Delete", "Me", new Date(), Role.INGENIEUR);
        User savedUser = userService.addUser(user);

        userService.deleteUser(savedUser.getId().toString());

        Optional<User> deleted = userRepository.findById(savedUser.getId());
        assertFalse(deleted.isPresent());
    }

    @Test
    public void testRetrieveAllUsersReal() {
        userService.addUser(new User("User1", "Last1", new Date(), Role.INGENIEUR));
        userService.addUser(new User("User2", "Last2", new Date(), Role.ADMINISTRATEUR));

        List<User> users = userService.retrieveAllUsers();
        assertTrue(users.size() >= 2);
    }
}
