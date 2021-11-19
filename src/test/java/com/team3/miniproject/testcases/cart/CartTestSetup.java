package com.team3.miniproject.testcases.cart;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.team3.miniproject.sitepages.AppleCinema;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CartTestSetup {
	
	WebDriver driver;
	String baseUrl="http://localhost/opencartsite/";
	AppleCinema hpc_object;
	ExtentReports report;
	ExtentTest test;
	
  //TC_OC_CART_008
  @Test
  public void testCase008() {
	  test.log(LogStatus.INFO, "TC_OC_CART_008-Add product with customizable features to cart but leave some of the required fields in the features form blank ");
	  hpc_object=new AppleCinema(driver); //create a new instance of AppleCinema Class
	  //click on add to cart button on home page
	  hpc_object.clickAppleCinemaCart();
	  //click on radio button
	  hpc_object.clickRadioButton();
	  //click on checkbox
	  hpc_object.clickCheckbox();
	  //click on add to cart button
	  hpc_object.clickAddToCart();
	  //Assert if warning is visible
	  hpc_object.checkMandatoryFieldsWarning();
	  //Check if test Passed or failed
	  if(hpc_object.checkPageTitle().equals("Apple Cinema 30")) {
		  test.log(LogStatus.PASS, "Test Passed- Title Matched");
	  }else {
		  test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
	  }
  }
  
  //TC_OC_CART_010
  @Test
  public void testCase010() throws InterruptedException, IOException {
	  test.log(LogStatus.INFO, "TC_OC_CART_010-To verify that new window opens when user clicks the Tweet button");
	  
	  hpc_object=new AppleCinema(driver); //create new instance of AppleCinema class
	  //click on cinema cart
	  hpc_object.clickAppleCinemaCart();
	  //wait till title loads
	  WebDriverWait w =new WebDriverWait(driver, 3);
	  w.until(ExpectedConditions.titleIs("Apple Cinema 30"));
	  //get parent window handle
	  String parentWindowHandle=driver.getWindowHandle();
	  if(driver.getTitle().equals("Apple Cinema 30")) {
		  test.log(LogStatus.PASS, "Test Passed- Title Matched");
	  }
	  else {
	      test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
	  }	  
	  //click on tweet btn
	  hpc_object.clickTweetBtn();
	  //get child window handles
	  Set<String> childWindowHandles=driver.getWindowHandles();
	  Iterator<String> itr=childWindowHandles.iterator();  
	  while(itr.hasNext()) {
		  String childWindow=itr.next();
		  //switch to child window
		  if(!parentWindowHandle.equals(childWindow)) {
			  driver.switchTo().window(childWindow);
			  w.until(ExpectedConditions.titleIs("Twitter"));
			  test.log(LogStatus.INFO, "Switched to child window handle");
			  if(driver.getTitle().equals("Twitter")) {
				  test.log(LogStatus.PASS, "Test Passed- Child window Title matched");
			  }else {
				  test.log(LogStatus.FAIL, "Test Failed- Child Window title mismatched");
			  }
			  driver.close();
		  }
		  else {
			  test.log(LogStatus.FAIL, "Test Failed- Did not switch to child window");
		  }
	  }
	  Thread.sleep(3000); //only to visualize the going back to parent window
	  //switch back to parent window
	  driver.switchTo().window(parentWindowHandle);
	  test.log(LogStatus.INFO, "Switched to parent window handle");
	  if(driver.getTitle().equals("Apple Cinema 30")) {
		  test.log(LogStatus.PASS, "Test Passed- Parent Window Title Matched");
	  }
	  else {
	      test.log(LogStatus.FAIL, "Test Failed- Parent Window Title Mismatched");
	  }
  }
  
  @BeforeMethod
  public void beforeMethod(Method m) {
	  report =new ExtentReports("ExtentReports\\AppleCinemaCart\\"+m.getName()+".html");
	  test=report.startTest(m.getName());
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(baseUrl);
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  report.endTest(test);
	  report.flush();
	  driver.quit();
  }

}
