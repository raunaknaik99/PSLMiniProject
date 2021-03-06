package com.team3.miniproject.sitepages;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.team3.miniproject.testcases.ddt.ContactUsData;

public class ContactUsPage {
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
	@FindBy(css = "input[value='Submit']")
	WebElement submitBtn;

	// your name field warning (appears if input is not valid)
	@FindBy(css="form.form-horizontal>fieldset>div>div>div")
	WebElement yourNameWarning;

	// E-mail address field warning (appears if input is not valid)
	@FindBy(css="form.form-horizontal>fieldset>div:nth-of-type(2)>div>div")
	WebElement emailWarning;

	// Enquiry field warning (appears if input is not valid)
	@FindBy(css="form.form-horizontal>fieldset>div:nth-of-type(3)>div>div")
	WebElement enquiryWarning;

	public ContactUsPage(WebDriver driver) {
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

	//method to get name warning message
	public String getYourNameWarning() {
		String warningText = yourNameWarning.getText();
		return warningText;
	}

	//method to get email warning message
	public String getEmailWarning() {
		String warningText = emailWarning.getText();
		return warningText;
	}

	//method to get enquiry warning message
	public String getEnquiryWarning() {
		String warningText = enquiryWarning.getText();
		return warningText;
	}
	
/*-------------------------*/
	public void loginForContactUs() throws IOException {
		ContactUsData objContact  = new ContactUsData();
		
		ArrayList<ArrayList<String>> myContactData = objContact.contactUsData();
		
		//link text for My Account dropdown
		  driver.findElement(By.linkText("My Account")).click();
		  
		  //link text for Login
		  driver.findElement(By.linkText("Login")).click();
		  
		  //id of email field of login page
		  driver.findElement(By.id("input-email")).sendKeys(myContactData.get(4).get(1));
		  
		  //id of password field
		  driver.findElement(By.id("input-password")).sendKeys(myContactData.get(4).get(2));
		  
		  //css of login button
		  driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	}
}
