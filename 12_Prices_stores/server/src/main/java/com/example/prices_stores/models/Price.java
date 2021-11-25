package com.example.prices_stores.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "prices")
@Entity
public class Price {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private double price;

    @Column
    private double priceOfPrice;

    @Column
    private String size;

    @Column
    private String color;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

}
