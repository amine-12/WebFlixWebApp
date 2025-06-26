package org.example.service;

import org.example.dao.ClientDAO;
import org.example.dao.CopieFilmDAO;
import org.example.dao.FilmDAO;
import org.example.dao.LocationDAO;
import org.example.model.Client;
import org.example.model.Copie;
import org.example.model.Film;
import org.example.model.Location;

import java.time.LocalDate;
import java.util.List;

public class LocationService {

    private final ClientDAO clientDAO = new ClientDAO();
    private final CopieFilmDAO copieFilmDAO = new CopieFilmDAO();
    private final FilmDAO filmDAO = new FilmDAO();
    private final LocationDAO locationDAO = new LocationDAO();

    public String louerFilm(int clientId, int copieId) {
        // Charger client
        Client client = clientDAO.getById(clientId);
        if (client == null) return "Client introuvable.";

        // Charger copie
        Copie copie = copieFilmDAO.getById(copieId);
        if (copie == null || !"true".equalsIgnoreCase(copie.getEstDisponible())) {
            return "Copie non disponible.";
        }

        // Vérifier le droit de louer
        int nbLocationsActives = locationDAO.countLocationsActivesByClientId(client.getId());
        if (nbLocationsActives >= client.getForfait().getMaxLocations()) {
            return "Le forfait du client ne permet pas plus de locations en cours.";
        }

        // Charger le film
        Film film = filmDAO.getFilmById(copie.getFilmId());
        if (film == null || film.getNbrCopiesDisponibles() <= 0) {
            return "Aucune copie disponible pour ce film.";
        }

        // Mise à jour BD
        copie.setEstDisponible("false");
        copieFilmDAO.update(copie);

        film.setNbrCopiesDisponibles(film.getNbrCopiesDisponibles() - 1);
        filmDAO.update(film);

        // Enregistrer la location
        Location location = new Location();
        location.setClientId(client.getId());
        location.setCopieId(copie.getCopieId());
        location.setDateLocation(LocalDate.now());
        location.setDateRetourPrevu(LocalDate.now().plusDays(client.getForfait().getDureeMax()));

        locationDAO.save(location);

        return "Location enregistrée avec succès.";
    }

    public List<Copie> getCopies(int filmId){
        return copieFilmDAO.getCopiesDisponiblesByFilmId(filmId);
    }
}
