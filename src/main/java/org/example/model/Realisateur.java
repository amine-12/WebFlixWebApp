package org.example.model;

import java.time.LocalDate;

public class Realisateur extends PersonneFilm {
    public Realisateur() {
    }

    public Realisateur(int id, String nom, LocalDate dateNaissance, String lieuNaissance, String photo, String biographie) {
        super(id, nom, dateNaissance, lieuNaissance, photo, biographie);
    }
}
