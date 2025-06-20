package org.example.DTO;
import org.example.model.Film;
import org.example.model.Pays;
import org.example.model.Genre;
import org.example.model.Scenariste;
import org.example.model.BandeAnnonce;

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
//    public FilmDTO(String titre, int anneeSortie, String langueOriginale, int dureeMinutes,
//                   List<String> paysProduction, List<String> genres, String realisateur,
//                   List<String> scenaristes, List<Acteur> acteurs, String resume,
//                   String affiche, List<String> bandesAnnonces) {
//        this.titre = titre;
//        this.anneeSortie = anneeSortie;
//        this.langueOriginale = langueOriginale;
//        this.dureeMinutes = dureeMinutes;
//        this.paysProduction = paysProduction;
//        this.genres = genres;
//        this.realisateur = realisateur;
//        this.scenaristes = scenaristes;
//        this.acteurs = acteurs;
//        this.resume = resume;
//        this.affiche = affiche;
//        this.bandesAnnonces = bandesAnnonces;
//    }

    public FilmDTO(String titre, int anneeSortie, String langueOriginale, int dureeMinutes, String resume, String affiche) {
        this.titre = titre;
        this.anneeSortie = anneeSortie;
        this.langueOriginale = langueOriginale;
        this.dureeMinutes = dureeMinutes;
//        this.genres = genres;
        this.resume = resume;
        this.affiche = affiche;

        // Initialize omitted fields as empty or null to avoid NullPointerExceptions
        this.paysProduction = List.of();
        this.realisateur = null;
        this.scenaristes = List.of();
        this.acteurs = List.of();
        this.bandesAnnonces = List.of();
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

    // À la fin de ta classe FilmDTO (avant la dernière accolade de fermeture)
//    public static FilmDTO from(Film film) {
//        return new FilmDTO(
//                film.getTitre(),
//                film.getAnneeSortie(),
//                film.getLangueOriginale(),
//                film.getDureeMinutes(),
//                film.getPays().stream().map(Pays::getNom).toList(),
//                film.getGenres().stream().map(Genre::getNom).toList(),
//                film.getRealisateur() != null ? film.getRealisateur().getNom() : null,
//                film.getScenaristes().stream().map(Scenariste::getNom).toList(),
//                film.getActeurs().stream()
//                        .map(acteur -> new Acteur(
//                                acteur.getActeur().getNom(),
//                                acteur.getPersonnage()))
//                        .toList(),
//                film.getResumeAsString(),
//                film.getAffiche(),
//                film.getBandesAnnonces().stream().map(BandeAnnonce::getUrl).toList()
//        );
//    }

    public static FilmDTO from(Film film) {
        return new FilmDTO(
                film.getTitre(),
                film.getAnneeSortie(),
                film.getLangueOriginale(),
                film.getDureeMinutes(),
                film.getResumeAsString(),
                film.getAffiche()
        );
    }



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