package com.example.mongoauth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.mongoauth.model.User;
import com.example.mongoauth.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User createUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }
}