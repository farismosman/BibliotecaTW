import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

public class UserChoices {

    private Biblioteca biblioteca;
    private Library library;
    private HashMap<String, ChoiceHandler> allChoices = new HashMap<String, ChoiceHandler>();
    
    public UserChoices(Biblioteca biblioteca, Library library) {
        this.biblioteca = biblioteca;
        this.library = library;
        commandFactory();
    }
    
    private final HashMap<String, ChoiceHandler> commandFactory(){
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
            return biblioteca.quitUser();
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
