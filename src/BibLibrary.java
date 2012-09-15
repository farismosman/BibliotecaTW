public class BibLibrary {
    
    public String viewListOfBooks() {
        return "book 1\n" + "book 2\n" + "book 3\n";
    }

    public String processUserChoice(String input) {
        if (input.equals("view books")){
        return viewListOfBooks();
        } else {
            return "Select a valid option!!";
        }
    }
}
