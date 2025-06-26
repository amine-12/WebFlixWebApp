package org.example.DTO;

public class LocationRequestDTO {
    private int clientId;
    private int copieId;

    public LocationRequestDTO() {}

    public LocationRequestDTO(int clientId, int copieId) {
        this.clientId = clientId;
        this.copieId = copieId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getCopieId() {
        return copieId;
    }

    public void setCopieId(int copieId) {
        this.copieId = copieId;
    }
}

