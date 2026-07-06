package com.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(MyAccountPage.class);

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By myAccountHeading = By.xpath("//div[@id='content']/h2[1]");
    private final By myAccountMenu = By.xpath("//span[text()='My Account']");
    private final By logoutLink = By.linkText("Logout");

    public boolean isMyAccountPageDisplayed() {

        try {

            return waitUtility
                    .waitForElementVisible(myAccountHeading)
                    .isDisplayed();

        } catch (Exception e) {

            return false;

        }
    }
    public void clickLogout() {
        waitUtility.waitForElementClickable(myAccountMenu).click();
        logger.info("Clicked My Account menu.");

        waitUtility.waitForElementClickable(logoutLink).click();
        logger.info("Clicked Logout.");
    }
}