package com.example.poelse_project.controllers;

import com.example.poelse_project.models.Product;
import com.example.poelse_project.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    ProductRepo productRepo;

    @GetMapping("/products")
    public Iterable<Product> getProducts() {
        return productRepo.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productRepo.findById(id).get();

    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product newProduct) {
        newProduct.setId(null);
        return productRepo.save(newProduct);
    }
}
