package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.testbase.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;

	@FindBy(xpath = "//button[contains(text(),\"New\")]")
	WebElement newContactLink;

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastName;

	@FindBy(xpath = "//input[@class='search']")
	WebElement company;

	@FindBy(xpath = "//button[contains(text(),\"Save\")]")
	WebElement saveBtn;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public void clickOnNewContactLink() {
		newContactLink.click();
	}

	public void createNewContact(String fName, String lName, String comp) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(comp);
		saveBtn.click();
	}

	public boolean verifyContact(String fullName) {
		WebElement Name = driver.findElement(By.xpath("//td[contains(text(),"+fullName+")]"));
		return Name.isDisplayed();
	}

}
