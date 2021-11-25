package com.example.prices_stores.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stores")
@Data
public class Store {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String owner;

    @Column
    private String storeName;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Type type;

    @Column
    @Enumerated(value = EnumType.STRING)
    private CountryOfOrigin madeIn;

    @JsonIgnore
    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Price> prices;
}
