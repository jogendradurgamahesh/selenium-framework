package com.crm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {
	
	public DealsPage() {
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//*[@class='selectable ']")
	WebElement checkTitle;
	
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(name="description")
	WebElement description;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveBtn;
	
	
	
	
	public String verifyTitle() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		 wait.until(ExpectedConditions.visibilityOf(checkTitle));
		 return driver.getTitle();
		
	}
	
	
	
	public void createDealForm(String t,String d) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		    wait.until(ExpectedConditions.visibilityOf(title));
		title.sendKeys(t);
		description.sendKeys(d);
		saveBtn.click();
	}
	

}
