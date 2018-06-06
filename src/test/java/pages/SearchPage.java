package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private SelenideElement searchButton = $(".a_menu[title=\"Search announcements\"]");
    private SelenideElement searchField = $("#ptxt");
    private SelenideElement firstAd = $("#page_main table:nth-of-type(2) tr:nth-of-type(2)");

    @Step("Search by text: '{text}'")
    public void searchText(String message) {
        searchButton.click();
        searchField.setValue(message).pressEnter();
    }

    @Step("Select first Ad")
    public void selectFirstAd() {
        firstAd.click();
    }
}
