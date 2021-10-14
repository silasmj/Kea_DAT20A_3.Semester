package edu.kea.paintings.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.kea.paintings.DTO.ArtistDTO;
import edu.kea.paintings.models.Painting;
import edu.kea.paintings.repositories.ArtistRepository;
import edu.kea.paintings.repositories.PaintingRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api(value = "Paintings controller", description = "REST endpoints for paintings")
@RestController
public class Paintings {

    @Autowired
    PaintingRepository paintings;

    @Autowired
    ArtistRepository artists;

    @GetMapping("/paintings")
    public Iterable<Painting> getPaintings() {
        return paintings.findAll();
    }

    @GetMapping("/paintings/{id}")
    public Painting getPaintingById(@PathVariable Long id) {
        return paintings.findById(id).get();
    }

    @GetMapping("/paintings/timeline")
    public List<Painting> getPaintingByArtistAndYear(@RequestParam String artist, @RequestParam int year) {
        return paintings.findPaintingsByArtistAndYear(artist, year);
    }

    @GetMapping("/paintings/priceabove/{price}")
    public List<Painting> findPaintingsAboveACertainPrice(@PathVariable double price) {
        return paintings.findPaintingsAboveACertainPrice(price);
    }

    @PostMapping("/paintings")
    public Painting addPainting(@RequestBody String body) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        Painting paintingToCreate = mapper.readValue(body, Painting.class);

        Iterable<Long> artistsIds = mapper.readValue(body, ArtistDTO.class).artistsIds;

        artists.findAllById(artistsIds);

        return null;

       /* newPainting.setId(null);
        return paintings.save(newPainting); */
    }
    @DeleteMapping("/paintings/{id}")
    public void deletePaintingById(@PathVariable Long id) {
        paintings.deleteById(id);
    }
    @PutMapping("/paintings/{id}")
    public String updatePainting(@PathVariable Long id, @RequestBody Painting paintingToUpdate) {
        if(paintings.existsById(id)) {
            paintingToUpdate.setId(id);
            paintings.save(paintingToUpdate);
            return "Painting was created";
        }else{
            return "Painting was not found";
        }
    }
    @PatchMapping("/paintings/{id}")
    public String patchPainting(@PathVariable Long id, @RequestBody Painting paintingToUpdate) {
        return paintings.findById(id).map(foundPaiting -> {
            if (paintingToUpdate.getArtist() != null) foundPaiting.setArtist(paintingToUpdate.getArtist());
            if (paintingToUpdate.getPrice() != 0) foundPaiting.setPrice(paintingToUpdate.getPrice());
            if (paintingToUpdate.getTitle() != null) foundPaiting.setTitle(paintingToUpdate.getTitle());
            if (paintingToUpdate.getGenre() != null) foundPaiting.setGenre(paintingToUpdate.getGenre());
            if (paintingToUpdate.getYear() != 0) foundPaiting.setYear(paintingToUpdate.getYear());

            paintings.save(foundPaiting);
            return "Painting updated";
        }).orElse("Painting not found");
    }



}
