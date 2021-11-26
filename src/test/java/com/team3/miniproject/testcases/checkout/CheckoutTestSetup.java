package com.team3.miniproject.testcases.checkout;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.team3.miniproject.base.BrowserSetup;
import com.team3.miniproject.sitepages.CheckoutPage;
import com.team3.miniproject.sitepages.LoginPage;
import com.team3.miniproject.testcases.ddt.LoginData;
import com.team3.miniproject.testcases.ddt.ReadInputs;
import com.team3.miniproject.sitepages.HomePage;
//import io.github.bonigarcia.wdm.WebDriverManager;
import screenshot.ScreenShotCapture;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
//import sitepages.LoginPage;
//import com.teasitepages.CheckoutPage;
import org.testng.annotations.BeforeClass;



public class CheckoutTestSetup extends BrowserSetup{
//	WebDriver driver;
	CheckoutPage checkout;
	LoginPage login;

	HomePage objHomePage;
	ReadInputs reader= new ReadInputs();
	ExtentReports report;
	ExtentTest test;
	ScreenShotCapture s;
	String timeStamp = new SimpleDateFormat("yyyy_MMM_dd_HH.mm.ss").format(new Date());
	LoginData rd;
	

	//TC_OC_CE_001 - To implement the checkout functionality when the cart is empty

	@Test(enabled=true,priority=1)
	public void testCase1() throws InterruptedException, IOException {
		
		test.log(LogStatus.INFO, "TC_OC_CE_001-To implement the checkout functionality when the cart is empty");
		s = new ScreenShotCapture(driver);
		Thread.sleep(5000);
		reader.i = 5;
		login.login(reader.getEmailId(), reader.getPassword());
		//Asserting that user is logged in
		Assert.assertEquals(checkout.checkIfUserLoggedIn(), true,"User is logged in!");
		test.log(LogStatus.PASS, "User is logged in!");
		//Asserting that cart is empty
		Assert.assertEquals(checkout.checkIfCartIsEmpty(),true,"Cart is Empty!");
		test.log(LogStatus.PASS, "Cart is Empty!");
		checkout.checkout();
		//Assert user is redirected to shopping cart page
		Assert.assertEquals(driver.getTitle(), "Shopping Cart");
		test.log(LogStatus.PASS, "User is redirected to Shopping cart Page");
		//Assert "Your shopping cart is empty" message is displayed 
		Assert.assertEquals(driver.findElement(By.cssSelector("#content > p")).getText(),"Your shopping cart is empty!");
		if(driver.findElement(By.cssSelector("#content > p")).getText().equals("Your shopping cart is empty!"))
			test.log(LogStatus.PASS, "Test Passed - The user is redirected to the shopping cart page and message appears: 'Your shopping cart is empty!'");
		else
			test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\Checkout\\testCase1" + timeStamp + ".PNG"))+ "Test Fails - The user can proceed to checkout despite shopping cart being empty!");
		login.logout();
	}
	//TC_OC_CF_001 - User clicks on checkout, but does not fill a mandatory field

    @Test(enabled=true,priority=2)

	public void testCase001() throws InterruptedException, IOException {
		test.log(LogStatus.INFO, "TC_OC_CF_001 - User clicks on checkout, but does not fill a mandatory field");
		s = new ScreenShotCapture(driver);
		reader.i = 12;
		login.login(reader.getEmailId(), reader.getPassword());
		//Asserting that user is logged in 
		Assert.assertEquals(checkout.checkIfUserLoggedIn(), true);
		test.log(LogStatus.PASS, "Login Check passed - The user is logged in.");
		checkout.navigateToHomepage();
		objHomePage.addProductToCart(1);
		Thread.sleep(3000);
		//Asserting that cart is not empty
		Assert.assertEquals(checkout.checkIfCartIsEmpty(),false);
		test.log(LogStatus.PASS, "Cart is not empty!");
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
		Assert.assertEquals(checkout.isClickable(By.cssSelector("#accordion > div:nth-child(3) > div.panel-heading > h4 > a")),false);
		Assert.assertEquals(checkout.isClickable(By.cssSelector("#accordion > div:nth-child(4) > div.panel-heading > h4 > a")),false);
		Assert.assertEquals(checkout.isClickable(By.cssSelector("#accordion > div:nth-child(5) > div.panel-heading > h4 > a")),false);
		Assert.assertEquals(checkout.isClickable(By.cssSelector("#accordion > div:nth-child(6) > div.panel-heading > h4 > a")),false);
		if(we1.getText().equals("Last Name must be between 1 and 32 characters!"))
			test.log(LogStatus.PASS, "Test Passed - Warning appears: 'Last Name must be between 1 and 32 characters!' and user is not allowed to proceed. Following headers are not clickable");
		else
			test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\Checkout\\testCase001" + timeStamp + ".PNG"))+"Test Failed - Warning does not appear and user is allowed to proceed. Following headers are clickable");

		login.logout();
	}
	//TC_OC_CF_002 - User clicks on checkout, but does not enter an alphanumeric postal code

