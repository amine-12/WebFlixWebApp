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


    public Film getFilmById(int id, int clientId) {
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

        Object moyenne = session.createNativeQuery(
                        "SELECT moyenne FROM MA_VUE_MOYENNE WHERE idFilm = :id")
                .setParameter("id", id)
                .uniqueResult();
        System.out.println("Cote moyenne récupérée pour le film " + id + " : " + moyenne);

        if (moyenne != null) {
            film.setCoteMoyenne(((Number) moyenne).doubleValue());
        }

        System.out.println("Recommandations récupérées pour le film " + id + " : " + clientId);

        @SuppressWarnings("unchecked")
        List<Object[]> resultats = session.createNativeQuery(
                        "SELECT f.FILM_ID, f.TITRE, f.AFFICHE " +
                                "FROM MA_VUE_CORRELATIONS r " +
                                "JOIN FILM f ON r.PK = f.FILM_ID " +
                                "WHERE r.PJ = :filmId " +
                                // exclure les films déjà loués par ce client
                                "AND f.FILM_ID NOT IN ( " +
                                "    SELECT c.FILM_ID " +
                                "    FROM LOCATION l " +
                                "    JOIN COPIE_FILM c ON l.COPIE_ID = c.COPIE_ID " +
                                "    WHERE l.CLIENT_ID = :clientId " +
                                ") " +
                                // garder seulement les films qui ont au moins une copie disponible
                                "AND EXISTS ( " +
                                "    SELECT 1 FROM COPIE_FILM cf " +
                                "    WHERE cf.FILM_ID = f.FILM_ID AND cf.EST_DISPONIBLE = 'true'\n " +
                                ") " +
                                "ORDER BY r.CORRELATION DESC"
                )
                .setParameter("filmId", id)
                .setParameter("clientId", clientId)
                .getResultList();

        List<Film> recommandations = new ArrayList<>();
        for (Object[] row : resultats) {
            if (recommandations.size() >= 3) break; // TOP 3 réellement disponibles
            Film recommandation = new Film();
            recommandation.setFilmId(((Number) row[0]).intValue());
            recommandation.setTitre((String) row[1]);
            recommandation.setAffiche((String) row[2]);
            recommandations.add(recommandation);
        }

        System.out.println("Recommandations récupérées pour le film " + id + " : " + recommandations);

        film.setFilmsRecommandes(recommandations);

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
