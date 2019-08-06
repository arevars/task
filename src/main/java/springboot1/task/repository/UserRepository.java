package springboot1.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot1.task.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
