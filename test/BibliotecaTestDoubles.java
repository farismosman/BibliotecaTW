import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BibliotecaTestDoubles {

    public ByteArrayOutputStream consoleOutputContent = new ByteArrayOutputStream();

    public Biblioteca fakedBibliotecaUserInput(String aText){
        ByteArrayInputStream consoleInputContent = new ByteArrayInputStream(aText.getBytes());
        return new Biblioteca(new PrintStream(consoleOutputContent), consoleInputContent);
    }

    public String output(){
        return consoleOutputContent.toString().trim();
    }

}
