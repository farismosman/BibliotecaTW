import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBibLibrary {

    BibLibrary library = new BibLibrary();

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
