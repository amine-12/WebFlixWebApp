package org.example.dao;

import org.example.DTO.PersonneDTO;
import org.example.HibernateUtil;
import org.example.model.Personne;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class PersonneDAO {

    public Personne login(String courriel, String motDePasse) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Personne> query = session.createQuery(
                "FROM Personne WHERE courriel = :courriel AND motDePasse = :motDePasse", Personne.class
        );
        query.setParameter("courriel", courriel);
        query.setParameter("motDePasse", motDePasse);

        Personne personne = query.uniqueResult();
        session.close();
        return personne;
    }
}
