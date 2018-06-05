package pages;

import com.codeborne.selenide.SelenideElement;
import data.TestPropertiesLoader;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private String searchText = TestPropertiesLoader.getSearchText();

    private SelenideElement searchButton = $(".a_menu[title=\"Search announcements\"]");
    private SelenideElement searchField = $("#ptxt");
    private SelenideElement firstAd = $("#page_main table:nth-of-type(2) tr:nth-of-type(2)");

    @Step("Search by text: '{text}'")
    public void searchText() {
        searchButton.click();
        searchField.setValue(searchText).pressEnter();
    }

    @Step("Select first Ad")
    public void selectFirstAd() {
        firstAd.click();
    }
}
