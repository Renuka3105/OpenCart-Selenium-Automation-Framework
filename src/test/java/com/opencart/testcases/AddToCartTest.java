/*package com.opencart.testcases;

import com.opencart.base.BaseTest;
import com.opencart.pages.HomePage;
import com.opencart.pages.ProductPage;
import com.opencart.pages.SearchPage;
import com.opencart.pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void verifyAddToCart() throws InterruptedException {

        // Home Page
        HomePage homePage = new HomePage(driver);

        homePage.enterProductName("iPhone");
        homePage.clickSearch();

        // Search Results
        SearchPage searchPage = new SearchPage(driver);

        Assert.assertTrue(
                searchPage.isProductDisplayed(),
                "Product not found in search results."
        );

        searchPage.openProduct();

        // Product Page
        ProductPage productPage = new ProductPage(driver);

        Assert.assertEquals(
                productPage.getProductName(),
                "iPhone",
                "Incorrect product page opened."
        );

        productPage.clickAddToCart();

// Debug
        String successMessage = productPage.getSuccessMessage();

        System.out.println("SUCCESS MESSAGE: " + successMessage);
        System.out.println("CURRENT URL: " + driver.getCurrentUrl());

// Pause for 10 seconds so you can inspect the browser
        Thread.sleep(10000);

        productPage.clickShoppingCart();

        productPage.clickShoppingCart();

        // Shopping Cart Page
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        Assert.assertTrue(
                shoppingCartPage.getCartHeading().contains("Shopping Cart"),
                "Shopping Cart page not opened."
        );

        Assert.assertEquals(
                shoppingCartPage.getProductName(),
                "iPhone",
                "Incorrect product present in cart."
        );

        System.out.println("Add To Cart Test Passed");
    }
}*/

package com.opencart.testcases;

import com.opencart.base.BaseTest;
import com.opencart.pages.HomePage;
import com.opencart.pages.ProductPage;
import com.opencart.pages.SearchPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(AddToCartTest.class);

    @Test
    public void verifyAddToCart() {

        HomePage homePage = new HomePage(driver);

        homePage.enterProductName("iPhone");
        homePage.clickSearch();

        SearchPage searchPage = new SearchPage(driver);

        Assert.assertTrue(
                searchPage.isProductDisplayed(),
                "Product is not displayed in search results."
        );

        searchPage.openProduct();

        ProductPage productPage = new ProductPage(driver);

        Assert.assertEquals(
                productPage.getProductName(),
                "iPhone",
                "Incorrect product page."
        );

        productPage.clickAddToCart();

        String successMessage = productPage.getSuccessMessage();

        Assert.assertTrue(
                successMessage.contains("Success: You have added iPhone to your shopping cart!"),
                "Product was not added successfully."
        );

        logger.info("Add To Cart Test Passed");
    }
}