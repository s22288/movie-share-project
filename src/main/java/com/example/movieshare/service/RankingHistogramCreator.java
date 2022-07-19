package com.example.movieshare.service;

import com.example.movieshare.models.Movie;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RankingHistogramCreator {

    private List<Movie> allMovies;

    public RankingHistogramCreator(List<Movie> allMovies) {
        this.allMovies = allMovies;
    }

    public Map<Double, List<Movie>> getHistogramOfRatings(){
      return   allMovies.stream().collect(Collectors.groupingBy(Movie::getAvg));

    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    public void setAllMovies(List<Movie> allMovies) {
        this.allMovies = allMovies;
    }
}
