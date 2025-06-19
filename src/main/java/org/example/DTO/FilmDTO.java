package org.example.DTO;
import java.util.List;

public class FilmDTO {
    private String titre;
    private int anneeSortie;
    private String langueOriginale;
    private int dureeMinutes;
    private List<String> paysProduction;
    private List<String> genres;
    private String realisateur;
    private List<String> scenaristes;
    private List<Acteur> acteurs;
    private String resume;
    private String affiche;
    private List<String> bandesAnnonces;

    // Constructeur
    public FilmDTO(String titre, int anneeSortie, String langueOriginale, int dureeMinutes,
                   List<String> paysProduction, List<String> genres, String realisateur,
                   List<String> scenaristes, List<Acteur> acteurs, String resume,
                   String affiche, List<String> bandesAnnonces) {
        this.titre = titre;
        this.anneeSortie = anneeSortie;
        this.langueOriginale = langueOriginale;
        this.dureeMinutes = dureeMinutes;
        this.paysProduction = paysProduction;
        this.genres = genres;
        this.realisateur = realisateur;
        this.scenaristes = scenaristes;
        this.acteurs = acteurs;
        this.resume = resume;
        this.affiche = affiche;
        this.bandesAnnonces = bandesAnnonces;
    }

    // Getters et setters
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public int getAnneeSortie() { return anneeSortie; }
    public void setAnneeSortie(int anneeSortie) { this.anneeSortie = anneeSortie; }

    public String getLangueOriginale() { return langueOriginale; }
    public void setLangueOriginale(String langueOriginale) { this.langueOriginale = langueOriginale; }

    public int getDureeMinutes() { return dureeMinutes; }
    public void setDureeMinutes(int dureeMinutes) { this.dureeMinutes = dureeMinutes; }

    public List<String> getPaysProduction() { return paysProduction; }
    public void setPaysProduction(List<String> paysProduction) { this.paysProduction = paysProduction; }

    public List<String> getGenres() { return genres; }
    public void setGenres(List<String> genres) { this.genres = genres; }

    public String getRealisateur() { return realisateur; }
    public void setRealisateur(String realisateur) { this.realisateur = realisateur; }

    public List<String> getScenaristes() { return scenaristes; }
    public void setScenaristes(List<String> scenaristes) { this.scenaristes = scenaristes; }

    public List<Acteur> getActeurs() { return acteurs; }
    public void setActeurs(List<Acteur> acteurs) { this.acteurs = acteurs; }

    public String getResume() { return resume; }
    public void setResume(String resume) { this.resume = resume; }

    public String getAffiche() { return affiche; }
    public void setAffiche(String affiche) { this.affiche = affiche; }

    public List<String> getBandesAnnonces() { return bandesAnnonces; }
    public void setBandesAnnonces(List<String> bandesAnnonces) { this.bandesAnnonces = bandesAnnonces; }

    // Classe interne pour représenter un acteur
    public static class Acteur {
        private String nom;
        private String personnage;

        public Acteur(String nom, String personnage) {
            this.nom = nom;
            this.personnage = personnage;
        }

        public String getNom() { return nom; }
        public void setNom(String nom) { this.nom = nom; }

        public String getPersonnage() { return personnage; }
        public void setPersonnage(String personnage) { this.personnage = personnage; }
    }
}