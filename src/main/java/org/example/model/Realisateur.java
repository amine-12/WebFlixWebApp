package org.example.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "REALISATEUR")
@PrimaryKeyJoinColumn(name = "PERSONNE_FILM_ID")
public class Realisateur extends PersonneFilm {
    public Realisateur() {
        super();
    }

    public Realisateur(int id, String nom, java.time.LocalDate dateNaissance, String lieuNaissance, String photo, String biographie) {
        super(id, nom, dateNaissance, lieuNaissance, photo, biographie);
    }
}
