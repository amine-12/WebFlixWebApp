package org.example.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @Column(name = "PERSONNE_ID")
    private Integer id;

    @Column(name = "TYPE", nullable = false, length = 10)
    private String typeCarte;

    @Column(name = "NUMERO", nullable = false, length = 20)
    private String numeroCarte;

    @Column(name = "CVV", nullable = false)
    private Integer cvv;

    @Column(name = "DATE_EXPIRATION", nullable = false)
    private LocalDate dateExpiration;

    @Column(name = "FORFAIT_CODE", nullable = false, length = 1)
    private String codeForfait;


    public int getDureeMax() {
        switch (codeForfait) {
            case "D": return 10;
            case "I": return 30;
            case "A": return 365;
            default: return 0;
        }
    }

    // ----- Getters / Setters -----

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeCarte() {
        return typeCarte;
    }

    public void setTypeCarte(String typeCarte) {
        this.typeCarte = typeCarte;
    }

    public String getNumeroCarte() {
        return numeroCarte;
    }

    public void setNumeroCarte(String numeroCarte) {
        this.numeroCarte = numeroCarte;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public String getCodeForfait() {
        return codeForfait;
    }

    @Transient
    public Forfait getForfait() {
        switch (codeForfait) {
            case "D": return new Forfait("D", 1, 10);
            case "I": return new Forfait("I", 5, 30);
            case "A": return new Forfait("A", 10, 365);
            default: return null;
        }
    }


    public void setCodeForfait(String codeForfait) {
        this.codeForfait = codeForfait;
    }

}
