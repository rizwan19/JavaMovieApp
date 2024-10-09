package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private List<Movie> favoriteMovieList = new ArrayList<>();

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public List<Movie> getFavoriteMovies() {
        return this.favoriteMovieList;
    }
}
