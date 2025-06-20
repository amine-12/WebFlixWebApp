package org.example.controller;

import org.example.DTO.PersonneDTO;
import org.example.dao.PersonneFilmDAO;
import org.example.model.PersonneFilm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/personnes/")
public class PersonneFilmController {
    PersonneFilmDAO personneFilmDAO = new PersonneFilmDAO();
    @GetMapping("/{id}")
    public ResponseEntity<PersonneDTO> getPersonne(@PathVariable int id) {
        PersonneFilm personne = personneFilmDAO.getById(id);
        if (personne == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(PersonneDTO.from(personne));
    }

}
