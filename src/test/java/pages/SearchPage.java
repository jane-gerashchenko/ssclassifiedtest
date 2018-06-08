package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private SelenideElement searchButton = $(".a_menu[title=\"Search announcements\"]");
    private SelenideElement searchField = $("#ptxt");
    private SelenideElement firstAdvertisement = $("#page_main table:nth-of-type(2) tr:nth-of-type(2)");
    private SelenideElement advertisementCheckbox = $("#page_main table:nth-of-type(2) tr:nth-of-type(2) input[name='mid[]']");
    private SelenideElement addToFavorites = $("#a_fav_sel");


    @Step("Go to search page")
    public void openSearch() {
        searchButton.click();
    }

    @Step("Search by text: '{text}'")
    public void searchFor(String text) {
        searchField.setValue(text).pressEnter();
    }

    @Step("Select first found advertisement by clicking on it")
    public void selectFirstAdvertisement() {
        firstAdvertisement.click();
    }

    @Step("Select first found advertisement using checkbox")
    public void selectFoundAdvertisementViaCheckbox() {
        advertisementCheckbox.click();
    }

    @Step("Add advertisement to favorites list")
    public void addAdvertisementToFavorites() {
        addToFavorites.click();
    }
}
