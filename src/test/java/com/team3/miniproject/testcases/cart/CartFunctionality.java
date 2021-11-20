package com.team3.miniproject.testcases.cart;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.team3.miniproject.sitepages.Cart;
import com.team3.miniproject.sitepages.Header;
import com.team3.miniproject.sitepages.HomePage;
import com.team3.miniproject.sitepages.Tablets;
import com.team3.miniproject.testcases.ddt.AppleCinemaData;

import io.github.bonigarcia.wdm.WebDriverManager;
import screenshot.*;

public class CartFunctionality {
	WebDriver driver;
	String baseUrl = "http://localhost/opencartsite";
	ExtentReports report;
	static ExtentTest test;
	
	//page objects
	HomePage objHomePage;
	Cart objCart;
	Tablets objTablets;
	Header objHeader;
	AppleCinemaData objCinemaData;
	AppleCinema appleCinemaObject;
	
	ScreenShotCapture objScreenshot;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	String timeStamp = new SimpleDateFormat("yyyy_MMM_dd_HH.mm.ss").format(new Date());
	
	// TC_OC_CART_001
  @Test(enabled = false)
  public void testCase001() throws InterruptedException, IOException{
	  objScreenshot = new ScreenShotCapture(driver);
	  test.log(LogStatus.INFO, "TC_OC_CART_001 - To add a product in the cart and verify its addition in the cart.");
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  objHomePage = new HomePage(driver);
	  objHeader = new Header(driver);
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView();", objHomePage.homeProducts.get(0));
	  objHomePage.addProductToCart(0);
	  
	  Thread.sleep(3000);
	  
	  if(objHomePage.successAlert.isDisplayed()) {
		  test.log(LogStatus.PASS, "The alert message about addition of the product to the cart is displayed.");
	  }
	  else {
		  test.log(LogStatus.FAIL, objScreenshot.captureScreenshot("\\AddToCart\\" + "testCase001.1_"+ timeStamp +".PNG") + "The alert message about addition of the product to the cart is not displayed.");
	  }

	  Thread.sleep(5000);
	  objHeader.clickViewCartOption();
	  WebElement productInCart = driver.findElement(By.linkText("MacBook"));
	  if(productInCart.isDisplayed()) {
		  test.log(LogStatus.PASS, "The added product is visible in the cart.");
	  }
	  else {
		  test.log(LogStatus.FAIL, objScreenshot.captureScreenshot("\\AddToCart\\" + "testCase001.2_"+ timeStamp +".PNG") + "The added product is not visible in the cart.");
		  
	  }
	  
}
//  TC_OC_CART_002
  @Test (enabled = true)
  public void testCase002() throws InterruptedException, AWTException, IOException {
	  test.log(LogStatus.INFO, "TC_OC_CART_006 - Adding a product with customizable features to the cart with quantity less than the minimum required quantity.");
	  objScreenshot = new ScreenShotCapture(driver);
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  objHomePage = new HomePage(driver);
	  
	  objCinemaData = new AppleCinemaData();
	  
	  ArrayList<ArrayList<String>> myData = objCinemaData.appleCinemaData();
	  
	  appleCinemaObject = new AppleCinema(driver);

	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView();", objHomePage.homeProducts.get(2));
	  objHomePage.addProductToCart(2); // index 2 for Apple Cinema
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  appleCinemaObject.clickRadioButton();
	  appleCinemaObject.clickCheckbox();	  
	  appleCinemaObject.enterInTextbox(myData.get(0).get(0));
	  	  
	  appleCinemaObject.clickDropdown("4");
	  
	  appleCinemaObject.enterInTextArea(myData.get(0).get(1));
	  
	  if(appleCinemaObject.selectFileForUpload("D:\\Mini Project\\PSLMiniProject\\Resources\\test.txt")) {
		  test.log(LogStatus.PASS, "The driver successfully switched to the alert and clicked OK.");
	  }
	  else {
		  test.log(LogStatus.FAIL, objScreenshot.captureScreenshot("\\AddToCart\\" + "testCase006.1_"+ timeStamp +".PNG") +"The driver did not switch to the alert.");
	  }	
  	  Thread.sleep(2000);
	  appleCinemaObject.enterQuantity("1");
	  appleCinemaObject.clickAddToCart(); 
	  Thread.sleep(2000);
	  
	  if(appleCinemaObject.checkSuccessAlert()) {
		  test.log(LogStatus.FAIL, objScreenshot.captureScreenshot("\\AddToCart\\" + "testCase006.2_"+ timeStamp +".PNG") + "The warning message about the minimum required quantity is not displayed.");
	  }
	  else {
		  test.log(LogStatus.PASS, "The warning message about the minimum required quantity is displayed.");
	  }
	  
  }
  //TC_OC_CART_003
  @Test (enabled = false)
  public void testCase003() throws InterruptedException, IOException {
	  test.log(LogStatus.INFO, "TC_OC_CART_003 - Adding a product which is not in stock to the cart.");
	  objScreenshot = new ScreenShotCapture(driver);
	  objHomePage = new HomePage(driver);
	  objTablets = new Tablets(driver);
	  objCart = new Cart(driver);
	  objHeader = new Header(driver);
	  Thread.sleep(5000);
		
	  objTablets.addTabletToCart();
	  Thread.sleep(5000);
	  
	  WebElement successAlert = driver.findElement(By.cssSelector("#product-category > div.alert.alert-success.alert-dismissible"));
	  if(successAlert.isDisplayed()) {
		  test.log(LogStatus.PASS, "The success message of adding the product to the cart is displayed.");
	  }
	  else {
		  test.log(LogStatus.FAIL, objScreenshot.captureScreenshot("\\AddToCart\\" + "testCase003.1_"+ timeStamp +".PNG") + "The success message for adding the product to the cart is not displayed.");
	  }
	  
	  objHeader.clickShoppingCartLink();
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkout-cart\"]/div[1]")));
	  
	  WebElement AlertMessage=driver.findElement(By.xpath("//*[@id=\"checkout-cart\"]/div[1]"));
	  if(AlertMessage.isDisplayed()) {
		  test.log(LogStatus.PASS, "The warning about the out of stock product in the cart is displayed.");
	  }
	  else {
		  test.log(LogStatus.FAIL, objScreenshot.captureScreenshot("\\AddToCart\\" + "testCase003.2_"+ timeStamp +".PNG") + "The warning about the out of stock product in the cart is not displayed.");
	  }
	  
}
  //TC_OC_CART_004
  @Test (enabled = false)
  public void testCase004() throws InterruptedException, IOException {
	  test.log(LogStatus.INFO, "TC_OC_CART_004 - Removing a product from the cart.");
	  objScreenshot = new ScreenShotCapture(driver);
	  objHomePage = new HomePage(driver);
	  objHeader = new Header(driver);
	  objHomePage.addProductToCart(0);
	  Thread.sleep(5000);
	  
	  if(objHomePage.successAlert.isDisplayed()) {
		  test.log(LogStatus.PASS, "The alert message about addition of the product to the cart is displayed.");
	  }
	  else {
		  test.log(LogStatus.FAIL, objScreenshot.captureScreenshot("\\AddToCart\\" + "testCase004.1_"+ timeStamp +".PNG") + "The alert message about addition of the product to the cart is not displayed.");
		  
	  }
	  
	  objHeader.clickCartDropDown(); 
	  Thread.sleep(5000);
	  objHeader.removeItemFromCart(0);
	  Thread.sleep(5000);
	  
	  if(objHeader.cartDropDown.getText() == "0 item(s) - £0.00") {
		  test.log(LogStatus.PASS, "The product was successfully removed from the cart.");
	  }
	  else {
		  test.log(LogStatus.FAIL, objScreenshot.captureScreenshot("\\AddToCart\\" + "testCase004.2_"+ timeStamp +".PNG") + "The product was not removed from the cart.");
	  }
} 
  //TC_OC_CART_005 - Adding a product to the cart with quantity as zero.
