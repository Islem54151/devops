import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplMock {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private tn.esprit.spring.services.UserServiceImpl  userService;

    @Test
    public void testAddUser() {
        User user = new User("Ali", "Ben Ali", new Date(), Role.ADMINISTRATEUR);
        Mockito.when(userRepository.save(user)).thenReturn(user);

        User result = userService.addUser(user);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Ali", result.getPrenom());
        Mockito.verify(userRepository).save(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User("Ali", "Ben Ali", new Date(), Role.ADMINISTRATEUR);
        user.setId(1L);
        Mockito.when(userRepository.save(user)).thenReturn(user);

        User result = userService.updateUser(user);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1L, result.getId());
        Mockito.verify(userRepository).save(user);
    }

    @Test
    public void testRetrieveUserById() {
        User user = new User("Ali", "Ben Ali", new Date(), Role.ADMINISTRATEUR);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.retrieveUser("1");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Ben Ali", result.getLastName());
        Mockito.verify(userRepository).findById(1L);
    }

    @Test
    public void testRetrieveUserByIdNotFound() {
        Mockito.when(userRepository.findById(99L)).thenReturn(Optional.empty());

        User result = userService.retrieveUser("99");

        Assertions.assertNull(result);
        Mockito.verify(userRepository).findById(99L);
    }

    @Test
    public void testRetrieveAllUsers() {
        List<User> users = Arrays.asList(
                new User("Ali", "Ben Ali", new Date(), Role.ADMINISTRATEUR),
                new User("Sara", "Kefi", new Date(), Role.INGENIEUR)
        );

        Mockito.when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.retrieveAllUsers();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());
        Mockito.verify(userRepository).findAll();
    }

    @Test
    public void testDeleteUser() {
        Long userId = 1L;

        userService.deleteUser(userId.toString());

        Mockito.verify(userRepository).deleteById(userId);
    }
}
