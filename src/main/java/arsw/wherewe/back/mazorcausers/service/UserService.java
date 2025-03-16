package arsw.wherewe.back.mazorcausers.service;

import arsw.wherewe.back.mazorcausers.model.User;
import arsw.wherewe.back.mazorcausers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * User service class for user operations
 */
@Service
public class UserService {


    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Create a new user if it does not exist
     * @param user
     * @return User
     */
    public User createUserIfNotExists(User user) {
        // Verifica si el usuario ya existe
        Optional<User> existingUser = userRepository.findByUserEmail(user.getUserEmail());
        if (existingUser.isPresent()) {
            return existingUser.get(); // Retorna el usuario si ya existe
        }

        // Si no existe, guarda el nuevo usuario
        return userRepository.save(user);
    }

    /**
     * Get all users
     * @return List<User>
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Get User by Id
     * @param id String
     * @return User or null
     */
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }
}
