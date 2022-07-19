package com.example.movieshare.controller;

import com.example.movieshare.models.Genre;
import com.example.movieshare.models.Movie;
import com.example.movieshare.models.Rating;
import com.example.movieshare.repositories.GenreRepository;
import com.example.movieshare.repositories.MovieRepository;
import com.example.movieshare.repositories.RatingsRepository;
import com.example.movieshare.service.CalculateRatingAverage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class WelcomeController {
    @Autowired
 private MovieRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private RatingsRepository ratingsRepository;

    private CalculateRatingAverage calculateRatingAverage;
    @GetMapping(value = "/byname")
    public ModelAndView sortByName(){
        ModelAndView mv = new ModelAndView("index");
        List<Movie> all = movieRepository.findAll();
        List<Genre> genres = genreRepository.findAll();


        all.sort(Comparator.comparing(Movie::getName));

        mv.addObject("movies",all);
        mv.addObject("genres",genres);


        return mv;
    }

    @GetMapping(value = "/byDate")
    public ModelAndView sortByRealaseDate(){
        ModelAndView mv = new ModelAndView("index");
        List<Movie> all = movieRepository.findAll();
        List<Genre> genres = genreRepository.findAll();


        all.sort(Comparator.comparing(Movie::getRealeaseDate));

        mv.addObject("movies",all);
        mv.addObject("genres",genres);


        return mv;
    }
    @GetMapping(value = "/byRatings")
    public ModelAndView sortByRatings(){
        ModelAndView mv = new ModelAndView("index");
        List<Movie> all = movieRepository.findAll();
        List<Genre> genres = genreRepository.findAll();


        all.sort(Comparator.comparing(Movie::getAvg));

        mv.addObject("movies",all);
        mv.addObject("genres",genres);


        return mv;
    }

    @GetMapping(value = "/selectCategory")
    @ResponseBody
    public ModelAndView SpecificCategory(@RequestParam Long id){
        ModelAndView mv = new ModelAndView("GenreView");

        Set<Movie> movies = genreRepository.findById(id).get().getMovies();
      Genre genre =  genreRepository.findById(id).get();


        mv.addObject("setOfMovies",movies);
        mv.addObject("genre",genre);

        return mv;
    }
    @GetMapping(value = "/")
    public ModelAndView mainMoviePageShow(){
        ModelAndView mv = new ModelAndView("index");
        List<Movie> all = movieRepository.findAll();
        List<Genre> genres = genreRepository.findAll();


        mv.addObject("movies",all);
        mv.addObject("genres",genres);
        return mv;
    }

    @GetMapping(value = "/details")
    public ModelAndView ShowDetail(@RequestParam Long id){
        ModelAndView mv = new ModelAndView("Details");
        Movie movie = movieRepository.findById(id).get();
        Set<Rating> ratings = movie.getRatings();
        calculateRatingAverage = new CalculateRatingAverage(ratings);

        mv.addObject("movdet",movie);
        mv.addObject("ratings",ratings);

        return mv;
    }


}
