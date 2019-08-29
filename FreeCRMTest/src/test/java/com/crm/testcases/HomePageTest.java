package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.pages.HomePage;
import com.crm.pages.LandingPage;
import com.crm.pages.LoginPage;
import com.crm.testbase.TestBase;

public class HomePageTest extends TestBase{

	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;

	public HomePageTest() {
		super();
	}


	@BeforeMethod
	public void setUp() {
		Initialization();
		landingPage = new LandingPage();
		loginPage = new LoginPage();
		homePage = new HomePage();

		landingPage.crmlogin();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void verifyUsernameLabelOnHomePageTest() {
		Assert.assertTrue(homePage.verifyUsernameLabel());
	}

	@Test
	public void verifyclickOnContactsLinkTest() {
		homePage.clickOnContactsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
