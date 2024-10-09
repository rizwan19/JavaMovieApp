package org.example.model;

public class Movie {
    private String title;
    private String cast;
    private String category;
    private int id;
    private String releaseDate;
    private double budget;

    public Movie(int id, String title, String cast, String category, String releaseDate, double budget) {
        this.title = title;
        this.cast = cast;
        this.category = category;
        this.id = id;
        this.releaseDate = releaseDate;
        this.budget = budget;
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

    public int getId() {
        return this.id;
    }
}
