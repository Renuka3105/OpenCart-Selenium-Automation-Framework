package com.opencart.testcases;

import com.opencart.base.BaseTest;
import com.opencart.pages.HomePage;
import com.opencart.pages.RegisterPage;
import com.opencart.utilities.RandomDataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void verifyUserRegistration() {

        HomePage homePage = new HomePage(driver);

        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.register(
                "Renuka",
                "Chowdary",
                RandomDataGenerator.generateRandomEmail(),
                "9876543210",
                "Test@123"
        );

        String actualMessage = registerPage.getSuccessMessage();
        String expectedMessage = "Your Account Has Been Created!";

        Assert.assertEquals(actualMessage, expectedMessage);

        System.out.println("User Registered Successfully");

    }
}