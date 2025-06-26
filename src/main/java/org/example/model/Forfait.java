package org.example.model;

public class Forfait {
    private String code;
    private int maxLocations;
    private int dureeMax;

    public Forfait(String code, int maxLocations, int dureeMax) {
        this.code = code;
        this.maxLocations = maxLocations;
        this.dureeMax = dureeMax;
    }

    // Getters
    public String getCode() {
        return code;
    }

    public int getMaxLocations() {
        return maxLocations;
    }

    public int getDureeMax() {
        return dureeMax;
    }
}
