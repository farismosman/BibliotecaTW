import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBibLibrary {

    private String listOfAllBooks = "book 1\n" + "book 2\n" + "book 3\n";

    BibLibrary library = new BibLibrary();

    @Test
    public void testWhenUserChoosesToViewBooksHeShouldSeeThem() throws Exception {
        String viewAllBooks = "view books";
        
        assertEquals(listOfAllBooks, library.processUserChoice(viewAllBooks));
    }

    @Test
    public void testUserSelectsInvalidOption() throws Exception {
        String userChoice = "an option";
        
        assertEquals("Select a valid option!!", library.processUserChoice(userChoice)); 
    }
}
