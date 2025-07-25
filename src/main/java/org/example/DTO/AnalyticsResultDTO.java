package org.example.DTO;

public class AnalyticsResultDTO {
    private long nombreLocations;

    public AnalyticsResultDTO(long nombreLocations) {
        this.nombreLocations = nombreLocations;
    }
    public long getNombreLocations() {
        return nombreLocations;
    }
    public void setNombreLocations(long nombreLocations) {
        this.nombreLocations = nombreLocations;
    }
}
