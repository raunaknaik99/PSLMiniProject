package com.team3.miniproject.testcases.login;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.team3.miniproject.sitepages.LoginPage;
import com.team3.miniproject.testcases.ddt.ReadInputs;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTC_OC_001_to_005 {
	WebDriver driver;
	LoginPage login1;
	ReadInputs reader = new ReadInputs();
	String expectedTitle;
	String actualTitle;
	ExtentReports report;
	ExtentTest test;


  @Test
  //TC_OC_LR_001 TO TC_OC_LR_005
  public void testCase001To005() throws IOException, InterruptedException {
	 // test.log(LogStatus.INFO, "TC_OC_LR_001 to TC_OC_LR_005 - to test all the possible scenarios for Login with email-id and password");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  	reader.readExcel("src\\test\\resources","loginDDT.xlsx","Login");
		  for (reader.i = 1; reader.i<reader.rowCount+1; reader.i++) {  
		  String emailId=reader.getEmailId();
		  String password=reader.getPassword();  
		  login1.login(emailId,password);
		  actualTitle=login1.driver.getTitle();

		  //assert Login unsuccessful/unsuccessful
		  if(reader.i<reader.rowCount) {
			expectedTitle="Account Login";
			Thread.sleep(3000);
			 if(actualTitle.equals(expectedTitle))
			 {
				  test.log(LogStatus.PASS, "Test Passed- Warning appears");
			 }
		     else {
				  test.log(LogStatus.FAIL, "Test Failed - Warning does not appear!");
				  }
		  }
		  if(reader.i==reader.rowCount) {
			  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  expectedTitle="My Account";
			  if(actualTitle.equals(expectedTitle))
				  test.log(LogStatus.PASS, "Test Passed- Login Successful");
			  else
				  test.log(LogStatus.FAIL, "Test Failed - Login Unsuccessful!");
		  }
		 
		  Assert.assertEquals(actualTitle, expectedTitle);  
		  }
  }


	@Test
	
	public void testCase006() throws IOException {
		reader.i=5;
		String emailId=reader.getEmailId();
		  String password=reader.getPassword();  
		  login1.login(emailId,password);
		driver.get("http://localhost/miniproject/index.php?route=account/login");
		actualTitle = login1.driver.getTitle();
		expectedTitle = "My Account";
		if(actualTitle.equals(expectedTitle))
			  test.log(LogStatus.PASS, "Test Passed - Logged in user cannot access login page and is redirected to 'My Account' page.");
	    else 
			  test.log(LogStatus.FAIL, "Test Failed - Logged in user can access login page.");
	
	
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@Test
	public void testCase007() throws IOException {
		reader.i=5;
		String emailId=reader.getEmailId();
		String password=reader.getPassword();  
		login1.login(emailId,password);
		driver.navigate().back();
		actualTitle = login1.driver.getTitle();
		expectedTitle = "My Account";
		if(actualTitle.equals(expectedTitle))
			  test.log(LogStatus.PASS, "Test Passed - Logged in user does not get logged out after clicking the back button on the browser");
	    else 
			  test.log(LogStatus.FAIL, "Test Failed - Logged in user gets logged out after clicking the back button on the browser");
	
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@BeforeMethod
	public void beforeMethod(Method m) {
	    String timeStamp = new SimpleDateFormat("yyyy_MMM_dd_HH.mm.ss").format(new Date());
		report =new ExtentReports("ExtentReports\\Login\\"+m.getName()+"_"+timeStamp+".html");
		test=report.startTest(m.getName());
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
