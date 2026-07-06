package com.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(WishlistPage.class);

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By wishlistHeading =
            By.xpath("//div[@id='content']/h2");

    private final By productName =
            By.xpath("//table[contains(@class,'table')]//td[@class='text-left']/a");

    private final By removeButton =
            By.xpath("//a[@data-original-title='Remove']");

    private final By successMessage =
            By.xpath("//div[contains(@class,'alert-success')]");

    private final By emptyWishlistMessage =
            By.xpath("//div[@id='content']//p");

    // Methods

    public String getWishlistHeading() {
        logger.info("Getting Wishlist Heading.");
        return waitUtility.waitForElementVisible(wishlistHeading).getText();
    }

    public String getProductName() {
        logger.info("Getting Product Name.");
        return waitUtility.waitForElementVisible(productName).getText();
    }

    public void clickRemoveButton() {
        waitUtility.waitForElementClickable(removeButton).click();
        logger.info("Clicked Remove Button.");
    }

    public String getSuccessMessage() {
        logger.info("Getting Success Message.");
        return waitUtility.waitForElementVisible(successMessage).getText();
    }

    public String getEmptyWishlistMessage() {
        logger.info("Getting Empty Wishlist Message.");
        return waitUtility.waitForElementVisible(emptyWishlistMessage).getText();
    }

}