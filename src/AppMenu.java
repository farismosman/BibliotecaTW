public class AppMenu {
    private static final String viewBooks = "To view all books type \"view books\"\n";
    private static final String reserveBook = "To reserve a book type \"reserve book\"\n";
    private static final String libraryNumber = "To check your library number type \"library number\"\n"; 
    public static final String quitApp = "To quit application type \"q\" or \"Q\"";
    
    public String userOptions() {
        return viewBooks + reserveBook + libraryNumber + quitApp;
    }

}
