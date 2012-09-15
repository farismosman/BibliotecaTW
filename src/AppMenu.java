public class AppMenu {
    private static final String viewBooks = "To view all books type \"view books\"\n";
    
    public String userOptions() {
        return viewBooks;
    }

    public String selectedOption(String userOption) {
        return userOption;
    }
}
