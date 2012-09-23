package com.thoughtworks.biblioteca;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

public class UserChoices {

    private BibManager bibManager;
    private Library library;

    private HashMap<String, ChoiceHandler> allChoices = new HashMap<String, ChoiceHandler>();

    public UserChoices(BibManager bibManager, Library library) {
        this.bibManager = bibManager;
        this.library = library;
    }
    
    public HashMap<String, ChoiceHandler> commandsFactory(){
        allChoices.put("view books", new ViewBooks());
        allChoices.put("view movies", new ViewMovies());
        allChoices.put("library number", new LibraryNumber());
        allChoices.put("reserve a book", new ReserveABook());
        allChoices.put("q", new QuitUser());
        allChoices.put("Q", new QuitUser());
        return allChoices;
    }

    private class ViewBooks implements ChoiceHandler {
        @Override
        public String execute() {
            return StringUtils.join(library.books().keySet(), "\n");
        }

    }

    private class LibraryNumber implements ChoiceHandler {
        @Override
        public String execute() {
            return bibManager.checkNumber();
        }
    }
    
    private class QuitUser implements ChoiceHandler {
        @Override
        public String execute() {
            return bibManager.quitUser();
        }
    }
    
    private class ReserveABook implements ChoiceHandler {
        @Override
        public String execute() {
            bibManager.printStream.print("Book: ");
            String book = bibManager.userInput();
            return library.reserveABook(book);
        }
    }

    private class ViewMovies implements ChoiceHandler {

        @Override
        public String execute() {
           return StringUtils.join(library.movies(), "\n");
        }
    }
}
