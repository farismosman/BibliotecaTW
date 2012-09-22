package com.thoughtworks.biblioteca;

import java.io.*;

public class BibManager {
    
    AppMenu appMenu = new AppMenu();
    private UserChoices userChoice = new UserChoices(this, new Library()) ;
    
    protected PrintStream printStream;
    private BufferedReader bufferedReader;

    private boolean QUIT = false;

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
    
    public static void main(String [] args){
        new BibManager(System.out, System.in).run();
    }
}
