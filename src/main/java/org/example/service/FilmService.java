package org.example.service;

import org.example.dao.FilmDAO;
import org.example.model.Film;

public class FilmService {
    private FilmDAO filmDAO = new FilmDAO();

    public Film getFilmDetails(int id) {
        return filmDAO.getFilmById(id);
    }
}
