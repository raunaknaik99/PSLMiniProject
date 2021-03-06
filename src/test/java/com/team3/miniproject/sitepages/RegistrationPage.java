package com.team3.miniproject.sitepages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	WebDriver driver;

	// first name input field element
	@FindBy(id = "input-firstname")
	WebElement firstNameInput;

	// last name input field element
	@FindBy(id = "input-lastname")
	WebElement lastNameInput;

	// email input field element
	@FindBy(id = "input-email")
	WebElement emailInput;

	// telephone input field element
	@FindBy(id = "input-telephone")
	WebElement telephoneInput;

	// password input field element
	@FindBy(id = "input-password")
	WebElement passwordInput;

	// confirm password input field element
	@FindBy(id = "input-confirm")
	WebElement confirmPasswordInput;

	// privacy checkbox element
	@FindBy(name = "agree")
	WebElement privacyCheckbox;

	// continue button element
	@FindBy(css = "input[value='Continue']")
	WebElement continueBtn;

	// warning div element
	@FindBy(css = "div[class='alert alert-danger alert-dismissible']")
	public WebElement warningDiv;
	
	// confirm password warning(when number of characters for password is not sufficient)
	@FindBy(css = "#content > form > fieldset:nth-child(2) > div.form-group.required.has-error > div > div")
	WebElement passWarning;
	
	// confirm password warning(when confirm password is not same as password)
	@FindBy(css = "form.form-horizontal>fieldset:nth-of-type(2)>div:nth-of-type(2)>div>div")
	WebElement confirmPasswordWarning;

	// first name warning (appears when invalid input in first name field)
	@FindBy(css = "fieldset#account>div:nth-of-type(2)>div>div")
	WebElement fNameWarning;

	// first name warning (appears when invalid input in last name field)
	@FindBy(css = "fieldset#account>div:nth-of-type(3)>div>div")
	WebElement lNameWarning;

	// first name warning (appears when invalid input in telephone field)
	@FindBy(css = "fieldset#account>div:nth-of-type(5)>div>div")
	WebElement telephoneWarning;

	@FindBy(linkText = "login page")
	WebElement loginLink;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// method to fill registration form
	public void fillRegistrationForm(String fname, String lname, String email, String tel, String pwrd,
			String conpwrd) {
		firstNameInput.sendKeys(fname);
		lastNameInput.sendKeys(lname);
		emailInput.sendKeys(email);
		telephoneInput.sendKeys(tel);
		passwordInput.sendKeys(pwrd);
		confirmPasswordInput.sendKeys(conpwrd);
	}

	// method to check the privacy policy
	public void checkPrivacyPolicy() {
		privacyCheckbox.click();
	}

	// method to click continue button
	public void clickContinueBtn() {
		continueBtn.click();
	}

	// method to return page title
	public String getPageTitle() {
		return driver.getTitle();
	}

	// method to click login link
	public void clickLoginLink() {
		loginLink.click();
	}

	// method verify warning visibility
	public Boolean verifyWarningVisibility() {
		return warningDiv.isDisplayed();
		
		// Assert.assertTrue(warningDiv.isDisplayed());
	}

	// method to verify confirm password warning visibility
	public Boolean verifyConfirmPasswordWarning() {
		return confirmPasswordWarning.isDisplayed();
	}

	// method to verify first name warning visibility
	public Boolean verifyFirstNameWarning() {
		return fNameWarning.isDisplayed();
	}

	// method to return last name warning visibility
	public Boolean verifyLastNameWarning() {
		return lNameWarning.isDisplayed();
	}

	// method to return telephone warning visibility
	public Boolean verifyTelephoneWarning() {
		return telephoneWarning.isDisplayed();
	}
	public Boolean verifyPassWarning() {
		return passWarning.isDisplayed();
	}
}
