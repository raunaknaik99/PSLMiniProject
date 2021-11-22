package com.team3.miniproject.testcases.login;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.team3.miniproject.base.BrowserSetup;
import com.team3.miniproject.sitepages.LoginPage;
import com.team3.miniproject.testcases.ddt.ReadInputs;

import screenshot.ScreenShotCapture;

public class LogoutAndFpTest extends BrowserSetup {
//	WebDriver driver;
	LoginPage login1;
	ReadInputs reader = new ReadInputs();
	String timeStamp = new SimpleDateFormat("yyyy_MMM_dd_HH.mm.ss").format(new Date());
	ExtentReports report;
	ExtentTest test;
	ScreenShotCapture s;

	@Test
	public void verifyTestCase001() throws IOException {
		try {
			test.log(LogStatus.INFO, "TC_OC_FP_001 - using forgotten password with invalid email id");
			s = new ScreenShotCapture(driver);

			login1.navigateToLogin();
			login1.forgotPassword();

			reader.i = 10;
			String emailId = reader.getEmailId();
			login1.fillForgotPass(emailId);

			String actualTitle = login1.driver.getTitle();
			String expectedTitle = "Forgot Your Password?";
			if (actualTitle.equals(expectedTitle))
				test.log(LogStatus.PASS,
						"Test Passed - User entered incorrect email Id and the confirmation email was not sent.");
			else
				test.log(LogStatus.FAIL, test
						.addScreenCapture(s.captureScreenshot("\\LogoutAndFp\\verifyTestCase001_" + timeStamp + ".PNG"))
						+ "Test Failed - The user entered an incorrect email Id, yet the confirmation email was sent.");
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}

	}

	@Test
	public void verifyTestCase002() throws InterruptedException, IOException {
		try {
			test.log(LogStatus.INFO, "TC_OC_FP_002 - using forgotten password with valid email id");
			s = new ScreenShotCapture(driver);

			login1.navigateToLogin();
			login1.forgotPassword();

			reader.i = 11;
			String emailId = reader.getEmailId();
			login1.fillForgotPass(emailId);

			String actualTitle = login1.driver.getTitle();
			String expectedTitle = "Account Login";
			if (actualTitle.equals(expectedTitle))
				test.log(LogStatus.PASS,
						"Test Passed - User entered correct email Id and an email with confirmation link has been sent.");
			else
				test.log(LogStatus.FAIL, test
						.addScreenCapture(s.captureScreenshot("\\LogoutAndFp\\verifyTestCase002_" + timeStamp + ".PNG"))
						+ "Test Failed - User entered correct email Id, yet the confirmation email was not sent");
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	@Test
	public void logoutTestCase001() throws InterruptedException, IOException {
		try {
			test.log(LogStatus.INFO,
					"TC_OC_LO_001 - To Verify that user does not get logged back in automatically on clicking continue after logging out.");
			s = new ScreenShotCapture(driver);

			login1.navigateToLogin();
			reader.i = 11;
			String emailId = reader.getEmailId();
			String password = reader.getPassword();
			login1.login(emailId, password);

			login1.logout();
			String actualTitle = login1.driver.getTitle();
			String expectedTitle = "Account Logout";
			if (actualTitle.equals(expectedTitle))
				test.log(LogStatus.PASS, "Test Passed - Account is logged out successfully.");
			else
				test.log(LogStatus.FAIL,
						test.addScreenCapture(
								s.captureScreenshot("\\LogoutAndFp\\logoutTestCase001_" + timeStamp + ".PNG"))
								+ "Test Failed - Account is not logged out.");
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(Method m, String browser) throws IOException {
		test = report.startTest(m.getName());
		reader.readExcel("src\\test\\resources", "loginDDT.xlsx", "Login");
		initialize(browser);
		login1 = new LoginPage(driver);
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		report.endTest(test);
		report.flush();
		driver.quit();
	}

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		report = new ExtentReports(
				"ExtentReports\\LogoutAndFp\\LogoutAndFpTests_" + browser + "_" + timeStamp + ".html");
	}
}
