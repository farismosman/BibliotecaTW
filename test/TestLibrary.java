import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class TestLibrary {

    Library library = new Library();

    private ByteArrayOutputStream consoleOutputContent = new ByteArrayOutputStream();
    Biblioteca biblioteca = fakedBibliotecaUserInput("some faked input");

    private Biblioteca fakedBibliotecaUserInput(String aText){
        ByteArrayInputStream consoleInputContent = new ByteArrayInputStream(aText.getBytes());
        return new Biblioteca(new PrintStream(consoleOutputContent), consoleInputContent);
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
        
        assertEquals("Sorry we don't have that book yet.", library.reserve("book that does not exist"));
    }
}
