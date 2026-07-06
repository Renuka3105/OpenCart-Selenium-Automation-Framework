package com.opencart.testcases;

import com.opencart.base.BaseTest;
import com.opencart.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void verifyHomePageTitle() {

        String actualTitle = driver.getTitle();
        String expectedTitle = "Your Store";

        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Home Page Title Verified Successfully");
    }

    @Test(priority = 2)
    public void verifySearchBoxDisplayed() {

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.isSearchBoxDisplayed());

        System.out.println("Search Box is displayed");
    }
}