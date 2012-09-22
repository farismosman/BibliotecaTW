package com.thoughtworks.biblioteca;

import java.util.HashMap;

public class Library {

    private HashMap<String, String> allBooks = new HashMap<String, String>();

    public final HashMap<String, String> books() {
        allBooks.put(new Book("book 1").toString(), "not reserved");
        allBooks.put(new Book("book 2").toString(), "not reserved");
        allBooks.put(new Book("book 3").toString(), "not reserved");
        return allBooks;
    }

    public Library() {
        books();
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
