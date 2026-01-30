package com.example.user_project.Controller;

import com.example.user_project.Entity.User;
import com.example.user_project.Service.Imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return userServiceImp.save(user);

    }

    @GetMapping("/all")
    public List<User> getAllUser(User user){
        return userServiceImp.finaAll(user);

    }

    @GetMapping("/user-id/{id}")
    public User getUserById(@PathVariable Long id){
        return userServiceImp.findById(id);
    }


    @GetMapping("/user-by/{name}/{city}")
    public List<User> getUserByEmail(@PathVariable String name, @PathVariable String city){
        return userServiceImp.findUserNameAndCity(name, city);
    }


    @GetMapping("/user-email/{email}")
    public User getUserByEmail(@PathVariable String email){
        return userServiceImp.findByEmail(email);
    }

}
