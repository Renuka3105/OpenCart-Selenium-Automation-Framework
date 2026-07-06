package com.opencart.testcases;

import com.opencart.base.BaseTest;
import com.opencart.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToWishlistTest extends BaseTest {

    private static final Logger logger =
            LogManager.getLogger(AddToWishlistTest.class);

    @Test
    public void verifyAddToWishlist() {

        HomePage homePage = new HomePage(driver);

        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                config.getEmail(),
                config.getPassword()
        );

        HomePage hp = new HomePage(driver);

        hp.enterProductName("iPhone");
        hp.clickSearch();

        SearchPage searchPage = new SearchPage(driver);

        Assert.assertTrue(searchPage.isProductDisplayed());

        searchPage.openProduct();

        ProductPage productPage = new ProductPage(driver);

        Assert.assertEquals(productPage.getProductName(), "iPhone");

        productPage.clickWishlistButton();

        Assert.assertTrue(
                productPage.getSuccessMessage().contains("Success"),
                "Wishlist Success Message Not Displayed"
        );

        productPage.openWishlist();

        WishlistPage wishlistPage = new WishlistPage(driver);

        Assert.assertEquals(
                wishlistPage.getWishlistHeading(),
                "My Wish List"
        );

        Assert.assertEquals(
                wishlistPage.getProductName(),
                "iPhone"
        );

        logger.info("Wishlist Test Passed.");
    }
}
