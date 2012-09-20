import org.apache.commons.lang3.StringUtils;

public class UserChoices {

    private Biblioteca biblioteca;
    private Library library;

    public UserChoices(Biblioteca biblioteca, Library library) {
        this.biblioteca = biblioteca;
        this.library = library;
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
