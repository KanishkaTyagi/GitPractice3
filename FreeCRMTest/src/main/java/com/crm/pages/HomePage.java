package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.testbase.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),\"Contacts\")]")
	WebElement usernameLabel;

	@FindBy(xpath = "//span[contains(text(),\"Contacts\")]")
	WebElement contactsLink;

	@FindBy(xpath = "//span[contains(text(),\"Deals\")]")
	WebElement dealsLink;

	@FindBy(xpath = "//span[contains(text(),\"Tasks\")]")
	WebElement tasksLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyUsernameLabel() {
		return usernameLabel.isDisplayed();
	}

	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}

}
