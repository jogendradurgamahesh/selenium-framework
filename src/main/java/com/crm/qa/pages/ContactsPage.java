package com.crm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	
//	   @FindBy(xpath="//*[contains(text(),'First Name')]")
//	    WebElement firstName;
//	   
//	   @FindBy(xpath="//*[contains(text(),'Last Name')]")
//	   WebElement lastName;
//	   
//	
//	   
//	   @FindBy(xpath=" //*[normalize-space()='Email']")
//	   WebElement email;
//	   
//	
//	   
//	   @FindBy(xpath=" //button[normalize-space()='Save']")
//	   WebElement saveBtn;
	
	
	
	
	@FindBy(xpath="//th[normalize-space()='Address']")
	WebElement contactLabel;
	
	@FindBy(xpath="")
	WebElement checkBox;
	
	
	@FindBy(name="first_name")
	WebElement firstName;

	@FindBy(name="last_name")
	WebElement lastName;

	@FindBy(name="value")
	WebElement email;

	@FindBy(xpath="//button[text()='Save']")
	WebElement saveBtn;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public boolean verifyContactLabel() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		    wait.until(ExpectedConditions.visibilityOf(contactLabel));
		
		return contactLabel.isDisplayed();
	}


	
	
	public void selectContacts(String name) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    String xpath =
	            "//a[normalize-space()='" + name + "']" +
	            "/ancestor::tr//div[contains(@class,'checkbox')]";

	    WebElement checkbox =
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
	}
	
	
	
	 public void createNewContact(String fn, String ln, String mail) {
	       
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		    wait.until(ExpectedConditions.visibilityOf(firstName));
	        firstName.sendKeys(fn);
	        lastName.sendKeys(ln);
	        email.sendKeys(mail);
	        saveBtn.click();
	    }
	
}
