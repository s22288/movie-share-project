package com.example.movieshare.controller;

import com.example.movieshare.models.Genre;
import com.example.movieshare.models.Movie;
import com.example.movieshare.repositories.GenreRepository;
import com.example.movieshare.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/editmv")

public class MovieModifieController {
@Autowired
    private MovieRepository movieRepository;

@Autowired
    private GenreRepository genreRepository;
 private    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    @GetMapping()
    public String getUsers(Model model) {

        model.addAttribute("Myperson", new Movie());
        return "modifie";
    }
    @PostMapping(value = "/add")
    @ResponseBody // Annotation here
    public ModelAndView addMovie(@RequestParam("name") String name, @RequestParam("date") String date, @RequestParam("photo") String photo, @RequestParam("video") String video) throws MalformedURLException {

        ModelAndView mv = new ModelAndView("success");
        Movie movie = new Movie();
        movie.setMovieId(movieRepository.count() +1);
       movie.setName(name);
        LocalDate parse = LocalDate.parse(date, formatter);
        movie.setRealeaseDate(parse);

        // uworzenie dwóch urli
        URL photoUrl = new URL(photo);
        movie.setPhoto(photoUrl);

        URL videoUrl = new URL(video);
        movie.setVideo(videoUrl);
        Genre genre = genreRepository.findAll().get(0);
        Set<Genre> objects = new HashSet<>();
        objects.add(genre);
        movie.setGenres(objects);
        System.out.println(movie);

//movieRepository.save(movie);

        return mv;
}
}
