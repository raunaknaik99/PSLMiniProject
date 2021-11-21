package com.team3.miniproject.testcases.footer;

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
import com.team3.miniproject.sitepages.Footer;
import com.team3.miniproject.sitepages.Header;
import com.team3.miniproject.sitepages.LoginPage;
import com.team3.miniproject.testcases.ddt.ReadInputs;

import screenshot.ScreenShotCapture;

public class FooterTestSetup extends BrowserSetup {

	// WebDriver driver;
	String baseUrl = "http://localhost/opencartsite/";
	Footer footerObject;
	Header headerObject;
	LoginPage loginObject;
	ScreenShotCapture s;
	ExtentReports report;
	ExtentTest test;

	String timeStamp = new SimpleDateFormat("yyyy_MMM_dd_HH.mm.ss").format(new Date());

	// TC_OC_FL_001
	@Test(enabled = false)
	public void testCase001() {
		s = new ScreenShotCapture(driver);
		try {
			footerObject = new Footer(driver);
			footerObject.getContactUs();

			if (driver.getTitle().equals("Contact Us")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");
			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(s.captureScreenshot("\\Footer\\" + "testCase001_" + timeStamp + ".PNG"))
								+ "Test Failed- Title MisMatched");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	// TC_OC_FL_002
	@Test(enabled = false)
	public void testCase002() {
		s = new ScreenShotCapture(driver);
		try {
			footerObject = new Footer(driver);
			footerObject.getSiteMap();
			if (driver.getTitle().equals("Site Map")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");

			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(s.captureScreenshot("\\Footer\\" + "testCase002_" + timeStamp + ".PNG"))
								+ "Test Failed- Title MisMatched");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	// TC_OC_FL_003
	@Test(enabled = false)
	public void testCase003() {
		s = new ScreenShotCapture(driver);
		try {
			footerObject = new Footer(driver);
			footerObject.getReturns();

			if (driver.getTitle().equals("Product Returns")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");

			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(s.captureScreenshot("\\Footer\\" + "testCase003_" + timeStamp + ".PNG"))
								+ "Test Failed- Title MisMatched");

			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	// TC_OC_FL_004
	@Test(enabled = false)
	public void testCase004() {
		s = new ScreenShotCapture(driver);
		try {
			footerObject = new Footer(driver);
			footerObject.getBrandsPage();

			if (driver.getTitle().equals("Find Your Favorite Brand")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");

			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(s.captureScreenshot("\\Footer\\" + "testCase004_" + timeStamp + ".PNG"))
								+ "Test Failed- Title MisMatched");

			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	// TC_OC_FL_005
	@Test(enabled = false)
	public void testCase005() {
		s = new ScreenShotCapture(driver);
		try {
			footerObject = new Footer(driver);
			footerObject.getAffiliatePage();

			if (driver.getTitle().equals("Affiliate Program")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");

			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(s.captureScreenshot("\\Footer\\" + "testCase005_" + timeStamp + ".PNG"))
								+ "Test Failed- Title MisMatched");

			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	// TC_OC_FL_006
	@Test(enabled = false)
	public void testCase006() {
		s = new ScreenShotCapture(driver);
		try {
			footerObject = new Footer(driver);
			footerObject.getAboutUs();

			if (driver.getTitle().equals("About Us")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");

			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(s.captureScreenshot("\\Footer\\" + "testCase006_" + timeStamp + ".PNG"))
								+ "Test Failed- Title MisMatched");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	// TC_OC_FL_007
	@Test(enabled = false)
	public void testCase007() {
		s = new ScreenShotCapture(driver);
		try {
			footerObject = new Footer(driver);
			footerObject.getDeliveryInformation();

			if (driver.getTitle().equals("Delivery Information")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");

			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(s.captureScreenshot("\\Footer\\" + "testCase007_" + timeStamp + ".PNG"))
								+ "Test Failed- Title MisMatched");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	// TC_OC_FL_008
	@Test(enabled = false)
	public void testCase008() {
		s = new ScreenShotCapture(driver);
		try {
			footerObject = new Footer(driver);
			footerObject.getPrivacyPolicy();
			if (driver.getTitle().equals("Privacy Policy")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");

			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(s.captureScreenshot("\\Footer\\" + "testCase008_" + timeStamp + ".PNG"))
								+ "Test Failed- Title MisMatched");

			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	// TC_OC_FL_009
	@Test(enabled = false)
	public void testCase009() {
		s = new ScreenShotCapture(driver);
		try {
			footerObject = new Footer(driver);
			footerObject.getTermsAndConditions();
			if (driver.getTitle().equals("Terms & Conditions")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");

			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(s.captureScreenshot("\\Footer\\" + "testCase009_" + timeStamp + ".PNG"))
								+ "Test Failed- Title MisMatched");

			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}

	}

	// TC_OC_FL_010
	@Test(enabled = false)
	public void testCase010() {
		s = new ScreenShotCapture(driver);
		try {
			footerObject = new Footer(driver);
			footerObject.getNewsletter();
			if (driver.getTitle().equals("Account Login")) {
				test.log(LogStatus.PASS, "Test Passed-Title Matched");

			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(s.captureScreenshot("\\Footer\\" + "testCase010_" + timeStamp + ".PNG"))
								+ "Test Failed- Title MisMatched");

			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	// TC_OC_FL_011
	@Test(enabled = true)
	public void testCase011() {
		s = new ScreenShotCapture(driver);
		try {
			footerObject = new Footer(driver);
			footerObject.getMyAccount();
			if (driver.getTitle().equals("Account Login")) {
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
	@Test(enabled = true)
	public void testCase012() throws IOException {
		s = new ScreenShotCapture(driver);
		ReadInputs loginreader = new ReadInputs();
		loginreader.readExcel("src\\test\\resources", "loginDDT.xlsx", "Login");
		try {
			headerObject = new Header(driver);
			footerObject = new Footer(driver);
			loginObject = new LoginPage(driver);

			headerObject.selectFromMyAccountDropDown(1);
			loginreader.i = 5;
			loginObject.login(loginreader.getEmailId(), loginreader.getPassword());
			footerObject.getMyAccount();

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

	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(Method m, String browser) {
		test = report.startTest(m.getName());
		initialize(browser);
		// WebDriverManager.chromedriver().setup();
		// driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		// driver.manage().window().maximize();
		footerObject = new Footer(driver);
	}

	@AfterMethod
	public void afterMethod(Method m) throws IOException {
		report.endTest(test);
		report.flush();
		driver.quit();
	}

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		report = new ExtentReports("ExtentReports\\Footer\\FooterTests_" + browser + "_" + timeStamp + ".html");
	}

}
