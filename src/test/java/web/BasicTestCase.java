package web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.TestPropertiesLoader;
import org.junit.BeforeClass;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasicTestCase {

    private static String baseUrl = TestPropertiesLoader.getBaseUrl();
    private static String browser = TestPropertiesLoader.getBrowser();

    private SelenideElement advertisementContent = $("#msg_div_msg");
    private SelenideElement confirmationMessage = $("#alert_msg");
    private SelenideElement defaultMessage = $("#page_main center\\<br td");
    private SelenideElement searchFieldName = $("#page_main table tr:nth-of-type(2) td:nth-of-type(1)");
    private SelenideElement sectionFilter = $("#page_main table tr:nth-of-type(4) td:nth-of-type(1)");
    private SelenideElement regionFilter = $("#page_main table tr:nth-of-type(6) td:nth-of-type(1)");
    private SelenideElement periodFilter = $("#page_main table tr:nth-of-type(7) td:nth-of-type(1)");
    private SelenideElement emptySearchResult = $("#page_main table:nth-of-type(2) td");

    @BeforeClass
    public static void setup() {
        System.setProperty("selenide.browser", browser);
    }

    public void openPage() {
        open(baseUrl);
    }

    public void openPage(String query) {
        open(baseUrl + query);
    }

    void verifyAdvertisementHasText(String text) {
        advertisementContent.shouldHave(Condition.text(text));
    }

    void verifyConfirmationMessageHasText(String text) {
        confirmationMessage.shouldHave(Condition.exactText(text));
    }

    void verifyEmptyFavoritesPageHasText(String text) {
        defaultMessage.shouldHave(Condition.exactText(text));
    }

    void verifySearchFieldNameHasText(String text) {
        searchFieldName.shouldHave(Condition.exactText(text));
    }

    void verifySectionFilterHasText(String text) {
        sectionFilter.shouldHave(Condition.exactText(text));
    }

    void verifyRegionFilterHasText(String text) {
        regionFilter.shouldHave(Condition.exactText(text));
    }

    void verifyPeriodFilterHasText(String text) {
        periodFilter.shouldHave(Condition.exactText(text));
    }

    void verifyEmptySearchResultPageHasText(String text) {
        emptySearchResult.shouldHave(Condition.exactText(text));
    }
}
