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

    private SelenideElement announcementContent = $("#msg_div_msg");
    private SelenideElement confirmationMessage = $("#alert_msg");


    @BeforeClass
    public static void setup() {
        System.setProperty("selenide.browser", browser);
    }

    @Before
    public void openPage() {
        open(baseUrl);
    }

    void verifyAdvertisementVisibleAndHasText(String message) {
        announcementContent.shouldBe(Condition.visible).shouldHave(Condition.text(message));
    }

    void verifyConfirmationMessageVisibleAndHasText(String message) {
        confirmationMessage.shouldBe(Condition.visible).shouldHave(Condition.exactText(message));
    }
}
