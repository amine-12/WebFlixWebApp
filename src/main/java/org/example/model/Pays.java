package org.example.model;

public class Pays {
    private int paysId;
    private String nom;

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
