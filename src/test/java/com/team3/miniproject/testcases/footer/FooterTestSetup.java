package com.team3.miniproject.testcases.footer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.team3.miniproject.sitepages.Footer;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterTestSetup {
	
	WebDriver driver;
	String baseUrl="http://localhost/opencartsite/";
	Footer f_object;
  @Test
  public void testCase001() {
	  f_object=new Footer(driver);
	  f_object.getContactUs();
  }
  
  @Test
  public void testCase002() {
	  f_object=new Footer(driver);
	  f_object.getSiteMap();
  }
  
  @Test
  public void testCase003() {
	  f_object=new Footer(driver);
	  f_object.getReturns();
  }
  
  @Test
  public void testCase004() {
	  f_object=new Footer(driver);
	  f_object.getBrandsPage();
  }
	
  @Test
  public void testCase005() {
	  f_object=new Footer(driver);
	  f_object.getAffiliatePage();
  }
  
  @Test
  public void testCase006() {
	  f_object=new Footer(driver);
	  f_object.getAboutUs();
  }
  @Test
  public void testCase007() {
	  f_object=new Footer(driver);
	  f_object.getDeliveryInformation();
  }
  @Test
  public void testCase008() {
	  f_object=new Footer(driver);
	  f_object.getPrivacyPolicy();
  }
 @Test
  public void testCase009() {
	  f_object=new Footer(driver);
	  f_object.getTermsAndConditions();
  }
  	
  @Test
  public void testCase010() {
	  f_object=new Footer(driver);
	  f_object.getNewsletter();
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(baseUrl);
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
