package com.example.movieshare.controller;

import com.example.movieshare.models.Movie;
import com.example.movieshare.repositories.MovieRepository;
import com.example.movieshare.service.RankingHistogramCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class RankingController {

    @Autowired
    private MovieRepository movieRepository;
    @GetMapping(value = "/ranking")
    public ModelAndView GetRankingInfo(){
        ModelAndView mv = new ModelAndView("Ranking");
        List<Movie> all = movieRepository.findAll();
         RankingHistogramCreator rankingHistogramCreator = new RankingHistogramCreator(all);

        Map<Double, List<Movie>> histogramOfRatings = rankingHistogramCreator.getHistogramOfRatings();

        mv.addObject("movierank",histogramOfRatings);
        return mv;
    }
}
