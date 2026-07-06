/*package com.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(ProductPage.class);

    // Constructor
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By productName = By.xpath("//div[@id='content']//h1");

    private final By productPrice = By.xpath("//ul[@class='list-unstyled']//h2");

    private final By addToCartButton = By.id("button-cart");

    private final By successMessage =
            By.xpath("//div[contains(@class,'alert-success')]");

    private final By cartTotal =
            By.id("cart-total");

    private final By cartButton = By.id("cart");

    private final By viewCartLink = By.xpath("//strong[normalize-space()='View Cart']/parent::a");

    // Methods

    public String getProductName() {
        logger.info("Getting product name.");
        return waitUtility.waitForElementVisible(productName).getText();
    }

    public String getProductPrice() {
        logger.info("Getting product price.");
        return waitUtility.waitForElementVisible(productPrice).getText();
    }

    public void clickAddToCart() {
        waitUtility.waitForElementClickable(addToCartButton).click();
        logger.info("Clicked Add to Cart button.");
    }

    public String getSuccessMessage() {
        logger.info("Getting Add to Cart success message.");
        return waitUtility.waitForElementVisible(successMessage).getText();
    }

    public String getCartTotal() {
        logger.info("Getting cart total.");
        return waitUtility.waitForElementVisible(cartTotal).getText();
    }

    public void clickShoppingCart() {

        waitUtility.waitForElementClickable(cartButton).click();
        logger.info("Clicked Cart button.");

        waitUtility.waitForElementClickable(viewCartLink).click();
        logger.info("Clicked View Cart.");
    }
}*/


package com.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(ProductPage.class);

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private final By productName =
            By.xpath("//div[@id='content']//h1");

    private final By productPrice =
            By.xpath("//ul[@class='list-unstyled']//h2");

    private final By addToCartButton =
            By.id("button-cart");

    private final By successMessage =
            By.xpath("//div[contains(@class,'alert-success')]");

    private final By wishlistButton =
            By.xpath("//button[@data-original-title='Add to Wish List']");

    private final By wishlistLink =
            By.linkText("wish list");

    public String getProductName() {
        logger.info("Getting Product Name.");
        return waitUtility.waitForElementVisible(productName).getText();
    }

    public String getProductPrice() {
        logger.info("Getting Product Price.");
        return waitUtility.waitForElementVisible(productPrice).getText();
    }

    public void clickAddToCart() {
        waitUtility.waitForElementClickable(addToCartButton).click();
        logger.info("Clicked Add To Cart.");
    }

    public String getSuccessMessage() {
        logger.info("Getting Success Message.");
        return waitUtility.waitForElementVisible(successMessage).getText();
    }

    public void clickWishlistButton() {
        waitUtility.waitForElementClickable(wishlistButton).click();
        logger.info("Clicked Wishlist Button.");
    }

    public void openWishlist() {
        waitUtility.waitForElementClickable(wishlistLink).click();
        logger.info("Opened Wishlist.");
    }
}