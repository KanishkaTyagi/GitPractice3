package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.testbase.TestBase;

public class LandingPage extends TestBase {

	//1..Page Factory objects
	//2..actions or methods

	@FindBy(xpath="//a[@title='free crm home']")
	WebElement crmLogo;

	@FindBy(xpath="//a[@class='btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30']")
	WebElement signUpLink;

	@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	WebElement loginLink;

	public LandingPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLandingPageTitle() {
		return driver.getTitle();
	}


	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}

	public LoginPage crmlogin() {
		loginLink.click();
		return new LoginPage();
	}

	public SignUpPage crmSignUp() {
		signUpLink.click();
		return new SignUpPage();
	}

}
