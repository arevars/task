package springboot1.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot1.task.dao.UserDAO;
import springboot1.task.model.User;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDAO userDAO;

    /* to save an user*/
    @PostMapping("/create")
    public User createUser(@Valid @RequestBody User user) {
        return userDAO.save(user);
    }

    /*get all users*/
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userDAO.findAll();
    }

    /*get user by userid*/
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value="id") Long userid){

        User user=userDAO.findOne(userid);

        if(user==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);

    }


    /*update an user by userid*/
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value="id") Long userid,@Valid @RequestBody User userDetails){

        User user=userDAO.findOne(userid);
        if(user==null) {
            return ResponseEntity.notFound().build();
        }

        user.setName(userDetails.getName());
        user.setSurname(userDetails.getSurname());
        user.setEmail(userDetails.getEmail());

        User updateUser=userDAO.save(user);
        return ResponseEntity.ok().body(updateUser);



    }

    /*Delete an user*/
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value="id") Long userid){

        User user=userDAO.findOne(userid);
        if(user==null) {
            return ResponseEntity.notFound().build();
        }
        userDAO.delete(user);

        return ResponseEntity.ok().build();


    }



}
