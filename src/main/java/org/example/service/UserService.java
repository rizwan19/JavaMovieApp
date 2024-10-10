package org.example.service;

import org.example.model.Movie;
import org.example.model.User;

import java.util.*;

public class UserService {
    public static Map <String, User> userMap = new HashMap<>();
    public static User currentUser;
    public User register(User newUser) {
        if(!userMap.containsKey(newUser.getEmail())){
            userMap.put(newUser.getEmail(), newUser);
            currentUser = newUser;
            System.out.println("User is registered successfully");
            return newUser;
        }
        return null;
    }

    public void addToFavorite(Movie movie) {
        currentUser.getFavoriteMovies().add(movie);
        System.out.println(movie.title() + " is added to your favorite list");
    }

    public void removeFromFavorite(Movie movie) {
        currentUser.getFavoriteMovies().remove(movie);
    }

    public String showPersonalDetails(){
        String personalDetails = currentUser.toString();
        System.out.println(personalDetails);
        return personalDetails;
    }


    public void showFavoriteMovies() {
        System.out.println(currentUser.getFavoriteMovies());
    }

    public List<Movie> findByTitleForFavorite(String title) {
        List<Movie> result = new ArrayList<>();
        for(Movie movie : currentUser.getFavoriteMovies()){
            if(movie.title().toLowerCase().contains(title.toLowerCase())){
                result.add(movie);
            }
        }
        result.sort(Comparator.comparing(Movie::title));
        return result;
    }

    public List<Movie> findByCastForFavorite(String cast) {
        List<Movie> result = new ArrayList<>();
        for(Movie movie : currentUser.getFavoriteMovies()){
            if(movie.cast().toLowerCase().contains(cast.toLowerCase())){
                result.add(movie);
            }
        }
        result.sort(Comparator.comparing(Movie::title));
        return result;
    }

    public List<Movie> findByCategoryForFavorite(String category) {
        List<Movie> result = new ArrayList<>();
        for(Movie movie : currentUser.getFavoriteMovies()){
            if(movie.category().toLowerCase().contains(category.toLowerCase())){
                result.add(movie);
            }
        }
        result.sort(Comparator.comparing(Movie::title));
        return result;
    }

    public void searchFavoriteMovie(String query, String searchBy){
        List<Movie> movieList = new ArrayList<>();
        if(searchBy.equalsIgnoreCase("title")){
            movieList = findByTitleForFavorite(query);
        }
        else if(searchBy.equalsIgnoreCase("cast")){
            movieList = findByCastForFavorite(query);
        }
        else if(searchBy.equalsIgnoreCase("category")){
            movieList = findByCategoryForFavorite(query);
        }
        else{
            System.out.println("Invalid search criteria");
            return;
        }
        for(Movie movie : movieList){
            showMovieDetailsByMovie(movie);
        }
        if(movieList.isEmpty()){
            System.out.println("Not found");
        }
    }

    public void showMovieDetailsByMovie(Movie movie){
        System.out.println(movie.toString());
    }
}
