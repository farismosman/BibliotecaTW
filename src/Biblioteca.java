import java.io.*;

public class Biblioteca {
    
    AppMenu appMenu = new AppMenu();
    
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
}
