package org.example.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PERSONNE_FILM")
public class PersonneFilm {
    @Id
    @Column(name = "PERSONNE_FILM_ID")
    private int personneFilmId;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "DATE_NAISSANCE")
    private LocalDate dateNaissance;

    @Column(name = "LIEU_NAISSANCE")
    private String lieuNaissance;

    @Column(name = "PHOTO")
    private String photo;

    @Lob
    @Column(name = "BIOGRAPHIE")
    private String biographie;

    @OneToMany(mappedBy = "personne")
    private List<PersonneFilmRole> films;


    public PersonneFilm() {}

    public PersonneFilm(int id, String nom, LocalDate dateNaissance, String lieuNaissance, String photo, String biographie) {
        this.personneFilmId = id;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.photo = photo;
        this.biographie = biographie;
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
