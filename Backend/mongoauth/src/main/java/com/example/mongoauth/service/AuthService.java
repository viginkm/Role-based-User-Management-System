package com.example.mongoauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.mongoauth.config.JwtUtil;
import com.example.mongoauth.model.User;
import com.example.mongoauth.repository.UserRepository;

@Service
public class AuthService {
	@Autowired
	private BCryptPasswordEncoder encoder;

    private final UserRepository repo;
    private final JwtUtil jwt;

    public AuthService(UserRepository repo, JwtUtil jwt) {
        this.repo = repo;
        this.jwt = jwt;
    }

    public String login(String username, String password) {
        User user = repo.findByUsername(username);
        if (user != null &&         encoder.matches(password, user.getPassword())  )      {            //   new BCryptPasswordEncoder().matches(password, user.getPassword())) {
            return jwt.generateToken(user.getUsername(), user.getRole().name());
        }
        return null;
    }
}