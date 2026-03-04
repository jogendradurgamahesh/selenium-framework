


//Author:Mahesh



package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.crm.qa.util.WebEventListener;

public class TestBase {
	
public 	static WebDriver driver;
public	static Properties prop;


	
	public TestBase() {
		
		
		
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\crm"
			         +"\\qa\\config\\config.properties");
//			FileInputStream ip = new FileInputStream(
//				    System.getProperty("user.dir") +
//				    "/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	

	public static  void initialization() {
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			driver=new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
			
		}
		
		
		 WebDriverListener listener = new WebEventListener();

		    EventFiringDecorator<WebDriver> decorator =
		            new EventFiringDecorator<>(listener);

		    driver = decorator.decorate(driver);
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT);
//		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT);
		
		driver.get(prop.getProperty("url"));
		
		
	}
	
	
	public String takeScreenshot(String testName) {

	    String folderPath = System.getProperty("user.dir") + "/screenshots";
	    File folder = new File(folderPath);
	    if (!folder.exists()) {
	        folder.mkdirs();
	    }

	    String filePath = folderPath + "/" + testName + "_"
	            + LocalDateTime.now()
	            .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"))
	            + ".png";

	    try {
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(src, new File(filePath));
	        System.out.println("📸 Screenshot saved at: " + filePath);
	    } catch (Exception e) {
	        System.out.println("Screenshot failed: " + e.getMessage());
	    }

	    return filePath;
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {

	    if (result.getStatus() == ITestResult.FAILURE) {

	        String screenshotPath = takeScreenshot(result.getName());

	        // Store path inside TestNG result object
	        result.setAttribute("screenshotPath", screenshotPath);
	    }

	    if (driver != null) {
	        driver.quit();
	    }
	}
	

}
