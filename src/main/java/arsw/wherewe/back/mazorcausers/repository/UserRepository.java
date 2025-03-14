package arsw.wherewe.back.mazorcausers.repository;

import arsw.wherewe.back.mazorcausers.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * User repository interface for MongoDB
 */
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUserEmail(String email);
}