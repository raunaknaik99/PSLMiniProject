package com.team3.miniproject.sitepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs {

	WebDriver driver;

	// name field element
	@FindBy(id = "input-name")
	WebElement nameField;

	// email field element
	@FindBy(id = "input-email")
	WebElement emailField;

	// enquiry field element
	@FindBy(id = "input-enquiry")
	WebElement enquiryField;

	// submit button element
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitBtn;

	// your name field warning (appears if input is not valid)
	@FindBy(xpath = "//*[@id='content']/form/fieldset/div[1]/div/div")
	WebElement yourNameWarning;

	// E-mail address field warning (appears if input is not valid)
	@FindBy(xpath = "//*[@id='content']/form/fieldset/div[2]/div/div")
	WebElement emailWarning;

	// Enquiry field warning (appears if input is not valid)
	@FindBy(xpath = "//*[@id='content']/form/fieldset/div[3]/div/div")
	WebElement enquiryWarning;

	public ContactUs(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// method to enter name
	public void enterName(String name) {
		nameField.sendKeys(name);
	}

	// method to enter email
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}

	// method to enter enquiry
	public void enterEnquiry(String enquiry) {
		enquiryField.sendKeys(enquiry);
	}

	// method to click submit
	public void clickSubmit() {
		submitBtn.click();
	}

	// method to get page title
	public String getPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	public String getYourNameWarning() {
		String warningText = yourNameWarning.getText();
		return warningText;
	}

	public String getEmailWarning() {
		String warningText = emailWarning.getText();
		return warningText;
	}

	public String getEnquiryWarning() {
		String warningText = enquiryWarning.getText();
		return warningText;
	}

}
