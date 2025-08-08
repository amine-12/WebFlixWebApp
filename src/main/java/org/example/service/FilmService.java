package org.example.service;

import org.example.dao.FilmDAO;
import org.example.model.Client;
import org.example.model.Film;

import java.util.List;
import java.util.Map;

public class FilmService {
    private final FilmDAO filmDAO = new FilmDAO();
    private final org.example.dao.ClientDAO clientDAO = new org.example.dao.ClientDAO();

    public Film getFilmDetails(int id, int clientId) {
        Film film = filmDAO.getFilmById(id, clientId);

        return film;
    }

    public List<Map<String, Object>> getFilms(String titre, String genres, String pays, String langue, Integer anneeMin, Integer anneeMax, String acteur, String realisateur) {
        return filmDAO.searchFilms(titre, genres, pays, langue, anneeMin, anneeMax, acteur, realisateur);
    }
}

