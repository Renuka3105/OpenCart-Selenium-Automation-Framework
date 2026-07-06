package com.opencart.utilities;

import com.opencart.factory.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestFailure(ITestResult result) {

        logger.error("Test Failed: {}", result.getName());

        String path = ScreenshotUtility.captureScreenshot(
                DriverFactory.getDriver(),
                result.getName());

        logger.error("Screenshot captured at: {}", path);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        logger.info("Test Passed: {}", result.getName());

    }
}