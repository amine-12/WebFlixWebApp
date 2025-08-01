package org.example.controller;

import org.example.DTO.PersonneFilmDTO;
import org.example.facade.FilmSystemFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/personnes-films/")
public class PersonneFilmController {
    private final FilmSystemFacade facade;

    public PersonneFilmController() {
        this.facade = new FilmSystemFacade();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonneFilmDTO> getPersonne(@PathVariable int id) {
        PersonneFilmDTO personne = facade.getPersonneDetails(id);
        if (personne == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personne);
    }

}
