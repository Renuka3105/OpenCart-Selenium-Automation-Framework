package com.opencart.testcases;

import com.opencart.base.BaseTest;
import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void verifyInvalidLogin() {

        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "invaliduser@gmail.com",
                "Invalid@123"
        );

        String warning = loginPage.getWarningMessage();

        Assert.assertTrue(
                warning.contains("Warning"),
                "Warning message not displayed."
        );

        System.out.println("Invalid Login Verified Successfully");
    }
}