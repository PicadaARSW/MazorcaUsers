package arsw.wherewe.back.mazorcausers.controller;

import arsw.wherewe.back.mazorcausers.model.User;
import arsw.wherewe.back.mazorcausers.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserControllerTests {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    public UserControllerTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUserSuccessfully() {
        User user = new User("1", "John", "John Doe", "john.doe@example.com", "UTC");
        when(userService.createUserIfNotExists(user)).thenReturn(user);

        ResponseEntity<User> response = userController.createUser(user);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(user, response.getBody());
    }

    @Test
    void createUserAlreadyExists() {
        User user = new User("1", "John", "John Doe", "john.doe@example.com", "UTC");
        when(userService.createUserIfNotExists(user)).thenReturn(null);

        ResponseEntity<User> response = userController.createUser(user);

        assertEquals(400, response.getStatusCodeValue());
        assertNull(response.getBody());
    }

    @Test
    void getAllUsersSuccessfully() {
        User user1 = new User("1", "John", "John Doe", "john.doe@example.com", "UTC");
        User user2 = new User("2", "Jane", "Jane Doe", "jane.doe@example.com", "PST");
        List<User> users = List.of(user1, user2);
        when(userService.getAllUsers()).thenReturn(users);

        ResponseEntity<List<User>> response = userController.getAllUsers();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(users, response.getBody());
    }

    @Test
    void getAllUsersNoContent() {
        when(userService.getAllUsers()).thenReturn(Collections.emptyList());

        ResponseEntity<List<User>> response = userController.getAllUsers();

        assertEquals(204, response.getStatusCodeValue());
        assertNull(response.getBody());
    }
}