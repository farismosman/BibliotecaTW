public class AppMenu {
    private static final String viewBooks = "To view all books type \"view books\"\n";
    private static final String reserveBook = "To reserve a book type \"reserve book\"";
    
    public String userOptions() {
        return viewBooks + reserveBook;
    }

    public String selectedOption(String userOption) {
        return userOption;
    }
}
