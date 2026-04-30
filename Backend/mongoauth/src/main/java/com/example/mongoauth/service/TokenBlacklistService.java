package com.example.mongoauth.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.mongoauth.model.BlacklistedToken;
import com.example.mongoauth.repository.BlacklistedTokenRepository;

@Service
public class TokenBlacklistService {

    private final BlacklistedTokenRepository repository;

    public TokenBlacklistService(BlacklistedTokenRepository repository) {
        this.repository = repository;
    }

    public void blacklistToken(String token, LocalDateTime expiry) {
        repository.save(new BlacklistedToken(token, expiry));
    }

    public boolean isTokenBlacklisted(String token) {
        return repository.existsByToken(token);
    }
}