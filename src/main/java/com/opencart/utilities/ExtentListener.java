package com.opencart.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.opencart.factory.DriverFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentListener implements ITestListener {

    private static final ExtentReports extent = ExtentManager.getExtentReports();

    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test = extent.createTest(result.getMethod().getMethodName());

        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.get().log(Status.FAIL, "Test Failed");

        extentTest.get().fail(result.getThrowable());

        String screenshotPath =
                ScreenshotUtility.captureScreenshot(
                        DriverFactory.getDriver(),
                        result.getMethod().getMethodName());

        try {

            extentTest.get().addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {

            extentTest.get().log(Status.WARNING,
                    "Unable to attach screenshot.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest.get().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}
