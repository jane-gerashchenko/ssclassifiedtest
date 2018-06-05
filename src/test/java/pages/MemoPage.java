package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MemoPage {

    private SelenideElement addToMemo = $("#a_fav");
    private SelenideElement confirmationMessage = $("#alert_msg");
    private SelenideElement confirmationButton = $("#alert_ok");
    private ElementsCollection addedAnnouncements = $$("#page_main form table tr");
    private SelenideElement favoriteAd = $("#page_main form table tr:nth-of-type(2)");
    private SelenideElement memoButton = $(".a_menu[title=\"Memo\"]");

    @Step("Add to favorites")
    public void addAnnouncementToMemo() {
        addToMemo.click();
        confirmationMessage.shouldHave(Condition.exactText("Advertisement added to favorites."));
        confirmationButton.click();
    }

    @Step("Select favorite Ad")
    public void selectAddedAnnouncement(){
        addedAnnouncements.shouldHave(CollectionCondition.size(2));
        favoriteAd.click();
    }

    @Step("Go to Memo")
    public void goToMemo() {
        memoButton.click();
    }
}
