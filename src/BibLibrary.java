public class BibLibrary {

    public BibLibrary() {
        booksInLibrary();
    }

    public String processUserChoice(String input) {
        if (input.equals("view books")){
        return booksInLibrary();
        } else {
            return "Select a valid option!!";
        }
    }

    private final String booksInLibrary() {
        String allBooks = 
                new Book("book 1") + "\n" +
                new Book("book 2") + "\n" +
                new Book("book 3") + "\n";
        return allBooks;
     }
}
