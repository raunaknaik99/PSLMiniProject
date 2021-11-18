package com.team3.miniproject.testcases.cart;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CartFunctionality {
	WebDriver driver;
	String baseUrl = "http://localhost";
	ExtentReports report;
	static ExtentTest test;
	
	//page objects
	HomePage objHomePage;
	Cart objCart;
	Tablets objTablets;
	Header objHeader;
	AppleCinema hpc_object;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	// TC_OC_CART_001
  @Test(enabled = true)
  public void cart_TC001() throws InterruptedException{
	  test.log(LogStatus.INFO, "TC_OC_CART_001 - To add a product in the cart and verify its addition in the cart.");
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  objHomePage = new HomePage(driver);
	  objHeader = new Header(driver);
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView();", objHomePage.addMacbook);
	  objHomePage.addMacbookToCart();
	  
	  Thread.sleep(3000);
	  
	  if(objHomePage.successAlert.isDisplayed()) {
		  test.log(LogStatus.PASS, "The alert message about addition of the product to the cart is displayed.");
	  }
	  else {
		  test.log(LogStatus.FAIL, "The alert message about addition of the product to the cart is not displayed.");
	  }

	  Thread.sleep(5000);
	  objHeader.clickViewCartOption();
	  WebElement productInCart = driver.findElement(By.linkText("MacBook"));
	  if(productInCart.isDisplayed()) {
		  test.log(LogStatus.PASS, "The added product is visible in the cart.");
	  }
	  else {
		  test.log(LogStatus.FAIL, "The added product is not visible in the cart.");
	  }
	  
}
  //TC_OC_CART_002
  @Test (enabled = true)
  public void cart_TC002() throws InterruptedException, AWTException {
	  test.log(LogStatus.INFO, "TC_OC_CART_002 - Adding a product with customizable features to the cart.");
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  objHomePage = new HomePage(driver);
	  hpc_object = new AppleCinema(driver);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView();", objHomePage.addCinema);
	  objHomePage.addCinemaToCart();
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  hpc_object.clickRadioButton("//input[@name='option[218]' and @value='5']");
	  hpc_object.clickCheckbox("//input[@name='option[223][]' and @value='8']");	  
	  hpc_object.enterInTextbox("test");
	  	  
	  hpc_object.clickDropdown("4");

	  hpc_object.enterInTextArea("This is a test order");
	  
	  hpc_object.selectFileForUpload("D:\\Mini Project\\PSLMiniProject\\Resources\\test.txt");	  
	  
	  Thread.sleep(2000);
	  hpc_object.enterQuantity("2");
	  hpc_object.clickAddToCart("button-cart");
	  Thread.sleep(2000);
	  if(hpc_object.checkSuccessAlert()) {
		  test.log(LogStatus.PASS, "The success message for adding Apple Cinema to the cart was displayed.");
	  }
	  else {
		  test.log(LogStatus.INFO, "The success message for adding Apple Cinema to the cart was not displayed.");
	  }
	  
  }
  //TC_OC_CART_003
  @Test (enabled = true)
  public void Cart_TC003() throws InterruptedException {
	  test.log(LogStatus.INFO, "TC_OC_CART_003 - Adding a product which is not in stock to the cart.");
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
		  test.log(LogStatus.FAIL, "The success message for adding the product to the cart is not displayed.");
	  }
	  
	  objHeader.clickShoppingCartLink();
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkout-cart\"]/div[1]")));
	  
	  WebElement AlertMessage=driver.findElement(By.xpath("//*[@id=\"checkout-cart\"]/div[1]"));
	  if(AlertMessage.isDisplayed()) {
		  test.log(LogStatus.PASS, "The warning about the out of stock product in the cart is displayed.");
	  }
	  else {
		  test.log(LogStatus.FAIL, "The warning about the out of stock product in the cart is not displayed.");
	  }
	  
}
  //TC_OC_CART_004
  @Test (enabled = true)
  public void Cart_TC004() throws InterruptedException {
	  test.log(LogStatus.INFO, "TC_OC_CART_004 - Removing a product from the cart.");
	  objHomePage = new HomePage(driver);
	  objHeader = new Header(driver);
	  objHomePage.addMacbookToCart();
	  Thread.sleep(5000);
	  
	  if(objHomePage.successAlert.isDisplayed()) {
		  test.log(LogStatus.PASS, "The alert message about addition of the product to the cart is displayed.");
	  }
	  else {
		  test.log(LogStatus.FAIL, "The alert message about addition of the product to the cart is not displayed.");
	  }
	  
	  objHeader.clickCartDropDown(); 
	  Thread.sleep(5000);
	  objHeader.removeItemFromCart(0);
	  Thread.sleep(5000);
	  
	  if(objHeader.cartDropDown.getText() == " 0 item(s) - $0.00") {
		  test.log(LogStatus.PASS, "The product was successfully removed from the cart.");
	  }
	  else {
		  test.log(LogStatus.FAIL, "The product was not removed from the cart.");
	  }
} 
  //TC_OC_CART_005
