package org.example.dao;

import org.example.HibernateUtil;
import org.example.model.*;
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

    public List<Map<String, Object>> searchFilms(String titre, String genre, String pays, String langue, Integer anneeMin, Integer anneeMax, String acteur, String realisateur) {
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
            predicates.add(cb.like(cb.lower(filmRoot.get("langueOriginale")), "%" + langue.toLowerCase() + "%"));
        }

        if (anneeMin != null) {
            predicates.add(cb.greaterThanOrEqualTo(filmRoot.get("anneeSortie"), anneeMin));
        }

        if (anneeMax != null) {
            predicates.add(cb.lessThanOrEqualTo(filmRoot.get("anneeSortie"), anneeMax));
        }

        if ((acteur != null && !acteur.isBlank()) || (realisateur != null && !realisateur.isBlank())) {
            // Filtrage acteur
            if (acteur != null && !acteur.isBlank()) {
                Join<Film, PersonneFilmRole> acteurRoleJoin = filmRoot.join("roles", JoinType.INNER);
                Join<PersonneFilmRole, PersonneFilm> acteurJoin = acteurRoleJoin.join("personne");

                Predicate acteurPredicate = cb.and(
                        cb.equal(cb.lower(acteurRoleJoin.get("role")), "acteur"),
                        cb.like(cb.lower(acteurJoin.get("nom")), "%" + acteur.toLowerCase() + "%")
                );
                predicates.add(acteurPredicate);
            }

            // Filtrage réalisateur
            if (realisateur != null && !realisateur.isBlank()) {
                Join<Film, PersonneFilmRole> realisateurRoleJoin = filmRoot.join("roles", JoinType.INNER);
                Join<PersonneFilmRole, PersonneFilm> realisateurJoin = realisateurRoleJoin.join("personne");

                Predicate realPredicate = cb.and(
                        cb.equal(cb.lower(realisateurRoleJoin.get("role")), "realisateur"),
                        cb.like(cb.lower(realisateurJoin.get("nom")), "%" + realisateur.toLowerCase() + "%")
                );
                predicates.add(realPredicate);
            }
        }



        cq.multiselect(filmRoot.get("filmId"), filmRoot.get("titre"), filmRoot.get("anneeSortie")).distinct(true);

        if (!predicates.isEmpty()) {
            cq.where(cb.and(predicates.toArray(new Predicate[0])));
        }

        List<Object[]> results = session.createQuery(cq).getResultList();

        session.close();

        return results.stream().map(obj -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", obj[0]);
            map.put("titre", obj[1]);
            map.put("anneeSortie", obj[2]);
            return map;
        }).toList();
    }

    public void update(Film film) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(film);
        session.getTransaction().commit();
        session.close();
    }

}
