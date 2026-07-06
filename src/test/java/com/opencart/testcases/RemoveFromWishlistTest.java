package com.opencart.testcases;

import com.opencart.base.BaseTest;
import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;
import com.opencart.pages.ProductPage;
import com.opencart.pages.SearchPage;
import com.opencart.pages.WishlistPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveFromWishlistTest extends BaseTest {

    private static final Logger logger =
            LogManager.getLogger(RemoveFromWishlistTest.class);

    @Test
    public void verifyRemoveFromWishlist() {

        HomePage homePage = new HomePage(driver);

        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                config.getEmail(),
                config.getPassword()
        );

        homePage.enterProductName("iPhone");
        homePage.clickSearch();

        SearchPage searchPage = new SearchPage(driver);

        Assert.assertTrue(searchPage.isProductDisplayed());

        searchPage.openProduct();

        ProductPage productPage = new ProductPage(driver);

        productPage.clickWishlistButton();

        Assert.assertTrue(
                productPage.getSuccessMessage().contains("Success"),
                "Product not added to wishlist."
        );

        productPage.openWishlist();

        WishlistPage wishlistPage = new WishlistPage(driver);

        Assert.assertEquals(
                wishlistPage.getProductName(),
                "iPhone"
        );

        wishlistPage.clickRemoveButton();

        Assert.assertTrue(
                wishlistPage.getSuccessMessage().contains("Success"),
                "Wishlist remove message not displayed."
        );

        Assert.assertTrue(
                wishlistPage.getEmptyWishlistMessage()
                        .contains("Your wish list is empty."),
                "Wishlist is not empty."
        );

        logger.info("Remove From Wishlist Test Passed.");
    }
}