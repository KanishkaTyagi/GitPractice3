package com.crm.testcases;

import org.testng.annotations.Test;

import com.crm.pages.LandingPage;
import com.crm.pages.LoginPage;
import com.crm.pages.SignUpPage;
import com.crm.testbase.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LandingPageTest extends TestBase {

	LandingPage landingPage;
	LoginPage loginPage;
	SignUpPage signupPage;

	public LandingPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		Initialization();
		landingPage = new LandingPage();

	}
	@Test(priority = 1)
	public void validateLandingPageTest() {
		String title = landingPage.validateLandingPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the Cloud FreeCRM","Title not matching..!!");
		System.out.println("First Test case execution completed");
	}

	@Test(priority = 2)
	public void validateCRMLogoTest() {
		boolean flag = landingPage.validateCRMLogo();
		assertTrue(flag);
		System.out.println("Second Test case execution completed");
	}

	@Test(priority = 3)
	public void validateclickOnLogIn() {
		landingPage.crmlogin();
		System.out.println("Navigated to Login page successfully");

	}

	@Test(priority = 4, dependsOnMethods = {"validateclickOnLogIn"})
	public void validateclickOnSignUp() {
		landingPage.crmSignUp();
		System.out.println("Navigated to Sign Up page successfully");


	}
	
	@Parameters({ "test1" })
	@Test
	public void testParameter(String test1) {
		System.out.println("The value of Test1 is -->> "+test1);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
