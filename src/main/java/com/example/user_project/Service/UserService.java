package com.example.user_project.Service;

import com.example.user_project.Entity.User;
import com.example.user_project.Exception.UserNotFoundException;
import com.example.user_project.Repository.UserRepo;
import com.example.user_project.Service.Imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceImp{

    @Autowired
    private UserRepo userRepo;

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> finaAll(User user) {
        List<User> user1 = userRepo.findAll();

        if(user1.isEmpty()){
            throw new UserNotFoundException("USER NOT FOUND");
        }
        return user1;
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("USER NOT FOUND BY :" + id));

//        if(user.isEmpty()){
//            throw new RuntimeException("USER NOT FOUND " + id);
//        }
//        return user.get();
    }

    @Override
    public List<User> findUserNameAndCity(String name, String city){
        List<User> users = userRepo.findUserNameAndCity(name, city);

        if(users.isEmpty()){
            throw new UserNotFoundException("USER NOT FOUNT : " + name + "and" + city);
        }
        return users;
    }

    @Override
    public User findByEmail(String email){
        User user = userRepo.findByEmail(email);

        if(user == null){
            throw new UserNotFoundException("USER NOT FOUNT BY :" + email);
        }
        return user;
    }
}
