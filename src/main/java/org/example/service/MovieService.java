package org.example.service;

import org.example.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieService {
    List<Movie> movieList = new ArrayList<>();

    public List<Movie> findByTitle(String title) {
        List<Movie> result = new ArrayList<>();
        for(Movie movie : movieList){
            if(movie.title().toLowerCase().contains(title.toLowerCase())){
                result.add(movie);
            }
        }
        return result;
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }
}