@Test(enabled = false)
  public void testCase005() throws InterruptedException, IOException {
	test.log(LogStatus.INFO, "TC_OC_CART_005 - Adding a product to the cart with quantity as zero.");
	objScreenshot = new ScreenShotCapture(driver);
	 driver.manage().window().maximize();
	 //Click on an item
	 driver.findElement(By.linkText("Desktops")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.linkText("Mac (1)")).click();
	 
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,250)", "");
	 Thread.sleep(2000);
	 
	 driver.findElement(By.linkText("iMac")).click();
	 js.executeScript("window.scrollBy(0,250)", "");
	 Thread.sleep(2000);
	 
	 WebElement qty = driver.findElement(By.id("input-quantity"));
	 qty.clear();
	 Thread.sleep(2000);
	 // Enter Quantity as 0
	 qty.sendKeys("0");
	 Thread.sleep(1000);
	 //Add to cart
	 driver.findElement(By.id("button-cart")).click();
	 Thread.sleep(2000);
	 
	 WebElement successAlert = driver.findElement(By.cssSelector("#product-product > div.alert.alert-success.alert-dismissible"));
	 if(successAlert.isDisplayed()) {
		 test.log(LogStatus.FAIL, objScreenshot.captureScreenshot("\\AddToCart\\" + "testCase005.1_"+ timeStamp +".PNG") + "The warning about the quantity is not displayed.");
	 }
	 else {
		 test.log(LogStatus.PASS, "The warning about the quantity is displayed.");
	 }
  }
