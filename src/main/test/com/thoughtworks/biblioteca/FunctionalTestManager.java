package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class FunctionalTestManager {
    ByteArrayInputStream consoleInputContent = new ByteArrayInputStream("just a string".getBytes());

    BibManagerTestDoubles fakedBibManager = new BibManagerTestDoubles();
    BibManager bibManager = new BibManager(new PrintStream(fakedBibManager.consoleOutputContent), consoleInputContent);

    private String listOfAllBooks = "book 1\n" + "book 2\n" + "book 3";
    private String bookHasBeenReserved = "Thank You! Enjoy the book.";

    @Test
    public void testUserViewsBooksAndRequestsOne() throws Exception {
        bibManager = fakedBibManager.fakedUserInput("view books\nreserve a book\nbook 1");
        String expectedMessage = listOfAllBooks + "\n" + bookHasBeenReserved;
        bibManager.run();
        assertEquals(expectedMessage, fakedBibManager.output());
    }
}
