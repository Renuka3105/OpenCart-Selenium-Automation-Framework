package com.opencart.testcases;

import com.opencart.base.BaseTest;
import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;
import com.opencart.pages.MyAccountPage;
import com.opencart.utilities.DataProviders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginDDTTest extends BaseTest {

    private static final Logger logger =
            LogManager.getLogger(LoginDDTTest.class);

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void verifyLoginDDT(String email,
                               String password,
                               String expected) {

        logger.info("Executing Login DDT");

        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        MyAccountPage myAccountPage = new MyAccountPage(driver);

        boolean actualResult = myAccountPage.isMyAccountPageDisplayed();

        if (expected.equalsIgnoreCase("Pass")) {

            Assert.assertTrue(actualResult);
            logger.info("Valid Login Passed");

            myAccountPage.clickLogout();

        } else {

            Assert.assertFalse(actualResult);
            logger.info("Invalid Login Passed");

        }
    }
}