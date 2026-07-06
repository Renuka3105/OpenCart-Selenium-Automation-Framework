package com.opencart.pages;

import com.opencart.utilities.WaitUtility;
import org.openqa.selenium.WebDriver;


public class BasePage {

    protected WebDriver driver;
    protected WaitUtility waitUtility;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtility = new WaitUtility(driver);
    }
}