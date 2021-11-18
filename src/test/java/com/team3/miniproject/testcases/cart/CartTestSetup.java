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
	  hpc_object=new AppleCinema(driver);
	  hpc_object.clickAppleCinemaCart("//button[@onclick=\"cart.add('42');\"]");
	  hpc_object.clickRadioButton("//input[@name='option[218]' and @value='6']");
	  hpc_object.clickCheckbox("//input[@name='option[223][]' and @value='10']");
	  hpc_object.clickAddToCart("button-cart");
	  hpc_object.checkMandatoryFieldsWarning("//div[@class='text-danger']");
	  if(hpc_object.checkPageTitle().equals("Apple Cinema 30")) {
		  test.log(LogStatus.PASS, "Test Passed- Title Matched");
	  }else {
		  test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
	  }
  }
  
//TC_OC_CART_009
  @Test
  public void testCase009() throws InterruptedException, IOException {
	  test.log(LogStatus.INFO, "TC_OC_CART_009-To verify that new window opens when user clicks the like button");
	  hpc_object=new AppleCinema(driver);
	  hpc_object.clickAppleCinemaCart("//button[@onclick=\"cart.add('42');\"]");
	 
	  WebDriverWait w =new WebDriverWait(driver, 5);
	  w.until(ExpectedConditions.titleIs("Apple Cinema 30"));
	  
	  String parentWindowHandle=driver.getWindowHandle();
	  //Assert.assertEquals("Apple Cinema 30", driver.getTitle());
	  if(driver.getTitle().equals("Apple Cinema 30")) {
		  test.log(LogStatus.PASS, "Test Passed- Title Matched");
	  }
	  else {
	      test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
	  }
	  hpc_object.clickFbLikeBtn();
	  
	  Set<String> childWindowHandles=driver.getWindowHandles();
	  Iterator<String> itr=childWindowHandles.iterator();  
	  while(itr.hasNext()) {
		  String childWindow=itr.next();
		  if(!parentWindowHandle.equals(childWindow)) {
			  driver.switchTo().window(childWindow);
			  //String childPageTitle=driver.getTitle();
			  w.until(ExpectedConditions.titleIs("Facebook"));
			  test.log(LogStatus.INFO, "Switched to child window handle");
			  //System.out.println("child window handle");
			  //Assert.assertEquals("Facebook", childPageTitle);
			  if(driver.getTitle().equals("Facebook")) {
				  test.log(LogStatus.PASS, "Test Passed- Child window Title matched");
			  }else {
				  test.log(LogStatus.FAIL, "Test Failed- Child Window title mismatched");
			  }
			  driver.close();
		  }
	  }
	  Thread.sleep(3000);//only to visualize the going back to parent window
	  driver.switchTo().window(parentWindowHandle);
	 // Assert.assertEquals("Apple Cinema 30", driver.getTitle());
	  test.log(LogStatus.INFO, "Switched to parent window handle");
	  if(driver.getTitle().equals("Apple Cinema 30")) {
		  test.log(LogStatus.PASS, "Test Passed- Parent Window Title Matched");
	  }
	  else {
	      test.log(LogStatus.FAIL, "Test Failed- Parent Window Title Mismatched");
	  }
  }
  
//TC_OC_CART_010
  @Test
  public void testCase010() throws InterruptedException, IOException {
	  test.log(LogStatus.INFO, "TC_OC_CART_010-To verify that new window opens when user clicks the Tweet button");
	  hpc_object=new AppleCinema(driver);
	  hpc_object.clickAppleCinemaCart("//button[@onclick=\"cart.add('42');\"]");
	  
	  WebDriverWait w =new WebDriverWait(driver, 3);
	  w.until(ExpectedConditions.titleIs("Apple Cinema 30"));
	  
	  String parentWindowHandle=driver.getWindowHandle();
	  //System.out.println(parentWindowHandle);
	  //Assert.assertEquals("Apple Cinema 30", driver.getTitle());
	  if(driver.getTitle().equals("Apple Cinema 30")) {
		  test.log(LogStatus.PASS, "Test Passed- Title Matched");
	  }
	  else {
	      test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
	  }
	  
	  hpc_object.clickTweetBtn();
	  
	  Set<String> childWindowHandles=driver.getWindowHandles();
	 // System.out.println(childWindowHandles);
	  Iterator<String> itr=childWindowHandles.iterator();  
	  while(itr.hasNext()) {
		  String childWindow=itr.next();
		  if(!parentWindowHandle.equals(childWindow)) {
			  driver.switchTo().window(childWindow);
			  //String childPageTitle=driver.getTitle();
			  w.until(ExpectedConditions.titleIs("Twitter"));
			  //Assert.assertEquals("Twitter", childPageTitle);
			  test.log(LogStatus.INFO, "Switched to child window handle");
			  //System.out.println("child window handle");
			  //Assert.assertEquals("Facebook", childPageTitle);
			  if(driver.getTitle().equals("Twitter")) {
				  test.log(LogStatus.PASS, "Test Passed- Child window Title matched");
			  }else {
				  test.log(LogStatus.FAIL, "Test Failed- Child Window title mismatched");
			  }
			  driver.close();
		  }
	  }
	  Thread.sleep(3000); //only to visualize the going back to parent window
	  driver.switchTo().window(parentWindowHandle);
	  //Assert.assertEquals("Apple Cinema 30", driver.getTitle());
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
