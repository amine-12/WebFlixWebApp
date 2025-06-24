package org.example.dao;

import org.example.HibernateUtil;
import org.example.model.Film;
import org.example.model.Genre;
import org.example.model.Pays;
import org.example.model.PersonneFilmRole;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<Map<String, Object>> searchFilms(String titre, String genre, String pays, String langue, Integer anneeMin, Integer anneeMax) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Film> filmRoot = cq.from(Film.class);

        List<Predicate> predicates = new ArrayList<>();

        if (titre != null && !titre.isBlank()) {
            predicates.add(cb.like(cb.lower(filmRoot.get("titre")), "%" + titre.toLowerCase() + "%"));
        }

        if (genre != null && !genre.isBlank()) {
            Join<Film, Genre> genreJoin = filmRoot.join("genres");
            predicates.add(cb.equal(cb.lower(genreJoin.get("nom")), genre.toLowerCase()));
        }

        if (pays != null && !pays.isBlank()) {
            Join<Film, Pays> paysJoin = filmRoot.join("pays");
            predicates.add(cb.equal(cb.lower(paysJoin.get("nom")), pays.toLowerCase()));
        }

        if (langue != null && !langue.isBlank()) {
            predicates.add(cb.like(cb.lower(filmRoot.get("langueOriginale")), langue.toLowerCase()));
        }

        if (anneeMin != null) {
            predicates.add(cb.greaterThanOrEqualTo(filmRoot.get("anneeSortie"), anneeMin));
        }

        if (anneeMax != null) {
            predicates.add(cb.lessThanOrEqualTo(filmRoot.get("anneeSortie"), anneeMax));
        }

        cq.multiselect(filmRoot.get("filmId"), filmRoot.get("titre")).distinct(true);

        if (!predicates.isEmpty()) {
            cq.where(cb.and(predicates.toArray(new Predicate[0])));
        }

        List<Object[]> results = session.createQuery(cq).getResultList();

        session.close();

        // Convertir en liste de maps { "id": ..., "titre": ... }
        return results.stream().map(obj -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", obj[0]);
            map.put("titre", obj[1]);
            return map;
        }).toList();
    }
}
