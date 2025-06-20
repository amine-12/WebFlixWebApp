package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "PERSONNE_FILM_ROLE")
public class PersonneFilmRole {

    @EmbeddedId
    private PersonneFilmRoleId id;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "FILM_ID")
    private Film film;

    @ManyToOne
    @MapsId("personneFilmId")
    @JoinColumn(name = "PERSONNE_FILM_ID")
    private PersonneFilm personne;

    @Column(name = "ROLE", length = 50)
    private String role;

    public PersonneFilmRole() {}

    public PersonneFilmRole(Film film, PersonneFilm personne, String role) {
        this.film = film;
        this.personne = personne;
        this.role = role;
        this.id = new PersonneFilmRoleId(film.getFilmId(), personne.getPersonneFilmId());
    }

    public PersonneFilmRoleId getId() {
        return id;
    }

    public void setId(PersonneFilmRoleId id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public PersonneFilm getPersonne() {
        return personne;
    }

    public void setPersonne(PersonneFilm personne) {
        this.personne = personne;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
