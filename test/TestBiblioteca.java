import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class TestBiblioteca {

    private ByteArrayOutputStream consoleContents = new ByteArrayOutputStream();
    
    Biblioteca biblioteca = new Biblioteca(new PrintStream(consoleContents));
    
    private String output(){
        return consoleContents.toString().trim();
    }

    @Test
    public void testOutputToConsole() throws Exception {
        String expectedMessage = "some text!";
        biblioteca.printMessages("some text!");
        assertEquals(expectedMessage, output());
    }
}
