package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "BANDE_ANNONCE")
public class BandeAnnonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BANDE_ANNONCE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILM_ID", nullable = false)
    private Film film;

    @Column(name = "URL")
    private String url;

    public BandeAnnonce() {}

    public BandeAnnonce(String url, Film film) {
        this.url = url;
        this.film = film;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
