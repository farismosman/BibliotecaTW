package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {

    private HashMap<String, String> allBooks = new HashMap<String, String>();
    private HashMap<String, Users> allUsers = new HashMap<String, Users>();
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

    public final List<String> movies() {
        allMovies.add(new Movie("Movie", "Director", "Rating").toString());
        allMovies.add(new Movie("movie 1", "director 1", "7.1").toString());
        allMovies.add(new Movie("movie 2", "director 2", "1.4").toString());
        allMovies.add(new Movie("movie 3", "director 3", "N/A").toString());
        return allMovies;
    }
    
    public final HashMap<String, Users> users(){
        allUsers.put("111-1111", new Users("111-1111","passone", "111-1111, 1111@email, 1111-phone"));
        allUsers.put("111-1112", new Users("111-1112","passtwo", "111-1112, 1112@email, 1112-phone"));
        allUsers.put("111-1113", new Users("111-1113","passthree", "111-1113, 1113@email, 1113-phone"));
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
}
