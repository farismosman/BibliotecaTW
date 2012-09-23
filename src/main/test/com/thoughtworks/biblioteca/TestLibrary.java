package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLibrary {

    Library library = new Library();

    @Test
    public void testReserveExistingBook() throws Exception {
        assertEquals("Thank You! Enjoy the book.", library.reserveABook("book 1"));
    }

    @Test
    public void testReserveChangeItsStatusFromFalseToTrue() throws Exception {
        library.reserveABook("book 1");

        assertEquals(true, library.getStatus("book 1"));
    }

    @Test
    public void testBookIsNotReservedByDefault() throws Exception {
        assertEquals(false, library.getStatus("book 1"));
    }


    @Test
    public void testIfBookDoesNotExist() throws Exception {
        
        assertEquals("Sorry we don't have that book yet.", library.reserveABook("some unavailable book"));
    }

}
