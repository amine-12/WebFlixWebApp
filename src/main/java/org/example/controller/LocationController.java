package org.example.controller;

import org.example.DTO.LocationRequestDTO;

import org.example.facade.FilmSystemFacade;
import org.example.model.Copie;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {
    private final FilmSystemFacade facade = new FilmSystemFacade();

    @PostMapping("/louer")
    public String louerFilm(@RequestBody LocationRequestDTO request) {
        return facade.louerFilm(request.getClientId(), request.getCopieId());
    }

    @GetMapping("/copies-disponibles/{filmId}")
    public ResponseEntity<List<Copie>> getCopiesDisponibles(@PathVariable int filmId) {
        List<Copie> copies = facade.getCopiesDisponibles(filmId);
        return ResponseEntity.ok(copies);
    }

}
