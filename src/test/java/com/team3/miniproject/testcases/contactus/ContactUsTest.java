package com.team3.miniproject.testcases.contactus;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.team3.miniproject.sitepages.ContactUs;
import com.team3.miniproject.testcases.ddt.ContactUsData;

import io.github.bonigarcia.wdm.WebDriverManager;
import screenshot.ScreenShotCapture;

public class ContactUsTest {

	WebDriver driver;
	String baseUrl = "http://localhost/miniproject/index.php?route=information/contact";
	ContactUs cnct_object;
	ExtentReports report;
	ExtentTest test;
	ScreenShotCapture objScreenshot;
	ContactUsData contactdata;
	String timeStamp = new SimpleDateFormat("yyyy_MMM_dd_HH.mm.ss").format(new Date());

	/*------------------------------*/
	@Test
	public void contactTestCase001() throws InterruptedException {
		cnct_object = new ContactUs(driver);
		cnct_object.loginForContactUs();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(3000);

		// link text to click on Contact Us link
		driver.findElement(By.linkText("Contact Us")).click();
		cnct_object.enterEnquiry("This is the input for enquiry field");
		Thread.sleep(3000);

		// css of submit button of Contact Us Page---input[type=\"submit\"]
		cnct_object.clickSubmit();
		Thread.sleep(3000);
		cnct_object.getPageTitle();

		// link text to click Continue after navigating next to Contact Us page
		driver.findElement(By.linkText("Continue"));
	}

	@Test
	public void contactTestCase002() throws InterruptedException {
		cnct_object = new ContactUs(driver);
		cnct_object.loginForContactUs();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(3000);
		driver.findElement(By.linkText("Contact Us")).click();

		WebElement name = driver.findElement(By.id("input-name"));
		name.clear();
		name.sendKeys("Joe");

		WebElement email_field = driver.findElement(By.id("input-email"));
		email_field.clear();
		email_field.sendKeys("joe@demo.com");

		cnct_object.enterEnquiry("This is the input for enquiry field");
		Thread.sleep(3000);
		cnct_object.clickSubmit();
		Thread.sleep(3000);
		cnct_object.getPageTitle();

		// link Text to click Continue
		driver.findElement(By.linkText("Continue"));
	}

