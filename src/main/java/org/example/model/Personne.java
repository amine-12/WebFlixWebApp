package org.example.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PERSONNE")
public class Personne {

    @Id
    @Column(name = "PERSONNE_ID")
    private Integer id;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "COURRIEL")
    private String courriel;

    @Column(name = "TELEPHONE")
    private String telephone;

    @Column(name = "DATE_NAISSANCE")
    private LocalDate dateNaissance;

    @Column(name = "MOT_DE_PASSE")
    private String motDePasse;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "VILLE")
    private String ville;

    @Column(name = "PROVINCE")
    private String province;

    @Column(name = "CODE_POSTAL")
    private String codePostal;

    public Personne() {}

    // ----- Getters / Setters -----

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
}
