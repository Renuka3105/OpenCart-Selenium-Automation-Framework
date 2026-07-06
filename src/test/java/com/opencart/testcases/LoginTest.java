package com.opencart.testcases;

import com.opencart.base.BaseTest;
import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;
import com.opencart.pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyValidLogin() {

        // Home Page
        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginPage();

        // Login Page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                config.getEmail(),
                config.getPassword()
        );

        // My Account Page
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        Assert.assertTrue(
                myAccountPage.isMyAccountPageDisplayed(),
                "Login Failed!"
        );

        System.out.println("Login Successful");

    }
}