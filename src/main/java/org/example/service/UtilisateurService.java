package org.example.service;

import org.example.dao.UtilisateurDAO;
import org.example.model.Utilisateur;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class UtilisateurService {
    private final UtilisateurDAO dao = new UtilisateurDAO();
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Utilisateur authenticate(String email, String motDePasse) {
        Utilisateur u = dao.findByEmail(email);
        if (u != null && encoder.matches(motDePasse, u.getMotDePasse())) {
            return u;
        }
        return null;
    }

    public Utilisateur register(String email, String motDePasse, String role) {
        if (dao.findByEmail(email) != null) {
            throw new IllegalArgumentException("Email déjà utilisé");
        }
        // Ici on hache le mot de passe avant de le sauvegarder
        String hashedPassword = encoder.encode(motDePasse);
        Utilisateur u = new Utilisateur(email, hashedPassword, role);
        return dao.save(u);
    }
}
