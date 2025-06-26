package org.example.facade;

import org.example.DTO.FilmDTO;
import org.example.DTO.PersonneFilmDTO;
import org.example.service.FilmService;
import org.example.service.PersonneFilmService;

import java.util.List;
import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class FilmSystemFacade {
    private final FilmService filmService;
    private final PersonneFilmService personneFilmService;

    public FilmSystemFacade() {
        this.filmService = new FilmService();
        this.personneFilmService = new PersonneFilmService();
    }

    public List<Map<String, Object>> getFilms(String titre, String genres, String pays, String langue, Integer anneeMin, Integer anneeMax,String acteur, String realisateur) {
        return filmService.getFilms(titre, genres, pays, langue, anneeMin, anneeMax, acteur, realisateur);
    }

    public FilmDTO getFilmDetails(int id) {
        return FilmDTO.from(filmService.getFilmDetails(id));
    }

    public PersonneFilmDTO getPersonneDetails(int id) {
        return PersonneFilmDTO.from(personneFilmService.getPersonneFilmDetails(id));
    }

}
