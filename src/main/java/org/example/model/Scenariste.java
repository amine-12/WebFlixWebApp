package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "SCENARISTE")
public class Scenariste {

    @Id
    @Column(name = "SCENARISTE_ID")
    private int id;

    @Column(name = "NOM")
    private String nom;

    public Scenariste() {
    }

    public Scenariste(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    // Getters et setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
