package com.thoughtworks.biblioteca;

import java.io.*;

public class BibManager {
    
    AppMenu appMenu = new AppMenu();
    private UserChoices userChoice = new UserChoices(this, new Library()) ;
    
    protected PrintStream printStream;
    private BufferedReader bufferedReader;

    private boolean QUIT = false;
    private Library library = new Library();
    private boolean isLogin = false;

    public boolean isQUIT() {
        return QUIT;
    }

    public BibManager(PrintStream printStream, InputStream inputStream) {
        this.printStream = printStream;
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public void printMessages(String message) {
        printStream.println(message);
    }

    public void welcomeScreen() {
        printMessages("Welcome to Bangalore Public Library System");
    }

    public void bibMenu() {
        printMessages(appMenu.userOptions());
    }

    public String userInput() {
        printStream.print("> ");
        String input = "";
        try{
            input = bufferedReader.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return input;
    }

    public String quitUser() {
        QUIT = true;
        return "Thanks for using our library!";
    }

    public String process(String input) {
        if (userChoice.commandsFactory().containsKey(input)){
            return userChoice.commandsFactory().get(input).execute();
        } else {
            return "Select a valid option!!";
        }
    }

    public void run(){
        welcomeScreen();
        bibMenu();
        while (!QUIT){
            String choice = userInput();
            process(choice);   
        }
    }

    public String checkNumber() {
        if (isLogin){
            return "111-1111, 1111@email.com, 111-1111-phone";
        } else {
        return "Please talk to Librarian. Thank you.";
        }

    }

    public static void main(String [] args){
        new BibManager(System.out, System.in).run();
    }

    public boolean login(String username, String password) {
        if (library.users().containsKey(username) && library.users().get(username).equals(password)){
            isLogin = true;
            return isLogin;
        } else {
            return isLogin;
        }
    }
}
