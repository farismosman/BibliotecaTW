import java.io.PrintStream;

public class Biblioteca {
    private PrintStream printStream;

    public Biblioteca(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printMessages(String message) {
        printStream.println(message);
    }
    
    public void main(){
        Biblioteca biblioteca = new Biblioteca(printStream);
    }
}
