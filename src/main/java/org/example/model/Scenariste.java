package org.example.model;

import java.time.LocalDate;

public class Scenariste extends PersonneFilm {
    public Scenariste() {
    }

    public Scenariste(int id, String nom, LocalDate dateNaissance, String lieuNaissance, String photo, String biographie) {
        super(id, nom, dateNaissance, lieuNaissance, photo, biographie);
    }
}
