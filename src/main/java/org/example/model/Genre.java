package org.example.model;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name = "GENRE")
public class Genre {

    @Id
    @Column(name = "GENRE_ID")
    private int genreId;

    @Column(name = "NOM")
    private String nom;

    public Genre() {}

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
