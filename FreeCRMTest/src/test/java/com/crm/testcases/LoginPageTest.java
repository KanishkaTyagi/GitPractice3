package com.crm.testcases;

import org.testng.annotations.Test;

import com.crm.pages.HomePage;
import com.crm.pages.LandingPage;
import com.crm.pages.LoginPage;
import com.crm.testbase.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTest extends TestBase {
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		Initialization();
		landingPage = new LandingPage();
		loginPage = new LoginPage();
		loginPage = landingPage.crmlogin();
	}

	@Test
	public void verifyLoginBtnTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test void verifyLoginPageTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String title = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(title, "CRM");
	}

	@AfterMethod
	public void tearDown() {
		
	}


}
