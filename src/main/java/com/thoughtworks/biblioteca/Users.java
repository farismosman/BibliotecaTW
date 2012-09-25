package com.thoughtworks.biblioteca;

public class Users {

    private String username;
    private String password;

    private String details;

    public Users(String username, String password, String details) {
        this.username = username;
        this.password = password;
        this.details = details;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDetails() {
        return details;
    }
}
