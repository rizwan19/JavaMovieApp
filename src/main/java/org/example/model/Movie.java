package org.example.model;

public class Movie {
    private String title;
    private String cast;
    private String category;

    public Movie(String title, String cast, String category) {
        this.title = title;
        this.cast = cast;
        this.category = category;
    }

    public String title() {
        return this.title;
    }

    public String cast() {
        return this.cast;
    }

    public String category() {
        return this.category;
    }
}
