package org.example.facade;

import org.example.DTO.FilmDTO;
import org.example.DTO.PersonneFilmDTO;
import org.example.DTO.UtilisateurDTO;
import org.example.model.Utilisateur;
import org.example.service.FilmService;
import org.example.service.PersonneFilmService;
import org.example.service.UtilisateurService;

import java.util.List;
import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class FilmSystemFacade {
    private final FilmService filmService;
    private final PersonneFilmService personneFilmService;
    private final UtilisateurService utilisateurService;

    public FilmSystemFacade() {
        this.filmService = new FilmService();
        this.personneFilmService = new PersonneFilmService();
        this.utilisateurService = new UtilisateurService();
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

    public UtilisateurDTO login(String email, String motDePasse) {
        Utilisateur u = utilisateurService.authenticate(email, motDePasse);
        return u == null
                ? null
                : new UtilisateurDTO(u.getId(), u.getEmail(), u.getRole());
    }

    public UtilisateurDTO register(String email, String motDePasse, String role) {
        Utilisateur u = utilisateurService.register(email, motDePasse, role);
        return new UtilisateurDTO(u.getId(), u.getEmail(), u.getRole());
    }
}
