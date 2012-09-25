package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestUserChoices {
    private UserChoices userChoices = new UserChoices(new BibManager(System.out, System.in), new Library());

    @Test
    public void testCommandFactoryHasTheseCommands() throws Exception {
        assertTrue(userChoices.commandsFactory().containsKey("view books"));
        assertTrue(userChoices.commandsFactory().containsKey("view movies"));
        assertTrue(userChoices.commandsFactory().containsKey("reserve a book"));
        assertTrue(userChoices.commandsFactory().containsKey("login"));
        assertTrue(userChoices.commandsFactory().containsKey("q"));
        assertTrue(userChoices.commandsFactory().containsKey("Q"));
    }

    @Test
    public void testCommandFactoryDoesNotHaveAnOption() throws Exception {
        assertFalse(userChoices.commandsFactory().containsKey("an option"));
    }
}
