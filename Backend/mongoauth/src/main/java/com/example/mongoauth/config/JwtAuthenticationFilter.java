package com.example.mongoauth.config;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.mongoauth.service.TokenBlacklistService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
public static 	final Set<String> tokenBlacklist = new HashSet<String>();

    private JwtUtil jwtUtil;
    
    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
    	
    	
        this.jwtUtil = jwtUtil;
        
    }
    
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
        	
        	
        	
        	
        	
        	String token = header.substring(7);
        	if (tokenBlacklist.contains(token)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Token is logged out!");
                return;
            }
        	
        	
        	
        	
        	
        	
        	
        	
        	
            try {
               // String token = header.substring(7);
                var claims = jwtUtil.extractAll(token);

                String username = claims.getSubject();
                String role = claims.get("role", String.class);

                var auth = new UsernamePasswordAuthenticationToken(username, null,
                        java.util.List.of(() -> "ROLE_" + role));

                SecurityContextHolder.getContext().setAuthentication(auth);
            } catch (Exception ignored) {}
        }
        

        filterChain.doFilter(request, response);
    }
    
    
    public static void blacklistToken(String token) {
        tokenBlacklist.add(token);
    }
    
}
