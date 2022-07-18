package com.example.movieshare.service;

import com.example.movieshare.models.Movie;

import java.util.HashMap;
import java.util.Set;

public class RankingHistogramCreator {

    private Set<Movie> allMovies;

    public RankingHistogramCreator(Set<Movie> allMovies) {
        this.allMovies = allMovies;
    }

//    public HashMap<String,Double> getHistogramOfRatings(){
//        allMovies.stream().collect()
//    }
}
