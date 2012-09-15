import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBibLibrary {

    private String listOfAllBooks = "book 1\n" + "book 2\n" + "book 3";

    BibLibrary library = new BibLibrary();

    @Test
    public void testWhenUserChoosesToViewBooksHeShouldSeeThem() throws Exception {
        String userChoice = "view books";
        
        assertEquals(listOfAllBooks, library.processUserChoice(userChoice));
    }

    @Test
    public void testUserSelectsInvalidOption() throws Exception {
        String userChoice = "an option";
        
        assertEquals("Select a valid option!!", library.processUserChoice(userChoice)); 
    }

    @Test
    public void testIfUserReserveABookItShouldReserveIt() throws Exception {
        String userChoice = "reserve a book";
        
        assertEquals("Thank You! Enjoy the book.", library.processUserChoice(userChoice));
    }

    @Test
    public void testIfUserChoosesToCheckLibraryNumberItShouldDoIt() throws Exception {
        String userChoice = "library number";

        assertEquals("Please talk to Librarian. Thank you.", library.processUserChoice(userChoice));
    }

    @Test
    public void testReserveABook() throws Exception {
        library.reserve("book 1");

        assertEquals(true, library.getStatus("book 1"));
    }

    @Test
    public void testBookIsNotReservedByDefault() throws Exception {
        assertEquals(false, library.getStatus("book 1"));
    }


    @Test
    public void testIfBookDoesNotExist() throws Exception {
        String userChoice = "book that does not exist";
        
        assertEquals("Sorry we don't have that book yet.", library.reserve(userChoice));
    }
}
