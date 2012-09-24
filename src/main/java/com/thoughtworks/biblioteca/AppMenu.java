package com.thoughtworks.biblioteca;

public class AppMenu {
    private static final String VIEW_BOOKS = "To view all books type \"view books\"\n";
    private static final String VIEW_MOVIES = "To view all movies type \"view movies\"\n";
    private static final String RESERVE_BOOK = "To reserve a book type \"reserve book\"\n";
    private static final String LIBRARY_NUMBER = "To check your library number type \"library number\"\n";
    private static final String LOGIN = "To login type \"login\"\n";
    private static final String QUIT_APP = "To quit application type \"q\" or \"Q\"";
    
    public String userOptions() {
        return VIEW_BOOKS + RESERVE_BOOK + LIBRARY_NUMBER + VIEW_MOVIES + LOGIN + QUIT_APP;
    }

}
