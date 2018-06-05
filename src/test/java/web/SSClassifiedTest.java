package web;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MemoPage;
import pages.SearchPage;

public class SSClassifiedTest extends BasicTestCase {

    private SearchPage SearchPage = new SearchPage();
    private MemoPage MemoPage = new MemoPage();

    @Test
    @DisplayName("Test search and adding to favorites")
    public void testFindContent(){

        SearchPage.searchText();
        SearchPage.selectFirstAd();
        verifyAdVisibleAndHasSearchText();

        MemoPage.addAnnouncementToMemo();
        MemoPage.goToMemo();
        MemoPage.selectAddedAnnouncement();
        verifyAdVisibleAndHasSearchText();
    }
}
