package com.crm.qa.pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

//	@FindBy(name="username")
//	WebElement username;
//	
//	@FindBy(name="password")
//	WebElement password;
//	
//	@FindBy(xpath="//input[@type='submit']")
//	WebElement loginBtn;
//	
//	@FindBy(xpath="//a [contains(text(),'Sign Up')]")
//	WebElement signUpBtn;
//	
//	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
//	WebElement CRMLogo;
//	
//	
//	//intializing the page objects:
//	public LoginPage() {
//		PageFactory.initElements(driver, this);
//	}
//	
//	
//	//Actions 
//	public  String validateLoginPageTitle() {
//		return driver.getTitle();
//	}
//	
//	
//	public boolean validateCRMImage() {
//		return CRMLogo.isDisplayed();
//	}
//	
//
//	public HomePage login(String un,String pwd) {
//		username.sendKeys(un);
//		password.sendKeys(pwd);
//		loginBtn.click();
//		
//		return new HomePage();
//	}
	
	//img[@class='hidden-on-mobile']
	
	
	
	  @FindBy(name="email")
	    WebElement email;

	    @FindBy(name="password")
	    WebElement password;

	    @FindBy(xpath="//div[text()='Login']")
	    WebElement loginBtn;
	    
		@FindBy(xpath="//img[@class='hidden-on-mobile']")
		WebElement CRMLogo;

	    public LoginPage() {
	        PageFactory.initElements(driver, this);
	    }
	    
	    
		public  String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	
//	public boolean validateCRMImage() {
//		return CRMLogo.isDisplayed();
//	}
	    
	    

	    public HomePage login(String un, String pwd) {

	    	 email.clear();
	    	    email.sendKeys(un);

	    	    password.clear();
	    	    password.sendKeys(pwd);

	    	    loginBtn.click();

	    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    	    // Wait for Home page element
	    	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	    	            By.xpath("//span[contains(text(),'Contacts')]")
	    	    ));

	    	    return new HomePage();
}
}
