package org.example.dao;

import org.example.HibernateUtil;
import org.example.model.Utilisateur;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UtilisateurDAO {

    public Utilisateur findByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Utilisateur> q = session.createQuery(
                    "FROM Utilisateur u WHERE u.email = :email", Utilisateur.class);
            q.setParameter("email", email);
            return q.uniqueResult();
        }
    }

    public Utilisateur save(Utilisateur user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            return user;
        }
    }
}
