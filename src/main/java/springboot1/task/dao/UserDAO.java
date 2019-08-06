package springboot1.task.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springboot1.task.model.User;
import springboot1.task.repository.UserRepository;

import java.util.List;

@Service
public class UserDAO {

    @Autowired
    UserRepository userRepository;

    /*to save an user*/

    public User save(User user) {
        return userRepository.save(user);
    }


    /* search all users*/

    public List<User> findAll(){
        return userRepository.findAll();
    }


    /*get an user by id*/
    public User findOne(Long userid) {
        return userRepository.findById(userid).orElseThrow(() ->
                new UsernameNotFoundException("User Not Found with -> userid : " + userid)
        );
    }


    /*delete an user*/

    public void delete(User user) {
        userRepository.delete(user);
    }


}