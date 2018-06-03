package web;

import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import pages.MemoPage;
import pages.SearchPage;

import static com.codeborne.selenide.Selenide.$;

public class SSClassifiedTest extends BasicTestCase {

    private SelenideElement announcementContent = $("#msg_div_msg");
    private SelenideElement memoButton = $(".a_menu[title=\"Memo\"]");
    private SearchPage SearchPage = new SearchPage();
    private MemoPage MemoPage = new MemoPage();

    @Test
    public void testFindContent(){

        SearchPage.searchText("QA engineer");
        SearchPage.selectFirstResult();
        verifyMessageVisibleAndHasText(announcementContent, "QA engineer");

        MemoPage.addToFavorites();
        memoButton.click();
        MemoPage.selectAddedAnnouncement();
        verifyMessageVisibleAndHasText(announcementContent, "QA engineer");
    }
}
