package com.example.poelse_project.repos;


import com.example.poelse_project.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
