package org.example.model;

public class ActeurFilm {
    private Acteur acteur;
    private Film film;
    private String personnage;

    public ActeurFilm() {
    }

    public ActeurFilm(Acteur acteur, Film film, String personnage) {
        this.acteur = acteur;
        this.film = film;
        this.personnage = personnage;
    }

    public Acteur getActeur() {
        return acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String getPersonnage() {
        return personnage;
    }

    public void setPersonnage(String personnage) {
        this.personnage = personnage;
    }
}
