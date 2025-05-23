package arsw.wherewe.back.mazorcausers.controller;

import arsw.wherewe.back.mazorcausers.dto.UserDTO;
import arsw.wherewe.back.mazorcausers.model.User;
import arsw.wherewe.back.mazorcausers.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * User controller class for user operations
 */
@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Users", description = "User management API endpoints")
public class UserController {


    private UserService userService;

    /**
     * Constructor for UserController injecting UserService
     * @param userService UserService
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Create a new user
     * @param userDTO User
     * @return ResponseEntity<User>
     */
    @PostMapping("")
    @Operation(summary = "Create a new user", description = "Creates a new user if it doesn't already exist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created successfully",
                    content = @Content(schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "400", description = "Invalid user data provided")
    })
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO newUser = userService.createUserIfNotExists(userDTO);
        if (newUser == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(newUser);
    }

    /**
     * Get all users
     * @return ResponseEntity<List<User>>
     */
    @GetMapping("")
    @Operation(summary = "Get all users", description = "Retrieves a list of all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of users",
                    content = @Content(schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "204", description = "No users found")
    })
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    /**
     * Get User by Id
     * @param id String
     * @return ResponseEntity<User>
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID", description = "Retrieves a user by their unique identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found",
                    content = @Content(schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") String id) {
        UserDTO user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}/profile-picture")
    @Operation(summary = "Update user profile picture", description = "Updates the profile picture URL for a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profile picture updated successfully",
                    content = @Content(schema = @Schema(implementation = UserDTO.class))),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "400", description = "Invalid picture URL")
    })
    public ResponseEntity<UserDTO> updateProfilePicture(
            @PathVariable("id") String id,
            @RequestBody Map<String, String> requestBody) {
        String pictureUrl = requestBody.get("pictureUrl");
        if (pictureUrl == null || pictureUrl.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        UserDTO updatedUser = userService.updateProfilePicture(id, pictureUrl);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete user account", description = "Deletes a user account by their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User account deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
