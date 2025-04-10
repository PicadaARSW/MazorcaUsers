package arsw.wherewe.back.mazorcausers.service;

import arsw.wherewe.back.mazorcausers.dto.UserDTO;
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
import static org.junit.jupiter.api.Assertions.assertNull;
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

        UserDTO userDTO = new UserDTO();
        userDTO.setUserEmail("test@example.com");

        when(userRepository.findByUserEmail(user.getUserEmail())).thenReturn(Optional.of(user));

        UserDTO result = userService.createUserIfNotExists(userDTO);

        assertEquals(user.getUserEmail(), result.getUserEmail());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void createUserIfNotExists_userDoesNotExist() {
        User user = new User();
        user.setUserEmail("test@example.com");

        UserDTO userDTO = new UserDTO();
        userDTO.setUserEmail("test@example.com");

        when(userRepository.findByUserEmail(user.getUserEmail())).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDTO result = userService.createUserIfNotExists(userDTO);

        assertEquals(user.getUserEmail(), result.getUserEmail());
        verify(userRepository).save(any(User.class));
    }

    @Test
    void getAllUsers_returnsAllUsers() {
        List<User> users = List.of(new User(), new User());

        when(userRepository.findAll()).thenReturn(users);

        List<UserDTO> result = userService.getAllUsers();

        assertEquals(users.size(), result.size());
    }

    @Test
    void getUserById_userExists() {
        User user = new User();
        user.setId("1");
        when(userRepository.findById("1")).thenReturn(Optional.of(user));

        UserDTO result = userService.getUserById("1");

        assertEquals(user.getId(), result.getId());
    }

    @Test
    void getUserById_userDoesNotExist() {
        when(userRepository.findById("1")).thenReturn(Optional.empty());

        UserDTO result = userService.getUserById("1");

        assertNull(result);
    }

    @Test
    void updateProfilePictureSuccessfully() {
        User user = new User("1", "John", "John Doe", "john.doe@example.com", "UTC", null);
        when(userRepository.findById("1")).thenReturn(Optional.of(user));

        UserDTO result = userService.updateProfilePicture("1", "newProfilePictureUrl");

        assertEquals("newProfilePictureUrl", result.getProfilePicture());
        verify(userRepository).save(user);
    }

    @Test
    void updateProfilePictureUserNotFound() {
        when(userRepository.findById("1")).thenReturn(Optional.empty());

        UserDTO result = userService.updateProfilePicture("1", "newProfilePictureUrl");

        assertNull(result);
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void deleteUserSuccessfully() {
        User user = new User();
        user.setId("1");
        when(userRepository.findById("1")).thenReturn(Optional.of(user));

        boolean result = userService.deleteUser("1");

        assertEquals(true, result);
        verify(userRepository).deleteById("1");
    }

    @Test
    void deleteUserNotFound() {
        when(userRepository.findById("1")).thenReturn(Optional.empty());

        boolean result = userService.deleteUser("1");

        assertEquals(false, result);
        verify(userRepository, never()).deleteById(anyString());
    }
}