package com.team3.miniproject.testcases.contactus;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.team3.miniproject.base.BrowserSetup;
import com.team3.miniproject.sitepages.ContactUsPage;
import com.team3.miniproject.testcases.ddt.ContactUsData;

import screenshot.ScreenShotCapture;

public class ContactUsTestSetup extends BrowserSetup {

	// WebDriver driver;
	String baseUrl = "http://localhost/opencartsite/index.php?route=information/contact";
	ContactUsPage contactUsObject;
	ExtentReports report;
	ExtentTest test;
	ScreenShotCapture objScreenshot;
	ContactUsData contactdata = new ContactUsData();
	String timeStamp = new SimpleDateFormat("yyyy_MMM_dd_HH.mm.ss").format(new Date());

	/*------------------------------*/
	@Test(enabled = true)
	public void testCase001() throws InterruptedException {
		objScreenshot = new ScreenShotCapture(driver);
		contactUsObject = new ContactUsPage(driver);
		test.log(LogStatus.INFO,
				"TC_OC_CU_001 - To test the functionality of contact us link by navigating to the page and entering valid details");

		try {
			contactUsObject.loginForContactUs();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)", "");
			Thread.sleep(3000);

			// link text to click on Contact Us link
			driver.findElement(By.linkText("Contact Us")).click();
			contactUsObject.enterEnquiry("This is the input for enquiry field");
			Thread.sleep(3000);

			// css of submit button of Contact Us Page---input[type=\"submit\"]
			contactUsObject.clickSubmit();
			Thread.sleep(3000);
			contactUsObject.getPageTitle();

			// link text to click Continue after navigating next to Contact Us page
			driver.findElement(By.linkText("Continue"));
			if (driver.getCurrentUrl()
					.equals("http://localhost/opencartsite/index.php?route=information/contact/success")) {
				test.log(LogStatus.PASS, "Test Passed: Contact us form was successfully submitted");
			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(
								objScreenshot.captureScreenshot("\\ContactUs\\testCase001" + timeStamp + ".PNG"))
								+ "Test Failed- Contact us form failed to submit");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	@Test(enabled = true)
	public void testCase002() throws InterruptedException {
		objScreenshot = new ScreenShotCapture(driver);
		contactUsObject = new ContactUsPage(driver);
		test.log(LogStatus.INFO,
				"TC_OC_CU_002 - To test the functionality of contact us link by navigating to the page and changing the data of 'Your Name' and 'Email' field");

		try {
			contactUsObject.loginForContactUs();
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

			contactUsObject.enterEnquiry("This is the input for enquiry field");
			Thread.sleep(3000);
			contactUsObject.clickSubmit();
			Thread.sleep(3000);
			contactUsObject.getPageTitle();

			// link Text to click Continue
			driver.findElement(By.linkText("Continue"));
			if (driver.getCurrentUrl().equals("http://localhost/opencartsite/index.php?route=information/contact")) {
				test.log(LogStatus.PASS, "Test Passed: Contact us form was not submitted");
			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(
								objScreenshot.captureScreenshot("\\ContactUs\\testCase002" + timeStamp + ".PNG"))
								+ "Test Failed- Contact us form was submitted");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	/*-------------------------------*/
	@Test(enabled = true)
	public void testCase003() throws IOException {
		objScreenshot = new ScreenShotCapture(driver);
		ArrayList<ArrayList<String>> myData = contactdata.contactUsData();

		test.log(LogStatus.INFO, "TC_OC_CU_003 - To test whether the contact us form accepts an invalid email id");
		try {
			contactUsObject = new ContactUsPage(driver);
			contactUsObject.enterName(myData.get(1).get(0));
			contactUsObject.enterEmail(myData.get(1).get(1));
			contactUsObject.enterEnquiry(myData.get(1).get(2));
			contactUsObject.clickSubmit();
			String actualUrl = "http://localhost/opencartsite/index.php?route=information/contact";
			if (driver.getCurrentUrl().equals(actualUrl)) {
				test.log(LogStatus.PASS, "Test Passed - Contact us form was not submitted");
			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(
								objScreenshot.captureScreenshot("\\ContactUs\\testCase003.1_" + timeStamp + ".PNG"))
								+ "Test Failed - Contact us form was submitted");
			}
			if (contactUsObject.getEmailWarning().equals("E-Mail Address does not appear to be valid!")) {
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

	@Test(enabled = true)
	public void testCase004() throws IOException {
		objScreenshot = new ScreenShotCapture(driver);
		ArrayList<ArrayList<String>> myData = contactdata.contactUsData();

		test.log(LogStatus.INFO,
				"TC_OC_CU_004 - To test whether the contact us form accepts less than 3 characters in 'Your Name' field");
		try {
			contactUsObject = new ContactUsPage(driver);
			contactUsObject.enterName(myData.get(2).get(0));
			contactUsObject.enterEmail(myData.get(2).get(1));
			contactUsObject.enterEnquiry(myData.get(2).get(2));
			contactUsObject.clickSubmit();
			String actualUrl = "http://localhost/opencartsite/index.php?route=information/contact";
			if (driver.getCurrentUrl().equals(actualUrl)) {
				test.log(LogStatus.PASS, "Test Passed - Contact us form was not submitted");
			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(
								objScreenshot.captureScreenshot("\\ContactUs\\testCase004.1_" + timeStamp + ".PNG"))
								+ "Test Failed - Contact us form was submitted");
			}
			if (contactUsObject.getYourNameWarning().equals("Name must be between 3 and 32 characters!")) {
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

	@Test(enabled = true)
	public void testCase005() throws IOException {
		objScreenshot = new ScreenShotCapture(driver);
		ArrayList<ArrayList<String>> myData = contactdata.contactUsData();

		test.log(LogStatus.INFO,
				"TC_OC_CU_005 - To test whether the contact us form accepts less than 10 characters in the 'Enquiry' field");
		try {
			contactUsObject = new ContactUsPage(driver);
			contactUsObject.enterName(myData.get(3).get(0));
			contactUsObject.enterEmail(myData.get(3).get(1));
			contactUsObject.enterEnquiry(myData.get(3).get(2));
			contactUsObject.clickSubmit();
			String actualUrl = "http://localhost/opencartsite/index.php?route=information/contact";
			if (driver.getCurrentUrl().equals(actualUrl)) {
				test.log(LogStatus.PASS, "Test Passed - Contact us form was not submitted");
			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(
								objScreenshot.captureScreenshot("\\ContactUs\\testCase005.1_" + timeStamp + ".PNG"))
								+ "Test Failed - Contact us form was submitted");
			}
			if (contactUsObject.getEnquiryWarning().equals("Enquiry must be between 10 and 3000 characters!")) {
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
		test.log(LogStatus.INFO, "TC_OC_CU_006-To test whether contact us form works even when user is not signed in");
		try {
			ArrayList<ArrayList<String>> myData = contactdata.contactUsData();
			contactUsObject = new ContactUsPage(driver);
			// enter the details in the contact us form
			contactUsObject.enterName(myData.get(0).get(0));
			contactUsObject.enterEmail(myData.get(0).get(1));
			contactUsObject.enterEnquiry(myData.get(0).get(2));
			contactUsObject.clickSubmit();
			String actualUrl = "http://localhost/opencartsite/index.php?route=information/contact/success";
			if (driver.getCurrentUrl().equals(actualUrl)) {
				test.log(LogStatus.PASS,
						"Test Passed- User navigated to Success correct Url after submiting contact us form");
			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(
								objScreenshot.captureScreenshot("\\ContactUs\\" + "testCase006_" + timeStamp + ".PNG"))
								+ "Test Failed- user navigated to wrong URL");

			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	// TC_OC_CU_008
	@Test(enabled = true)
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
				test.log(LogStatus.FAIL,
						test.addScreenCapture(objScreenshot
								.captureScreenshot("\\ContactUs\\" + "testCase008.1_" + timeStamp + ".PNG"))
								+ "Test Failed-Name Field is Blank & Email Field is not Blank: " + emailField);
			} else if (!nameField.getText().equals("") && emailField.getText().equals("")) {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(objScreenshot
								.captureScreenshot("\\ContactUs\\" + "testCase008.2_" + timeStamp + ".PNG"))
								+ "Test Failed-Name Field is Not Blank & Email Field is Blank: " + nameField);
			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(objScreenshot
								.captureScreenshot("\\ContactUs\\" + "testCase008.3_" + timeStamp + ".PNG"))
								+ "Test Failed-Name Field is not Blank, Contains Text: " + nameField);
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	@Test(priority = 1, enabled = true)
	public void testCase009() {
		objScreenshot = new ScreenShotCapture(driver);
		test.log(LogStatus.INFO, "TC_OC_CU_009-To test whether Store location details are present on the page");
		try {
			WebElement nameField = driver
					.findElement(By.cssSelector("#content > div > div > div > div:nth-child(1) > address"));
			if (nameField.getText().equals("Address 1")) {
				test.log(LogStatus.PASS, "Test Passed-Store location details are visible");
			} else {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(
								objScreenshot.captureScreenshot("\\ContactUs\\" + "testCase009_" + timeStamp + ".PNG"))
								+ "Test Failed-Store location details are not visible ");
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
		driver.get(baseUrl);
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
		report = new ExtentReports("ExtentReports\\ContactUs\\ContactUsTests_" + browser + "_" + timeStamp + ".html");
	}
}
