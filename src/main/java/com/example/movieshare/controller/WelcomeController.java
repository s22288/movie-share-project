package com.example.movieshare.controller;

import com.example.movieshare.models.Movie;
import com.example.movieshare.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WelcomeController {
    @Autowired
 private MovieRepository movieRepository;

    @GetMapping(value = "/")
    public ModelAndView mainMoviePageShow(){
        ModelAndView mv = new ModelAndView("index");
        List<Movie> all = movieRepository.findAll();

        mv.addObject("movies",all);
        return mv;
    }
}
