package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MemoPage {

    private SelenideElement addToFavorites = $("#a_fav");
    private SelenideElement confirmationMessage = $("#alert_msg");
    private SelenideElement confirmationButton = $("#alert_ok");
    private ElementsCollection addedAnnouncements = $$("#page_main form table tr");
    private SelenideElement favoriteAnnouncement = $("#page_main form table tr:nth-of-type(2)");

    @Step("Add to favorites")
    public void addToFavorites() {
        addToFavorites.click();
        confirmationMessage.shouldHave(Condition.exactText("Advertisement added to favorites."));
        confirmationButton.click();
    }

    @Step("Select favorite announcement")
    public void selectAddedAnnouncement(){
        addedAnnouncements.shouldHave(CollectionCondition.size(2));
        favoriteAnnouncement.click();
    }
}
