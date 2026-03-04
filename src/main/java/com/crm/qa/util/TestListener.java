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

public class TestListener  implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {

	    String testName = result.getName();
	    System.out.println("❌ Test Failed: " + testName);
	}
//	    try {
//	        if (driver != null &&
//	            ((org.openqa.selenium.remote.RemoteWebDriver) driver).getSessionId() != null) {
//
//	            takeScreenshot(testName);
//
//	        } else {
//	            System.out.println("Driver session already closed. Screenshot skipped.");
//	        }
//
//	    } catch (Exception e) {
//	        System.out.println("Error while capturing screenshot: " + e.getMessage());
//	    }
//
	
	
	
//	public String takeScreenshot(String testName) {
//
//	    String folderPath = System.getProperty("user.dir") + "/screenshots";
//	    File folder = new File(folderPath);
//	    if (!folder.exists()) {
//	        folder.mkdirs();
//	    }
//
//	    String filePath = folderPath + "/" + testName + "_"
//	            + LocalDateTime.now()
//	            .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"))
//	            + ".png";
//
//	    try {
//	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//	        FileUtils.copyFile(src, new File(filePath));
//	        System.out.println("📸 Screenshot saved at: " + filePath);
//	    } catch (Exception e) {
//	        System.out.println("Screenshot failed: " + e.getMessage());
//	    }
//
//	    return filePath;
//	}
	
   
}