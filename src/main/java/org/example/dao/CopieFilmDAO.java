package org.example.dao;

import org.example.HibernateUtil;
import org.example.model.Copie;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import org.hibernate.query.Query;
import java.util.List;

public class CopieFilmDAO {

    public Copie getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Copie copie = session.get(Copie.class, id);
        session.close();
        return copie;
    }

    public void update(Copie copie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(copie);
        tx.commit();
        session.close();
    }

    public List<Copie> getCopiesDisponiblesByFilmId(int filmId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Copie WHERE filmId = :filmId AND lower(estDisponible) = 'true'";
        Query<Copie> query = session.createQuery(hql, Copie.class);
        query.setParameter("filmId", filmId);
        List<Copie> result = query.getResultList();
        session.close();
        return result;
    }
}
