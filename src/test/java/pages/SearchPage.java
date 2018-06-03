package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private SelenideElement searchButton = $(".a_menu[title=\"Search announcements\"]");
    private SelenideElement searchField = $("#ptxt");
    private SelenideElement firstResult = $("#page_main table:nth-of-type(2) tr:nth-of-type(2)");

    public void searchText(String text) {
        searchButton.click();
        searchField.setValue(text).pressEnter();
    }

    public void selectFirstResult() {
        firstResult.click();
    }
}
