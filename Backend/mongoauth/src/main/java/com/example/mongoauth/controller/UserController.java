package com.example.mongoauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongoauth.model.User;
import com.example.mongoauth.service.UserService;

//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping
    public List<User> list() {
        return service.getAllUsers();
    }
}