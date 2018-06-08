package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class FavoritesPage {

    private SelenideElement addToFavorites = $("#a_fav");
    private SelenideElement confirmationButton = $("#alert_ok");
    private SelenideElement favoriteAdvertisement = $("#page_main form table tr:nth-of-type(2)");
    private SelenideElement memoButton = $(".a_menu[title=\"Memo\"]");
    private SelenideElement deleteFromFavorites = $("#del_selected_a");
    private SelenideElement advertisementCheckbox = $("#page_main form table tr:nth-of-type(2) input[name='mid[]']");

    @Step("Add advertisement to favorites list")
    public void addAdvertisementToFavorites() {
        addToFavorites.click();
    }

    @Step("Confirm adding advertisement to favorites list")
    public void confirm() {
        confirmationButton.click();
    }

    @Step("Go to favorites list")
    public void goToFavorites() {
        memoButton.click();
    }

    @Step("Select favorite advertisement")
    public void selectAddedAdvertisement(){
        favoriteAdvertisement.click();
    }

    @Step("Select favorite advertisement using checkbox")
    public void selectFavoriteAdvertisementViaCheckbox() {
        advertisementCheckbox.click();
    }

    @Step("Delete advertisement from favorites list")
    public void removeAdvertisementFromFavorites() {
        deleteFromFavorites.click();
    }
}