	@Test(enabled=true,priority=3)

	public void testCase002() throws InterruptedException, IOException {
		test.log(LogStatus.INFO, "User clicks on checkout, but does not enter an alphanumeric postal code");
		s = new ScreenShotCapture(driver);
		reader.i = 12;
		login.login(reader.getEmailId(), reader.getPassword());
		//Assert user is Logged in
		Assert.assertEquals(checkout.checkIfUserLoggedIn(), true);
		test.log(LogStatus.PASS, "User is Logged in");
		checkout.navigateToHomepage();
		objHomePage.addProductToCart(1);
		Thread.sleep(3000);
		//Assert cart is not empty
		Assert.assertEquals(checkout.checkIfCartIsEmpty(),false);
		test.log(LogStatus.PASS, "Cart is not empty");
		checkout.checkout();
		checkout.enterNewBillingDetails(2);
		
		//Assert Warning is displayed
		
		try {
		if(driver.findElement(By.className("text-danger")).isDisplayed())
			test.log(LogStatus.PASS, "Test Passed- Warning appears!");
		}
		catch(Exception e) {	
			test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\Checkout\\testCase002" + timeStamp + ".PNG"))+"Test Failed- Warning does not appear. User is allowed to proceed.");
		}
		

	}
	//TC_OC_CF_003 - User clicks on checkout, enters all details uptil Payment method, but does not check 'Terms and Conditions

	@Test(enabled=true,priority=4)

	public void testCase003() throws InterruptedException, IOException {
		test.log(LogStatus.INFO, "User clicks on checkout, enters all details uptil Payment method, but does not check 'Terms and Conditions'");
		s = new ScreenShotCapture(driver);
		reader.i = 12;
		login.login(reader.getEmailId(), reader.getPassword());
		//Asserting user is logged in
		Assert.assertEquals(checkout.checkIfUserLoggedIn(), true);
		test.log(LogStatus.PASS, "User is Logged in");
		checkout.navigateToHomepage();
		objHomePage.addProductToCart(1);
		Thread.sleep(3000);
		//Asserting cart is not empty
		Assert.assertEquals(checkout.checkIfCartIsEmpty(),false);
		test.log(LogStatus.PASS, "Cart is not empty");
		checkout.checkout();
		checkout.enterNewBillingDetails(2);
		checkout.enterExistingDeliveryDetailsAndContinue();
		checkout.enterDeliveryMethodAndContinue();
		checkout.enterPaymentMethod(); //Did not agree to Terms and Conditions
		driver.findElement(By.id("button-payment-method")).click();
		//Assert Warning is displayed
		if (driver.findElement(By.cssSelector("[class='alert alert-danger alert-dismissible']")).getText().contains("Warning: You must agree to the Terms & Conditions!"))
			test.log(LogStatus.PASS, "Test Passed - Warning appears:You must agree to the Terms & Conditions! ");
		else
			test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\Checkout\\testCase003" + timeStamp + ".PNG"))+"Test Failed - Warning does not appear. User is allowed to proceed. ");
		//login.logout();
	}

	//TC_OC_CF_004 - User enters all details up till Payment method, checks 'Terms and Conditions' and confirms order

	@Test(enabled=true,priority=5)

