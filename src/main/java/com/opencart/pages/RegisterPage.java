package com.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(RegisterPage.class);

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By firstName = By.id("input-firstname");
    private final By lastName = By.id("input-lastname");
    private final By email = By.id("input-email");
    private final By telephone = By.id("input-telephone");
    private final By password = By.id("input-password");
    private final By confirmPassword = By.id("input-confirm");
    private final By privacyPolicy = By.name("agree");
    private final By continueButton = By.xpath("//input[@value='Continue']");
    private final By successMessage = By.xpath("//div[@id='content']/h1");

    public void register(String fName,
                         String lName,
                         String emailId,
                         String phone,
                         String pwd) {

        waitUtility.waitForElementVisible(firstName).clear();
        waitUtility.waitForElementVisible(firstName).sendKeys(fName);

        waitUtility.waitForElementVisible(lastName).clear();
        waitUtility.waitForElementVisible(lastName).sendKeys(lName);

        waitUtility.waitForElementVisible(email).clear();
        waitUtility.waitForElementVisible(email).sendKeys(emailId);

        waitUtility.waitForElementVisible(telephone).clear();
        waitUtility.waitForElementVisible(telephone).sendKeys(phone);

        waitUtility.waitForElementVisible(password).clear();
        waitUtility.waitForElementVisible(password).sendKeys(pwd);

        waitUtility.waitForElementVisible(confirmPassword).clear();
        waitUtility.waitForElementVisible(confirmPassword).sendKeys(pwd);

        logger.info("Entered registration details.");

        waitUtility.waitForElementClickable(privacyPolicy).click();
        logger.info("Accepted Privacy Policy.");

        waitUtility.waitForElementClickable(continueButton).click();
        logger.info("Clicked Continue button.");
    }

    public String getSuccessMessage() {
        logger.info("Retrieved registration success message.");
        return waitUtility.waitForElementVisible(successMessage).getText();
    }
}