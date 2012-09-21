import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

public class UserChoices {

    private Manager manager;
    private Library library;

    private HashMap<String, ChoiceHandler> allChoices = new HashMap<String, ChoiceHandler>();

    public UserChoices(Manager manager, Library library) {
        this.manager = manager;
        this.library = library;
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
            return manager.quitUser();
        }
    }
    
    private class ReserveABook implements ChoiceHandler {
        @Override
        public String execute() {
            manager.printStream.println("Book:");
            String book = manager.userInput();
            return library.reserve(book);
        }
    }
}
