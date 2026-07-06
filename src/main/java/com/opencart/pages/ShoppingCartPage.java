package com.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(ShoppingCartPage.class);

    // Constructor
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By cartHeading =
            By.xpath("//div[@id='content']/h1");

    private final By productName = By.xpath("//a[normalize-space()='iPhone']");

    private final By removeButton =
            By.xpath("//button[@data-original-title='Remove']");

    private final By emptyCartMessage =
            By.xpath("//div[@id='content']/p");

    // Methods

    public String getCartHeading() {
        logger.info("Getting Shopping Cart heading.");
        return waitUtility.waitForElementVisible(cartHeading).getText();
    }

    public String getProductName() {
        return waitUtility
                .waitForElementVisible(By.xpath("//table//a"))
                .getText();
    }

    public void removeProduct() {
        waitUtility.waitForElementClickable(removeButton).click();
        logger.info("Removed product from Shopping Cart.");
    }

    public String getEmptyCartMessage() {
        logger.info("Getting empty cart message.");
        return waitUtility.waitForElementVisible(emptyCartMessage).getText();
    }
}
