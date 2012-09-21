import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class UnitTestManager {

    ByteArrayInputStream consoleInputContent = new ByteArrayInputStream("just a string".getBytes());
    
    BibliotecaTestDoubles fakedManager = new BibliotecaTestDoubles();
    Manager manager = new Manager(new PrintStream(fakedManager.consoleOutputContent), consoleInputContent);

    private String listOfAllBooks = "book 1\n" + "book 2\n" + "book 3";

    @Test
    public void testOutputToConsole() throws Exception {
        String expectedMessage = "some text!";
        manager.printMessages("some text!");
        
        assertEquals(expectedMessage, fakedManager.output());
    }

    @Test
    public void testWelcomeScreen() throws Exception {
        String welcome = "Welcome to Bangalore Public Library System";
        manager.welcomeScreen();
        assertEquals(welcome, fakedManager.output());
    }

    @Test
    public void testMenuOptions() throws Exception {
        String menuOptions = 
                        "To view all books type \"view books\"\n" +
                        "To reserve a book type \"reserve book\"\n" +
                        "To check your library number type \"library number\"\n" +
                        "To quit application type \"q\" or \"Q\"";
        manager.bibMenu();
        assertEquals(menuOptions, fakedManager.output());
    }

    @Test
    public void testUserCanInputFromConsole() throws Exception {
        manager = fakedManager.fakedUserInput("a user input");

        assertEquals("a user input", manager.userInput());
    }

    @Test
    public void testWhenUserChoosesToViewBooksHeShouldSeeThem() throws Exception {
        manager = fakedManager.fakedUserInput("view books");

        assertEquals(listOfAllBooks, manager.process());
    }

    @Test
    public void testUserSelectsInvalidOption() throws Exception {
        manager = fakedManager.fakedUserInput("an option");

        assertEquals("Select a valid option!!", manager.process());
    }

    @Test
    public void testIfUserReserveABookItShouldReserveIt() throws Exception {
        manager = fakedManager.fakedUserInput("reserve a book\nbook 1");

        assertEquals("Thank You! Enjoy the book.", manager.process());
    }

    @Test
    public void testIfUserChoosesToCheckLibraryNumberItShouldDoIt() throws Exception {
        manager = fakedManager.fakedUserInput("library number");
        
        assertEquals("Please talk to Librarian. Thank you.", manager.process());
    }

    @Test
    public void testQuitAppLowerCaseInput() throws Exception {
        manager = fakedManager.fakedUserInput("q");
        
        assertEquals("Thanks for using our library!", manager.quitUser());
    }

    @Test
    public void testQuitAppUpperCaseInput() throws Exception {
        manager = fakedManager.fakedUserInput("Q");

        assertEquals("Thanks for using our library!", manager.quitUser());
    }

    @Test
    public void testQuitChangesToTrueWhenUserQuits() throws Exception {
        manager.quitUser();
        assertEquals(true, manager.isQUIT());
    }
}
