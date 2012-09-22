package com.thoughtworks.biblioteca;

import java.text.MessageFormat;

public class Movie {

    private final int LENGTH = 20;
    private final String FORMAT = MessageFormat.format("%-{0}s%-{0}s%-{0}s", LENGTH);
    
    public String name;
    public String director;
    public String rating;

    public Movie(String name, String director, String rating) {
        this.name = name;
        this.director = director;
        this.rating = rating;
    }
    
    @Override
    public String toString(){
        return String.format(FORMAT, name, director, rating).trim();
    }
}
