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

        // -Dbrowser=firefox overrides the XML/default value (only if passed)
        String browserToUse = System.getProperty("browser", browser);

        // -DbaseUrl=https://... overrides the URL from config.properties (only if passed)
        String urlToUse = System.getProperty("baseUrl", config.getApplicationURL());

        driver = DriverFactory.initializeDriver(browserToUse);
        logger.info("Browser launched: {}", browserToUse);

        DriverFactory.getDriver().get(urlToUse);
        logger.info("Application opened: {}", urlToUse);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        logger.info("Closing browser.");

        DriverFactory.quitDriver();

        logger.info("========== Test Execution Finished ==========");
    }
}