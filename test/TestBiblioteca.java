import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class TestBiblioteca {

    ByteArrayInputStream consoleInputContent = new ByteArrayInputStream("just a string".getBytes());
    
    BibliotecaTestDoubles fakedBiblioteca = new BibliotecaTestDoubles();
    Biblioteca biblioteca = new Biblioteca(new PrintStream(fakedBiblioteca.consoleOutputContent), consoleInputContent);

    private String listOfAllBooks = "book 1\n" + "book 2\n" + "book 3";

    @Test
    public void testOutputToConsole() throws Exception {
        String expectedMessage = "some text!";
        biblioteca.printMessages("some text!");
        
        assertEquals(expectedMessage, fakedBiblioteca.output());
    }

    @Test
    public void testWelcomeScreen() throws Exception {
        String welcome = "Welcome to Bangalore Public Library System";
        biblioteca.welcomeScreen();
        assertEquals(welcome, fakedBiblioteca.output());
    }

    @Test
    public void testMenuOptions() throws Exception {
        String menuOptions = 
                        "To view all books type \"view books\"\n" +
                        "To reserve a book type \"reserve book\"\n" +
                        "To check your library number type \"library number\"\n" +
                        "To quit application type \"q\" or \"Q\"";
        biblioteca.bibMenu();
        assertEquals(menuOptions, fakedBiblioteca.output());
    }

    @Test
    public void testUserCanInputFromConsole() throws Exception {
        biblioteca = fakedBiblioteca.fakedBibliotecaUserInput("a user input");

        assertEquals("a user input", biblioteca.userInput());
    }

    @Test
    public void testWhenUserChoosesToViewBooksHeShouldSeeThem() throws Exception {
        biblioteca = fakedBiblioteca.fakedBibliotecaUserInput("view books");

        assertEquals(listOfAllBooks, biblioteca.processUserChoice());
    }

    @Test
    public void testUserSelectsInvalidOption() throws Exception {
        biblioteca = fakedBiblioteca.fakedBibliotecaUserInput("an option");

        assertEquals("Select a valid option!!", biblioteca.processUserChoice());
    }

    @Test
    public void testIfUserReserveABookItShouldReserveIt() throws Exception {
        biblioteca = fakedBiblioteca.fakedBibliotecaUserInput("reserve a book\nbook 1");

        assertEquals("Thank You! Enjoy the book.", biblioteca.processUserChoice());
    }

    @Test
    public void testIfUserChoosesToCheckLibraryNumberItShouldDoIt() throws Exception {
        biblioteca = fakedBiblioteca.fakedBibliotecaUserInput("library number");
        
        assertEquals("Please talk to Librarian. Thank you.", biblioteca.processUserChoice());
    }

    @Test
    public void testQuitAppLowerCaseInput() throws Exception {
        biblioteca = fakedBiblioteca.fakedBibliotecaUserInput("q");
        
        assertEquals("Thanks for using our library!", biblioteca.quitUser());
    }

    @Test
    public void testQuitAppUpperCaseInput() throws Exception {
        biblioteca = fakedBiblioteca.fakedBibliotecaUserInput("Q");

        assertEquals("Thanks for using our library!", biblioteca.quitUser());
    }

    @Test
    public void testQuitChangesToTrueWhenUserQuits() throws Exception {
        biblioteca.quitUser();
        assertEquals(true, biblioteca.isQuit());
    }
}
