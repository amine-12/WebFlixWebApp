package org.example.service;

import org.example.dao.FilmDAO;
import org.example.model.Film;

import java.util.List;
import java.util.Map;

public class FilmService {
    private final FilmDAO filmDAO = new FilmDAO();

    public Film getFilmDetails(int id) {
        Film film = filmDAO.getFilmById(id);
        return film;
    }

    public List<Map<String, Object>> getFilms(String titre, String genres, String pays, String langue, Integer anneeMin, Integer anneeMax, String acteur, String realisateur) {
        return filmDAO.searchFilms(titre, genres, pays, langue, anneeMin, anneeMax, acteur, realisateur);
    }
}

