package org.example.dao;

import org.example.HibernateUtil;
import org.example.model.Client;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ClientDAO {

    public Client getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }
}
