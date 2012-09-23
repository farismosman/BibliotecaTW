import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestUsers {
    @Test
    public void testUserHasUsername() throws Exception {
        assertEquals("a user", new Users("a user", "a password").getUsername());
    }

    @Test
    public void testUserHasPassword() throws Exception {
        assertEquals("a password", new Users("a user", "a password").getPassword());
    }
}
