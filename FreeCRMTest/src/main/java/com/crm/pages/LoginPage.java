package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.testbase.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name="email")
	WebElement usernameLabel;

	@FindBy(name="password")
	WebElement passwordLabel;

	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement submitBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String un, String pwd) {
		usernameLabel.sendKeys(un);
		passwordLabel.sendKeys(pwd);
		submitBtn.click();
		return new HomePage();
	}

}
