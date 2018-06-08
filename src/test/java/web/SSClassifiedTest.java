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
    @DisplayName("Test default search page state")
    public void testSearchPageElementsPresent() {

        openPage();
        SearchPage.openSearch();
        verifySearchFieldNameHasText("Ought word or phrase:");
        verifySectionFilterHasText("Section:");
        verifyRegionFilterHasText("Town, region:");
        verifyPeriodFilterHasText("Search for the period:");
        verifySearchButtonHasText("Search");
    }

    @Test
    @DisplayName("Test empty search")
    public void testEmptySearch() {

        openPage();
        SearchPage.openSearch();
        SearchPage.searchFor("");
        verifyEmptySearchResultPageHasText("On your inquiry it is not found any message");
    }

   @Test
   @DisplayName("Test search to find advertisement")
   public void testSearchForAdvertisement() {

       openPage();
       SearchPage.openSearch();
       SearchPage.searchFor(searchText);
       SearchPage.selectFirstAdvertisement();
       verifyAdvertisementHasText(searchText);
   }

    @Test
    @DisplayName("Test default favorites page state")
    public void testFavoritesPageElementsPresent() {

        openPage();
        FavoritesPage.goToFavorites();
        verifyViewModeSelectorAvailability();
        verifyFavoritesLinkHasText("Favorites");
        verifyViewedAdsLinkHasText("Recently viewed ads");
        verifyEmptyFavoritesPageHasText("Select the messages.");
    }

    @Test
    @DisplayName("Test search for advertisement and add it to favorites list")
    public void testAddAdvertisementToFavorites(){

        openPage("/search-result/?q=" + searchText);
        SearchPage.selectFirstAdvertisement();
        verifyAdvertisementHasText(searchText);

        FavoritesPage.addAdvertisementToFavorites();
        verifyConfirmationMessageHasText("Advertisement added to favorites.");
        FavoritesPage.confirm();

        FavoritesPage.goToFavorites();
        FavoritesPage.selectAddedAdvertisement();
        verifyAdvertisementHasText(searchText);
    }

    @Test
    @DisplayName("Test add advertisement via checkbox to favorites and remove it from favorites")
    public void testAddAdvertisementToFavoritesAndRemoveFromFavorites() {

        openPage("/search-result/?q=" + searchText);
        SearchPage.selectFoundAdvertisementViaCheckbox();
        SearchPage.addAdvertisementToFavorites();
        verifyConfirmationMessageHasText("Sludinājumi ir pievienoti Memo.");
        FavoritesPage.confirm();

        FavoritesPage.goToFavorites();
        FavoritesPage.selectFavoriteAdvertisementViaCheckbox();
        FavoritesPage.removeAdvertisementFromFavorites();
        verifyEmptyFavoritesPageHasText("Select the messages.");
    }
}
