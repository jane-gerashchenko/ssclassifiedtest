package web;

import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SSClassifiedTest extends BasicTestCase {

    @Test
    public void testFindElement(){
        $(".a_menu_active").hover().click();
    }
}
