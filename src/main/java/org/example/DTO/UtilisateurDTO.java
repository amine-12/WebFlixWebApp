package org.example.DTO;

public class UtilisateurDTO {
    private Integer id;
    private String email;
    private String role;

    // Constructeur vide (pour Jackson si besoin)
    public UtilisateurDTO() {}

    // Constructeur paramétré
    public UtilisateurDTO(Integer id, String email, String role) {
        this.id = id;
        this.email = email;
        this.role = role;
    }

    // Getters pour la sérialisation JSON
    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
