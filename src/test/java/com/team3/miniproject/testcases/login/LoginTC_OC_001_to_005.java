package com.team3.miniproject.testcases.login;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.team3.miniproject.sitepages.LoginPage;
import com.team3.miniproject.testcases.ddt.ReadInputs;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTC_OC_001_to_005 {
	WebDriver driver;
	LoginPage login1;
	ReadInputs reader = new ReadInputs();
	String expectedTitle;
	String actualTitle;

	@Test
	public void testCase001To004() throws IOException {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		reader.readExcel("C:\\Users\\diffa_pinto\\Desktop", "loginDDT.xlsx", "Sheet1");
		for (reader.i = 1; reader.i < reader.rowCount + 1; reader.i++) {
			String emailId = reader.getEmailId();
			String password = reader.getPassword();
			login1.login(emailId, password);
			actualTitle = login1.driver.getTitle();

			// assert Login unsuccessful/unsuccessful
			if (reader.i < reader.rowCount) {
				expectedTitle = "Account Login";
			}
			if (reader.i == reader.rowCount) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				expectedTitle = "My Account";
			}
			Assert.assertEquals(actualTitle, expectedTitle);
		}
	}

	@Test
	public void testCase005() throws IOException {

		login1.login("", "");
		actualTitle = login1.driver.getTitle();
		expectedTitle = "Account Login";
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@Test
	public void testCase006() throws IOException {

		login1.login("demo1@example.com", "testing123");
		driver.get("http://localhost/opencartsite/index.php?route=account/login");
		actualTitle = login1.driver.getTitle();
		expectedTitle = "My Account";
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@Test
	public void testCase007() throws IOException {
		login1.login("demo1@example.com", "testing123");
		driver.navigate().back();
		actualTitle = login1.driver.getTitle();
		expectedTitle = "My Account";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		login1 = new LoginPage(driver);
		login1.navigateToLogin();

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		login1.finish();
	}
}
