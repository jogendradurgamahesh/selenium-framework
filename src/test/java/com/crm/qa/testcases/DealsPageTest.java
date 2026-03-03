package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

@Listeners(com.crm.qa.util.TestListener.class)
public class DealsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	DealsPage dealsPage;
	
	String sheetName="deals";
	
	public DealsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		dealsPage=new DealsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		dealsPage= homePage.clickOnDealsLink();
	}
	
	@Test
	public void verifyDealsLabel() {
	String title=dealsPage.verifyTitle();
	System.out.println("title "+title);
	Assert.assertEquals(title, "Free CRM");
	
		
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException {
	
		Object data[][]=TestUtil.getTestData(sheetName);
	    return data;
		
		
	}
	
	
	@Test(dataProvider ="getCRMTestData")
//	public void validateCreateNewContact() {
	public void validateCreateNewContact(String title,String description) {
		homePage.ClickOnDealsLink();
		dealsPage.createDealForm(title, description);
		
		
	}
	
	
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
