package org.example.DTO;

public class CredentialsDTO {
    private String email;
    private String motDePasse;

    // Constructeur vide nécessaire pour Jackson
    public CredentialsDTO() {}

    // Constructeur pratique si tu veux initialiser d’un coup
    public CredentialsDTO(String email, String motDePasse) {
        this.email = email;
        this.motDePasse = motDePasse;
    }

    // ----- Getters et setters -----
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
