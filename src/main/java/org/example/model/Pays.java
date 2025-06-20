package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "PAYS")
public class Pays {
    @Id
    @Column(name = "PAYS_ID")
    private int paysId;

    @Column(name = "NOM")
    private String nom;

    public Pays() {}

    public Pays(String nom) {
        this.nom = nom;
    }

    public Pays(int id, String nom) {
        this.paysId = id;
        this.nom = nom;
    }

    public int getPaysId() {
        return paysId;
    }

    public void setPaysId(int paysId) {
        this.paysId = paysId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
