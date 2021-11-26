package com.team3.miniproject.sitepages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;


	String baseUrl = "http://localhost/miniproject";
	String expectedTitle = "Account Login";

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#top-links > ul > li.dropdown > a")
	WebElement myAccountIcon;
	@FindBy(linkText = "Login")
	WebElement chooseLogin;
	@FindBy(id = "input-email")
	WebElement usernameField;
	@FindBy(id = "input-password")
	WebElement passwordField;
	@FindBy(css = "input[value='Login']")
	WebElement loginButton;
	@FindBy(linkText = "Logout")
	WebElement chooseLogout;
	@FindBy(linkText = "Forgotten Password")
	WebElement forgotPass;
	@FindBy(css = "input[value='Continue']")
	WebElement continueBtn;
	@FindBy(css = "#content > form > div > div.pull-right > input")
	WebElement fpContinueBtn;

	public void navigateToLogin() {

		driver.get(baseUrl);
		String actualTitle = driver.getTitle();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (actualTitle == expectedTitle) {
			System.out.println("Page Title matched");
		}
		driver.manage().window().maximize();
		myAccountIcon.click();
		chooseLogin.click();

	}

	public void login(String user_name, String password) {
		usernameField.clear();
		usernameField.sendKeys(user_name);
		passwordField.clear();
		passwordField.sendKeys(password);
		loginButton.click();

	}

	public void logout() {
		myAccountIcon.click();
		chooseLogout.click();
	}

	public void forgotPassword() {
		forgotPass.click();
	}

	public void enterEmail(String user_name) {
		usernameField.sendKeys(user_name);
		continueBtn.click();
	}
	
	public void fillForgotPass(String user_name) {
		usernameField.sendKeys(user_name);
		fpContinueBtn.click();
	}
	public String getEmailPlaceholder() {
		return(usernameField.getAttribute("placeholder"));
		
	}
	public String getPasswordPlaceholder() {
		return(passwordField.getAttribute("placeholder"));
		
	}

	public void finish() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

	public static void main(String[] args) {

	}

}
