package com.example.movieshare.models;

import com.example.movieshare.service.CalculateRatingAverage;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MOVIES")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long MovieId;
    private String Name;
    private LocalDate realeaseDate;
    private URL photo;

    private URL video;

    @ManyToMany(cascade = {CascadeType.ALL})
            @JoinTable(
                    name = "Movies_Genres",joinColumns ={@JoinColumn(name = "MovieId")},
                    inverseJoinColumns = {@JoinColumn(name = "IdGenre")}
            )
     Set<Genre> genres = new HashSet<>();


    @OneToMany(mappedBy="movie")
    private Set<Rating> ratings;
    public Movie(Long movieId, String name, LocalDate realeaseDate, URL photo) {
        MovieId = movieId;
        Name = name;
        this.realeaseDate = realeaseDate;
        this.photo = photo;
    }


    public Movie(String name, URL photo) {
        Name = name;
        this.photo = photo;
    }

    public Movie(Long movieId, String name, LocalDate realeaseDate, URL photo, Set<Genre> genres) {
        MovieId = movieId;
        Name = name;
        this.realeaseDate = realeaseDate;
        this.photo = photo;
        this.genres = genres;
    }

    public Movie() {
    }

    public URL getVideo() {
        return video;
    }

    public void setVideo(URL video) {
        this.video = video;
    }

    public double getAvg(){
        CalculateRatingAverage ratingAverage = new CalculateRatingAverage(ratings);
        BigDecimal bd = BigDecimal.valueOf(ratingAverage.getAVG()).setScale(2, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }


    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
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


    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "MovieId=" + MovieId +
                ", Name='" + Name + '\'' +
                ", realeaseDate=" + realeaseDate +
                ", photo=" + photo +
                ", video=" + video +
                ", genres=" + genres +
                ", ratings=" + ratings +
                '}';
    }
}
