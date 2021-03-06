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
    private String listOfAllMovies = "Movie               Director            Rating\n" +
                                     "movie 1             director 1          7.1\n" +
                                     "movie 2             director 2          1.4\n" +
                                     "movie 3             director 3          N/A";

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
                        "To login type \"login\"\n" +
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
    public void testUserChoosesToViewMoviesHeShouldSeeThem() throws Exception {
        
        assertEquals(listOfAllMovies, bibManager.process("view movies"));
    }

    @Test
    public void testUserSelectsInvalidOption() throws Exception {

        assertEquals("Select a valid option!!", bibManager.process("an option"));
    }

    @Test
    public void testUserSelectsToLogin() throws Exception {
        bibManager = fakedBibManager.fakedUserInput("111-1111\npassone");
        
        assertEquals("Logged in successfully", bibManager.process("login"));
        assertEquals(true, bibManager.isLogin);
    }

        @Test
    public void testIfUserReserveABookItShouldReserveIt() throws Exception {
        bibManager = fakedBibManager.fakedUserInput("book 1");

        assertEquals("Thank You! Enjoy the book.", bibManager.process("reserve a book"));
    }


    @Test
    public void testUserCanLoginIfDetailsAreCorrect() throws Exception {
        String aUsername = "111-1111";
        String aPassword = "passone";
        
        assertEquals(true, bibManager.login(aUsername, aPassword));
    }

    @Test
    public void testUserCantLoginIfDetailsAreWrong() throws Exception {
        String aUsername = "wrong username";
        String aPassword = "111-1112";
        
        assertEquals(false, bibManager.login(aUsername, aPassword));
    }

    @Test
    public void testUserCantSeeHisLibraryNumberIfHeIsNotLoggedIn() throws Exception {
        
        assertEquals("Please talk to Librarian. Thank you.", bibManager.process("library number"));
    }

    @Test
    public void testUserShouldSeeHisDetailsWhenHeIsLoggedIn() throws Exception {
        String aUsername = "111-1111";
        String aPassword = "passone";
        bibManager.login(aUsername, aPassword);
        
        assertEquals("111-1111, 1111@email, 1111-phone", bibManager.process("library number"));
    }
}
