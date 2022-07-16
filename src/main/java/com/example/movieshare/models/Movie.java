package com.example.movieshare.models;

import javax.persistence.*;
import java.net.URL;
import java.time.LocalDate;
@Entity
@Table(name = "MOVIES")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long MovieId;
    private String Name;
    private LocalDate realeaseDate;
    private URL photo;

    public Movie(Long movieId, String name, LocalDate realeaseDate, URL photo) {
        MovieId = movieId;
        Name = name;
        this.realeaseDate = realeaseDate;
        this.photo = photo;
    }

    public Movie() {
    }

    public Long getMovieId() {
        return MovieId;
    }

    public void setMovieId(Long movieId) {
        MovieId = movieId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LocalDate getRealeaseDate() {
        return realeaseDate;
    }

    public void setRealeaseDate(LocalDate realeaseDate) {
        this.realeaseDate = realeaseDate;
    }

    public URL getPhoto() {
        return photo;
    }

    public void setPhoto(URL photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "MovieId=" + MovieId +
                ", Name='" + Name + '\'' +
                ", realeaseDate=" + realeaseDate +
                ", photo=" + photo +
                '}';
    }
}
