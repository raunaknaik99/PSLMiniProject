package com.team3.miniproject.testcases.registration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.team3.miniproject.sitepages.Header;
import com.team3.miniproject.sitepages.LoginPage;
import com.team3.miniproject.sitepages.RegistrationPage;
import com.team3.miniproject.testcases.ddt.RegistrationData;

import io.github.bonigarcia.wdm.WebDriverManager;
import screenshot.ScreenShotCapture;

public class RegistrationTestSetup {

	RegistrationPage rg_object;
	LoginPage lg_object;
	Header h_object;
	WebDriver driver;
	String baseUrl = "http://localhost/opencartsite/index.php?route=account/register";
	RegistrationData rd = new RegistrationData();
	ScreenShotCapture s;

	// Should Pass
	@Test
	public void testCase001() {
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			rg_object.verifyPageTitle("Register Account");
			rg_object.fillRegistrationForm(myData.get(0).get(0), myData.get(0).get(1), myData.get(0).get(2),
					myData.get(0).get(3), myData.get(0).get(4), myData.get(0).get(5));
			rg_object.clickContinueBtn();
			rg_object.verifyPageTitle("Register Account");
			rg_object.verifyWarningVisibility();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// should Pass
	@Test
	public void testCase002() {
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			rg_object.verifyPageTitle("Register Account");
			rg_object.fillRegistrationForm(myData.get(1).get(0), myData.get(1).get(1), myData.get(1).get(2),
					myData.get(1).get(3), myData.get(1).get(4), myData.get(1).get(5));
			rg_object.clickContinueBtn();
			rg_object.verifyPageTitle("Register Account");
			rg_object.verifyWarningVisibility();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Should Pass
	@Test
	public void testCase003() {
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			rg_object.verifyPageTitle("Register Account");
			rg_object.fillRegistrationForm(myData.get(2).get(0), myData.get(2).get(1), myData.get(2).get(2),
					myData.get(2).get(3), myData.get(2).get(4), myData.get(2).get(5));
			rg_object.clickContinueBtn();
			rg_object.verifyPageTitle("Register Account");
			rg_object.verifyWarningVisibility();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test(enabled=false)
	public void testCase004() {
		rg_object = new RegistrationPage(driver);
		rg_object.verifyPageTitle("Register Account");
		rg_object.fillRegistrationForm("Deeksha", "123", "1.1@example.com", "123", "testing123", "testing123");
		rg_object.clickContinueBtn();
		rg_object.verifyPageTitle("Your Account Has Been Created!");
//		Assert.assertTrue(rg_object.verifyConfirmPasswordWarning());
	}

	// Should Pass
	@Test
	public void testCase005() {
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			rg_object.verifyPageTitle("Register Account");
			rg_object.fillRegistrationForm(myData.get(3).get(0), myData.get(3).get(1), myData.get(3).get(2),
					myData.get(3).get(3), myData.get(3).get(4), myData.get(3).get(5));
			rg_object.checkPrivacyPolicy();
			rg_object.clickContinueBtn();
			WebDriverWait w = new WebDriverWait(driver, 3);
			w.until(ExpectedConditions.titleContains("Your Account Has Been Created!"));
			rg_object.verifyPageTitle("Your Account Has Been Created!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// should Fail
	@Test
	public void testCase008() {
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			rg_object.verifyPageTitle("Register Account");
			rg_object.fillRegistrationForm(myData.get(4).get(0), myData.get(4).get(1), myData.get(4).get(2),
					myData.get(4).get(3), myData.get(4).get(4), myData.get(4).get(5));
			rg_object.checkPrivacyPolicy();
			rg_object.clickContinueBtn();
			WebDriverWait w = new WebDriverWait(driver, 3);
			w.until(ExpectedConditions.titleContains("Your Account Has Been Created!"));
			rg_object.verifyPageTitle("Register Account");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test(enabled = false)
	public void testCase009() {
		rg_object = new RegistrationPage(driver);
		rg_object.clickLoginLink();
		rg_object.verifyPageTitle("Account Login");
	}

	// should pass
	@Test(enabled = true)
	public void testCase006() {
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			rg_object.verifyPageTitle("Register Account");
			rg_object.fillRegistrationForm(myData.get(5).get(0), myData.get(5).get(1), myData.get(5).get(2),
					myData.get(5).get(3), myData.get(5).get(4), myData.get(5).get(5));
			rg_object.checkPrivacyPolicy();
			rg_object.clickContinueBtn();
			rg_object.verifyPageTitle("Register Account");
			Assert.assertEquals(rg_object.verifyConfirmPasswordWarning(),
					"Password confirmation does not match password!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// should pass
	@Test(enabled = true)
	public void testCase007() {
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			rg_object.verifyPageTitle("Register Account");
			rg_object.fillRegistrationForm(myData.get(6).get(0), myData.get(6).get(1), myData.get(6).get(2),
					myData.get(6).get(3), myData.get(6).get(4), myData.get(6).get(5));
			rg_object.checkPrivacyPolicy();
			rg_object.clickContinueBtn();
			rg_object.verifyPageTitle("Register Account");
			rg_object.verifyWarningVisibility();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// should pass
	@Test(enabled = true)
	public void testCase010() {
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			rg_object.verifyPageTitle("Register Account");
			rg_object.fillRegistrationForm(myData.get(7).get(0), myData.get(7).get(1), myData.get(7).get(2),
					myData.get(7).get(3), myData.get(7).get(4), myData.get(7).get(5));
			rg_object.checkPrivacyPolicy();
			rg_object.clickContinueBtn();
			rg_object.verifyPageTitle("Register Account");
			Assert.assertEquals(rg_object.verifyFirstNameWarning(), "First Name must be between 1 and 32 characters!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// should pass
	@Test(enabled = true)
	public void testCase011() {
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			rg_object.verifyPageTitle("Register Account");
			rg_object.fillRegistrationForm(myData.get(8).get(0), myData.get(8).get(1), myData.get(8).get(2),
					myData.get(8).get(3), myData.get(8).get(4), myData.get(8).get(5));
			rg_object.checkPrivacyPolicy();
			rg_object.clickContinueBtn();
			rg_object.verifyPageTitle("Register Account");
			Assert.assertEquals(rg_object.verifyTelephoneWarning(), "Telephone must be between 3 and 32 characters!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// should pass
	@Test(enabled = true)
	public void testCase012() {
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			rg_object.verifyPageTitle("Register Account");
			rg_object.fillRegistrationForm(myData.get(9).get(0), myData.get(9).get(1), myData.get(9).get(2),
					myData.get(9).get(3), myData.get(9).get(4), myData.get(9).get(5));
			rg_object.checkPrivacyPolicy();
			rg_object.clickContinueBtn();
			rg_object.verifyPageTitle("Register Account");
			Assert.assertEquals(rg_object.verifyFirstNameWarning(), "First Name must be between 1 and 32 characters!");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// should pass
	@Test(enabled = true)
	public void testCase013() {
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			rg_object.verifyPageTitle("Register Account");
			rg_object.fillRegistrationForm(myData.get(10).get(0), myData.get(10).get(1), myData.get(10).get(2),
					myData.get(10).get(3), myData.get(10).get(4), myData.get(10).get(5));
			rg_object.checkPrivacyPolicy();
			rg_object.clickContinueBtn();
			rg_object.verifyPageTitle("Register Account");
			Assert.assertEquals(rg_object.verifyLastNameWarning(), "Last Name must be between 1 and 32 characters!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// should pass
	@Test(enabled = true)
	public void testCase014() {
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			rg_object.verifyPageTitle("Register Account");
			rg_object.fillRegistrationForm(myData.get(11).get(0), myData.get(11).get(1), myData.get(11).get(2),
					myData.get(11).get(3), myData.get(11).get(4), myData.get(11).get(5));
			rg_object.checkPrivacyPolicy();
			rg_object.clickContinueBtn();
			rg_object.verifyPageTitle("Register Account");
			Assert.assertEquals(rg_object.verifyTelephoneWarning(), "Telephone must be between 3 and 32 characters!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// should pass
	@Test(enabled = false)
	public void testCase015() {
		rg_object = new RegistrationPage(driver);
		h_object = new Header(driver);
		lg_object = new LoginPage(driver);

		h_object.selectFromMyAccountDropDown(1);
		lg_object.login("demo1@example.com", "testing123");
		driver.get(baseUrl);
		rg_object.verifyPageTitle("My Account");
	}

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) throws IOException {
		if (!testResult.isSuccess()) {
			s = new ScreenShotCapture(driver);
			s.captureScreenshot(testResult.getName() + ".png");
		}
		driver.quit();
	}
}
