package com.thoughtworks.biblioteca;

import com.thoughtworks.biblioteca.Users;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestUsers {
    @Test
    public void testUserHasUsername() throws Exception {
        assertEquals("a user", new Users("a user", "a password", "details").getUsername());
    }

    @Test
    public void testUserHasPassword() throws Exception {
        assertEquals("a password", new Users("a user", "a password", "details").getPassword());
    }

    @Test
    public void testUserHasDetails() throws Exception {
        assertEquals("details", new Users("username", "password", "details").getDetails());
    }
}
