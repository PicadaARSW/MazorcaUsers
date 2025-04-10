package arsw.wherewe.back.mazorcausers.service;

import arsw.wherewe.back.mazorcausers.dto.UserDTO;
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


    // Map User to UserDTO
    private UserDTO toUserDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getUserFirstName(),
                user.getUserFullName(),
                user.getUserEmail(),
                user.getUserTimeZone(),
                user.getProfilePicture()
        );
    }

    // Map UserDTO to User
    private User toUser(UserDTO userDTO) {
        return new User(
                userDTO.getId(),
                userDTO.getUserFirstName(),
                userDTO.getUserFullName(),
                userDTO.getUserEmail(),
                userDTO.getUserTimeZone(),
                userDTO.getProfilePicture()
        );
    }

    /**
     * Create a new user if it does not exist
     * @param userDTO
     * @return UserDTO
     */
    public UserDTO createUserIfNotExists(UserDTO userDTO) {
        // Convert DTO to entity
        User user = toUser(userDTO);

        // Verifica si el usuario ya existe
        Optional<User> existingUser = userRepository.findByUserEmail(user.getUserEmail());
        if (existingUser.isPresent()) {
            return toUserDTO(existingUser.get()); // Retorna el usuario si ya existe
        }

        // Si no existe, guarda el nuevo usuario
        User savedUser = userRepository.save(user);
        return toUserDTO(savedUser);
    }

    /**
     * Get all users
     * @return List<UserDTO>
     */
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::toUserDTO)
                .toList();
    }

    /**
     * Get User by Id
     * @param id String
     * @return UserDTO or null
     */
    public UserDTO getUserById(String id) {
        User user = userRepository.findById(id).orElse(null);
        return user != null ? toUserDTO(user) : null;
    }

    public UserDTO updateProfilePicture(String id, String profilePicture) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setProfilePicture(profilePicture);
            userRepository.save(user);
            return toUserDTO(user);
        }
        return null;
    }

    /**
     * Delete user by id
     * @param id String
     * @return boolean
     */
    public boolean deleteUser(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
