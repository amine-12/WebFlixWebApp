package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "PERSONNAGE")
public class Personnage {

    @EmbeddedId
    private PersonnageId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("acteurId")
    @JoinColumn(name = "ACTEUR_ID")
    private PersonneFilm acteur;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("filmId")
    @JoinColumn(name = "FILM_ID")
    private Film film;

    @Column(name = "NOM_PERSONNAGE")
    private String nomPersonnage;

    // Getters
    public PersonneFilm getActeur() { return acteur; }
    public Film getFilm() { return film; }
    public String getNomPersonnage() { return nomPersonnage; }
}

