package org.example.model;


import org.example.util.ClobToStringConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Lob;
import java.sql.Clob;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Film {
    private int filmId;
    private String titre;
    private int anneeSortie;
    private String langueOriginale;
    private int dureeMinutes;
    private Clob resume;
    private String affiche;
    private List<Genre> genres;
    private List<Pays> pays;
    private Realisateur realisateur;
    private List<Scenariste> scenaristes;
    private List<ActeurFilm> acteurs;
    private List<BandeAnnonce> bandesAnnonces;
    private Set<Copie> copies;

    private int NbrCopiesDisponibles = ThreadLocalRandom.current().nextInt(1, 101);;

    public Film(int id, String titre, int anneeSortie, String langueOriginale, int dureeMinutes, Clob resume, String affiche, List<Genre> genres, List<Pays> pays, Realisateur realisateur, List<Scenariste> scenaristes, List<ActeurFilm> acteurs, List<BandeAnnonce> bandesAnnonces, Set<Copie> copies) {
        this.filmId = id;
        this.titre = titre;
        this.anneeSortie = anneeSortie;
        this.langueOriginale = langueOriginale;
        this.dureeMinutes = dureeMinutes;
        this.resume = resume;
        this.affiche = affiche;
        this.genres = genres;
        this.pays = pays;
        this.realisateur = realisateur;
        this.scenaristes = scenaristes;
        this.acteurs = acteurs;
        this.bandesAnnonces = bandesAnnonces;
        this.copies = copies;
    }

    public Film() {
    }

    public int getNbrCopiesDisponibles() {
        return NbrCopiesDisponibles;
    }

    public void setNbrCopiesDisponibles(int nbrCopiesDisponibles) {
        NbrCopiesDisponibles = nbrCopiesDisponibles;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAnneeSortie() {
        return anneeSortie;
    }

    public void setAnneeSortie(int anneeSortie) {
        this.anneeSortie = anneeSortie;
    }

    public String getLangueOriginale() {
        return langueOriginale;
    }

    public void setLangueOriginale(String langueOriginale) {
        this.langueOriginale = langueOriginale;
    }

    public int getDureeMinutes() {
        return dureeMinutes;
    }

    public void setDureeMinutes(int dureeMinutes) {
        this.dureeMinutes = dureeMinutes;
    }

    public Clob getResume() {
        return resume;
    }

    public void setResume(Clob resume) {
        this.resume = resume;
    }

    // Getter pratique utilisé dans ton code pour avoir une string
    public String getResumeAsString() {
        try {
            if (resume != null) {
                return resume.getSubString(1, (int) resume.length());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getAffiche() {
        return affiche;
    }

    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Pays> getPays() {
        return pays;
    }

    public void setPays(List<Pays> pays) {
        this.pays = pays;
    }

    public Realisateur getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Realisateur realisateur) {
        this.realisateur = realisateur;
    }

    public List<Scenariste> getScenaristes() {
        return scenaristes;
    }

    public void setScenaristes(List<Scenariste> scenaristes) {
        this.scenaristes = scenaristes;
    }

    public List<ActeurFilm> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<ActeurFilm> acteurs) {
        this.acteurs = acteurs;
    }

    public List<BandeAnnonce> getBandesAnnonces() {
        return bandesAnnonces;
    }

    public void setBandesAnnonces(List<BandeAnnonce> bandesAnnonces) {
        this.bandesAnnonces = bandesAnnonces;
    }

    public Set<Copie> getCopies() {
        return copies;
    }

    public void setCopies(Set<Copie> copies) {
        this.copies = copies;
    }
}
