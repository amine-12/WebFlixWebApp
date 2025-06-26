package org.example.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "ACTEUR")
@PrimaryKeyJoinColumn(name = "PERSONNE_FILM_ID")
public class Acteur extends PersonneFilm {

    public Acteur() {
        super();
    }

    public Acteur(int id, String nom, LocalDate dateNaissance, String lieuNaissance, String photo, String biographie) {
        super(id, nom, dateNaissance, lieuNaissance, photo, biographie);
    }
}
