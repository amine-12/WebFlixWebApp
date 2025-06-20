package org.example.dao;

import org.example.HibernateUtil;
import org.example.model.PersonneFilm;
import org.hibernate.Session;

public class PersonneFilmDAO {

    public PersonneFilm getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        PersonneFilm personne = session.get(PersonneFilm.class, id);
        session.close();
        return personne;
    }
}
