package arsw.wherewe.back.mazorcausers.service;

import arsw.wherewe.back.mazorcausers.model.User;
import arsw.wherewe.back.mazorcausers.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUserIfNotExists_userExists() {
        User user = new User();
        user.setUserEmail("test@example.com");

        when(userRepository.findByUserEmail(user.getUserEmail())).thenReturn(Optional.of(user));

        User result = userService.createUserIfNotExists(user);

        assertEquals(user, result);
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void createUserIfNotExists_userDoesNotExist() {
        User user = new User();
        user.setUserEmail("test@example.com");

        when(userRepository.findByUserEmail(user.getUserEmail())).thenReturn(Optional.empty());
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.createUserIfNotExists(user);

        assertEquals(user, result);
        verify(userRepository).save(user);
    }

    @Test
    void getAllUsers_returnsAllUsers() {
        List<User> users = List.of(new User(), new User());

        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertEquals(users, result);
    }
}