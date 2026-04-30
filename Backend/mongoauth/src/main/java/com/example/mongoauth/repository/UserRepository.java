package com.example.mongoauth.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongoauth.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}