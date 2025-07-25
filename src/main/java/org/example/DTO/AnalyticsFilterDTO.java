package org.example.DTO;

public class AnalyticsFilterDTO {
    private String groupeAge;   // ou null pour “Tous”
    private String province;    // ou null
    private String jourSemaine; // ou null
    private String mois;        // ou null

    // getters & setters
    public String getGroupeAge() {
        return groupeAge;
    }

    public void setGroupeAge(String groupeAge) {
        this.groupeAge = groupeAge;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getJourSemaine() {
        return jourSemaine;
    }

    public void setJourSemaine(String jourSemaine) {
        this.jourSemaine = jourSemaine;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }
}
