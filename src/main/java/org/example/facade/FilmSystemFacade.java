package org.example.facade;

import org.example.DTO.FilmDTO;
import org.example.DTO.PersonneFilmDTO;
import org.example.service.FilmService;
import org.example.service.PersonneFilmService;

public class FilmSystemFacade {
    private final FilmService filmService;
    private final PersonneFilmService personneFilmService;

    public FilmSystemFacade() {
        this.filmService = new FilmService();
        this.personneFilmService = new PersonneFilmService();
    }

    public FilmDTO getFilmDetails(int id) {
        return FilmDTO.from(filmService.getFilmDetails(id));
    }

    public PersonneFilmDTO getPersonneDetails(int id) {
        return PersonneFilmDTO.from(personneFilmService.getPersonneFilmDetails(id));
    }

}
