import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBook {
    Book book = new Book();
    
    @Test
    public void testBookIsCreated() throws Exception {
        String someBook = "a test book";
        assertEquals(someBook, book.makeABook("a test book"));
    }
}
