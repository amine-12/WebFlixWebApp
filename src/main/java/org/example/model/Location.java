package org.example.model;

import java.util.Date;

public class Location {
    private Date dateLocation;
    private Date dateRetourPrevue;
    private Date dateRetourReelle;
    private Copie copie;

    public Location(Date dateLocation, Date dateRetourPrevue, Date dateRetourReelle, Copie copie) {
        this.dateLocation = dateLocation;
        this.dateRetourPrevue = dateRetourPrevue;
        this.dateRetourReelle = dateRetourReelle;
        this.copie = copie;
    }

    public Date getDateLocation() {
        return dateLocation;
    }

    public void setDateLocation(Date dateLocation) {
        this.dateLocation = dateLocation;
    }

    public Date getDateRetourPrevue() {
        return dateRetourPrevue;
    }

    public void setDateRetourPrevue(Date dateRetourPrevue) {
        this.dateRetourPrevue = dateRetourPrevue;
    }

    public Date getDateRetourReelle() {
        return dateRetourReelle;
    }

    public void setDateRetourReelle(Date dateRetourReelle) {
        this.dateRetourReelle = dateRetourReelle;
    }

    public Copie getCopie() {
        return copie;
    }

    public void setCopie(Copie copie) {
        this.copie = copie;
    }
}
