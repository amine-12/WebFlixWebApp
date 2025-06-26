package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "COPIE_FILM")
public class Copie {

    @Id
    @Column(name = "COPIE_ID")
    private Integer copieId;

    @Column(name = "CODE_COPIE", length = 50)
    private String codeCopie;

    @Column(name = "FILM_ID")
    private Integer filmId;

    @Column(name = "EST_DISPONIBLE", length = 5)
    private String estDisponible;

    public Copie() {}

    public Copie(Integer copieId, String codeCopie, Integer filmId, String estDisponible) {
        this.copieId = copieId;
        this.codeCopie = codeCopie;
        this.filmId = filmId;
        this.estDisponible = estDisponible;
    }

    public Integer getCopieId() {
        return copieId;
    }

    public void setCopieId(Integer copieId) {
        this.copieId = copieId;
    }

    public String getCodeCopie() {
        return codeCopie;
    }

    public void setCodeCopie(String codeCopie) {
        this.codeCopie = codeCopie;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getEstDisponible() {
        return estDisponible;
    }

    public void setEstDisponible(String estDisponible) {
        this.estDisponible = estDisponible;
    }
}
