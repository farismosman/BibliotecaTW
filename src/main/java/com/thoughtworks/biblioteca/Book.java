package com.thoughtworks.biblioteca;

public class Book {

    private String aBook;

    public Book(String aBook) {
        this.aBook = aBook;
    }

    @Override
    public String toString() {
        return aBook;
    }
}
