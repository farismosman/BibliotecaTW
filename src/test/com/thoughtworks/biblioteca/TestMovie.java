package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMovie {
    @Test
    public void testMovieHasAName() throws Exception {
        String movieName = "movie 1";
        
        assertEquals(movieName, new Movie("movie 1", "a director", "N/A").name); 
    }

    @Test
    public void testMovieHasADirector() throws Exception {
        String directorName = "a director";
        
        assertEquals(directorName, new Movie("movie 1", "a director", "N/A").director);
    }

    @Test
    public void testMovieHasRating() throws Exception {
        String rating = "N/A";
        
        assertEquals(rating, new Movie("movie 1", "director", "N/A").rating);
    }

    @Test
    public void testMovieFormat() throws Exception {
        String aMovie =  "movie 1             director            6.4";
        
        assertEquals(aMovie, new Movie("movie 1", "director", "6.4").toString());
    }
}
