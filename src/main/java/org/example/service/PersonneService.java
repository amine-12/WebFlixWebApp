package org.example.service;


import org.example.dao.PersonneDAO;
import org.example.model.Personne;

public class PersonneService {
    private final PersonneDAO personneDAO = new PersonneDAO();

    public Personne login(String courriel, String motDePasse){
        return personneDAO.login(courriel,motDePasse);
    }
}
