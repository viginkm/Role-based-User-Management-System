package com.example.mongoauth.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongoauth.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}