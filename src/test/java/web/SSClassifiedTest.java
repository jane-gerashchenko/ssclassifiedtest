package web;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.FavoritesPage;
import pages.SearchPage;

public class SSClassifiedTest extends BasicTestCase {

    private SearchPage SearchPage = new SearchPage();
    private FavoritesPage FavoritesPage = new FavoritesPage();

    private String searchText = "Tallina - Helsinki - Stokholma";

    @Test
    @DisplayName("Test search for advertisement and add it to favorites list")
    public void testFindAdvertisementAndAddToFavorites(){

        SearchPage.searchFor(searchText);
        SearchPage.selectFirstAdvertisement();
        verifyAdvertisementHasText(searchText);

        FavoritesPage.addAdvertisementToFavorites();
        verifyConfirmationMessageHasText("Advertisement added to favorites.");
        FavoritesPage.confirm();

        FavoritesPage.goToFavorites();
        FavoritesPage.selectAddedAdvertisement();
        verifyAdvertisementHasText(searchText);
    }
}
