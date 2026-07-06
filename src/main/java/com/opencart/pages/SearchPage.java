package com.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(SearchPage.class);

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By validProduct = By.linkText("iPhone");
    private final By productLink = By.linkText("iPhone");

    private final By noProductMessage =
            By.xpath("//div[@id='content']/p[contains(text(),'There is no product')]");

    public boolean isProductDisplayed() {
        logger.info("Verified searched product is displayed.");
        return waitUtility.waitForElementVisible(validProduct).isDisplayed();
    }

    public String getNoProductMessage() {
        logger.info("Retrieved no product found message.");
        return waitUtility.waitForElementVisible(noProductMessage).getText();
    }

    public void openProduct() {
        waitUtility.waitForElementClickable(productLink).click();
        logger.info("Opened product details page.");
    }
}