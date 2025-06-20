package org.example.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Embeddable
public class PersonneFilmRoleId implements Serializable {

    @Column(name = "FILM_ID")
    private int filmId;

    @Column(name = "PERSONNE_FILM_ID")
    private int personneFilmId;

    public PersonneFilmRoleId() {}

    public PersonneFilmRoleId(int filmId, int personneFilmId) {
        this.filmId = filmId;
        this.personneFilmId = personneFilmId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getPersonneFilmId() {
        return personneFilmId;
    }

    public void setPersonneFilmId(int personneFilmId) {
        this.personneFilmId = personneFilmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonneFilmRoleId)) return false;
        PersonneFilmRoleId p = (PersonneFilmRoleId) o;
        return filmId == p.filmId && personneFilmId == p.personneFilmId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, personneFilmId);
    }
}
