package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {

    private HashMap<String, String> allBooks = new HashMap<String, String>();
    private HashMap<String, String> allUsers = new HashMap<String, String>();
    private List<String> allMovies = new ArrayList<String>();

    public Library() {
        books();
    }

    public final HashMap<String, String> books() {
        allBooks.put(new Book("book 1").toString(), "not reserved");
        allBooks.put(new Book("book 2").toString(), "not reserved");
        allBooks.put(new Book("book 3").toString(), "not reserved");
        return allBooks;
    }

    public List<String> movies() {
        allMovies.add(new Movie("Movie", "Director", "Rating").toString());
        allMovies.add(new Movie("movie 1", "director 1", "7.1").toString());
        allMovies.add(new Movie("movie 2", "director 2", "1.4").toString());
        allMovies.add(new Movie("movie 3", "director 3", "N/A").toString());
        return allMovies;
    }
    
    public HashMap<String, String> users(){
        allUsers.put("111-1111", "passone");
        allUsers.put("111-1112", "passtwo");
        allUsers.put("111-1113", "passthree");
        return allUsers;
    }

    public boolean getStatus(String book) {
        if (allBooks.containsKey(book) && allBooks.get(book).equals("not reserved")) {
            return false;
        } else {
            return true;
        }
    }

    public String reserveABook(String book) {
        if (books().containsKey(book)){
            books().put(book, "reserved");
            return "Thank You! Enjoy the book.";
        } else {
            return "Sorry we don't have that book yet.";
        }
    }

    public String checkNumber() {
        return "Please talk to Librarian. Thank you.";
    }
}
