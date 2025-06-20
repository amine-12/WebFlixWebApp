package org.example.model;

import javax.persistence.*;
import java.sql.Clob;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name = "FILM")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FILM_ID")
    private int filmId;

    @Column(name = "TITRE")
    private String titre;

    @Column(name = "ANNEE_SORTIE")
    private int anneeSortie;

    @Column(name = "LANGUE_ORIGINALE")
    private String langueOriginale;

    @Column(name = "DUREE_MINUTE")
    private int dureeMinutes;

    @Lob
    @Column(name = "RESUME", nullable = false)
    private Clob resume;

    @Column(name = "AFFICHE")
    private String affiche;

    @Column(name = "NBR_COPIES_DISPONIBLES")
    private int NbrCopiesDisponibles = ThreadLocalRandom.current().nextInt(1, 101);

    // ----- RELATIONS -----

    @OneToMany(mappedBy = "film", fetch = FetchType.LAZY)
    private List<Personnage> personnages;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "FILM_GENRE",
            joinColumns = @JoinColumn(name = "FILM_ID"),
            inverseJoinColumns = @JoinColumn(name = "GENRE_ID"))
    private List<Genre> genres;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "FILM_PAYS",
            joinColumns = @JoinColumn(name = "FILM_ID"),
            inverseJoinColumns = @JoinColumn(name = "PAYS_ID"))
    private List<Pays> pays;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "FILM_SCENARISTE",
            joinColumns = @JoinColumn(name = "FILM_ID"),
            inverseJoinColumns = @JoinColumn(name = "SCENARISTE_ID"))
    private List<Scenariste> scenaristes;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PersonneFilmRole> roles; // contient réalisateur et acteurs

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BandeAnnonce> bandesAnnonces;

    // ----- CONSTRUCTEURS -----

    public Film() {}

    public Film(int id, String titre, int anneeSortie, String langueOriginale, int dureeMinutes, Clob resume,
                String affiche, List<Genre> genres, List<Pays> pays,
                List<Scenariste> scenaristes, List<PersonneFilmRole> roles,
                List<BandeAnnonce> bandesAnnonces, Set<Copie> copies) {
        this.filmId = id;
        this.titre = titre;
        this.anneeSortie = anneeSortie;
        this.langueOriginale = langueOriginale;
        this.dureeMinutes = dureeMinutes;
        this.resume = resume;
        this.affiche = affiche;
        this.genres = genres;
        this.pays = pays;
        this.scenaristes = scenaristes;
        this.roles = roles;
        this.bandesAnnonces = bandesAnnonces;
    }

    // ----- GETTERS / SETTERS -----

    public List<Personnage> getPersonnages() {
        return personnages;
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

    public List<Scenariste> getScenaristes() {
        return scenaristes;
    }

    public void setScenaristes(List<Scenariste> scenaristes) {
        this.scenaristes = scenaristes;
    }

    public List<PersonneFilmRole> getRoles() {
        return roles;
    }

    public void setRoles(List<PersonneFilmRole> roles) {
        this.roles = roles;
    }

    public List<BandeAnnonce> getBandesAnnonces() {
        return bandesAnnonces;
    }

    public void setBandesAnnonces(List<BandeAnnonce> bandesAnnonces) {
        this.bandesAnnonces = bandesAnnonces;
    }

    public int getNbrCopiesDisponibles() {
        return NbrCopiesDisponibles;
    }

    public void setNbrCopiesDisponibles(int nbrCopiesDisponibles) {
        NbrCopiesDisponibles = nbrCopiesDisponibles;
    }
}
