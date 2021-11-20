package com.team3.miniproject.testcases.login;
//
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class LoginSetup {
	WebDriver driver;
	String baseUrl = "http://localhost/miniproject/";
	LoginTestCases logtc;
	
  @Test
  public void verifyTest1() {
	  logtc = new LoginTestCases(driver);
	  logtc.verifyTC_01();
	  
  }
  
  @Test
  public void verifyTest2() throws InterruptedException {
	  logtc = new LoginTestCases(driver);
	  logtc.verifyTC_02();
  }
  
  @Test
  public void logoutTest() throws InterruptedException {
	  logtc = new LoginTestCases(driver);
	  logtc.logoutTC_01();
  }
  
  @BeforeMethod
  public void beforeMethod() {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.get(baseUrl);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
