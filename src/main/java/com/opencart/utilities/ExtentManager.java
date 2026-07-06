package com.opencart.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;

    private ExtentManager() {
    }

    public static ExtentReports getExtentReports() {

        if (extent == null) {

            String timeStamp =
                    new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String reportPath =
                    System.getProperty("user.dir")
                            + "/Reports/ExtentReport_"
                            + timeStamp
                            + ".html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config().setReportName("OpenCart Automation Report");
            sparkReporter.config().setDocumentTitle("Automation Execution Report");

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Project", "OpenCart Automation");
            extent.setSystemInfo("Framework", "Selenium + TestNG");
            extent.setSystemInfo("Language", "Java");
            extent.setSystemInfo("Author", "Renuka");

        }

        return extent;
    }
}