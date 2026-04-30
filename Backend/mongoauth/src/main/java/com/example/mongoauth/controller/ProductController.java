package com.example.mongoauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongoauth.model.Product;
import com.example.mongoauth.service.ProductService;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public Product create(@RequestBody Product p) {
        return service.create(p);
    }

    @GetMapping
    public List<Product> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable String id) {
        return service.get(id);
    }
}