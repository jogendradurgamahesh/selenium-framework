package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

//@Listeners(com.crm.qa.util.TestListener.class)
public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	String sheetName="contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage= homePage.clickOnContactLinks();
	}
	
	@Test(priority=1)
	public void verifyContactPageLabel() {
	Assert.assertTrue(contactsPage.verifyContactLabel(),"Missing label");
	}
	
	@Test(priority=2)
	public void selectSingleCheckBox() {
		contactsPage.selectContacts("mahesh uggina");
	}
	
	
	@Test(priority=3)
	public void selectMultipleContactsTest() {
	    contactsPage.selectContacts("mahesh uggina");
	    contactsPage.selectContacts("jogi uggina");
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException {
	
		Object data[][]=TestUtil.getTestData(sheetName);
	    return data;
		
		
	}
	
	@Test(priority = 4,dataProvider = "getCRMTestData")
//	public void validateCreateNewContact() {
	public void validateCreateNewContact(String firstname,String lastname,String email) {
		homePage.clickOnNewContactsLink();
		//contactsPage.createNewContact("Prince", "Mahi", "prince@gmail.com");
		contactsPage.createNewContact(firstname, lastname, email);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
