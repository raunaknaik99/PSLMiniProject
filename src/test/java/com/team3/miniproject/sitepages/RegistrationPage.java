package com.team3.miniproject.sitepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	@FindBy(xpath = "//input[@name='agree']")
	WebElement privacyCheckbox;

	// continue button element
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueBtn;

	// warning div element
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement warningDiv;

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

	// method to verify page title
	public void verifyPageTitle(String title) {
		try {
			String registerPageTitle = driver.getTitle();
			Assert.assertEquals(title, registerPageTitle);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// method to click login link
	public void clickLoginLink() {
		try {
			WebElement loginLink = driver.findElement(By.linkText("login page"));
			loginLink.click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// method verify warning visibility
	public void verifyWarningVisibility() {
		Assert.assertTrue(warningDiv.isDisplayed());
	}

	// method to verify warning visibility
	public boolean verifyConfirmPasswordWarning() {
		WebElement warningDiv = driver.findElement(By.xpath("//*[@id='content']/form/fieldset[2]/div[2]/div/div"));
		return warningDiv.isDisplayed();
	}

	// method to verify warning visibility
	public boolean verifyFirstNameWarning() {
		WebElement warningDiv = driver.findElement(By.xpath("//*[@id='account']/div[2]/div/div"));
		return warningDiv.isDisplayed();
	}

	// method to verify warning visibility
	public boolean verifyLastNameWarning() {
		WebElement warningDiv = driver.findElement(By.xpath("//*[@id='account']/div[3]/div/div"));
		return warningDiv.isDisplayed();
	}

	// method to verify warning visibility
	public boolean verifyTelephoneWarning() {
		WebElement warningDiv = driver.findElement(By.xpath("//*[@id='account']/div[5]/div/div"));
		return warningDiv.isDisplayed();
	}
}
