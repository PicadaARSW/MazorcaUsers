package arsw.wherewe.back.mazorcausers.service;

import arsw.wherewe.back.mazorcausers.model.User;
import arsw.wherewe.back.mazorcausers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User createUserIfNotExists(User user) {
        // Verifica si el usuario ya existe
        Optional<User> existingUser = userRepository.findByUserEmail(user.getUserEmail());
        if (existingUser.isPresent()) {
            return existingUser.get(); // Retorna el usuario si ya existe
        }

        // Si no existe, guarda el nuevo usuario
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
