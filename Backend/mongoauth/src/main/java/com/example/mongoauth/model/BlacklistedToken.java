package com.example.mongoauth.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "blacklisted_tokens")
public class BlacklistedToken {

    @Id
    private String id;

    private String token;

    private LocalDateTime expiry;

    public BlacklistedToken(String token, LocalDateTime expiry) {
        this.token = token;
        this.expiry = expiry;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getExpiry() {
		return expiry;
	}

	public void setExpiry(LocalDateTime expiry) {
		this.expiry = expiry;
	}

	public BlacklistedToken(String id, String token, LocalDateTime expiry) {
		super();
		this.id = id;
		this.token = token;
		this.expiry = expiry;
	}

	public BlacklistedToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BlacklistedToken [id=" + id + ", token=" + token + ", expiry=" + expiry + "]";
	}

    // Getters & Setters
    
    
}