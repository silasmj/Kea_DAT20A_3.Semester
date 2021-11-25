package com.example.poelse_project.models;

import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;

@Data
@Table(name = "products")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private double price;

    @Column
    private String category;

    @Column
    private String country;

}
