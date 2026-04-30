package com.example.mongoauth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongoauth.model.Product;
import com.example.mongoauth.repository.ProductRepository;

@Service
	public class ProductService {

	    @Autowired
	    private ProductRepository repo;

	    public Product create(Product p) { return repo.save(p); }
	    public List<Product> list() { return repo.findAll(); }
	    public Product get(String id) { return repo.findById(id).orElse(null); }
	    public void delete(String id) { repo.deleteById(id); }
	}



