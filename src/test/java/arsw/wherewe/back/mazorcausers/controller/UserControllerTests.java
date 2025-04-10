package arsw.wherewe.back.mazorcausers.controller;

import arsw.wherewe.back.mazorcausers.dto.UserDTO;
import arsw.wherewe.back.mazorcausers.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTests {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    public UserControllerTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUserSuccessfully() {
        UserDTO userDTO = new UserDTO("1", "John", "John Doe", "john.doe@example.com", "UTC", "");
        when(userService.createUserIfNotExists(userDTO)).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = userController.createUser(userDTO);

        assertEquals(userDTO, response.getBody());
    }

    @Test
    void createUserAlreadyExists() {
        UserDTO userDTO = new UserDTO("1", "John", "John Doe", "john.doe@example.com", "UTC", "");
        when(userService.createUserIfNotExists(userDTO)).thenReturn(null);

        ResponseEntity<UserDTO> response = userController.createUser(userDTO);

        assertNull(response.getBody());
    }

    @Test
    void getAllUsersSuccessfully() {
        UserDTO user1 = new UserDTO("1", "John", "John Doe", "john.doe@example.com", "UTC", "https://example.com/profile1.jpg");
        UserDTO user2 = new UserDTO("2", "Jane", "Jane Doe", "jane.doe@example.com", "PST", "");
        List<UserDTO> users = List.of(user1, user2);
        when(userService.getAllUsers()).thenReturn(users);

        ResponseEntity<List<UserDTO>> response = userController.getAllUsers();

        assertEquals(users, response.getBody());
    }

    @Test
    void getAllUsersNoContent() {
        when(userService.getAllUsers()).thenReturn(Collections.emptyList());

        ResponseEntity<List<UserDTO>> response = userController.getAllUsers();

        assertNull(response.getBody());
    }

    @Test
    void getUserByIdSuccessfully() {
        UserDTO userDTO = new UserDTO("1", "John", "John Doe", "john.doe@example.com", "UTC", "");
        when(userService.getUserById("1")).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = userController.getUserById("1");

        assertEquals(userDTO, response.getBody());
    }

    @Test
    void getUserByIdNotFound() {
        when(userService.getUserById("1")).thenReturn(null);

        ResponseEntity<UserDTO> response = userController.getUserById("1");

        assertNull(response.getBody());
    }

    @Test
    void updateProfilePictureSuccessfully() {
        UserDTO updatedUser = new UserDTO("1", "John", "John Doe", "john.doe@example.com", "UTC", "https://example.com/new_profile.jpg");
        when(userService.updateProfilePicture("1", "https://example.com/new_profile.jpg")).thenReturn(updatedUser);

        ResponseEntity<UserDTO> response = userController.updateProfilePicture("1", Map.of("pictureUrl", "https://example.com/new_profile.jpg"));

        assertEquals(200, response.getStatusCode().value());
        assertEquals(updatedUser, response.getBody());
    }

    @Test
    void updateProfilePictureUserNotFound() {
        when(userService.updateProfilePicture("1", "https://example.com/new_profile.jpg")).thenReturn(null);

        ResponseEntity<UserDTO> response = userController.updateProfilePicture("1", Map.of("pictureUrl", "https://example.com/new_profile.jpg"));

        assertEquals(404, response.getStatusCode().value());
        assertNull(response.getBody());
    }

    @Test
    void updateProfilePictureInvalidUrl() {
        ResponseEntity<UserDTO> response = userController.updateProfilePicture("1", Map.of("pictureUrl", ""));

        assertEquals(400, response.getStatusCode().value());
        assertNull(response.getBody());
    }

    @Test
    void deleteUserSuccessfully() {
        when(userService.deleteUser("1")).thenReturn(true);

        ResponseEntity<Void> response = userController.deleteUser("1");

        assertEquals(200, response.getStatusCode().value());
        assertNull(response.getBody());
    }

    @Test
    void deleteUserNotFound() {
        when(userService.deleteUser("1")).thenReturn(false);

        ResponseEntity<Void> response = userController.deleteUser("1");

        assertEquals(404, response.getStatusCode().value());
        assertNull(response.getBody());
    }
}