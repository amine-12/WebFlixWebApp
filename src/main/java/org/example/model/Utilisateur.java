package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "UTILISATEUR")
@SequenceGenerator(
        name = "util_seq",                 // nom du générateur Hibernate
        sequenceName = "UTILISATEUR_SEQ",  // nom de la séquence Oracle
        allocationSize = 1                 // Hibernate fera NEXTVAL à chaque insert
)
public class Utilisateur {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "util_seq"
    )
    @Column(name = "UTILISATEUR_ID")
    private Integer id;

    @Column(name = "EMAIL", unique = true, nullable = false, length = 255)
    private String email;

    @Column(name = "MOT_DE_PASSE", nullable = false, length = 255)
    private String motDePasse;

    @Column(name = "ROLE", nullable = false, length = 50)
    private String role;

    // Constructeur vide pour Hibernate/Jackson
    public Utilisateur() {}

    // Constructeur pratique
    public Utilisateur(String email, String motDePasse, String role) {
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
    }

    // ----- Getters et setters -----
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
