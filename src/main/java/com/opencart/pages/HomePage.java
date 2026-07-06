package com.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By myAccount = By.xpath("//span[text()='My Account']");
    private final By loginLink = By.linkText("Login");
    private final By registerLink = By.linkText("Register");
    private final By searchBox = By.name("search");
    private final By searchButton = By.xpath("//button[contains(@class,'btn-default')]");

    public void clickMyAccount() {
        waitUtility.waitForElementClickable(myAccount).click();
        logger.info("Clicked on My Account.");
    }

    public void clickLogin() {
        waitUtility.waitForElementClickable(loginLink).click();
        logger.info("Clicked on Login.");
    }

    public void clickRegister() {
        waitUtility.waitForElementClickable(registerLink).click();
        logger.info("Clicked on Register.");
    }

    public boolean isSearchBoxDisplayed() {
        logger.info("Verified Search Box is displayed.");
        return waitUtility.waitForElementVisible(searchBox).isDisplayed();
    }

    public void enterProductName(String productName) {
        waitUtility.waitForElementVisible(searchBox).clear();
        waitUtility.waitForElementVisible(searchBox).sendKeys(productName);
        logger.info("Entered product name: {}", productName);
    }

    public void clickSearch() {
        waitUtility.waitForElementClickable(searchButton).click();
        logger.info("Clicked Search button.");
    }

    public void navigateToRegisterPage() {
        clickMyAccount();
        clickRegister();
    }

    public void navigateToLoginPage() {
        clickMyAccount();
        clickLogin();
    }
}