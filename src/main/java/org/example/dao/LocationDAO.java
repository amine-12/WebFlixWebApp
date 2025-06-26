package org.example.dao;

import org.example.HibernateUtil;
import org.example.model.Location;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LocationDAO {

    public void save(Location location) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(location);
        tx.commit();
        session.close();
    }

    public int countLocationsActivesByClientId(int clientId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Long count = session.createQuery(
                        "SELECT COUNT(l) FROM Location l WHERE l.clientId = :clientId AND l.dateRetourReel IS NULL", Long.class
                ).setParameter("clientId", clientId)
                .uniqueResult();
        session.close();
        return count != null ? count.intValue() : 0;
    }


    public Location getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Location location = session.get(Location.class, id);
        session.close();
        return location;
    }
}
