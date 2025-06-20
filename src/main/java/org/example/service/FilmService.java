package org.example.service;

import org.example.dao.FilmDAO;
import org.example.model.Film;

public class FilmService {
    private final FilmDAO filmDAO = new FilmDAO();

    public Film getFilmDetails(int id) {
        Film film = filmDAO.getFilmById(id);
        return film;
    }
}

