package org.example.model;

public class Movie {
    private String title;
    private String cast;

    public Movie(String title, String cast) {
        this.title = title;
        this.cast = cast;
    }

    public String title() {
        return this.title;
    }

    public String cast() {
        return this.cast;
    }
}
