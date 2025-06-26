package org.example.controller;

import org.example.DTO.FilmDTO;
import org.example.facade.FilmSystemFacade;
import org.example.model.Film;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/films")
public class FilmController {
    private final FilmSystemFacade facade;

    public FilmController() {
        this.facade = new FilmSystemFacade();
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<FilmDTO> getFilm(@PathVariable int id) {
        return ResponseEntity.ok(facade.getFilmDetails(id));
    }

    @GetMapping("/recherche-films")
    public ResponseEntity<List<Map<String, Object>>> rechercherFilms(
            @RequestParam(required = false) String titre,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) String pays,
            @RequestParam(required = false) String langue,
            @RequestParam(required = false) Integer annee_min,
            @RequestParam(required = false) Integer annee_max,
            @RequestParam(required = false) String acteur,
            @RequestParam(required = false) String realisateur
            ) {
        List<Map<String, Object>> resultat = facade.getFilms(
                titre, genre, pays, langue, annee_min, annee_max, acteur, realisateur
        );
        return ResponseEntity.ok(resultat);
    }


}

