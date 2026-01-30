package com.example.user_project.Service.Imp;

import com.example.user_project.Entity.User;

import java.util.List;

public interface UserServiceImp {

    User save(User user);

    List<User> finaAll(User user);

    User findById(Long id);

    List<User> findUserNameAndCity(String name, String city);

    User findByEmail(String email);

}

