package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class FunctionalTestManager {
    ByteArrayInputStream consoleInputContent = new ByteArrayInputStream("just a string".getBytes());

    BibManagerTestDoubles fakedBibManager = new BibManagerTestDoubles();
    BibManager bibManager = new BibManager(new PrintStream(fakedBibManager.consoleOutputContent), consoleInputContent);

    private String welcomeMessage = "Welcome to Bangalore Public Library System\n";
    private String menuOptions = "To view all books type \"view books\"\n" +
                                 "To reserve a book type \"reserve book\"\n" +
                                 "To check your library number type \"library number\"\n" +
                                 "To view all movies type \"view movies\"\n" +
                                 "To login type \"login\"\n" +
                                 "To quit application type \"q\" or \"Q\"";
    private String listOfAllBooks = "book 1\n" + "book 2\n" + "book 3";
    private String bookHasBeenReserved = "Thank You! Enjoy the book.";

    @Test
    public void testUserViewsBooksAndRequestsOne() throws Exception {
        bibManager = fakedBibManager.fakedUserInput("view books\nreserve a book\nbook 1\nq");
        String expectedMessage = welcomeMessage + menuOptions + "\n" + "> "+ listOfAllBooks + "\n" +
                                "> Book: > " + bookHasBeenReserved + "\n> Thanks for using our library!";
        bibManager.run();
        assertEquals(expectedMessage, fakedBibManager.output());
    }
}
