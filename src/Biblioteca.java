import org.apache.commons.lang3.StringUtils;

import java.io.*;

public class Biblioteca {
    
    AppMenu appMenu = new AppMenu();
    Library library = new Library();
    
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public boolean isQuit() {
        return quit;
    }

    private boolean quit = false;

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
        } else if (input.equals("q") || input.equals("Q")){
            return quitUser();
        }else {
            return "Select a valid option!!";
        }
    }

    public String quitUser() {
        quit = true;
        return "Thanks for using our library!";
    }
    
    public void run(){
        welcomeScreen();
        while (!quit){
            bibMenu();
            userInput();
            processUserChoice();   
        }
    }
    
    public void main(){
        new Biblioteca(System.out, System.in).run();
    }
}
