package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestUserChoices {
    private UserChoices userChoices = new UserChoices(new BibManager(System.out, System.in), new Library());

    @Test
    public void testCommandFactoryHasViewBooks() throws Exception {
        assertEquals(true, userChoices.commandsFactory().containsKey("view books"));
    }

    @Test
    public void testCommandFactoryHasReserveABook() throws Exception {
        assertEquals(true, userChoices.commandsFactory().containsKey("reserve a book"));
    }

    @Test
    public void testCommandFactoryDoesNotHaveAnOption() throws Exception {
        assertFalse(userChoices.commandsFactory().containsKey("an option"));
    }
}
