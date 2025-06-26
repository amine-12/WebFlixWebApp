package org.example.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "LOCATION")
@SequenceGenerator(
        name = "location_seq",
        sequenceName = "LOCATION_SEQ",
        allocationSize = 1
)
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_seq")
    @Column(name = "LOCATION_ID")
    private Integer id;

    @Column(name = "COPIE_ID", nullable = false)
    private Integer copieId;

    @Column(name = "CLIENT_ID", nullable = false)
    private Integer clientId;

    @Column(name = "DATE_LOCATION", nullable = false)
    private LocalDate dateLocation;

    @Column(name = "DATE_RETOUR_PREVU", nullable = false)
    private LocalDate dateRetourPrevu;

    @Column(name = "DATE_RETOUR_REEL")
    private LocalDate dateRetourReel;

    public Location() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCopieId() {
        return copieId;
    }

    public void setCopieId(Integer copieId) {
        this.copieId = copieId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public LocalDate getDateLocation() {
        return dateLocation;
    }

    public void setDateLocation(LocalDate dateLocation) {
        this.dateLocation = dateLocation;
    }

    public LocalDate getDateRetourPrevu() {
        return dateRetourPrevu;
    }

    public void setDateRetourPrevu(LocalDate dateRetourPrevu) {
        this.dateRetourPrevu = dateRetourPrevu;
    }

    public LocalDate getDateRetourReel() {
        return dateRetourReel;
    }

    public void setDateRetourReel(LocalDate dateRetourReel) {
        this.dateRetourReel = dateRetourReel;
    }
}
