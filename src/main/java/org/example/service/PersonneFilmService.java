package org.example.service;

import org.example.dao.PersonneFilmDAO;
import org.example.model.PersonneFilm;

public class PersonneFilmService {
    PersonneFilmDAO personneFilmDAO = new PersonneFilmDAO();

    public PersonneFilm getPersonneFilmDetails(int id) {
        PersonneFilm personneFilm = personneFilmDAO.getById(id);
        return personneFilm;
    }
}
