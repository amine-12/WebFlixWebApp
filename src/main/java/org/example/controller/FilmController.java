package org.example.controller;
import java.util.List;

import org.example.DTO.FilmDTO;
import org.example.dao.FilmDAO;
import org.example.model.Film;
import org.example.service.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/films")
public class FilmController {
    private final FilmDAO filmDAO = new FilmDAO();
    @GetMapping("/{id}")
    public ResponseEntity<FilmDTO> getFilm(@PathVariable int id) {
        Film film = filmDAO.getFilmById(id);
        return ResponseEntity.ok(FilmDTO.from(film));
    }
}

