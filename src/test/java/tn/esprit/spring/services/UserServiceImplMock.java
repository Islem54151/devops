package tn.esprit.spring.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplMock {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testRetrieveAllUsers() {
        List<User> mockUsers = Arrays.asList(
                new User("Ali", "Ben Ali", new Date(), Role.ADMINISTRATEUR),
                new User("Sara", "Kefi", new Date(), Role.INGENIEUR)
        );

        when(userRepository.findAll()).thenReturn(mockUsers);

        List<User> result = userService.retrieveAllUsers();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(userRepository).findAll();
    }
}
