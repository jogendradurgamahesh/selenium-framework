package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.crm.qa.util.WebEventListener;

import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

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
	

}
