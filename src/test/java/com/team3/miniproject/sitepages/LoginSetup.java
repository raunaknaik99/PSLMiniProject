package com.team3.miniproject.sitepages;
//package sitepages;
//
//import org.testng.annotations.Test;
//import org.testng.annotations.BeforeMethod;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;
//
//public class LoginSetup {
//	WebDriver driver;
//	String baseUrl = "http://localhost/webcreation/upload/index.php";
//	LoginTestCases logtc;
//	
//  @Test
//  public void verifyTest1() {
//	  logtc = new LoginTestCases(driver);
//	  logtc.verifyTC_01();
//	  
//  }
//  
//  @Test
//  public void verifyTest2() throws InterruptedException {
//	  logtc = new LoginTestCases(driver);
//	  logtc.verifyTC_02();
//  }
//  
//  @Test
//  public void logoutTest() throws InterruptedException {
//	  logtc = new LoginTestCases(driver);
//	  logtc.logoutTC_01();
//  }
//  
//  @BeforeMethod
//  public void beforeMethod() {
//		  System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
//		  driver = new ChromeDriver();
//		  driver.get(baseUrl);
//  }
//
//  @AfterMethod
//  public void afterMethod() {
//	  driver.quit();
//  }
//
//}