@Test(enabled = true)
  public void cart_TC005() throws InterruptedException {
	test.log(LogStatus.INFO, "TC_OC_CART_005 - Adding a product to the cart with quantity as zero.");
	 driver.manage().window().maximize();
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
	 qty.sendKeys("0");
	 Thread.sleep(1000);
	 driver.findElement(By.id("button-cart")).click();
	 Thread.sleep(2000);
	 
	 WebElement successAlert = driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]"));
	 if(successAlert.isDisplayed()) {
		 test.log(LogStatus.FAIL, "The warning about the quantity is not displayed.");
	 }
	 else {
		 test.log(LogStatus.PASS, "The warning about the quantity is displayed.");
	 }
  }
//TC_OC_CART_006
  @Test (enabled = true)
  public void cart_TC006() throws InterruptedException, AWTException {
	  test.log(LogStatus.INFO, "TC_OC_CART_006 - Adding a product with customizable features to the cart with quantity less than the minimum required quantity.");
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  objHomePage = new HomePage(driver);
	  hpc_object = new AppleCinema(driver);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView();", objHomePage.addCinema);
	  objHomePage.addCinemaToCart();
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  hpc_object.clickRadioButton("//input[@name='option[218]' and @value='5']");
	  hpc_object.clickCheckbox("//input[@name='option[223][]' and @value='8']");	  
	  hpc_object.enterInTextbox("test");
	  	  
	  hpc_object.clickDropdown("4");
	  
	  hpc_object.enterInTextArea("This is a test order");
	  
	  hpc_object.selectFileForUpload("D:\\Mini Project\\PSLMiniProject\\Resources\\test.txt");	
  	  Thread.sleep(2000);
	  hpc_object.enterQuantity("1");
	  hpc_object.clickAddToCart("button-cart"); 
	  Thread.sleep(2000);
	  
	  if(hpc_object.checkSuccessAlert()) {
		  test.log(LogStatus.FAIL, "The warning message about the minimum required quantity is not displayed.");
	  }
	  else {
		  test.log(LogStatus.FAIL, "The warning message about the minimum required quantity is displayed.");
	  }
  }
  //TC_OC_CART_007
   @Test(enabled = true)
  public void cart_TC007() throws InterruptedException {
	   test.log(LogStatus.INFO, "TC_OC_CART_007 - Adding a product to the cart but leaving the quantity field blank.");
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
		 test.log(LogStatus.FAIL, "The warning about the quantity is not displayed.");
	 }
	 else {
		 test.log(LogStatus.PASS, "The warning about the quantity is displayed.");
	 }
  }
   //TC_OC_CART_008
   @Test(enabled = true)
   public void testCase008() {
 	  test.log(LogStatus.INFO, "TC_OC_CART_008-Add product with customizable features to cart but leave some of the required fields in the features form blank ");
 	  hpc_object=new AppleCinema(driver); //create a new instance of AppleCinema Class
 	  //click on add to cart button on home page
 	  hpc_object.clickAppleCinemaCart("//button[@onclick=\"cart.add('42');\"]");
 	  //click on radio button
 	  hpc_object.clickRadioButton("//input[@name='option[218]' and @value='6']");
 	  //click on checkbox
 	  hpc_object.clickCheckbox("//input[@name='option[223][]' and @value='10']");
 	  //click on add to cart button
 	  hpc_object.clickAddToCart("button-cart");
 	  //Assert if warning is visible
 	  hpc_object.checkMandatoryFieldsWarning("//div[@class='text-danger']");
 	  //Check if test Passed or failed
 	  if(hpc_object.checkPageTitle().equals("Apple Cinema 30")) {
 		  test.log(LogStatus.PASS, "Test Passed- Title Matched");
 	  }else {
 		  test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
 	  }
   }
   
   //TC_OC_CART_009
   @Test(enabled = true)
   public void testCase009() throws InterruptedException, IOException {
 	  test.log(LogStatus.INFO, "TC_OC_CART_009-To verify that new window opens when user clicks the like button");
 	  hpc_object=new AppleCinema(driver); //create an instance of AppleCart class
 	  //click on cinema cart
 	  hpc_object.clickAppleCinemaCart("//button[@onclick=\"cart.add('42');\"]");
 	  //wait till title loads
 	  WebDriverWait w =new WebDriverWait(driver, 5);
 	  w.until(ExpectedConditions.titleIs("Apple Cinema 30"));
 	  //get parent window handle
 	  String parentWindowHandle=driver.getWindowHandle();
 	  if(driver.getTitle().equals("Apple Cinema 30")) {
 		  test.log(LogStatus.PASS, "Test Passed- Title Matched");
 	  }
 	  else {
 	      test.log(LogStatus.FAIL, "Test Failed- Title Mismatched");
 	  }
 	  //click on like btn
 	  hpc_object.clickFbLikeBtn();
 	  //get all the window handles
 	  Set<String> childWindowHandles=driver.getWindowHandles();
 	  Iterator<String> itr=childWindowHandles.iterator();  
 	  while(itr.hasNext()) {
 		  String childWindow=itr.next();
 		  //switch over to child handle
 		  if(!parentWindowHandle.equals(childWindow)) {
 			  driver.switchTo().window(childWindow);
 			  w.until(ExpectedConditions.titleIs("Facebook"));
 			  test.log(LogStatus.INFO, "Switched to child window handle");
 			  if(driver.getTitle().equals("Facebook")) {
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
 	  Thread.sleep(3000);//only to visualize the going back to parent window
 	  //switch back to parent window handle
 	  driver.switchTo().window(parentWindowHandle);
 	  test.log(LogStatus.INFO, "Switched to parent window handle");
 	  //verify is test passed or failed
 	  if(driver.getTitle().equals("Apple Cinema 30")) {
 		  test.log(LogStatus.PASS, "Test Passed- Parent Window Title Matched");
 	  }
 	  else {
 	      test.log(LogStatus.FAIL, "Test Failed- Parent Window Title Mismatched");
 	  }
   }
   
   //TC_OC_CART_010
   @Test(enabled=true)
   public void testCase010() throws InterruptedException, IOException {
 	  test.log(LogStatus.INFO, "TC_OC_CART_010-To verify that new window opens when user clicks the Tweet button");
 	  
 	  hpc_object=new AppleCinema(driver); //create new instance of AppleCinema class
 	  //click on cinema cart
 	  hpc_object.clickAppleCinemaCart("//button[@onclick=\"cart.add('42');\"]");
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
	//Date setup for naming of extent reports and Screenshots
	  WebDriverManager.chromedriver().setup();
	  String timeStamp = new SimpleDateFormat("yyyy_MMM_dd_HH.mm.ss").format(new Date());
	  report =new ExtentReports("ExtentReports\\AddToCart\\"+ m.getName() +"_"+ timeStamp + ".html");
	  test=report.startTest(m.getName());
	  
	  //driver initialisation
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(baseUrl);
	  driver.manage().window().maximize();
   }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.close();
  }

}
