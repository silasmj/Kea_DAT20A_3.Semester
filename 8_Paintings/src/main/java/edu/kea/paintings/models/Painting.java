package edu.kea.paintings.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "paintings")
public class Painting {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    @ApiModelProperty(notes ="Name of the artist")
    private String artist;
    @Column
    private double price;
    @Column
    private String title;
    @Column
    private String genre;
    @Column
    private int year;
    @Column
    private String image;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "paintings_artists",
            joinColumns = {
                    @JoinColumn(name = "paintings_id", referencedColumnName = "id",
                            nullable = true, updatable = true)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "artists_id", referencedColumnName = "id",
                            nullable = true, updatable = true)
            }
    )
    private List<Artist> artists;


}