	/*-------------------------------*/
	@Test(enabled = true)
	public void testCase003() {
		objScreenshot = new ScreenShotCapture(driver);
		test.log(LogStatus.INFO, "TC_OC_CU_003 - To test whether the contact us form accepts an invalid email id");
		try {
			cnct_object = new ContactUs(driver);
			cnct_object.enterName("Tester");
			cnct_object.enterEmail("demo1@example");
			cnct_object.enterEnquiry("When will the iPad Air be in stock again");
			cnct_object.clickSubmit();
			String actualUrl = "http://localhost/opencartsite/index.php?route=information/contact";
			if (driver.getCurrentUrl().equals(actualUrl)) {
				test.log(LogStatus.PASS, "Test Passed - Contact us form was not submitted");
			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(
								objScreenshot.captureScreenshot("\\ContactUs\\testCase003.1_" + timeStamp + ".PNG"))
								+ "Test Failed - Contact us form was submitted");
			}
			if (cnct_object.getEmailWarning().equals("E-Mail Address does not appear to be valid!")) {
				test.log(LogStatus.PASS, "Test Passed- Correct warning message was shown");
			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(
								objScreenshot.captureScreenshot("\\ContactUs\\testCase003.2_" + timeStamp + ".PNG"))
								+ "Test Failed- Incorrect warning message was shown");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	@Test
	public void testCase004() {
		objScreenshot = new ScreenShotCapture(driver);
		test.log(LogStatus.INFO,
				"TC_OC_CU_004 - To test whether the contact us form accepts less than 3 characters in 'Your Name' field");
		try {
			cnct_object = new ContactUs(driver);
			cnct_object.enterName("Te");
			cnct_object.enterEmail("demo@email.com");
			cnct_object.enterEnquiry("When will the iPad Air be in stock again");
			cnct_object.clickSubmit();
			String actualUrl = "http://localhost/opencartsite/index.php?route=information/contact";
			if (driver.getCurrentUrl().equals(actualUrl)) {
				test.log(LogStatus.PASS, "Test Passed - Contact us form was not submitted");
			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(
								objScreenshot.captureScreenshot("\\ContactUs\\testCase004.1_" + timeStamp + ".PNG"))
								+ "Test Failed - Contact us form was submitted");
			}
			if (cnct_object.getYourNameWarning().equals("Name must be between 3 and 32 characters!")) {
				test.log(LogStatus.PASS, "Test Passed- Correct warning message was shown");
			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(
								objScreenshot.captureScreenshot("\\ContactUs\\testCase004.2_" + timeStamp + ".PNG"))
								+ "Test Failed- Incorrect warning message was shown");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	@Test
	public void testCase005() {
		objScreenshot = new ScreenShotCapture(driver);
		test.log(LogStatus.INFO,
				"TC_OC_CU_005 - To test whether the contact us form accepts less than 10 characters in the 'Enquiry' field");
		try {
			cnct_object = new ContactUs(driver);
			cnct_object.enterName("Tester");
			cnct_object.enterEmail("demo@email.com");
			cnct_object.enterEnquiry("abcd");
			cnct_object.clickSubmit();
			String actualUrl = "http://localhost/opencartsite/index.php?route=information/contact";
			if (driver.getCurrentUrl().equals(actualUrl)) {
				test.log(LogStatus.PASS, "Test Passed - Contact us form was not submitted");
			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(
								objScreenshot.captureScreenshot("\\ContactUs\\testCase005.1_" + timeStamp + ".PNG"))
								+ "Test Failed - Contact us form was submitted");
			}
			if (cnct_object.getEnquiryWarning().equals("Enquiry must be between 10 and 3000 characters!")) {
				test.log(LogStatus.PASS, "Test Passed- Correct warning message was shown");
			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(
								objScreenshot.captureScreenshot("\\ContactUs\\testCase005.2_" + timeStamp + ".PNG"))
								+ "Test Failed- Incorrect warning message was shown");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	@Test(enabled = true)
	// TC_OC_CU_006
	public void testCase006() throws IOException {
		objScreenshot = new ScreenShotCapture(driver);
		ArrayList<ArrayList<String>> myData = contactdata.contactUsData();

		test.log(LogStatus.INFO, "TC_OC_CU_006-To test whether contact us form works even when user is not signed in");
		try {
			cnct_object = new ContactUs(driver);
			// enter the details in the contact us form
			cnct_object.enterName(myData.get(0).get(0));
			cnct_object.enterEmail(myData.get(0).get(1));
			cnct_object.enterEnquiry(myData.get(0).get(2));
			cnct_object.clickSubmit();
			String actualUrl = "http://localhost/opencartsite/index.php?route=information/contact/success";
			if (driver.getCurrentUrl().equals(actualUrl)) {
				test.log(LogStatus.PASS,
						"Test Passed- User navigated to Success correct Url after submiting contact us form");
			} else {
				test.log(LogStatus.FAIL, "Test Failed- user navigated to wrong URL");
				objScreenshot.captureScreenshot("\\ContactUs\\" + "testCase006_" + timeStamp + ".PNG");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	// TC_OC_CU_007
	@Test
	public void testCase007() {
		objScreenshot = new ScreenShotCapture(driver);
		test.log(LogStatus.INFO, "TC_OC_CU_007-To check if labels for mandatory fields are present");
		// to test the presence of astricks
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String astricks1 = (String) js.executeScript(
					"return window.getComputedStyle(document.querySelector(\"fieldset > div.required:nth-child(2) > label.control-label\"),':before').getPropertyValue('content')");
			String char1 = Character.toString(astricks1.charAt(1));

			if (char1.equals("*")) {
				test.log(LogStatus.PASS, "Test Passed- Astricks present for Input Field 1");
			} else {
				test.log(LogStatus.FAIL, "Test Failed- Astricks not present for Input field 1");
				objScreenshot.captureScreenshot("\\ContactUs\\" + "testCase007.1_" + timeStamp + ".PNG");
			}

			String astricks2 = (String) js.executeScript(
					"return window.getComputedStyle(document.querySelector(\"fieldset > div.required:nth-child(3) > label.control-label\"),':before').getPropertyValue('content')");
			String char2 = Character.toString(astricks2.charAt(1));

			if (char2.equals("*")) {
				test.log(LogStatus.PASS, "Test Passed- Astricks present for Input Field 2");
			} else {
				test.log(LogStatus.FAIL, "Test Failed- Astricks not present for Input field 2");
				objScreenshot.captureScreenshot("\\ContactUs\\" + "testCase007.2_" + timeStamp + ".PNG");
			}

			String astricks3 = (String) js.executeScript(
					"return window.getComputedStyle(document.querySelector(\"fieldset > div.required:nth-child(4) > label.control-label\"),':before').getPropertyValue('content')");
			String char3 = Character.toString(astricks3.charAt(1));

			if (char3.equals("*")) {
				test.log(LogStatus.PASS, "Test Passed- Astricks present for Input Field 3");
			} else {
				test.log(LogStatus.FAIL, "Test Failed- Astricks not present for Input field 3");
				objScreenshot.captureScreenshot("\\ContactUs\\" + "testCase007.3_" + timeStamp + ".PNG");
			}

		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	// TC_OC_CU_008
	@Test
	public void testCase008() {
		objScreenshot = new ScreenShotCapture(driver);
		test.log(LogStatus.INFO,
				"TC_OC_CU_008-To test whether name and email field is blank when user is not signed in");
		try {
			WebElement nameField = driver.findElement(By.id("input-name"));
			WebElement emailField = driver.findElement(By.id("input-email"));
			if (nameField.getText().equals("") && emailField.getText().equals("")) {
				test.log(LogStatus.PASS, "Test Passed-Name & Email Field is Blank");
			} else if (nameField.getText().equals("") && !emailField.getText().equals("")) {
				test.log(LogStatus.FAIL, "Test Failed-Name Field is Blank & Email Field is not Blank: " + emailField);
				objScreenshot.captureScreenshot("\\ContactUs\\" + "testCase008.1_" + timeStamp + ".PNG");
			} else if (!nameField.getText().equals("") && emailField.getText().equals("")) {
				test.log(LogStatus.FAIL, "Test Failed-Name Field is Not Blank & Email Field is Blank: " + nameField);
				objScreenshot.captureScreenshot("\\ContactUs\\" + "testCase008.2_" + timeStamp + ".PNG");
			} else {
				test.log(LogStatus.FAIL, "Test Failed-Name Field is not Blank, Contains Text: " + nameField);
				objScreenshot.captureScreenshot("\\ContactUs\\" + "testCase008.3_" + timeStamp + ".PNG");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	@BeforeMethod
	public void beforeMethod(Method m) {
		report = new ExtentReports("ExtentReports\\ContactUs\\" + m.getName() + "_" + timeStamp + ".html");
		test = report.startTest(m.getName());
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod(Method m) {
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