	public void testCase004() throws InterruptedException, IOException {
		test.log(LogStatus.INFO, "User enters all details uptil Payment method, checks 'Terms and Conditions' and confirms order");
		s = new ScreenShotCapture(driver);
		reader.i = 12;
		login.login(reader.getEmailId(), reader.getPassword());
		//Asserting user is logged in
		Assert.assertEquals(checkout.checkIfUserLoggedIn(), true);
		test.log(LogStatus.PASS, "User is Logged in");
		checkout.navigateToHomepage();
		objHomePage.addProductToCart(1);
		Thread.sleep(3000);
		//Asserting cart is not empty
		Assert.assertEquals(checkout.checkIfCartIsEmpty(),false);
		test.log(LogStatus.PASS, "Cart is not empty");
		checkout.checkout();
		checkout.enterNewBillingDetails(2);
		checkout.enterExistingDeliveryDetailsAndContinue();
		checkout.enterDeliveryMethodAndContinue();
		checkout.enterPaymentMethod(); 
		checkout.agreeToTermsAndConditionsAndContinue();
		checkout.confirmOrder();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Your order has been placed!");
		if(driver.getTitle().equals("Your order has been placed!"))
			test.log(LogStatus.PASS, "Test Passed - User is redirected to Checkout success page and message is displayed.");
		else
			test.log(LogStatus.FAIL,test.addScreenCapture(s.captureScreenshot("\\Checkout\\testCase004" + timeStamp + ".PNG"))+ "Test Failed - Checkout unsuccessful");
		
	}


	//TC_OC_CF_005
	@Test(enabled=true,priority=6)
	public void testCase005() {
		s=new ScreenShotCapture(driver);
		test.log(LogStatus.INFO, "TC_OC_CF_005-to test if the placeholders are present on all the input fields under billing details");

		try {
//			rd=new LoginData();
//			ArrayList<ArrayList<String>> myData = rd.loginData();
//			//System.out.println(myData);
//			login.login(myData.get(6).get(0), myData.get(6).get(1));
			reader.i = 6;
			login.login(reader.getEmailId(), reader.getPassword());
			if(checkout.checkIfUserLoggedIn()) {
				test.log(LogStatus.PASS,"Test Passed- user is logged in");
			}
			else {
				test.log(LogStatus.FAIL,test.addScreenCapture(s.captureScreenshot("\\Checkout\\" + "testCase005.1_"+ timeStamp +".PNG"))+ "Test failed- User Logged");
				
			}			//method to navigate to home page
			checkout.navigateToHomepage();
			objHomePage.addProductToCart(1);
			checkout.checkout();
			//get placeholder text and store in variables
			String fnamePlaceholder=checkout.getFnameElement().getAttribute("placeholder");
			String lnamePlaceholder=checkout.getLnameElement().getAttribute("placeholder");
			String company=checkout.getCompanyElement().getAttribute("placeholder");
			String address1=checkout.getAddress1().getAttribute("placeholder");
			String city=checkout.getCity().getAttribute("placeholder");
			String postCode=checkout.getPostCode().getAttribute("placeholder");
			//assert if the placeholders are present
			if(fnamePlaceholder.equals("")&& lnamePlaceholder.equals("")&&company.equals("")&&address1.equals("")&&city.equals("")&&postCode.equals("")) {
				test.log(LogStatus.FAIL,test.addScreenCapture(s.captureScreenshot("\\Checkout\\" + "testCase005.2_"+ timeStamp +".PNG"))+ "Test Failed- Placeholders are not present on billing form");
			}
			else {
				test.log(LogStatus.PASS, "Test Passed- Placeholders are present on billing form");
			}
		}catch(Exception e) {
			test.log(LogStatus.INFO, e);
		}

	}


