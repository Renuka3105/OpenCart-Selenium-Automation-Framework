package com.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By email = By.id("input-email");
    private final By password = By.id("input-password");
    private final By loginButton = By.xpath("//input[@value='Login']");
    private final By warningMessage = By.xpath("//div[contains(@class,'alert-danger')]");

    public void enterEmail(String emailAddress) {
        waitUtility.waitForElementVisible(email).clear();
        waitUtility.waitForElementVisible(email).sendKeys(emailAddress);
        logger.info("Entered email address.");
    }

    public void enterPassword(String pwd) {
        waitUtility.waitForElementVisible(password).clear();
        waitUtility.waitForElementVisible(password).sendKeys(pwd);
        logger.info("Entered password.");
    }

    public void clickLoginButton() {
        waitUtility.waitForElementClickable(loginButton).click();
        logger.info("Clicked Login button.");
    }

    public void login(String emailAddress, String pwd) {
        enterEmail(emailAddress);
        enterPassword(pwd);
        clickLoginButton();
    }

    public String getWarningMessage() {
        logger.info("Retrieved invalid login warning message.");
        return waitUtility.waitForElementVisible(warningMessage).getText();
    }
}