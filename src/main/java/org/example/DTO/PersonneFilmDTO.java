package org.example.DTO;

import org.example.model.PersonneFilm;

import java.time.LocalDate;

public class PersonneFilmDTO {
    private int id;
    private String nom;
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String photo;
    private String biographie;

    public PersonneFilmDTO(int id, String nom, LocalDate dateNaissance,
                           String lieuNaissance, String photo, String biographie) {
        this.id = id;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.photo = photo;
        this.biographie = biographie;
    }

    public static PersonneFilmDTO from(PersonneFilm personne) {
        return new PersonneFilmDTO(
                personne.getPersonneFilmId(),
                personne.getNom(),
                personne.getDateNaissance(),
                personne.getLieuNaissance(),
                personne.getPhoto(),
                personne.getBiographie()
        );
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public LocalDate getDateNaissance() { return dateNaissance; }
    public String getLieuNaissance() { return lieuNaissance; }
    public String getPhoto() { return photo; }
    public String getBiographie() { return biographie; }

}
