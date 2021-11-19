package com.team3.miniproject.testcases.checkout;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.team3.miniproject.sitepages.CheckoutPage;
import com.team3.miniproject.sitepages.LoginPage;
import com.team3.miniproject.testcases.ddt.ReadInputs;
import com.team3.miniproject.sitepages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
//import sitepages.LoginPage;
//import com.teasitepages.CheckoutPage;



public class CheckoutTestSetup {
	WebDriver driver;
	CheckoutPage checkout;
	LoginPage login;

	HomePage objHomePage;
	ReadInputs reader= new ReadInputs();

	ExtentReports report;
	ExtentTest test;
	

	//TC_OC_CE_001
  @Test(enabled=false)
  public void testCase1() throws InterruptedException {
	  
	  Thread.sleep(5000);
	  login.login("tester1@gmail.com", "tester123");
	  Assert.assertEquals(checkout.checkIfUserLoggedIn(), true,"User is logged in!");
	  Assert.assertEquals(checkout.checkIfCartIsEmpty(),true,"Cart is Empty!");
	  checkout.checkout();
	  //Assert user is redirected to shopping cart page
	  Assert.assertEquals(driver.getTitle(), "Shopping Cart");
	  //Assert "Your shopping cart is empty" message is displayed 
	  Assert.assertEquals(driver.findElement(By.cssSelector("#content > p")).getText(),"Your shopping cart is empty!");
	  login.logout();
  }
//TC_OC_CF_001
  @Test(enabled=false)
  public void testCase01() throws InterruptedException {
	  
	  login.login("tester234@gmail.com", "tester234");
	  Assert.assertEquals(checkout.checkIfUserLoggedIn(), true);
	  checkout.navigateToHomepage();
	  objHomePage.addIphoneToCart();
	  Assert.assertEquals(checkout.checkIfCartIsEmpty(),false);
	  checkout.checkout();
	  //Assert "Your shopping cart is empty" message is displayed
	  checkout.enterNewBillingDetails(1);
	  //Assert Warning is displayed
	  WebElement we1= driver.findElement(By.className("text-danger"));
	  Assert.assertEquals(we1.getText(), "Last Name must be between 1 and 32 characters!","Warning Appears!");
	    JavascriptExecutor js = (JavascriptExecutor)driver;
      js.executeScript("arguments[0].scrollIntoView(true)", we1);
      Thread.sleep(3000);
    //Assert following links are not clickable
      WebElement we2= driver.findElement(By.xpath("//*[@id='accordion']/div[6]/div[1]"));
      js.executeScript("arguments[0].scrollIntoView(true)", we2);
	  Assert.assertEquals(checkout.isClickable(By.xpath("//*[@id='accordion']/div[3]/div[1]/h4/a")),false);
	  Assert.assertEquals(checkout.isClickable(By.xpath("//*[@id='accordion']/div[4]/div[1]/h4/a")),false);
	  Assert.assertEquals(checkout.isClickable(By.xpath("//*[@id='accordion']/div[5]/div[1]/h4/a")),false);
	  Assert.assertEquals(checkout.isClickable(By.xpath("//*[@id='accordion']/div[6]/div[1]/h4/a")),false);
	  login.logout();
  }
//TC_OC_CF_002
   @Test(enabled=true)
  public void testCase002() throws InterruptedException {
	  login.login("tester234@gmail.com", "tester234");
	  Assert.assertEquals(checkout.checkIfUserLoggedIn(), true);
	  checkout.navigateToHomepage();
	  objHomePage.addIphoneToCart();
	  Assert.assertEquals(checkout.checkIfCartIsEmpty(),false);
	  checkout.checkout();
	  checkout.enterNewBillingDetails(2);
	  //Assert Warning is displayed
	  WebElement we = driver.findElement(By.className("text-danger"));
	  Assert.assertEquals(we.getText(), "Please enter a valid Postal Code!","Warning Appears!");
	  JavascriptExecutor js = (JavascriptExecutor)driver;
      js.executeScript("arguments[0].scrollIntoView(true)", we);
      Thread.sleep(5000);
	  //login.logout();
	 
  }
 //TC_OC_CF_003
	@Test(enabled=false)
    public void testCase003() throws InterruptedException {
	  login.login("tester234@gmail.com", "tester234");
	  Assert.assertEquals(checkout.checkIfUserLoggedIn(), true);
	  checkout.navigateToHomepage();
	  objHomePage.addIphoneToCart();
	  Assert.assertEquals(checkout.checkIfCartIsEmpty(),false);
	  checkout.checkout();
	  Thread.sleep(5000); //delete if not necessary
	  //Assert user is redirected to checkout page
	  Assert.assertEquals(driver.getTitle(), "Checkout");
	  checkout.enterNewBillingDetails(2);
	  checkout.enterExistingDeliveryDetailsAndContinue();
	  checkout.enterDeliveryMethodAndContinue();
	  checkout.enterPaymentMethod(); //Did not agree to Terms and Conditions
	  driver.findElement(By.id("button-payment-method")).click();
	  //Assert Warning is displayed
	  Assert.assertEquals(driver.findElement(By.xpath("//*[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: You must agree to the Terms & Conditions!"),true);
	 
	  //login.logout();
  }
	//TC_OC_CF_004
	@Test(enabled=false)
  public void testCase004() throws InterruptedException {
		
	  login.login("tester234@gmail.com", "tester234");
	  Assert.assertEquals(checkout.checkIfUserLoggedIn(), true);
	  checkout.navigateToHomepage();
	  objHomePage.addIphoneToCart();
	  Assert.assertEquals(checkout.checkIfCartIsEmpty(),false);
	  checkout.checkout();
	  //Assert user is redirected to checkout page
	  Thread.sleep(5000);
	  Assert.assertEquals(driver.getTitle(),"Checkout");
	  checkout.enterNewBillingDetails(2);
	  checkout.enterExistingDeliveryDetailsAndContinue();
	  checkout.enterDeliveryMethodAndContinue();
	  checkout.enterPaymentMethod(); //Did not agree to Terms and Conditions
	  checkout.agreeToTermsAndConditionsAndContinue();
	  checkout.confirmOrder();
	  Thread.sleep(10000);
	  Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		Thread.sleep(2000);
		alert1.accept();
		Thread.sleep(2000);
		System.out.println("Alert Accepted");
		checkout.confirmOrder();
		Thread.sleep(5000);
	  Assert.assertEquals(driver.getTitle(), "Your order has been placed!");
	 // login.logout();
  }
	
	
	//TC_OC_CF_005
	@Test(enabled=false)
	public void testCase005() {

		  login.login("tester234@gmail.com", "tester234");
		  test.log(LogStatus.INFO, "TC_OC_CF_005-to test if the placeholders are present on all the input fields under billing details");
		  Assert.assertEquals(checkout.checkIfUserLoggedIn(), true);
		  //method to navigate to home page
		  checkout.navigateToHomepage();
		  objHomePage.addIphoneToCart();
		  checkout.checkout();
		  //get placeholder text and store in variables
		  String fnamePlaceholder=driver.findElement(By.id("input-payment-firstname")).getAttribute("placeholder");
		  String lnamePlaceholder=driver.findElement(By.id("input-payment-lastname")).getAttribute("placeholder");
		  String company=driver.findElement(By.id("input-payment-company")).getAttribute("placeholder");
		  String address1=driver.findElement(By.id("input-payment-address-1")).getAttribute("placeholder");
		  String city=driver.findElement(By.id("input-payment-city")).getAttribute("placeholder");
		  String postCode=driver.findElement(By.id("input-payment-postcode")).getAttribute("placeholder");
		  //assert if the placeholders are present
		  if(fnamePlaceholder.equals("")&& lnamePlaceholder.equals("")&&company.equals("")&&address1.equals("")&&city.equals("")&&postCode.equals("")) {
			  test.log(LogStatus.FAIL, "Test Failed- Placeholders are not present on billing form");
		  }
		  else {
			  test.log(LogStatus.PASS, "Test Passed- Placeholders are present on billing form");
		  }
		  
	}
	
	
	//TC_OC_CF_006
	@Test(enabled=false)
	public void testCase006() {
		  test.log(LogStatus.INFO, "TC_OC_CF_006-To test if city field accepts less than 2 characters and we can proceed to step 3");
		  login.login("demo4@example.com", "test1234");
		  //assert if user is logged in
		  Assert.assertEquals(checkout.checkIfUserLoggedIn(), true);
		  checkout.navigateToHomepage();
		  objHomePage.addIphoneToCart();
		  checkout.checkout();
		  checkout.enterNewBillingDetails(3);
		  Assert.assertEquals("Step 3: Delivery Details", driver.findElement(By.xpath("//h4[text()='Step 3: Delivery Details']")).getText());
		  Assert.assertTrue(driver.findElement(By.xpath("//div[text()='City must be between 2 and 128 characters!']")).isDisplayed());
		  String step3Heading=driver.findElement(By.xpath("//h4[text()='Step 3: Delivery Details']")).getText();
		  //check for the test cases
		  if(step3Heading.equals("Step 3: Delivery Details")) {
			  test.log(LogStatus.PASS, "Test Passed-Cannot proceed to next form");
		  }
		  else {
			  test.log(LogStatus.FAIL, "Test Failed-Can proceed to next form");
		  }
		  Boolean warningPresence=driver.findElement(By.xpath("//div[text()='City must be between 2 and 128 characters!']")).isDisplayed();
		  if(warningPresence) {
			  test.log(LogStatus.PASS, "Test Passed-Warning is Present");
		  }else {
			  test.log(LogStatus.FAIL, "Test Failed-Warning is not present");
		  }
	}
	
	
	//TC_OC_CF_007
	@Test
	public void testCase007() {
		  test.log(LogStatus.INFO, "TC_OC_CF_007-to test if lastname can be more than 32 characters");
		  login.login("demo4@example.com", "test1234");
		  Assert.assertEquals(checkout.checkIfUserLoggedIn(), true);
		  //to go to home page
		  checkout.navigateToHomepage();
		  objHomePage.addIphoneToCart();
		  checkout.checkout();

		  checkout.enterNewBillingDetails(4);
		  Assert.assertEquals("Step 3: Delivery Details", driver.findElement(By.xpath("//h4[text()='Step 3: Delivery Details']")).getText());
		  Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Last Name must be between 1 and 32 characters!']")).isDisplayed());
	
		  //check for test cases
		  String step3Heading=driver.findElement(By.xpath("//h4[text()='Step 3: Delivery Details']")).getText();
		  if(step3Heading.equals("Step 3: Delivery Details")) {
			  test.log(LogStatus.PASS, "Test Passed-Cannot proceed to next form");
		  }
		  else {
			  test.log(LogStatus.FAIL, "Test Failed-Can proceed to next form");
		  }
		  Boolean warningPresence=driver.findElement(By.xpath("//div[text()='Last Name must be between 1 and 32 characters!']")).isDisplayed();
		  if(warningPresence) {
			  test.log(LogStatus.PASS, "Test Passed-Warning is Present");
		  }else {
			  test.log(LogStatus.FAIL, "Test Failed-Warning is not present");
		  }
    }

	
	
  @BeforeMethod
  public void beforeMethod(Method m) {
	  String timeStamp = new SimpleDateFormat("yyyy_MMM_dd_HH.mm.ss").format(new Date());
	  report =new ExtentReports("ExtentReports\\Checkout\\"+m.getName()+"_"+timeStamp+".html");
	  test=report.startTest(m.getName());
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  login=new LoginPage(driver);
	  checkout=new CheckoutPage(driver);
	  login.navigateToLogin();	
	  objHomePage=new HomePage(driver);
	  
  }

  @AfterMethod
  public void afterMethod(Method m) throws InterruptedException {
	  report.endTest(test);
	  report.flush();
	  Thread.sleep(5000);
	  checkout.closeBrowser();
  }

}

