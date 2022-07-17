package com.example.movieshare.models;

import javax.persistence.*;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdGenre;

    private String GenreName;
    private URL GenrePhoto;

    @ManyToMany(mappedBy = "genres")
    private Set<Movie> employees = new HashSet<>();
}
