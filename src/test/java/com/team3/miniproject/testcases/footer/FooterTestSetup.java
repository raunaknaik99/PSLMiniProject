package com.team3.miniproject.testcases.footer;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.team3.miniproject.sitepages.Footer;
import com.team3.miniproject.sitepages.Header;
import com.team3.miniproject.sitepages.LoginPage;
import com.team3.miniproject.testcases.ddt.ReadInputs;

import io.github.bonigarcia.wdm.WebDriverManager;
import screenshot.ScreenShotCapture;

public class FooterTestSetup {

	WebDriver driver;
	String baseUrl = "http://localhost/miniproject/";
	Footer f_object;
	Header h_object;
	LoginPage login_object;
	ScreenShotCapture s;
	ExtentReports report;
	ExtentTest test;
	ReadInputs reader = new ReadInputs();

	String timeStamp = new SimpleDateFormat("yyyy_MMM_dd_HH.mm.ss").format(new Date());

	// TC_OC_FL_001
	@Test
	public void testCase001() {
		s = new ScreenShotCapture(driver);
		try {
			f_object = new Footer(driver);
			f_object.getContactUs();

			if (driver.getTitle().equals("Contact Us")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");
			} else {
				test.log(LogStatus.FAIL, "Test Failed- Title MisMatched");
				s.captureScreenshot("\\Footer\\" + "testCase001_" + timeStamp + ".PNG");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	// TC_OC_FL_002
	@Test
	public void testCase002() {
		s = new ScreenShotCapture(driver);
		try {
			f_object = new Footer(driver);
			f_object.getSiteMap();
			if (driver.getTitle().equals("Site Map")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");

			} else {
				test.log(LogStatus.FAIL, "Test Failed- Title MisMatched");
				s.captureScreenshot("\\Footer\\" + "testCase002_" + timeStamp + ".PNG");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	// TC_OC_FL_003
	@Test
	public void testCase003() {
		s = new ScreenShotCapture(driver);
		try {
			f_object = new Footer(driver);
			f_object.getReturns();

			if (driver.getTitle().equals("Returns")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");

			} else {
				test.log(LogStatus.FAIL, "Test Failed- Title MisMatched");
				s.captureScreenshot("\\Footer\\" + "testCase003_" + timeStamp + ".PNG");

			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	// TC_OC_FL_004
	@Test
	public void testCase004() {
		s = new ScreenShotCapture(driver);
		try {
			f_object = new Footer(driver);
			f_object.getBrandsPage();

			if (driver.getTitle().equals("Brands")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");

			} else {
				test.log(LogStatus.FAIL, "Test Failed- Title MisMatched");
				s.captureScreenshot("\\Footer\\" + "testCase004_" + timeStamp + ".PNG");

			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	// TC_OC_FL_005
	@Test
	public void testCase005() {
		s = new ScreenShotCapture(driver);
		try {
			f_object = new Footer(driver);
			f_object.getAffiliatePage();

			if (driver.getTitle().equals("Affiliate")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");

			} else {
				test.log(LogStatus.FAIL, "Test Failed- Title MisMatched");
				s.captureScreenshot("\\Footer\\" + "testCase005_" + timeStamp + ".PNG");

			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	// TC_OC_FL_006
	@Test
	public void testCase006() {
		s = new ScreenShotCapture(driver);
		try {
			f_object = new Footer(driver);
			f_object.getAboutUs();

			if (driver.getTitle().equals("About Us")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");

			} else {
				test.log(LogStatus.FAIL, "Test Failed- Title MisMatched");
				s.captureScreenshot("\\Footer\\" + "testCase006_" + timeStamp + ".PNG");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	// TC_OC_FL_007
	@Test
	public void testCase007() {
		s = new ScreenShotCapture(driver);
		try {
			f_object = new Footer(driver);
			f_object.getDeliveryInformation();

			if (driver.getTitle().equals("Delivery Information")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");

			} else {
				test.log(LogStatus.FAIL, "Test Failed- Title MisMatched");
				s.captureScreenshot("\\Footer\\" + "testCase007_" + timeStamp + ".PNG");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	// TC_OC_FL_008
	@Test
	public void testCase008() {
		s = new ScreenShotCapture(driver);
		try {
			f_object = new Footer(driver);
			f_object.getPrivacyPolicy();
			if (driver.getTitle().equals("Privacy Policy")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");

			} else {
				test.log(LogStatus.FAIL, "Test Failed- Title MisMatched");
				s.captureScreenshot("\\Footer\\" + "testCase008_" + timeStamp + ".PNG");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	// TC_OC_FL_009
	@Test
	public void testCase009() {
		s = new ScreenShotCapture(driver);
		try {
			f_object = new Footer(driver);
			f_object.getTermsAndConditions();
			if (driver.getTitle().equals("Terms & Conditions")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");

			} else {
				test.log(LogStatus.FAIL, "Test Failed- Title MisMatched");
				s.captureScreenshot("\\Footer\\" + "testCase009_" + timeStamp + ".PNG");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}

	}

	// TC_OC_FL_010
	@Test
	public void testCase010() {
		s = new ScreenShotCapture(driver);
		try {
			f_object = new Footer(driver);
			f_object.getNewsletter();
			if (driver.getTitle().equals("Newsletter")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");

			} else {
				test.log(LogStatus.FAIL, "Test Failed- Title MisMatched");
				s.captureScreenshot("\\Footer\\" + "testCase010_" + timeStamp + ".PNG");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	// TC_OC_FL_011
	@Test
	public void testCase011() {
		s = new ScreenShotCapture(driver);
		try {
			f_object = new Footer(driver);
			f_object.getMyAccount();
			if (driver.getTitle().equals("My Account")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");

			} else {
				test.log(LogStatus.FAIL, s.captureScreenshot("\\Footer\\" + "testCase011_" + timeStamp + ".PNG")
						+ "Test Failed- Title MisMatched");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}

	}

	// TC_OC_FL_012
	@Test
	public void testCase012() throws IOException {
		reader.readExcel("src\\test\\resources", "loginDDT.xlsx", "Login");
		s = new ScreenShotCapture(driver);
		try {
			h_object = new Header(driver);
			f_object = new Footer(driver);
			login_object = new LoginPage(driver);

			h_object.selectFromMyAccountDropDown(1);
			login_object.login("demo1@example.com", "testing123");
			f_object.getMyAccount();

			if (driver.getTitle().equals("My Account")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");

			} else {
				test.log(LogStatus.FAIL, s.captureScreenshot("\\Footer\\" + "testCase013_" + timeStamp + ".PNG")
						+ "Test Failed- Title MisMatched");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}

	}

	@BeforeMethod
	public void beforeMethod(Method m) {
		report = new ExtentReports("ExtentReports\\Footer\\" + m.getName() + "_" + timeStamp + ".html");
		test = report.startTest(m.getName());
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		f_object = new Footer(driver);
	}

	// addded ITestResult fo screenshot
	@AfterMethod
	public void afterMethod(Method m) throws IOException {
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
