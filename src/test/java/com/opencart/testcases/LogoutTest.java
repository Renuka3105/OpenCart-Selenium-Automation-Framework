package com.opencart.testcases;

import com.opencart.base.BaseTest;
import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;
import com.opencart.pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void verifyLogout() {

        // Navigate to Login Page
        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginPage();

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                config.getEmail(),
                config.getPassword()
        );

        // Create MyAccountPage object
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        // Debug Information
        System.out.println("Current URL : " + driver.getCurrentUrl());
        System.out.println("Current Title : " + driver.getTitle());

        // Verify login succeeded
        Assert.assertTrue(
                myAccountPage.isMyAccountPageDisplayed(),
                "Login failed. My Account page not displayed."
        );

        // Logout
        myAccountPage.clickLogout();

        // Verify Logout Page
        String actualTitle = driver.getTitle();
        String expectedTitle = "Account Logout";

        System.out.println("Title After Logout : " + actualTitle);

        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Logout Successful");
    }
}