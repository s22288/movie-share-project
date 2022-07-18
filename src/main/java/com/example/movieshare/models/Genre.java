package com.example.movieshare.models;

import javax.persistence.*;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdGenre;

    private String GenreName;
    private URL GenrePhoto;

    @ManyToMany(mappedBy = "genres")
    private Set<Movie> movies = new HashSet<>();

    public Genre() {
    }

    public Genre(Long idGenre, String genreName, URL genrePhoto, Set<Movie> employees) {
        IdGenre = idGenre;
        GenreName = genreName;
        GenrePhoto = genrePhoto;
        this.movies = employees;
    }

    public Long getIdGenre() {
        return IdGenre;
    }

    public void setIdGenre(Long idGenre) {
        IdGenre = idGenre;
    }

    public String getGenreName() {
        return GenreName;
    }

    public void setGenreName(String genreName) {
        GenreName = genreName;
    }

    public URL getGenrePhoto() {
        return GenrePhoto;
    }

    public void setGenrePhoto(URL genrePhoto) {
        GenrePhoto = genrePhoto;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> employees) {
        this.movies = employees;
    }


    @Override
    public String toString() {
        return "Genre{" +
                "IdGenre=" + IdGenre +
                ", GenreName='" + GenreName + '\'' +
                ", GenrePhoto=" + GenrePhoto +
                ", employees=" + movies +
                '}';
    }
}
