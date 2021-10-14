package dk.kea.trash_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PokemonController {
    List<String> pokemon = Arrays.asList("Charmander", "Pikachu", "Weedle", "Beedrill", "Squirtle", "Charizard");

    @GetMapping("/pokemon/go")
    public boolean pokemonGo() {
        return true;
    }
    @GetMapping("/pokemon")
    public List<String> getAllPokemon() {
        return pokemon;
    }


}
