package org.example.facade;

import org.example.DTO.FilmDTO;
import org.example.DTO.PersonneFilmDTO;
import org.example.DTO.PersonneDTO;
import org.example.model.Copie;
import org.example.model.Personne;
import org.example.model.Utilisateur;
import org.example.service.*;

import java.util.List;
import java.util.Map;

public class FilmSystemFacade {
    private final FilmService filmService;
    private final PersonneFilmService personneFilmService;
    private final UtilisateurService utilisateurService;
    private final LocationService locationService;
    private final PersonneService personneService;

    public FilmSystemFacade() {
        this.personneService = new PersonneService();
        this.filmService = new FilmService();
        this.personneFilmService = new PersonneFilmService();
        this.utilisateurService = new UtilisateurService();
        this.locationService = new LocationService();
    }

    public List<Map<String, Object>> getFilms(String titre, String genres, String pays, String langue, Integer anneeMin, Integer anneeMax,String acteur, String realisateur) {
        return filmService.getFilms(titre, genres, pays, langue, anneeMin, anneeMax, acteur, realisateur);
    }

    public FilmDTO getFilmDetails(int id, int clientId) {
        return FilmDTO.from(filmService.getFilmDetails(id, clientId));
    }

    public PersonneFilmDTO getPersonneDetails(int id) {
        return PersonneFilmDTO.from(personneFilmService.getPersonneFilmDetails(id));
    }

    public Personne login(String email, String motDePasse) {
        return personneService.login(email, motDePasse);
    }

    public List<Copie> getCopiesDisponibles(int filmId) {
        return locationService.getCopies(filmId);
    }

    public String louerFilm(int clientId, int copieId) {
        return locationService.louerFilm(clientId, copieId);
    }
}
