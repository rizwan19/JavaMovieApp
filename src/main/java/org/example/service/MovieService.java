package org.example.service;

import org.example.model.Movie;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MovieService {
    private UserService userService = new UserService();
    public static List<Movie> movieList = new ArrayList<>();

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

    public void showMovieDetailsByMovie(Movie movie){
        System.out.println(movie.toString());
    }

    public void searchMovie(String query, String searchBy){
        List<Movie> movieList = new ArrayList<>();
        if(searchBy.equalsIgnoreCase("title")){
            movieList = findByTitle(query);
        }
        else if(searchBy.equalsIgnoreCase("cast")){
            movieList = findByCast(query);
        }
        else if(searchBy.equalsIgnoreCase("category")){
            movieList = findByCategory(query);
        }
        else{
            System.out.println("Invalid search criteria");
            return;
        }
        for(Movie movie : movieList){
            showMovieDetailsByMovie(movie);
        }
    }

    public void addMovieToFavoriteByTitle(String title){
        Movie movie = findByTitleExactMatched(title);

        if(Objects.nonNull(movie)){
            userService.addToFavorite(movie);
        }
        else{
            System.out.println("Movie not found");
        }
    }

    public void removeMovieFromFavoriteByTitle(String title){
        Movie movie = findByTitleExactMatched(title);

        if(Objects.nonNull(movie)){
            userService.removeFromFavorite(movie);
        }
        else{
            System.out.println("Movie not found");
        }
    }

    public Movie findByTitleExactMatched(String title) {
        for(Movie movie : movieList){
            if(movie.title().equals(title)){
                return movie;
            }
        }
        return null;
    }

    public void initMovies(){
        addMovie(new Movie(1, "Spiderman", "Tobey", "Action", "22/04/2002", 123456));
        addMovie(new Movie(2, "Batman", "Christian Bale", "Action", "22/04/2004", 35345345));
        addMovie(new Movie(3, "Superman", "Henry Cavill", "Action", "22/04/2010", 2325532));
    }
}
