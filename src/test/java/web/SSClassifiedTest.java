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
    @DisplayName("Test default search page")
    public void testSearchPage() {

        openPage();
        SearchPage.openSearch();
        verifySearchFieldNameHasText("Ought word or phrase:");
        verifySectionFilterHasText("Section:");
        verifyRegionFilterHasText("Town, region:");
        verifyPeriodFilterHasText("Search for the period:");
    }

    @Test
    @DisplayName("Test search query with empty search results")
    public void testEmptySearchResults() {

        openPage();
        SearchPage.openSearch();
        SearchPage.searchFor("6cd5862a-fb61-495d-96a8-45540638c967-to-get-zero-results");
        verifyEmptySearchResultPageHasText("On your inquiry it is not found any message");
    }

   @Test
   @DisplayName("Test search for valid advertisement")
   public void testSearchForAdvertisement() {

       openPage();
       SearchPage.openSearch();
       SearchPage.searchFor(searchText);
       SearchPage.selectFirstAdvertisement();
       verifyAdvertisementHasText(searchText);
   }

    @Test
    @DisplayName("Test search for advertisement and add it to favorites list")
    public void testAddAdvertisementToFavorites(){

        openPage("/search-result/?q=Tallina+-+Helsinki+-+Stokholma");
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

        openPage("/search-result/?q=Tallina+-+Helsinki+-+Stokholma");
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
