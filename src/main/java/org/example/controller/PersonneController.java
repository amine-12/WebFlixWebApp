package org.example.controller;

import org.example.facade.FilmSystemFacade;
import org.example.model.Personne;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personnes")
public class PersonneController {
    private final FilmSystemFacade facade = new FilmSystemFacade();

    @PostMapping("/login")
    public ResponseEntity<Personne> login(@RequestParam String courriel, @RequestParam String motDePasse) {
        Personne personne = facade.login(courriel, motDePasse);
        if (personne == null) {
            return ResponseEntity.status(401).build();
        }
        return ResponseEntity.ok(personne);
    }
}
