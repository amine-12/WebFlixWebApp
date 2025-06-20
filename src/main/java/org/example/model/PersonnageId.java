package org.example.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Embeddable
public class PersonnageId implements Serializable {

    private int acteurId;
    private int filmId;

    public PersonnageId() {}

    public PersonnageId(int acteurId, int filmId) {
        this.acteurId = acteurId;
        this.filmId = filmId;
    }

    // Getters et setters
    public int getActeurId() { return acteurId; }
    public void setActeurId(int acteurId) { this.acteurId = acteurId; }

    public int getFilmId() { return filmId; }
    public void setFilmId(int filmId) { this.filmId = filmId; }

    // equals() et hashCode() sont OBLIGATOIRES pour les clés composites
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonnageId)) return false;
        PersonnageId that = (PersonnageId) o;
        return acteurId == that.acteurId && filmId == that.filmId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(acteurId, filmId);
    }
}
