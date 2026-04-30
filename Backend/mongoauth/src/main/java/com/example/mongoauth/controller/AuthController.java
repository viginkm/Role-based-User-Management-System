package com.example.mongoauth.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongoauth.config.JwtAuthenticationFilter;
import com.example.mongoauth.service.AuthService;

import jakarta.servlet.http.HttpServletRequest;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> map) {
        String token = service.login(map.get("username"), map.get("password"));
        if (token == null)
            return ResponseEntity.status(401).body("Invalid Credentials");
        return ResponseEntity.ok(Map.of("token", token));
    }
    

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            JwtAuthenticationFilter.blacklistToken(token);
        }

        return ResponseEntity.ok("Logged out successfully!");
    }
}