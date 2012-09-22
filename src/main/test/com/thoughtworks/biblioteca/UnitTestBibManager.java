package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class UnitTestBibManager {

    ByteArrayInputStream consoleInputContent = new ByteArrayInputStream("just a string".getBytes());
    
    BibManagerTestDoubles fakedBibManager = new BibManagerTestDoubles();
    BibManager bibManager = new BibManager(new PrintStream(fakedBibManager.consoleOutputContent), consoleInputContent);

    private String listOfAllBooks = "book 1\n" + "book 2\n" + "book 3";

    @Test
    public void testOutputToConsole() throws Exception {
        String expectedMessage = "some text!";
        bibManager.printMessages("some text!");
        
        assertEquals(expectedMessage, fakedBibManager.output());
    }

    @Test
    public void testWelcomeScreen() throws Exception {
        String welcome = "Welcome to Bangalore Public Library System";
        bibManager.welcomeScreen();
        assertEquals(welcome, fakedBibManager.output());
    }

    @Test
    public void testMenuOptions() throws Exception {
        String menuOptions = 
                        "To view all books type \"view books\"\n" +
                        "To reserve a book type \"reserve book\"\n" +
                        "To check your library number type \"library number\"\n" +
                        "To view all movies type \"view movies\"\n" + 
                        "To quit application type \"q\" or \"Q\"";
        bibManager.bibMenu();
        assertEquals(menuOptions, fakedBibManager.output());
    }

    @Test
    public void testUserCanInputFromConsole() throws Exception {
        bibManager = fakedBibManager.fakedUserInput("a user input");

        assertEquals("a user input", bibManager.userInput());
    }

    @Test
    public void testQuitAppUpperCaseInput() throws Exception {
        bibManager = fakedBibManager.fakedUserInput("Q");

        assertEquals("Thanks for using our library!", bibManager.quitUser());
    }

    @Test
    public void testQuitAppLowerCaseInput() throws Exception {
        bibManager = fakedBibManager.fakedUserInput("q");
        
        assertEquals("Thanks for using our library!", bibManager.quitUser());
    }

    @Test
    public void testQuitChangesToTrueWhenUserQuits() throws Exception {
        bibManager.quitUser();
        assertEquals(true, bibManager.isQUIT());
    }

    @Test
    public void testWhenUserChoosesToViewBooksHeShouldSeeThem() throws Exception {

        assertEquals(listOfAllBooks, bibManager.process("view books"));
    }

    @Test
    public void testUserSelectsInvalidOption() throws Exception {

        assertEquals("Select a valid option!!", bibManager.process("an option"));
    }

//    @Test
//    public void testIfUserReserveABookItShouldReserveIt() throws Exception {
//
//        assertEquals("Thank You! Enjoy the book.", bibManager.process("reserve a book"));
//    }

    @Test
    public void testIfUserChoosesToCheckLibraryNumberItShouldDoIt() throws Exception {

        assertEquals("Please talk to Librarian. Thank you.", bibManager.process("library number"));
    }
}
