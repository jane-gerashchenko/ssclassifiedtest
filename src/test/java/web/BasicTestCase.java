package web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.TestPropertiesLoader;
import org.junit.Before;
import org.junit.BeforeClass;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasicTestCase {

    private static String baseUrl = TestPropertiesLoader.getBaseUrl();
    private static String browser = TestPropertiesLoader.getBrowser();
    private static String searchText = TestPropertiesLoader.getSearchText();

    private SelenideElement announcementContent = $("#msg_div_msg");


    @BeforeClass
    public static void setup() {
        System.setProperty("selenide.browser", browser);
    }

    @Before
    public void openPage() {
        open(baseUrl);
    }

    void verifyAdVisibleAndHasSearchText() {
        announcementContent.shouldBe(Condition.visible).shouldHave(Condition.text(searchText));
    }
}
