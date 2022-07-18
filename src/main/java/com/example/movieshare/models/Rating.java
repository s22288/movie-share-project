package com.example.movieshare.models;

import javax.persistence.*;

@Entity
@Table(name = "RATINGS")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRating;
    private int starsCount;

    @ManyToOne
    @JoinColumn(name="MovieId", nullable=false)
    private Movie movie;
    public Rating() {
    }

    public Rating(Long idRating, int starsCount) {
        this.idRating = idRating;
        this.starsCount = starsCount;
    }

    public Long getIdRating() {
        return idRating;
    }

    public void setIdRating(Long idRating) {
        this.idRating = idRating;
    }

    public int getStarsCount() {
        return starsCount;
    }

    public void setStarsCount(int starsCount) {
        this.starsCount = starsCount;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "idRating=" + idRating +
                ", starsCount=" + starsCount +
                '}';
    }
}
