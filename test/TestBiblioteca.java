import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class TestBiblioteca {

    private String listOfAllBooks = "book 1\n" + "book 2\n" + "book 3";

    private ByteArrayOutputStream consoleOutputContent = new ByteArrayOutputStream();
    Biblioteca biblioteca = fakedBibliotecaUserInput("some faked input");

    private String output(){
        return consoleOutputContent.toString().trim();
    }
    
    private Biblioteca fakedBibliotecaUserInput(String aText){
        ByteArrayInputStream consoleInputContent = new ByteArrayInputStream(aText.getBytes());
        return new Biblioteca(new PrintStream(consoleOutputContent), consoleInputContent);
    }

    @Test
    public void testOutputToConsole() throws Exception {
        String expectedMessage = "some text!";
        biblioteca.printMessages("some text!");
        assertEquals(expectedMessage, output());
    }

    @Test
    public void testWelcomeScreen() throws Exception {
        String welcome = "Welcome to Bangalore Public Library System";
        biblioteca.welcomeScreen();
        assertEquals(welcome, output());
    }

    @Test
    public void testMenuOptions() throws Exception {
        String menuOptions = 
                        "To view all books type \"view books\"\n" +
                        "To reserve a book type \"reserve book\"\n" +
                        "To check your library number type \"library number\"";
        biblioteca.bibMenu();
        assertEquals(menuOptions, output());
    }

    @Test
    public void testUserCanInputFromConsole() throws Exception {
        biblioteca = fakedBibliotecaUserInput("a user input");

        assertEquals("a user input", biblioteca.userInput());
    }

    @Test
    public void testWhenUserChoosesToViewBooksHeShouldSeeThem() throws Exception {
        biblioteca = fakedBibliotecaUserInput("view books");

        assertEquals(listOfAllBooks, biblioteca.processUserChoice());
    }

    @Test
    public void testUserSelectsInvalidOption() throws Exception {
        biblioteca = fakedBibliotecaUserInput("an option");

        assertEquals("Select a valid option!!", biblioteca.processUserChoice());
    }

    @Test
    public void testIfUserReserveABookItShouldReserveIt() throws Exception {
        biblioteca = fakedBibliotecaUserInput("reserve a book");

        assertEquals("Thank You! Enjoy the book.", biblioteca.processUserChoice());
    }

    @Test
    public void testIfUserChoosesToCheckLibraryNumberItShouldDoIt() throws Exception {
        biblioteca = fakedBibliotecaUserInput("library number");

        assertEquals("Please talk to Librarian. Thank you.", biblioteca.processUserChoice());
    }

}
