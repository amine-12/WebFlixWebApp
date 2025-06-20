package org.example.DTO;

import org.example.model.*;

import java.util.List;


public class FilmDTO {
    private String titre;
    private int anneeSortie;
    private String langueOriginale;
    private int dureeMinutes;
    private List<String> paysProduction;
    private List<String> genres;
    private Realisateur realisateur;
    private List<String> scenaristes;
    private List<Acteur> acteurs;
    private String resume;
    private String affiche;
    private List<String> bandesAnnonces;

    public FilmDTO(String titre, int anneeSortie, String langueOriginale, int dureeMinutes,
                   List<String> paysProduction, List<String> genres, Realisateur realisateur,
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

    public static FilmDTO from(Film film) {
        // Récupérer le réalisateur
        Realisateur realisateur = film.getRoles().stream()
                .filter(p -> p.getRole().equalsIgnoreCase("Realisateur"))
                .map(p -> new Realisateur(p.getPersonne().getPersonneFilmId(), p.getPersonne().getNom()))
                .findFirst()
                .orElse(null);


        // Récupérer les acteurs avec leur personnage
        List<Acteur> acteurs = film.getRoles().stream()
                .filter(p -> p.getRole().equalsIgnoreCase("Acteur"))
                .map(p -> {
                    String personnage = film.getPersonnages().stream()
                            .filter(per -> per.getActeur().getPersonneFilmId() == p.getPersonne().getPersonneFilmId())
                            .map(Personnage::getNomPersonnage)
                            .findFirst()
                            .orElse("Acteur");

                    return new Acteur(p.getPersonne().getPersonneFilmId(), p.getPersonne().getNom(), personnage);
                })
                .toList();

        return new FilmDTO(
                film.getTitre(),
                film.getAnneeSortie(),
                film.getLangueOriginale(),
                film.getDureeMinutes(),
                film.getPays() != null ? film.getPays().stream().map(Pays::getNom).toList() : List.of(),
                film.getGenres() != null ? film.getGenres().stream().map(Genre::getNom).toList() : List.of(),
                realisateur,
                film.getScenaristes() != null ? film.getScenaristes().stream().map(Scenariste::getNom).toList() : List.of(),
                acteurs,
                film.getResumeAsString(),
                film.getAffiche(),
                film.getBandesAnnonces() != null ? film.getBandesAnnonces().stream().map(BandeAnnonce::getUrl).toList() : List.of()
        );
    }


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

    public Realisateur getRealisateur() { return realisateur; }
    public void setRealisateur(Realisateur realisateur) { this.realisateur = realisateur; }

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

    public static class Acteur {
        private int id;
        private String nom;
        private String personnage;

        public Acteur(int id, String nom, String personnage) {
            this.id = id;
            this.nom = nom;
            this.personnage = personnage;
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getNom() { return nom; }
        public void setNom(String nom) { this.nom = nom; }

        public String getPersonnage() { return personnage; }
        public void setPersonnage(String personnage) { this.personnage = personnage; }
    }

    public static class Realisateur {
        private int id;
        private String nom;

        public Realisateur(int id, String nom) {
            this.id = id;
            this.nom = nom;
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getNom() { return nom; }
        public void setNom(String nom) { this.nom = nom; }
    }


}
