package org.example.service;

import org.example.dao.UtilisateurDAO;
import org.example.model.Utilisateur;

public class UtilisateurService {
    private final UtilisateurDAO dao = new UtilisateurDAO();

    public Utilisateur authenticate(String email, String motDePasse) {
        Utilisateur u = dao.findByEmail(email);
        if (u != null && u.getMotDePasse().equals(motDePasse)) {
            return u;
        }
        return null;
    }

    public Utilisateur register(String email, String motDePasse, String role) {
        if (dao.findByEmail(email) != null) {
            throw new IllegalArgumentException("Email déjà utilisé");
        }
        Utilisateur u = new Utilisateur(email, motDePasse, role);
        return dao.save(u);
    }
}
