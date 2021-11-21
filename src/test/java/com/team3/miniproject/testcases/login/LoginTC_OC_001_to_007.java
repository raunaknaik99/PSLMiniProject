package com.team3.miniproject.testcases.login;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.team3.miniproject.sitepages.LoginPage;
import com.team3.miniproject.testcases.ddt.ReadInputs;

import io.github.bonigarcia.wdm.WebDriverManager;
import screenshot.ScreenShotCapture;

public class LoginTC_OC_001_to_007 {
	WebDriver driver;
	LoginPage login1;
	ReadInputs reader = new ReadInputs();
	String expectedTitle;
	String actualTitle;
	ExtentReports report;
	ExtentTest test;
	String timeStamp;
	ScreenShotCapture s;

	@Test
	// TC_OC_LR_001 TO TC_OC_LR_005 - To test all the possible scenarios for Login with email-id and password
	public void testCase001To005() throws IOException, InterruptedException {
		test.log(LogStatus.INFO,"TC_OC_LR_001 to TC_OC_LR_005 - to test all the possible scenarios for Login with email-id and password");
		s = new ScreenShotCapture(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Reading emailId and password from excel sheet containing data
		reader.readExcel("src\\test\\resources", "loginDDT.xlsx", "Login");
		for (reader.i = 1; reader.i < 6; reader.i++) {
			String emailId = reader.getEmailId();
			String password = reader.getPassword();
			// Login using emailId and password
			login1.login(emailId, password);
			actualTitle = login1.driver.getTitle();

			// Assert Login unsuccessful/unsuccessful
			if (reader.i < 5) {
				expectedTitle = "Account Login";
				Thread.sleep(3000);
				if (actualTitle.equals(expectedTitle)) {
					test.log(LogStatus.PASS, "Test Passed- Warning appears");
				} else {
					test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\Login\\testCase001_to_005" + timeStamp + ".PNG"))+"Test Failed - Warning does not appear!");
					
				}
				Assert.assertEquals(actualTitle, expectedTitle);
			}
			if (reader.i == 5) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				expectedTitle = "My Account";
				if (actualTitle.equals(expectedTitle))
					test.log(LogStatus.PASS, "Test Passed- Login Successful");
				else
					test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\Login\\testCase001_to_005" + timeStamp + ".PNG"))+ "Test Failed - Login Unsuccessful!");
				Assert.assertEquals(actualTitle, expectedTitle);
			}

			
		}
	}
//TC_OC_LR_006 - To verify the that Login page is inaccessible when user is logged in
	@Test
	public void testCase006() throws IOException {
		test.log(LogStatus.INFO,"TC_OC_LR_006 - To verify the that Login page is inaccessible when user is logged in");
		s = new ScreenShotCapture(driver);
		reader.i = 5;
		String emailId = reader.getEmailId();
		String password = reader.getPassword();
		login1.login(emailId, password);
		driver.get("http://localhost/miniproject/index.php?route=account/login");
		actualTitle = login1.driver.getTitle();
		expectedTitle = "My Account";
		if (actualTitle.equals(expectedTitle))
			test.log(LogStatus.PASS,
					"Test Passed - Logged in user cannot access login page and is redirected to 'My Account' page.");
		else
			test.log(LogStatus.FAIL,
					test.addScreenCapture(s.captureScreenshot("\\Login\\testCase006_" + timeStamp + ".PNG"))
							+ "Test Failed - Logged in user can access login page.");
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test
	// TC_OC_LR_007 - To verify that Logged in user does not get logged out after clicking the back button on the browser
	public void testCase007() throws IOException {
		test.log(LogStatus.INFO,"TC_OC_LR_007 - To verify that Logged in user does not get logged out after clicking the back button on the browser");
		s = new ScreenShotCapture(driver);
		reader.i = 5;
		String emailId = reader.getEmailId();
		String password = reader.getPassword();
		login1.login(emailId, password);
		driver.navigate().back();
		actualTitle = login1.driver.getTitle();
		expectedTitle = "My Account";
		if (actualTitle.equals(expectedTitle))
			test.log(LogStatus.PASS,
					"Test Passed - Logged in user does not get logged out after clicking the back button on the browser");
		else
			test.log(LogStatus.FAIL, test
					.addScreenCapture(s.captureScreenshot("\\Login\\testCase007_" + timeStamp + ".PNG"))
					+ "Test Failed - Logged in user gets logged out after clicking the back button on the browser");
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test
	// TC_OC_LR_008 - To login with correct emailId and password, but the password is typed in wrong case
	public void testCase008() throws IOException {
		test.log(LogStatus.INFO,"TC_OC_LR_008 - To login with correct emailId and password, but the password is typed in wrong case");
		s = new ScreenShotCapture(driver);
		reader.i = 9;
		String emailId = reader.getEmailId();
		String password = reader.getPassword();
		login1.login(emailId, password);
		actualTitle = login1.driver.getTitle();
		expectedTitle = "My Account";
		if (actualTitle.equals(expectedTitle))
			test.log(LogStatus.PASS,"Test Passed - User is logged in! ");
		else
			test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\Login\\testCase008" + timeStamp + ".PNG"))+ "Test Failed - User is not logged in!");
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
//	@Parameters({ "Firefox" })
//	@BeforeTest
//	public void openBrowser(String browser) {
//		try {
//			if (browser.equalsIgnoreCase("Firefox")) {
//				WebDriverManager.firefoxdriver().setup();
//			} else if (browser.equalsIgnoreCase("chrome")) {
//				WebDriverManager.chromedriver().setup();
//			} else if (browser.equalsIgnoreCase("IE")) {
//				WebDriverManager.iedriver().setup();
//			}
//		
//		} catch (WebDriverException e) {
//			System.out.println(e.getMessage());
//		}
//	}

	@Parameters({"browser"})
	@BeforeMethod
	public void beforeMethod(Method m , String browser) {
		timeStamp = new SimpleDateFormat("yyyy_MMM_dd_HH.mm.ss").format(new Date());
		report = new ExtentReports("ExtentReports\\Login\\" + m.getName() + "_" + timeStamp + ".html");
		test = report.startTest(m.getName());
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		login1 = new LoginPage(driver);
		login1.navigateToLogin();

	}

	@AfterMethod
	public void afterMethod(Method m) throws InterruptedException {
		report.endTest(test);
		report.flush();
		login1.finish();
	}
}
