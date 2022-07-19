package com.example.movieshare.service;

import com.example.movieshare.models.Rating;

import java.util.IntSummaryStatistics;
import java.util.Set;
import java.util.stream.Stream;

public class CalculateRatingAverage {

    private Set<Rating> ratingSet;
    private IntSummaryStatistics stats;




    public CalculateRatingAverage(Set<Rating> ratingSet) {
        this.ratingSet = ratingSet;
        calculateAverage();

    }

    public void calculateAverage(){
        IntSummaryStatistics statistics = ratingSet.stream().map(e -> e.getStarsCount()).
                mapToInt(Integer::intValue)
                .summaryStatistics();
        this.stats = statistics;
    }
    public double getAVG(){
      return   stats.getAverage();
    }
}
