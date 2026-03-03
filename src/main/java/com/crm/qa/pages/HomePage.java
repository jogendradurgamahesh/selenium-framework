package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
//	//  //*[contains(text(),'System messages')]
//	
//	//     "//img[@class='hidden-on-mobile']"
//	
//	//span[@class='ui header']
//
////	@FindBy(xpath="//*[contains(text(),'System messages')]")
	
	
	@FindBy(xpath="//span[text()='System messages']")
	//@CacheLookup:to get data directly without loading the whole page
	WebElement homeLogo;
	
	//*[@class='item-text' and contains(text(),'Contacts')]
	
	@FindBy(xpath="//*[@class='item-text' and contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//div[@id='main-nav']//div[3]//button[1]//i[1]")
	WebElement contactCreateLink;
	
	@FindBy(xpath="//*[@class='item-text' and contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//div[5]//button[1]//i[1]")
	WebElement CreateDealsLink;
	
	
	
	@FindBy(xpath="//*[@class='item-text' and contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	
	
	//initializing page objects
	public HomePage() {

		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public String verifyHomePageTitle() {
	 return	driver.getTitle();
	}


	public boolean verifyLogo() {
	 return	homeLogo.isDisplayed();
	 
	}
	
	
	public ContactsPage clickOnContactLinks() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	
   
	//in homepage contact page iss there so we are writing in homepage to click/move to contacts page
	public void clickOnNewContactsLink() {
		Actions actions=new Actions(driver);
		actions.moveToElement(contactsLink).build().perform();
		contactCreateLink.click();
	}
	
	
	public void ClickOnDealsLink() {
		Actions actions=new Actions(driver);
		actions.moveToElement(dealsLink).build().perform();
		CreateDealsLink.click();
	}
	
}
