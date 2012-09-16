import java.io.PrintStream;

public class Biblioteca {
    
    AppMenu appMenu = new AppMenu();
    
    private PrintStream printStream;

    public Biblioteca(PrintStream printStream) {
        this.printStream = printStream;
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
}
