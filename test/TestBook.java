import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBook {
    
    @Test
    public void testBookIsCreated() throws Exception {
        String someBook = "a test book";

        assertEquals(someBook, new Book("a test book").toString());
    }

    @Test
    public void testBookIsNotReservedByDefault() throws Exception {
        
    }
}
