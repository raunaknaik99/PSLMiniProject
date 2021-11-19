package com.team3.miniproject.sitepages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	String baseUrl = "http://localhost/opencartsite";
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

	public void navigateToLogin() {

		driver.get(baseUrl);
		String actualTitle = driver.getTitle();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (actualTitle == expectedTitle) {
			System.out.println("Page Title matched");
		}
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\'top-links\']/ul/li[2]/ul/li[2]/a")).click();

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

	public void finish() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

	public static void main(String[] args) {

	}

}
