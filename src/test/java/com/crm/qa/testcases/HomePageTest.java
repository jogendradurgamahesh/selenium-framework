package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

//@Listeners(com.crm.qa.util.TestListener.class)
public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	public HomePageTest() {
		super();
	} 
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage(); 
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		System.out.println("Current URL After Login: " + driver.getCurrentUrl());
		 System.out.println("Title After Login: " + driver.getTitle());
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
	String homePageTitle=homePage.verifyHomePageTitle();
	 System.out.println("homePageTitle "+homePageTitle);
		Assert.assertEquals(homePageTitle, "Free CRM");
	
	}
	
	@Test(priority=2)
	public void verfiyHomeLogo() {
		
	 Assert.assertTrue(homePage.verifyLogo());
	}
	
	
	@Test(priority=3)
	public void verifyContactsList() {
	contactsPage=homePage.clickOnContactLinks();
	}
	
	
	@Test(priority=4)
	public void verifyDealsList() {
		dealsPage=homePage.clickOnDealsLink();
	}
	
	@Test(priority=5)
	public void verifyTasksList() {
		tasksPage=homePage.clickOnTasksLink();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
