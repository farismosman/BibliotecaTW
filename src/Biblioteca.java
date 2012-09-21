import java.io.*;

public class Biblioteca {
    
    AppMenu appMenu = new AppMenu();
    private UserChoices userChoice = new UserChoices(this, new Library()) ;
    
    protected PrintStream printStream;
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

    public String process() {
        String input = userInput();
        if (userChoice.commandsFactory().containsKey(input)){
            return userChoice.commandsFactory().get(input).execute();
        } else {
            return "Select a valid option";
        }
    }
    
    public void run(){
        welcomeScreen();
        while (!userChoice.isQUIT()){
            bibMenu();
            userInput();
            process();   
        }
    }
    
    public void main(){
        new Biblioteca(System.out, System.in).run();
    }
}
