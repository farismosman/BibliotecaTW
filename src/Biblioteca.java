import org.apache.commons.lang3.StringUtils;

import java.io.*;

public class Biblioteca {
    
    AppMenu appMenu = new AppMenu();
    BibLibrary library = new BibLibrary();
    
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public Biblioteca(PrintStream printStream, InputStream inputStream) {
        this.printStream = printStream;
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public void printMessages(String message) {
        printStream.println(message);
    }

    public void welcomeScreen() {
        printMessages("Welcome to Bangalore Public Library System");
    }

    public void bibMenu() {
        printMessages(appMenu.userOptions());
    }

    public String userInput() {
        String input = "";
        
        try{
            input = bufferedReader.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return input;
    }

    public String processUserChoice(String input) {
        if (input.equals("view books")){
            return StringUtils.join(library.books().keySet(), "\n");
        } else if (input.equals("reserve a book")) {
            return library.reserve("book 1");
        } else if (input.equals("library number")) {
            return library.checkNumber();
        } else {
            return "Select a valid option!!";
        }
    }
}
