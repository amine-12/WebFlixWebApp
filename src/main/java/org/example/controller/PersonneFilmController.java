package org.example.controller;

import org.example.DTO.PersonneFilmDTO;
import org.example.model.PersonneFilm;
import org.example.service.PersonneFilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/personnes-films/")
public class PersonneFilmController {
    PersonneFilmService personneFilmService = new PersonneFilmService();

    @GetMapping("/{id}")
    public ResponseEntity<PersonneFilmDTO> getPersonne(@PathVariable int id) {
        PersonneFilm personne = personneFilmService.getPersonneFilmDetails(id);
        if (personne == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(PersonneFilmDTO.from(personne));
    }

}
