package com.opencart.testcases;

import com.opencart.base.BaseTest;
import com.opencart.pages.HomePage;
import com.opencart.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(priority = 1)
    public void verifySearchExistingProduct() {

        HomePage homePage = new HomePage(driver);

        homePage.enterProductName("iPhone");
        homePage.clickSearch();

        SearchPage searchPage = new SearchPage(driver);

        Assert.assertTrue(searchPage.isProductDisplayed());

        System.out.println("Existing Product Search Passed");
    }

    @Test(priority = 2)
    public void verifySearchNonExistingProduct() {

        HomePage homePage = new HomePage(driver);

        homePage.enterProductName("SamsungGalaxy999");
        homePage.clickSearch();

        SearchPage searchPage = new SearchPage(driver);

        Assert.assertEquals(
                searchPage.getNoProductMessage(),
                "There is no product that matches the search criteria."
        );

        System.out.println("Non Existing Product Search Passed");
    }

    @Test(priority = 3)
    public void verifySearchWithoutProduct() {

        HomePage homePage = new HomePage(driver);

        homePage.clickSearch();

        SearchPage searchPage = new SearchPage(driver);

        Assert.assertEquals(
                searchPage.getNoProductMessage(),
                "There is no product that matches the search criteria."
        );

        System.out.println("Empty Search Passed");
    }
}