//TC_OC_CART_006
  @Test (enabled = true)
  public void testCase006() throws InterruptedException, AWTException, IOException {
	  test.log(LogStatus.INFO, "TC_OC_CART_006 - Adding a product with customizable features to the cart with quantity less than the minimum required quantity.");
	  objScreenshot = new ScreenShotCapture(driver);
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  objHomePage = new HomePage(driver);

	  objCinemaData = new AppleCinemaData();

	  appleCinemaObject = new AppleCinema(driver);

	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  ArrayList<ArrayList<String>> myData = objCinemaData.appleCinemaData();
	  
	  js.executeScript("arguments[0].scrollIntoView();", objHomePage.homeProducts.get(2));
	  objHomePage.addProductToCart(2); // index 2 for Apple Cinema
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  appleCinemaObject.clickRadioButton();
	  appleCinemaObject.clickCheckbox();	  
	  appleCinemaObject.enterInTextbox(myData.get(0).get(0));
	  	  
	  appleCinemaObject.clickDropdown("4");
	  
	  appleCinemaObject.enterInTextArea(myData.get(0).get(1));
	  
	  if(appleCinemaObject.selectFileForUpload("D:\\Mini Project\\PSLMiniProject\\Resources\\test.txt")) {
		  test.log(LogStatus.PASS, "The driver successfully switched to the alert and clicked OK.");
	  }
	  else {
		  test.log(LogStatus.FAIL, objScreenshot.captureScreenshot("\\AddToCart\\" + "testCase006.1_"+ timeStamp +".PNG") + "The driver did not switch to the alert.");
		  
	  }	
  	  Thread.sleep(2000);
	  appleCinemaObject.enterQuantity("1");
	  appleCinemaObject.clickAddToCart(); 
	  Thread.sleep(2000);
	  
	  if(appleCinemaObject.checkSuccessAlert()) {
		  test.log(LogStatus.FAIL, objScreenshot.captureScreenshot("\\AddToCart\\" + "testCase006.2_"+ timeStamp +".PNG") + "The warning message about the minimum required quantity is not displayed.");
	  }
	  else {
		  test.log(LogStatus.PASS, "The warning message about the minimum required quantity is displayed.");
	  }
  }
  //TC_OC_CART_007
   @Test(enabled = false)
  public void testCase007() throws InterruptedException, IOException {
	   test.log(LogStatus.INFO, "TC_OC_CART_007 - Adding a product to the cart but leaving the quantity field blank.");
	   objScreenshot = new ScreenShotCapture(driver);
	 driver.manage().window().maximize();
	 driver.findElement(By.linkText("Phones & PDAs")).click();
	 Thread.sleep(1000);
	 
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,300)", "");
	 Thread.sleep(3000);
	 
	 driver.findElement(By.linkText("HTC Touch HD")).click();
	 js.executeScript("window.scrollBy(0,250)", "");
	 Thread.sleep(2000);
	 
	 WebElement qty = driver.findElement(By.id("input-quantity"));
	 qty.clear();
	 Thread.sleep(2000);
	 driver.findElement(By.id("button-cart")).click();
	 Thread.sleep(2000);
	 
	 WebElement successAlert = driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]"));
	 if(successAlert.isDisplayed()) {
		 test.log(LogStatus.FAIL, objScreenshot.captureScreenshot("\\AddToCart\\" + "testCase007.1_"+ timeStamp +".PNG") + "The warning about the quantity is not displayed.");
	 }
	 else {
		 test.log(LogStatus.PASS, "The warning about the quantity is displayed.");
	 }
  }
   //TC_OC_CART_008
   @Test(enabled = false)
   public void testCase008() throws IOException {
	   try {
 	  test.log(LogStatus.INFO, "TC_OC_CART_008-Add product with customizable features to cart but leave some of the required fields in the features form blank ");
 	  objScreenshot = new ScreenShotCapture(driver);
 	  appleCinemaObject=new AppleCinema(driver); //create a new instance of AppleCinema Class
 	  //click on add to cart button on home page
 	  appleCinemaObject.clickAppleCinemaCart();
 	  //click on radio button
 	  appleCinemaObject.clickRadioButton();
 	  //click on checkbox
 	  appleCinemaObject.clickCheckbox();
 	  //click on add to cart button
 	  appleCinemaObject.clickAddToCart();
 	  //Assert if warning is visible
 	 if(appleCinemaObject.checkMandatoryFieldsWarning().isDisplayed()) {
 		test.log(LogStatus.PASS, "Test Passed- Warning was displayed");
 	 }
 	 else {
 		test.log(LogStatus.FAIL, objScreenshot.captureScreenshot("\\AddToCart\\" + "testCase008.1_"+ timeStamp +".PNG") + "Test Failed- Warning was not displayed");
 	 }
 	  //Check if test Passed or failed
 	  if(appleCinemaObject.checkPageTitle().equals("Apple Cinema 30")) {
 		  test.log(LogStatus.PASS, "Test Passed- Title Matched");
 	  }else {
 		  test.log(LogStatus.FAIL, objScreenshot.captureScreenshot("\\AddToCart\\" + "testCase008.2_"+ timeStamp +".PNG") + "Test Failed- Title Mismatched");
 	  }
	   }catch(Exception e) {
		   test.log(LogStatus.INFO, e);
	   }
   }
   
   
   //TC_OC_CART_010
   @Test(enabled=true)
   public void testCase010() throws InterruptedException, IOException {
	   try {
 	  test.log(LogStatus.INFO, "TC_OC_CART_010-To verify that new window opens when user clicks the Tweet button");
 	  objScreenshot = new ScreenShotCapture(driver);
 	  
 	  appleCinemaObject=new AppleCinema(driver); //create new instance of AppleCinema class
 	  //click on cinema cart
 	  appleCinemaObject.clickAppleCinemaCart();
 	  //wait till title loads
 	  WebDriverWait w =new WebDriverWait(driver, 5);
 	  w.until(ExpectedConditions.titleIs("Apple Cinema 30"));
 	  //get parent window handle
 	  String parentWindowHandle=driver.getWindowHandle();
 	  if(driver.getTitle().equals("Apple Cinema 30")) {
 		  test.log(LogStatus.PASS, "Test Passed- Title Matched");
 	  }
 	  else {
 	      test.log(LogStatus.FAIL, objScreenshot.captureScreenshot("\\AddToCart\\" + "testCase010.1_"+ timeStamp +".PNG") + "Test Failed- Title Mismatched");
 	  }	  
 	  //click on tweet btn
 	  appleCinemaObject.clickTweetBtn();
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
 				  test.log(LogStatus.FAIL, objScreenshot.captureScreenshot("\\AddToCart\\" + "testCase010.2_"+ timeStamp +".PNG") + "Test Failed- Child Window title mismatched");
 			  }
 			  driver.close();
 		  }
 		  else if(parentWindowHandle.equals(childWindow)) {
 			  continue;
 		  }
 		  else {
 			  test.log(LogStatus.FAIL, objScreenshot.captureScreenshot("\\AddToCart\\" + "testCase010.3_"+ timeStamp +".PNG") + "Test Failed- Did not switch to child window");
 			 
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
 	      test.log(LogStatus.FAIL, objScreenshot.captureScreenshot("\\AddToCart\\" + "testCase010.4_"+ timeStamp +".PNG") + "Test Failed- Parent Window Title Mismatched");
 	  }
	   }catch(Exception e) {
		   test.log(LogStatus.INFO, e);
	   }
   }
  @BeforeMethod
  public void beforeMethod(Method m) {
	//Date setup for naming of extent reports and Screenshots
	  WebDriverManager.chromedriver().setup();
	  report =new ExtentReports("ExtentReports\\AddToCart\\"+ m.getName() +"_"+ timeStamp + ".html");
	  test = report.startTest(m.getName());
	  
	  //driver initialisation
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(baseUrl);
	  driver.manage().window().maximize();
   }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  report.endTest(test);
	  report.flush();
	  Thread.sleep(5000);
	  driver.close();
  }

}
