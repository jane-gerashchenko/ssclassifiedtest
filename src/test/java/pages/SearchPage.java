package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private SelenideElement searchButton = $(".a_menu[title=\"Search announcements\"]");
    private SelenideElement searchField = $("#ptxt");
    private SelenideElement firstAdvertisement = $("#page_main table:nth-of-type(2) tr:nth-of-type(2)");

    @Step("Search by text: '{message}'")
    public void searchFor(String message) {
        searchButton.click();
        searchField.setValue(message).pressEnter();
    }

    @Step("Select first Advertisement")
    public void selectFirstAdvertisement() {
        firstAdvertisement.click();
    }
}
