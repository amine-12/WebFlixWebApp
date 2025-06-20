package org.example.model;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Acteur extends PersonneFilm {
    public Acteur() {
        super();
    }

    public Acteur(int id, String nom, LocalDate dateNaissance, String lieuNaissance, String photo, String biographie) {
        super(id, nom, dateNaissance, lieuNaissance, photo, biographie);
    }
}
