package com.team3.miniproject.testcases.login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.team3.miniproject.sitepages.LoginPage;
import com.team3.miniproject.testcases.ddt.ReadInputs;

public class LoginTestCases {
	WebDriver driver;
	LoginPage login1;
	ReadInputs reader = new ReadInputs();

	@Test
	public void verifyTestCase001() throws IOException {
		test.log(LogStatus.INFO,"TC_OC_FP_001 - using forgotten password with invalid email id");
		s = new ScreenShotCapture(driver);
		  
		  login1.forgotPassword();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		  reader.readExcel("src\\test\\resources", "loginDDT.xlsx", "Login");
		  reader.i = 10;
		  String emailId = reader.getEmailId();
		  login1.enterEmail(emailId);
		 
		  actualTitle = login1.driver.getTitle();
		  expectedTitle = "My Account";
			if (actualTitle.equals(expectedTitle))
				test.log(LogStatus.PASS,
						"Test Passed - User entered correct email Id and an email with confirmation link has been sent.");
			else
				test.log(LogStatus.FAIL,
						test.addScreenCapture(s.captureScreenshot("\\Login\\testCase009_" + timeStamp + ".PNG"))
								+ "Test Failed - The E-Mail Address was not found in our records, please try again!.");
		  	Assert.assertEquals(actualTitle, expectedTitle);
		
	}

	@Test
	public void verifyTestCase002() throws InterruptedException, IOException {
		 test.log(LogStatus.INFO,"TC_OC_FP_002 - using forgotten password with valid email id");
		 s = new ScreenShotCapture(driver);
			 
	  	 login1.forgotPassword();
		  
	  	 reader.readExcel("src\\test\\resources", "loginDDT.xlsx", "Login");
		  reader.i = 11;
		  String emailId = reader.getEmailId();
		  login1.enterEmail(emailId);
		 
		  actualTitle = login1.driver.getTitle();
		  expectedTitle = "My Account";
			if (actualTitle.equals(expectedTitle))
				test.log(LogStatus.PASS,
						"Test Passed - User entered correct email Id and an email with confirmation link has been sent.");
			else
				test.log(LogStatus.FAIL,
						test.addScreenCapture(s.captureScreenshot("\\Login\\testCase010_" + timeStamp + ".PNG"))
								+ "Test Failed - The E-Mail Address was not found in our records, please try again!.");
		  	Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void logoutTestCase001() throws InterruptedException, IOException {
		test.log(LogStatus.INFO,"TC_OC_LO_001 - To Verify that user does not get logged back in automatically on clicking continue after logging out.");
		 s = new ScreenShotCapture(driver);
			 
		 login1.navigateToLogin();
		  reader.readExcel("src\\test\\resources", "loginDDT.xlsx", "Login");
		  reader.i = 11;
		  String emailId = reader.getEmailId();
		  String password = reader.getPassword();
		  login1.login(emailId, password);
		  
		  login1.logout();
		  actualTitle = login1.driver.getTitle();
		  expectedTitle = "Account Logout";
			if (actualTitle.equals(expectedTitle))
				test.log(LogStatus.PASS,
						"Test Passed - Account is logged out successfully.");
			else
				test.log(LogStatus.FAIL,
						test.addScreenCapture(s.captureScreenshot("\\Login\\testCase011_" + timeStamp + ".PNG"))
								+ "Test Failed - Account is not logged out.");
		  	Assert.assertEquals(actualTitle, expectedTitle);
	}
}
