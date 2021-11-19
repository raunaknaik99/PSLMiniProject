package com.team3.miniproject.testcases.registration;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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
	ExtentReports report;
	ExtentTest test;
	String timeStamp = new SimpleDateFormat("yyyy_MMM_dd_HH.mm.ss").format(new Date());


	// Should Pass
	//TC_OC_REG_001
	@Test
	public void testCase001() {
		s= new ScreenShotCapture(driver);
	 	test.log(LogStatus.INFO, "TC_OC_REG_001-Try registering by entering valid data in input fields but not selecting the privacy policy checkbox");
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase001.1_"+ timeStamp +".PNG");
			}
			rg_object.fillRegistrationForm(myData.get(0).get(0), myData.get(0).get(1), myData.get(0).get(2),
					myData.get(0).get(3), myData.get(0).get(4), myData.get(0).get(5));
			rg_object.clickContinueBtn();
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase001.2_"+ timeStamp +".PNG");

			}
			test.log(LogStatus.INFO, "Warning Status: "+rg_object.verifyWarningVisibility());
		} catch (Exception e) {
            test.log(LogStatus.INFO, e);		
         }
	}

	// should Pass
	//TC_OC_REG_002
	@Test
	public void testCase002() {
		s= new ScreenShotCapture(driver);
	 	test.log(LogStatus.INFO, "TC_OC_REG_002-Registering by entering valid data in input fields, selecting the privacy policy checkbox, but entering insufficient characters for password");
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase002.1_"+ timeStamp +".PNG");
			}
			rg_object.fillRegistrationForm(myData.get(1).get(0), myData.get(1).get(1), myData.get(1).get(2),
					myData.get(1).get(3), myData.get(1).get(4), myData.get(1).get(5));
			rg_object.clickContinueBtn();
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase002.2_"+ timeStamp +".PNG");
			}
			test.log(LogStatus.INFO, "Warning Status: "+rg_object.verifyWarningVisibility());
		} catch (Exception e) {
            test.log(LogStatus.INFO, e);		
		}
	}

	// Should Pass
	//TC_OC_REG_003
	@Test
	public void testCase003() {
		s= new ScreenShotCapture(driver);
	 	test.log(LogStatus.INFO, "TC_OC_REG_003-Registering by entering valid data in input fields, selecting the privacy policy checkbox, not entering data in the necessary marked fields. ie lastname");
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase003.1_"+ timeStamp +".PNG");

			}
			rg_object.fillRegistrationForm(myData.get(2).get(0), myData.get(2).get(1), myData.get(2).get(2),
					myData.get(2).get(3), myData.get(2).get(4), myData.get(2).get(5));
			rg_object.clickContinueBtn();
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase003.2_"+ timeStamp +".PNG");

			}
			test.log(LogStatus.INFO, "Warning Status: "+rg_object.verifyWarningVisibility());
		} catch (Exception e) {
            test.log(LogStatus.INFO, e);		
		}
	}

	//TC_OC_REG_004
	@Test(enabled=false)
	public void testCase004() throws IOException {
		s= new ScreenShotCapture(driver);
	 	test.log(LogStatus.INFO, "TC_OC_REG_004-Registering by entering inappropriate data in input fields, selecting the privacy policy checkbox.");
		rg_object = new RegistrationPage(driver);
		if(rg_object.getPageTitle().equals("Register Account")) {
			test.log(LogStatus.PASS, "Test Passed- Title Matched");
		}else {
			test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
			s.captureScreenshot("\\Registration\\" + "testCase004.1_"+ timeStamp +".PNG");
		}
		rg_object.fillRegistrationForm("Deeksha", "123", "1.1@example.com", "123", "testing123", "testing123");
		rg_object.clickContinueBtn();
		if(rg_object.getPageTitle().equals("Your Account Has Been Created!")) {
			test.log(LogStatus.PASS, "Test Passed- Title Matched");
		}else {
			test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
			s.captureScreenshot("\\Registration\\" + "testCase004.2_"+ timeStamp +".PNG");

		}
	}

	// Should Pass
	//TC_OC_REG_005
	@Test
	public void testCase005() {
		s= new ScreenShotCapture(driver);
	 	test.log(LogStatus.INFO, "TC_OC_REG_005-Registering by entering appropriate data in input fields, selecting the privacy policy checkbox.");
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase005.1_"+ timeStamp +".PNG");

			}
			rg_object.fillRegistrationForm(myData.get(3).get(0), myData.get(3).get(1), myData.get(3).get(2),
					myData.get(3).get(3), myData.get(3).get(4), myData.get(3).get(5));
			rg_object.checkPrivacyPolicy();
			rg_object.clickContinueBtn();
			WebDriverWait w = new WebDriverWait(driver, 3);
			w.until(ExpectedConditions.titleContains("Your Account Has Been Created!"));
			if(rg_object.getPageTitle().equals("Your Account Has Been Created!")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase005.2_"+ timeStamp +".PNG");

			}
		} catch (Exception e) {
            test.log(LogStatus.INFO, e);		
		}
	}

	// should Fail
	//TC_OC_REG_008
	@Test
	public void testCase008() {
		s= new ScreenShotCapture(driver);
	 	test.log(LogStatus.INFO, "TC_OC_REG_008-Registering by entering invalid data in Telephone field");
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase008.1_"+ timeStamp +".PNG");

			}
			rg_object.fillRegistrationForm(myData.get(4).get(0), myData.get(4).get(1), myData.get(4).get(2),
					myData.get(4).get(3), myData.get(4).get(4), myData.get(4).get(5));
			rg_object.checkPrivacyPolicy();
			rg_object.clickContinueBtn();
			WebDriverWait w = new WebDriverWait(driver, 3);
			w.until(ExpectedConditions.titleContains("Your Account Has Been Created!"));
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase008.2_"+ timeStamp +".PNG");

			}
		} catch (Exception e) {
            test.log(LogStatus.INFO, e);		
		}
	}

	@Test(enabled = false)
	public void testCase009() throws IOException {
		s= new ScreenShotCapture(driver);
	 	test.log(LogStatus.INFO, "TC_OC_REG_009-Verify the login navigation link is working on registration page");
		rg_object = new RegistrationPage(driver);
		rg_object.clickLoginLink();
		if(rg_object.getPageTitle().equals("Account Login")) {
			test.log(LogStatus.PASS, "Test Passed- Title Matched");
		}else {
			test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
			s.captureScreenshot("\\Registration\\" + "testCase009_"+ timeStamp +".PNG");

		}
	}

	// should pass
	//TC_OC_REG_006
	@Test(enabled = true)
	public void testCase006() {
		s= new ScreenShotCapture(driver);
	 	test.log(LogStatus.INFO, "TC_OC_REG_006-Registering by entering appropriate data in input fields but entering different passwords in 'Password' and 'Password Confirm' fields.");
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase006.1_"+ timeStamp +".PNG");
			}
			rg_object.fillRegistrationForm(myData.get(5).get(0), myData.get(5).get(1), myData.get(5).get(2),
					myData.get(5).get(3), myData.get(5).get(4), myData.get(5).get(5));
			rg_object.checkPrivacyPolicy();
			rg_object.clickContinueBtn();
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase006.2_"+ timeStamp +".PNG");
			}
			Assert.assertEquals(rg_object.verifyConfirmPasswordWarning(),
					"Password confirmation does not match password!");
		} catch (Exception e) {
            test.log(LogStatus.INFO, e);		
		}
	}

	// should pass
	//TC_OC_REG_007
	@Test(enabled = true)
	public void testCase007() {
		s= new ScreenShotCapture(driver);
	 	test.log(LogStatus.INFO, "TC_OC_REG_007-Registering by entering an email id with which an account has already been registered previously");
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase007.1_"+ timeStamp +".PNG");

			}
			rg_object.fillRegistrationForm(myData.get(6).get(0), myData.get(6).get(1), myData.get(6).get(2),
					myData.get(6).get(3), myData.get(6).get(4), myData.get(6).get(5));
			rg_object.checkPrivacyPolicy();
			rg_object.clickContinueBtn();
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase007.2_"+ timeStamp +".PNG");

			}
			test.log(LogStatus.INFO, "Warning Status: "+rg_object.verifyWarningVisibility());
		} catch (Exception e) {
            test.log(LogStatus.INFO, e);		
		}
	}

	// should pass
	//TC_OC_REG_0010
	@Test(enabled = true)
	public void testCase010() {
		s= new ScreenShotCapture(driver);
	 	test.log(LogStatus.INFO, "TC_OC_REG_010-Registering by keeping the First Name field empty");
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase0010.1_"+ timeStamp +".PNG");

			}
			rg_object.fillRegistrationForm(myData.get(7).get(0), myData.get(7).get(1), myData.get(7).get(2),
					myData.get(7).get(3), myData.get(7).get(4), myData.get(7).get(5));
			rg_object.checkPrivacyPolicy();
			rg_object.clickContinueBtn();
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase0010.2_"+ timeStamp +".PNG");

			}
			Assert.assertEquals(rg_object.verifyFirstNameWarning(), "First Name must be between 1 and 32 characters!");
		} catch (Exception e) {
            test.log(LogStatus.INFO, e);		
		}
	}

	// should pass
	//TC_OC_REG_0011
	@Test(enabled = true)
	public void testCase011() {
		s= new ScreenShotCapture(driver);
	 	test.log(LogStatus.INFO, "TC_OC_REG_011-Registering by entering insufficient numbers in the Telephone field");
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase011.1_"+ timeStamp +".PNG");

			}
			rg_object.fillRegistrationForm(myData.get(8).get(0), myData.get(8).get(1), myData.get(8).get(2),
					myData.get(8).get(3), myData.get(8).get(4), myData.get(8).get(5));
			rg_object.checkPrivacyPolicy();
			rg_object.clickContinueBtn();
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase0011.2_"+ timeStamp +".PNG");

			}
			Assert.assertEquals(rg_object.verifyTelephoneWarning(), "Telephone must be between 3 and 32 characters!");
		} catch (Exception e) {
            test.log(LogStatus.INFO, e);		
		}
	}

	// should pass
	//TC_OC_REG_0012
	@Test(enabled = true)
	public void testCase012() {
		s= new ScreenShotCapture(driver);
	 	test.log(LogStatus.INFO, "TC_OC_REG_012-Registering by entering a First Name having more than 32 characters");
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase0012.1_"+ timeStamp +".PNG");

			}
			rg_object.fillRegistrationForm(myData.get(9).get(0), myData.get(9).get(1), myData.get(9).get(2),
					myData.get(9).get(3), myData.get(9).get(4), myData.get(9).get(5));
			rg_object.checkPrivacyPolicy();
			rg_object.clickContinueBtn();
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase0012.2_"+ timeStamp +".PNG");

			}
			Assert.assertEquals(rg_object.verifyFirstNameWarning(), "First Name must be between 1 and 32 characters!");
		} catch (Exception e) {
            test.log(LogStatus.INFO, e);		
		}

	}

	// should pass
	@Test(enabled = true)
	public void testCase013() {
	 	test.log(LogStatus.INFO, "TC_OC_REG_013-Registering by entering a Last Name having more than 32 characters");
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase013.1_"+ timeStamp +".PNG");

			}
			rg_object.fillRegistrationForm(myData.get(10).get(0), myData.get(10).get(1), myData.get(10).get(2),
					myData.get(10).get(3), myData.get(10).get(4), myData.get(10).get(5));
			rg_object.checkPrivacyPolicy();
			rg_object.clickContinueBtn();
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase013.2_"+ timeStamp +".PNG");

			}
			Assert.assertEquals(rg_object.verifyLastNameWarning(), "Last Name must be between 1 and 32 characters!");
		} catch (Exception e) {
            test.log(LogStatus.INFO, e);		
		}
	}

	// should pass
	@Test(enabled = true)
	public void testCase014() {
	 	test.log(LogStatus.INFO, "TC_OC_REG_014-Registering by entering more than 32 numbers in the Telephone field");
		try {
			ArrayList<ArrayList<String>> myData = rd.userData();
			rg_object = new RegistrationPage(driver);
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase014.1_"+ timeStamp +".PNG");

			}
			rg_object.fillRegistrationForm(myData.get(11).get(0), myData.get(11).get(1), myData.get(11).get(2),
					myData.get(11).get(3), myData.get(11).get(4), myData.get(11).get(5));
			rg_object.checkPrivacyPolicy();
			rg_object.clickContinueBtn();
			if(rg_object.getPageTitle().equals("Register Account")) {
				test.log(LogStatus.PASS, "Test Passed- Title Matched");
			}else {
				test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
				s.captureScreenshot("\\Registration\\" + "testCase014.2_"+ timeStamp +".PNG");

			}
			Assert.assertEquals(rg_object.verifyTelephoneWarning(), "Telephone must be between 3 and 32 characters!");
		} catch (Exception e) {
            test.log(LogStatus.INFO, e);		
		}
	}

	// should pass
	@Test(enabled = false)
	public void testCase015() throws IOException {
	 	test.log(LogStatus.INFO, "TC_OC_REG_015-To verify the that Register page is inaccessible when user is logged in");
		rg_object = new RegistrationPage(driver);
		h_object = new Header(driver);
		lg_object = new LoginPage(driver);

		h_object.selectFromMyAccountDropDown(1);
		lg_object.login("demo1@example.com", "testing123");
		driver.get(baseUrl);
		if(rg_object.getPageTitle().equals("My Account")) {
			test.log(LogStatus.PASS, "Test Passed- Title Matched");
		}else {
			test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
			s.captureScreenshot("\\Registration\\" + "testCase015_"+ timeStamp +".PNG");
		}
	}

	@BeforeMethod
	public void beforeMethod(Method m) {
		report =new ExtentReports("ExtentReports\\Registration\\"+m.getName()+"_"+timeStamp+".html");
		test=report.startTest(m.getName());
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod(Method m) throws IOException {
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
