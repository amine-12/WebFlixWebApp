package org.example.model;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.time.LocalDate;

public abstract class PersonneFilm {
    private int personneFilmId;
    private String nom;
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String photo;
    @Lob
    @Column(name = "BIOGRAPHIE")
    private String biographie;

    public PersonneFilm(int id, String nom, LocalDate dateNaissance, String lieuNaissance, String photo, String biographie) {
        this.personneFilmId = id;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.photo = photo;
        this.biographie = biographie;
    }

    public PersonneFilm() {
    }

    public int getPersonneFilmId() {
        return personneFilmId;
    }

    public void setPersonneFilmId(int personneFilmId) {
        this.personneFilmId = personneFilmId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBiographie() {
        return biographie;
    }

    public void setBiographie(String biographie) {
        this.biographie = biographie;
    }
}
