import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

public class BibLibrary {

    private HashMap<String, String> allBooks = new HashMap<String, String>();

    private final HashMap<String, String> books() {
        allBooks.put(new Book("book 1").toString(), "not reserved");
        allBooks.put(new Book("book 2").toString(), "not reserved");
        allBooks.put(new Book("book 3").toString(), "not reserved");
        return allBooks;
    }

    public BibLibrary() {
        books();
    }

    public String processUserChoice(String input) {
        if (input.equals("view books")){
            return StringUtils.join(books().keySet(), "\n");
        } else if (input.equals("reserve a book")) {
            return reserve("book 1");
        } else if (input.equals("library number")) {
            return checkNumber();
        } else {
            return "Select a valid option!!";
        }
    }

    public boolean getStatus(String book) {
        if (allBooks.containsKey(book) && allBooks.get(book).equals("not reserved")) {
            return false;
        } else {
            return true;
        }
    }

    public String reserve(String book) {
        if (allBooks.containsKey(book)){
            allBooks.put(book, "reserved");
            return "Thank You! Enjoy the book.";
        } else {
            return "Sorry we don't have that book yet.";
        }
    }

    public String checkNumber() {
        return "Please talk to Librarian. Thank you.";
    }
}
