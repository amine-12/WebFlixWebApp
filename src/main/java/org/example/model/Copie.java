package org.example.model;

import java.util.List;

public class Copie {
    private int copieId;
    private String codeCopie;
    private Film film;
    private String estDisponible;
    private List<Location> locations;

    public Copie(int copieId, String codeCopie, Film film, String estDisponible, List<Location> locations) {
        this.copieId = copieId;
        this.codeCopie = codeCopie;
        this.film = film;
        this.estDisponible = estDisponible;
        this.locations = locations;
    }

    public Copie() {

    }
    public int getCopieId() {
        return copieId;
    }

    public void setCopieId(int copieId) {
        this.copieId = copieId;
    }

    public String getCodeCopie() {
        return codeCopie;
    }

    public void setCodeCopie(String codeCopie) {
        this.codeCopie = codeCopie;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String isEstDisponible() {
        return estDisponible;
    }

    public void setEstDisponible(String estDisponible) {
        this.estDisponible = estDisponible;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
