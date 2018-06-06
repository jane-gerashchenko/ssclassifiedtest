package web;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.FavoritesPage;
import pages.SearchPage;

public class SSClassifiedTest extends BasicTestCase {

    private SearchPage SearchPage = new SearchPage();
    private FavoritesPage FavoritesPage = new FavoritesPage();

    @Test
    @DisplayName("Test search for ad and add it to favorites list")
    public void testFindContent(){

        //Search for advertisement
        SearchPage.searchText("Tallina - Helsinki - Stokholma");
        SearchPage.selectFirstAd();
        verifyAdvertisementHasText("Tallina - Helsinki - Stokholma");

        //Add advertisement to favorites list
        FavoritesPage.addAdvertisementToFavorites();
        verifyConfirmationMessageHasText("Advertisement added to favorites.");
        FavoritesPage.confirmAction();

        //Verify advertisement in the favorites list
        FavoritesPage.goToFavorites();
        FavoritesPage.selectAddedAdvertisement();
        verifyAdvertisementHasText("Tallina - Helsinki - Stokholma");
    }
}
