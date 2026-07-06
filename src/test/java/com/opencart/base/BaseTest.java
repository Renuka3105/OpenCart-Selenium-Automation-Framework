package com.opencart.base;

import com.opencart.factory.DriverFactory;
import com.opencart.utilities.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    protected WebDriver driver;
    protected ConfigReader config;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {

        logger.info("========== Test Execution Started ==========");

        config = new ConfigReader();

        logger.info("Configuration loaded successfully.");

        driver = DriverFactory.initializeDriver(browser);

        logger.info("Browser launched: {}", browser);

        DriverFactory.getDriver().get(config.getApplicationURL());

        logger.info("Application opened: {}", config.getApplicationURL());
    }

    @AfterMethod
    public void tearDown() {

        logger.info("Closing browser.");

        DriverFactory.quitDriver();

        logger.info("========== Test Execution Finished ==========");
    }
}