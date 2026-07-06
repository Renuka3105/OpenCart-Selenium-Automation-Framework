package com.opencart.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtility {

    private ScreenshotUtility() {
    }

    public static String captureScreenshot(WebDriver driver, String testName) {

        String timeStamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String destination =
                System.getProperty("user.dir")
                        + "/Screenshots/"
                        + testName
                        + "_"
                        + timeStamp
                        + ".png";

        File source = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        try {

            FileUtils.copyFile(source, new File(destination));

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

        return destination;
    }
}