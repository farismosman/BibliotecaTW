import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAppMenu {
    
    AppMenu appMenu = new AppMenu();
    
    @Test
    public void testUserOptions() throws Exception {
        String menuOptions = "To view all books type \"view books\"\n";
        assertEquals(menuOptions, appMenu.userOptions());
    }

    @Test
    public void testSelectedOptionReturnTheSelectedOption() throws Exception {
       assertEquals("invalid option", appMenu.selectedOption("invalid option"));
    }
}
