package dk.kea.trash_api.controllers;

import dk.kea.trash_api.SuperMarioCharacters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuperMarioController {

    static SuperMarioCharacters superMarioCharacters = new SuperMarioCharacters();

    @GetMapping("/supermario/characters")
    public SuperMarioCharacters getCharacters() {
        return superMarioCharacters;
    }
}
