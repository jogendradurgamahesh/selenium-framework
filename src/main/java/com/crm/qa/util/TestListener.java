package com.crm.qa.util;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crm.qa.base.TestBase;

public class TestListener extends TestBase implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        String testName = result.getName();
        System.out.println("❌ Test Failed: " + testName);

        if (driver != null) {
            takeScreenshot(testName);
        }
    }

    public void takeScreenshot(String testName) {

        try {
            // Create screenshots folder if not exists
            String folderPath = System.getProperty("user.dir") + "/screenshots";
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // Take screenshot
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String timeStamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            String filePath = folderPath + "/" + testName + "_" + timeStamp + ".png";

            FileUtils.copyFile(src, new File(filePath));

            System.out.println("📸 Screenshot saved at: " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}