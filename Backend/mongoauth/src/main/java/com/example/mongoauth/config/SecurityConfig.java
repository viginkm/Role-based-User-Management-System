package com.example.mongoauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@Configuration
//public class SecurityConfig {
//
//    private final JwtUtil jwtUtil;
//
//    public SecurityConfig(JwtUtil jwtUtil) {
//        this.jwtUtil = jwtUtil;
//    }
//
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//            .addFilter(new JwtAuthenticationFilter(jwtUtil))
//            .authorizeHttpRequests()
//            .requestMatchers("/auth/login").permitAll()
//            .requestMatchers("/users/**").hasRole("ADMIN")  // only admin
//            .requestMatchers("/products/**").hasAnyRole("ADMIN", "USER")
//            .anyRequest().authenticated();
//
//        return http.build();
//    }
//}

@Configuration
public class SecurityConfig {

    private final JwtUtil jwtUtil;

    public SecurityConfig(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
        .cors(cors -> {})      
        .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/users/**").hasRole("ADMIN")
                        .requestMatchers("/products/**").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated()
                )
                // IMPORTANT FIX
                .addFilterBefore(
                        new JwtAuthenticationFilter(jwtUtil),
                        UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}