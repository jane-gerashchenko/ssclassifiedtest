package web;

import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import pages.MemoPage;
import pages.SearchPage;

import static com.codeborne.selenide.Selenide.$;

public class SSClassifiedTest extends BasicTestCase {

    private SelenideElement announcementContent = $("#msg_div_msg");
    private SelenideElement memoButton = $(".a_menu[title=\"Memo\"]");
    private SearchPage SearchPage = new SearchPage();
    private MemoPage MemoPage = new MemoPage();

    @Test
    @DisplayName("Test search and adding to favorites")
    public void testFindContent(){

        SearchPage.searchText("Три столицы на Дунае");
        SearchPage.selectFirstResult();
        verifyMessageVisibleAndHasText(announcementContent, "Три столицы на Дунае");

        MemoPage.addToFavorites();
        memoButton.click();
        MemoPage.selectAddedAnnouncement();
        verifyMessageVisibleAndHasText(announcementContent, "Три столицы на Дунае");
    }
}
