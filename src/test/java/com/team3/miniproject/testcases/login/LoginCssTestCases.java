package com.team3.miniproject.testcases.login;

import org.testng.annotations.Test;

import com.team3.miniproject.sitepages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginCssTestCases {
	WebDriver driver;
	LoginPage login;
	
	//TC_OC_LCSS_001
  @Test
  public void testCaseCss001() {
	  login=new LoginPage(driver);
	  login.navigateToLogin();
	  String emailPlaceholder=driver.findElement(By.id("input-email")).getAttribute("placeholder");  
	  Assert.assertEquals("E-Mail Address", emailPlaceholder);
  }
  
  //TC_OC_LCSS_002
  @Test
  public void testCaseCss002() {
	  login=new LoginPage(driver);
	  login.navigateToLogin();
	  String passwordPlaceholder=driver.findElement(By.id("input-password")).getAttribute("placeholder");
	  Assert.assertEquals("Password", passwordPlaceholder);
  }
  
  //TC_OC_LCSS_003
  @Test
  public void testCaseCss003() {
	  login=new LoginPage(driver);
	  login.navigateToLogin();
	  Assert.assertTrue(driver.findElement(By.linkText("Forgotten Password")).isDisplayed());
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize(); 
  }

  @AfterMethod
  public void afterMethod() {
		driver.quit();
  }

}
