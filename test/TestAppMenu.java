import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAppMenu {
    
    AppMenu appMenu = new AppMenu();
    
    @Test
    public void testUserOptions() throws Exception {
        String menuOptions = 
                "To view all books type \"view books\"\n" + 
                "To reserve a book type \"reserve book\"\n" + 
                "To check your library number type \"library number\"\n" + 
                "To quit application type \"q\" or \"Q\"";
        assertEquals(menuOptions, appMenu.userOptions());
    }
}
