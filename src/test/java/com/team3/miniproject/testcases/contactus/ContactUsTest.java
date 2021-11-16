package com.team3.miniproject.testcases.contactus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.team3.miniproject.sitepages.ContactUs;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactUsTest {
	
	WebDriver driver;
	String baseUrl="http://localhost/opencartsite/index.php?route=information/contact";
	ContactUs cnct_object;
	
	
  @Test(enabled=false)
  public void testCase006() {
	  cnct_object=new ContactUs(driver);
	  cnct_object.enterName("Errol");
	  cnct_object.enterEmail("demo@email.com");
	  cnct_object.enterEnquiry("Testing if this field is working without");
	  cnct_object.clickSubmit();
  }
  
  @Test(enabled=false)
  public void testCase007() {
	  try {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			String astricks1=(String)js.executeScript("return window.getComputedStyle(document.querySelector(\"fieldset > div.required:nth-child(2) > label.control-label\"),':before').getPropertyValue('content')");
			String char1=Character.toString(astricks1.charAt(1));
			Assert.assertEquals("*",char1);
			
			String astricks2=(String)js.executeScript("return window.getComputedStyle(document.querySelector(\"fieldset > div.required:nth-child(3) > label.control-label\"),':before').getPropertyValue('content')");
			String char2=Character.toString(astricks2.charAt(1));
			Assert.assertEquals("*", char2);
			
			String astricks3=(String)js.executeScript("return window.getComputedStyle(document.querySelector(\"fieldset > div.required:nth-child(4) > label.control-label\"),':before').getPropertyValue('content')");
			String char3=Character.toString(astricks3.charAt(1));
			Assert.assertEquals("*", char3);
			
		}catch(Exception e) {
			System.out.println(e);
		}
  }
  
  @Test
  public void testCase008() {
		try {
		WebElement nameField=driver.findElement(By.id("input-name"));
		Assert.assertEquals("", nameField.getText());
		}catch(Exception e) {
			System.out.println(e);
		}
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
