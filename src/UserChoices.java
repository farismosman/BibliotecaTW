import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

public class UserChoices {

    private Biblioteca biblioteca;
    private Library library;

    private HashMap<String, ChoiceHandler> allChoices = new HashMap<String, ChoiceHandler>();

    private boolean QUIT = false;
    
    public UserChoices(Biblioteca biblioteca, Library library) {
        this.biblioteca = biblioteca;
        this.library = library;
        commandsFactory();
    }

    public boolean isQUIT() {
        return QUIT;
    }

    public String quitUser() {
        QUIT = true;
        return "Thanks for using our library!";
    }
    
    public HashMap<String, ChoiceHandler> commandsFactory(){
        allChoices.put("view books", new ViewBooks());
        allChoices.put("library number", new LibraryNumber());
        allChoices.put("reserve a book", new ReserveABook());
        allChoices.put("q", new QuitUser());
        allChoices.put("Q", new QuitUser());
        return allChoices;
    }

    private class ViewBooks implements ChoiceHandler {
        @Override
        public String execute() {
            return StringUtils.join(library.books().keySet(), "\n");
        }

    }

    private class LibraryNumber implements ChoiceHandler {
        @Override
        public String execute() {
            return library.checkNumber();
        }
    }
    
    private class QuitUser implements ChoiceHandler {
        @Override
        public String execute() {
            return quitUser();
        }
    }
    
    private class ReserveABook implements ChoiceHandler {
        @Override
        public String execute() {
            biblioteca.printStream.println("Book:");
            String book = biblioteca.userInput();
            return library.reserve(book);
        }
    }
}
