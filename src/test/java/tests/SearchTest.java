package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.SearchPage;

public class SearchTest extends BaseTest {

    @Test
    public void searchText() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterUsername();
        searchPage.enterPassword();
        searchPage.clickLoginButton();
        Assert.assertTrue(searchPage.verifySecureAreaText());
    }

    @Test
    public void verifyText() {
        SearchPage searchPage = new SearchPage(driver);
        Assert.assertTrue(
                searchPage.verifySecureAreaText(),
                "Expected text was not displayed");
    }
}
