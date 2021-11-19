package com.team3.miniproject.testcases.login;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.team3.miniproject.sitepages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import screenshot.ScreenShotCapture;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginCssTestCases {
	WebDriver driver;
	LoginPage login;
	ScreenShotCapture s;
	ExtentReports report;
	ExtentTest test;
	String timeStamp = new SimpleDateFormat("yyyy_MMM_dd_HH.mm.ss").format(new Date());

	//TC_OC_LCSS_001
	@Test
	public void testCaseCss001() {
		test.log(LogStatus.INFO, "TC_OC_LCSS_001");
		try {
			login=new LoginPage(driver);
			login.navigateToLogin();
			String emailPlaceholder=driver.findElement(By.id("input-email")).getAttribute("placeholder");  
			Assert.assertEquals("E-Mail Address", emailPlaceholder);
			if(emailPlaceholder.equals("E-Mail Address")) {
				test.log(LogStatus.PASS, "Test Passed- Placeholder Present");
			}
			else {
				test.log(LogStatus.FAIL, "Test Failed");
				s.captureScreenshot("\\Login\\" + "testCaseCss001_"+ timeStamp +".PNG");
			}}
		catch(Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	//TC_OC_LCSS_002
	@Test
	public void testCaseCss002() {
		test.log(LogStatus.INFO, "TC_OC_LCSS_001");
		try {
			login=new LoginPage(driver);
			login.navigateToLogin();
			String passwordPlaceholder=driver.findElement(By.id("input-password")).getAttribute("placeholder");
			Assert.assertEquals("Password", passwordPlaceholder);
			if(passwordPlaceholder.equals("Password")) {
				test.log(LogStatus.PASS, "Test Passed- Placeholder Present");
			}
			else {
				test.log(LogStatus.FAIL, "Test Failed");
				s.captureScreenshot("\\Login\\" + "testCaseCss001_"+ timeStamp +".PNG");
			}
		}catch(Exception e) {
			test.log(LogStatus.INFO, e);
		}
	}

	@BeforeMethod
	public void beforeMethod(Method m) {
		report =new ExtentReports("ExtentReports\\Login\\"+m.getName()+"_"+timeStamp+".html");
		test=report.startTest(m.getName());
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize(); 
	}

	@AfterMethod
	public void afterMethod() {
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
