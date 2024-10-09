package org.example.service;

import org.example.model.Movie;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MovieService {
    List<Movie> movieList = new ArrayList<>();

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    public List<Movie> findByTitle(String title) {
        List<Movie> result = new ArrayList<>();
        for(Movie movie : movieList){
            if(movie.title().toLowerCase().contains(title.toLowerCase())){
                result.add(movie);
            }
        }
        result.sort(Comparator.comparing(Movie::title));
        return result;
    }

    public List<Movie> findByCast(String cast) {
        List<Movie> result = new ArrayList<>();
        for(Movie movie : movieList){
            if(movie.cast().toLowerCase().contains(cast.toLowerCase())){
                result.add(movie);
            }
        }
        result.sort(Comparator.comparing(Movie::title));
        return result;
    }

    public List<Movie> findByCategory(String category) {
        List<Movie> result = new ArrayList<>();
        for(Movie movie : movieList){
            if(movie.category().toLowerCase().contains(category.toLowerCase())){
                result.add(movie);
            }
        }
        result.sort(Comparator.comparing(Movie::title));
        return result;
    }

    public Movie findMovieDetailsById(int id) {
        for(Movie movie : movieList){
            if(movie.getId() == id){
                return movie;
            }
        }
        return null;
    }

    public Movie showMovieDetailsById(int id) {
        Movie movie = findMovieDetailsById(id);
        if(Objects.nonNull(movie)){
            System.out.println(movie.toString());
        }
        return movie;
    }
}
