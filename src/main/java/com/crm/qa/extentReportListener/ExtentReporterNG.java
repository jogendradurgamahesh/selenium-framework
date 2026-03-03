package com.crm.qa.extentReportListener;

//public class ExtentReporterNG {
//
//}



import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.crm.qa.base.TestBase;

public class ExtentReporterNG extends TestBase implements ITestListener {

    private static ExtentReports extent;
    private static ExtentTest test;

    static {
        ExtentSparkReporter spark =
                new ExtentSparkReporter(System.getProperty("user.dir")
                        + "/ExtentReport.html");

        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        String screenshotPath = takeScreenshot(result.getMethod().getMethodName());

        test.addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    public String takeScreenshot(String testName) {

        String folderPath = System.getProperty("user.dir") + "/screenshots";
        File folder = new File(folderPath);
        if (!folder.exists()) folder.mkdirs();

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timeStamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String filePath = folderPath + "/" + testName + "_" + timeStamp + ".png";

        try {
            FileUtils.copyFile(src, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePath;
    }
}
