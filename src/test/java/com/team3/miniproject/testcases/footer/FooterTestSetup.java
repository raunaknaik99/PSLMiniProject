package com.team3.miniproject.testcases.footer;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.team3.miniproject.sitepages.Footer;
import com.team3.miniproject.sitepages.Header;
import com.team3.miniproject.sitepages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import screenshot.ScreenShotCapture;

public class FooterTestSetup {

	WebDriver driver;
	String baseUrl = "http://localhost/miniproject/";
	Footer f_object;
	Header h_object;
	LoginPage login_object;
	ScreenShotCapture s;

	@Test
	public void testCase001() {
		
		f_object.getContactUs();
	}

	@Test
	public void testCase002() {
		
		f_object.getSiteMap();
	}

	@Test
	public void testCase003() {
		
		f_object.getReturns();
	}

	@Test
	public void testCase004() {
		
		f_object.getBrandsPage();
	}

	@Test
	public void testCase005() {
		
		f_object.getAffiliatePage();
	}

	@Test
	public void testCase006() {
		
		f_object.getAboutUs();
	}

	@Test
	public void testCase007() {
		
		f_object.getDeliveryInformation();
	}

	@Test
	public void testCase008() {
		
		f_object.getPrivacyPolicy();
	}

	@Test
	public void testCase009() {
		
		f_object.getTermsAndConditions();
	}

	@Test
	public void testCase010() {
		
		f_object.getNewsletter();
	}

	@Test
	public void testCase011() {
		
		f_object.getMyAccount();
	}

	@Test(priority=1)
	public void testCase012() {
     	login_object = new LoginPage(driver);
        login_object.navigateToLogin();
		login_object.login("demo1@example.com", "testing123");
		f_object.getMyAccount();
	}

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		f_object = new Footer(driver);
	}

	// addded ITestResult fo screenshot
	@AfterMethod
	public void afterMethod(ITestResult testResult) throws IOException {
		if (!testResult.isSuccess()) {
			s = new ScreenShotCapture(driver);
			s.captureScreenshot(testResult.getName() + ".png");
		}
		driver.quit();
	}

}
