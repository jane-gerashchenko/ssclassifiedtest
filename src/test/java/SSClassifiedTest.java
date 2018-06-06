import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.FavoritesPage;
import pages.SearchPage;

public class SSClassifiedTest extends BasicTestCase {

    private SearchPage SearchPage = new SearchPage();
    private FavoritesPage FaforitesPage = new FavoritesPage();

    @Test
    @DisplayName("Test search for ad and add it to favorites list")
    public void testFindContent(){

        //Search for advertisement
        SearchPage.searchText("Tallina - Helsinki - Stokholma");
        SearchPage.selectFirstAd();
        verifyAdvertisementVisibleAndHasText("Tallina - Helsinki - Stokholma");

        //Add advertisement to favorites list
        FaforitesPage.addAdvertisementToFavorites();
        verifyConfirmationMessageVisibleAndHasText("Advertisement added to favorites.");
        FaforitesPage.confirmAction();

        //Verify advertisement in the favorites list
        FaforitesPage.goToFavorites();
        FaforitesPage.selectAddedAdvertisement();
        verifyAdvertisementVisibleAndHasText("Tallina - Helsinki - Stokholma");
    }
}