	//TC_OC_CF_006
	@Test(enabled=true, priority=7)
	public void testCase006() throws IOException {
		s=new ScreenShotCapture(driver);
		test.log(LogStatus.INFO, "TC_OC_CF_006-To test if city field accepts less than 2 characters and we can proceed to step 3");

		try {
//			rd=new LoginData();
//			ArrayList<ArrayList<String>> myData = rd.loginData();
//			login.login(myData.get(7).get(0), myData.get(7).get(1));
			reader.i = 7;
			login.login(reader.getEmailId(), reader.getPassword());
			if(checkout.checkIfUserLoggedIn()) {
				test.log(LogStatus.PASS,"Test Passed- user is logged in");
			}
			else {
				test.log(LogStatus.FAIL,test.addScreenCapture(s.captureScreenshot("\\Checkout\\" + "testCase006.1_"+ timeStamp +".PNG"))+ "Test failed- User Logged");
			}
			checkout.navigateToHomepage();
			objHomePage.addProductToCart(1);
			checkout.checkout();
			checkout.enterNewBillingDetails(3);
			
			if(checkout.getStep3Title().getText().equals("Step 3: Delivery Details")) {
				test.log(LogStatus.PASS, "Test Passed-Cannot proceed to next form");
			}
			else {
				test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\Checkout\\" + "testCase006.2_"+ timeStamp +".PNG"))+"Test Failed-Can proceed to next form");
			}

			Boolean warningPresence =checkout.getCityWarning().isDisplayed();
			if(warningPresence) {
				test.log(LogStatus.PASS, "Test Passed-Warning is Present");
			}else {
				test.log(LogStatus.FAIL,test.addScreenCapture(s.captureScreenshot("\\Checkout\\" + "testCase006.3_"+ timeStamp +".PNG"))+ "Test Failed-Warning is not present");
			}
		}catch(Exception e) {
			test.log(LogStatus.INFO,e);
		}
	}

	
	
	//TC_OC_CF_007

	@Test(enabled=true, priority=8)

	public void testCase007() throws InterruptedException, IOException {
		s=new ScreenShotCapture(driver);
		test.log(LogStatus.INFO, "TC_OC_CF_007-to test if lastname can be more than 32 characters");
		try {
//			rd=new LoginData();
//			ArrayList<ArrayList<String>> myData = rd.loginData();
//			login.login(myData.get(8).get(0), myData.get(8).get(1));
			//Assert.assertEquals(checkout.checkIfUserLoggedIn(), true);
			reader.i = 8;
			login.login(reader.getEmailId(), reader.getPassword());
			if(checkout.checkIfUserLoggedIn()) {
				test.log(LogStatus.PASS,"Test Passed- user is logged in");
			}
			else {
				test.log(LogStatus.FAIL,test.addScreenCapture(s.captureScreenshot("\\Checkout\\" + "testCase007.1_"+ timeStamp +".PNG"))+ "Test failed- User Logged");
			}
			//to go to home page
			checkout.navigateToHomepage();
			objHomePage.addProductToCart(1);
			checkout.checkout();

			checkout.enterNewBillingDetails(4);
			
			if(checkout.getStep3Title().getText().equals("Step 3: Delivery Details")) {
				test.log(LogStatus.PASS, "Test Passed-Cannot proceed to next form");
			}
			else {
				test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\Checkout\\" + "testCase007.2_"+ timeStamp +".PNG"))+"Test Failed-Can proceed to next form");
			}
			Boolean warningPresence=checkout.getLnameElement().isDisplayed();
			if(warningPresence) {
				test.log(LogStatus.PASS, "Test Passed-Warning is Present");
			}else {
				test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\Checkout\\" + "testCase007.3_"+ timeStamp +".PNG"))+ "Test Failed-Warning is not present");
				

			}}catch(Exception e) {
				test.log(LogStatus.INFO, e);
			}
	}



  @Parameters("browser")
  @BeforeMethod
  public void beforeMethod(Method m , String browser) throws IOException {
	  reader.readExcel("src\\test\\resources", "loginDDT.xlsx", "Login");
	//  String timeStamp = new SimpleDateFormat("yyyy_MMM_dd_HH.mm.ss").format(new Date());
	//  report =new ExtentReports("ExtentReports\\Checkout\\"+m.getName()+"_"+timeStamp+".html");
	  test=report.startTest(m.getName());
	//  WebDriverManager.chromedriver().setup();
	//  driver = new ChromeDriver();
	//  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  initialize(browser);
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
  @Parameters("browser")
  @BeforeClass
	public void beforeClass(String browser) {
		timeStamp = new SimpleDateFormat("yyyy_MMM_dd_HH.mm.ss").format(new Date());
		report = new ExtentReports("ExtentReports\\Checkout\\CheckoutTests_" + browser + "_" + timeStamp + ".html");
	}


}

