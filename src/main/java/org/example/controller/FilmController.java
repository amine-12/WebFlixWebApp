package org.example.controller;

import org.example.DTO.FilmDTO;
import org.example.facade.FilmSystemFacade;
import org.example.model.Film;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/films")
public class FilmController {
    private final FilmSystemFacade facade;

    public FilmController() {
        this.facade = new FilmSystemFacade();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmDTO> getFilm(@PathVariable int id) {
        return ResponseEntity.ok(facade.getFilmDetails(id));
    }
}

