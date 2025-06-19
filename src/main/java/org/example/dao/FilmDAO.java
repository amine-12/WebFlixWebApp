package org.example.dao;

import org.example.HibernateUtil;
import org.example.model.Film;
import org.hibernate.Session;

public class FilmDAO {
    public Film getFilmById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Film film = session.get(Film.class, id);
        session.close();
        return film;
    }
}
