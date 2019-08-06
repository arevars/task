package springboot1.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot1.task.model.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findOne(String userid);
}
