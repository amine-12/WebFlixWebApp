package org.example.DTO;

public class PersonneDTO {
    private Integer id;
    private String email;
    private String role;

    // Constructeur vide (pour Jackson si besoin)
    public PersonneDTO() {}

    // Constructeur paramétré
    public PersonneDTO(Integer id, String email) {
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
