package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LandingPage;
import com.crm.pages.LoginPage;
import com.crm.testbase.TestBase;
import com.crm.util.Utility;

public class ContactsPageTest extends TestBase {

	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	String sheetName = "Contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		Initialization();
		landingPage = new LandingPage();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		loginPage = landingPage.crmlogin();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}

	@Test(priority = 2)
	public void verifyclickOnNewContactLinkTest() {
		contactsPage.clickOnNewContactLink();
	}

	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = Utility.getTestData(sheetName);
		return data;
	}

	@Test(priority = 3, dataProvider = "getCRMTestData")
	public void verifyCreateNewContactTest(String firstName, String lastName, String company) {
		String fullName = "'" + firstName + " " + lastName + "'";
		contactsPage.clickOnNewContactLink();
		contactsPage.createNewContact(firstName, lastName, company);
		contactsPage = homePage.clickOnContactsLink();
		Assert.assertTrue(contactsPage.verifyContact(fullName));
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
