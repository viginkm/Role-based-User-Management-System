package com.example.mongoauth.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongoauth.model.BlacklistedToken;

public interface BlacklistedTokenRepository extends MongoRepository<BlacklistedToken, String> {
    boolean existsByToken(String token);
}