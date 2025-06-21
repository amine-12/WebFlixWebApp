package org.example.dao;

import org.example.HibernateUtil;
import org.example.model.Film;
import org.example.model.PersonneFilmRole;
import org.hibernate.Hibernate;
import org.hibernate.Session;

public class FilmDAO {

    public Film getFilmById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Film film = session.get(Film.class, id);

        if (film != null) {
            // Initialiser toutes les relations nécessaires tant que la session est encore ouverte
            Hibernate.initialize(film.getGenres());
            Hibernate.initialize(film.getPays());
            Hibernate.initialize(film.getScenaristes());
            Hibernate.initialize(film.getBandesAnnonces());
            Hibernate.initialize(film.getRoles());
            Hibernate.initialize(film.getPersonnages());

            for (PersonneFilmRole role : film.getRoles()) {
                Hibernate.initialize(role.getPersonne());
            }

            film.getRoles().stream()
                    .filter(r -> r.getRole().equalsIgnoreCase("Réalisateur"))
                    .findFirst()
                    .ifPresent(r -> Hibernate.initialize(r.getPersonne()));
        }

        session.close();
        return film;
    }
}
