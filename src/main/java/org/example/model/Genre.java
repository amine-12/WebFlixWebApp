package org.example.model;

public class Genre {
    private int genreId;
    private String nom;

    public Genre(String nom) {
        this.nom = nom;
    }

    public Genre(int id, String nom) {
        this.genreId = id;
        this.nom = nom;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
