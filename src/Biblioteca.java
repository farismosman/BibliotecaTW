import org.apache.commons.lang3.StringUtils;

import java.io.*;

public class Biblioteca {
    
    AppMenu appMenu = new AppMenu();
    Library library = new Library();
    
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
        printStream.print("> ");
        String input = "";
        
        try{
            input = bufferedReader.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return input;
    }

    public String processUserChoice() {
        String input = userInput();
        if (input.equals("view books")){
            return StringUtils.join(library.books().keySet(), "\n");
        } else if (input.equals("reserve a book")) {
            printStream.println("Book:");
            String book = userInput();
            return library.reserve(book);
        } else if (input.equals("library number")) {
            return library.checkNumber();
        } else {
            return "Select a valid option!!";
        }
    }
}
