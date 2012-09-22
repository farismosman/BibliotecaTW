import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BibManagerTestDoubles {

    public ByteArrayOutputStream consoleOutputContent = new ByteArrayOutputStream();

    public BibManager fakedUserInput(String aText){
        ByteArrayInputStream consoleInputContent = new ByteArrayInputStream(aText.getBytes());
        return new BibManager(new PrintStream(consoleOutputContent), consoleInputContent);
    }

    public String output(){
        return consoleOutputContent.toString().trim();
    }

}
