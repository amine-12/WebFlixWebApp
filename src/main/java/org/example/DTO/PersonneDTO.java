package org.example.DTO;

public class PersonneDTO {
    private Integer id;
    private String email;

    // Constructeur vide (pour Jackson si besoin)
    public PersonneDTO() {}

    // Constructeur paramétré
    public PersonneDTO(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}
