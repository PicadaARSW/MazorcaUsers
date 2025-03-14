package arsw.wherewe.back.mazorcausers.controller;

import arsw.wherewe.back.mazorcausers.model.User;
import arsw.wherewe.back.mazorcausers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User controller class for user operations
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    private UserService userService;

    /**
     * Constructor for UserController injecting UserService
     * @param userService
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Create a new user
     * @param user
     * @return ResponseEntity<User>
     */
    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User newUser = userService.createUserIfNotExists(user);
        if(newUser == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(newUser);
    }

    /**
     * Get all users
     * @return ResponseEntity<List<User>>
     */
    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        if(users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }
}
