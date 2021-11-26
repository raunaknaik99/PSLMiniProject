package com.team3.miniproject.testcases.wishlist;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.team3.miniproject.base.BrowserSetup;
import com.team3.miniproject.sitepages.LoginPage;
import com.team3.miniproject.sitepages.WishListPage;
import com.team3.miniproject.testcases.ddt.ReadInputs;

import screenshot.ScreenShotCapture;

import com.team3.miniproject.sitepages.WishListPage;

public class WishListTestSetup extends BrowserSetup {

	// WebDriver driver;
	String baseUrl = "http://localhost/miniproject";
	WishListPage obj12;
	ExtentTest test;
	ExtentReports report;
	ScreenShotCapture s;
	String timeStamp = new SimpleDateFormat("yyyy_MMM_dd_HH.mm.ss").format(new Date());
	ReadInputs reader=new ReadInputs();
	LoginPage login;

	@Test(priority = 1) // Check that user is able to add products to wishlist.
	public void testCase001() throws InterruptedException, IOException {
		s= new ScreenShotCapture(driver);
		test.log(LogStatus.INFO, "Check that user is able to add products  to wishlist");
		obj12 = new WishListPage(driver);
		login=new LoginPage(driver);
		login.navigateToLogin();
		reader.i=1;
		login.login(reader.getEmailId(),reader.getPassword());
		obj12.homeMethod(); // Navigating To Home Page

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");
		obj12.macWishlishbtnMethod(); // Adding MacBook To Wishlsit
		Thread.sleep(5000);
		// Checking Alert Displayed or Not
		if (obj12.successAlert.isDisplayed()) {
			test.log(LogStatus.PASS, "Success: You have added MacBook to your wish list!");
		} else {
			test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\WishList\\" + "testCase006_"+ timeStamp +".PNG"))
					  +"Tets Failed.");
		}

	}

	@Test(priority = 2) // Verify that added product is present on the wishlist page.
	public void testCase002() throws InterruptedException, IOException {
		s= new ScreenShotCapture(driver);
		test.log(LogStatus.INFO, "Verify that added product is present on the wishlist page");
		obj12 = new WishListPage(driver);
		login=new LoginPage(driver);
		login.navigateToLogin();
		reader.i=1;
		login.login(reader.getEmailId(),reader.getPassword());
		obj12.homeMethod(); // Navigating To Home Page

		obj12.wishbtntopMethod(); // Checking Element is displayed into Wishlist or not
		WebElement product = driver.findElement(By.linkText("MacBook"));
		if (product.isDisplayed()) {
			test.log(LogStatus.PASS, "The added product is visible in the WishList.");
		} else {
			test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\WishList\\" + "testCase006_"+ timeStamp +".PNG"))
					  +"The  first added product is not  visible in the WishList.");
			
		}

		obj12.continuebtnMethod();
		obj12.homeMethod(); // Navigating To Home Page
	}

	@Test(priority = 3) // Check that user is able to remove Product from wishlist.
	public void testCase003() throws InterruptedException, IOException {
		s= new ScreenShotCapture(driver);
		test.log(LogStatus.INFO, "Check that user is able to remove Product from wishlist");
		obj12 = new WishListPage(driver);
		login=new LoginPage(driver);
		login.navigateToLogin();
		reader.i=1;
		login.login(reader.getEmailId(),reader.getPassword());
		obj12.homeMethod(); // Navigating To Home Page
		obj12.wishbtntopMethod();

		obj12.removemacMethod(); // Remove product from wishlsit
		Thread.sleep(5000);
		if (obj12.successAlert.isDisplayed()) {
			test.log(LogStatus.PASS, "Success: You have modified your wish list!");
			test.log(LogStatus.PASS, "The added product is remove from WishList.");
		} else {
			test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\WishList\\" + "testCase006_"+ timeStamp +".PNG"))
					  +"Test Failed.");
		}
		obj12.continuebtnMethod();
		obj12.homeMethod(); // Navigating To Home Page
	}

	@Test(priority = 4) // Check that user is able to add products to Cart form wishlist.
	public void testCase004() throws InterruptedException, IOException {
		s= new ScreenShotCapture(driver);
		test.log(LogStatus.INFO, "Check that user is able to add products to Cart form wishlist");
		obj12 = new WishListPage(driver);
		login=new LoginPage(driver);
		login.navigateToLogin();
		reader.i=1;
		login.login(reader.getEmailId(),reader.getPassword());
		obj12.homeMethod(); // Navigating To Home Page

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		obj12.macWishlishbtnMethod();// Added product into wishlist
		obj12.wishbtntopMethod();
		obj12.addcartmacMethod();// Added product into cart from wishlist

		if (obj12.successAlert.isDisplayed()) {
			test.log(LogStatus.PASS, "Success: You have added MacBook to your shopping cart!");
		} else {
			test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\WishList\\" + "testCase006_"+ timeStamp +".PNG"))
					  +"Test Failed.");
		}
		Thread.sleep(5000);
		obj12.shoppingcartMethod();
		WebElement product = driver.findElement(By.linkText("MacBook"));
		if (product.isDisplayed()) {
			test.log(LogStatus.PASS, "The added product is visible in the Shopping Cart.");
		} else {
			test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\WishList\\" + "testCase006_"+ timeStamp +".PNG"))
					  +"The added product is not visible in the Shopping Cart.");
		}
		obj12.homeCartMethod();// Navigating To Home Page
	}

	@Test(priority = 5) // Check that user is able to add more than one products to wishlist.
	public void testCase005() throws InterruptedException, IOException {
		s= new ScreenShotCapture(driver);
		test.log(LogStatus.INFO, "Check that user is able to add more than one products to wishlist");
		obj12 = new WishListPage(driver);
		login=new LoginPage(driver);
		login.navigateToLogin();
		reader.i=1;
		login.login(reader.getEmailId(),reader.getPassword());
		obj12.homeMethod();// Navigating To Home Page

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");
		obj12.iphonewishlishbtnMethod(); // Added iphone into wishlist
		if (obj12.successAlert.isDisplayed()) {
			test.log(LogStatus.PASS, "Success: You have added iPhone to your wish list!");
		} else {
			test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\WishList\\" + "testCase006_"+ timeStamp +".PNG"))
					  +"Test Failed.");
		}
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,5000)");
		obj12.applecinemawishlishbtnMethod();// Added apple cinema into wishlist
		if (obj12.successAlert.isDisplayed()) {
			test.log(LogStatus.PASS, "Success: You have added Apple Cinema 30\" to your wish list!");
		} else {
			test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\WishList\\" + "testCase006_"+ timeStamp +".PNG"))
					  +"Test Failed");
		}
		Thread.sleep(5000);
		obj12.wishbtntopMethod();
		WebElement product1 = driver.findElement(By.linkText("iPhone"));
		WebElement product2 = driver.findElement(By.linkText("Apple Cinema 30\""));
		// Checking alert diplayed for not
		if (product1.isDisplayed()) {
			test.log(LogStatus.PASS, "The first added product is visible in the WishList.");
		} else {
			test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\WishList\\" + "testCase006_"+ timeStamp +".PNG"))
					  +"The  first added product is not  visible in the WishList.");
		}
		if (product2.isDisplayed()) {
			test.log(LogStatus.PASS, "The second added product is visible in the WishList.");
		} else {
			test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\WishList\\" + "testCase006_"+ timeStamp +".PNG"))
					  +"The second added product is not  visible in the Shopping Cart.");
		}
		obj12.homeMethod1();

	}

	@Test(priority = 7) // To check that trying to add a product to the wishlist while not logged in
						// shows the correct warning message
	public void testCase007() throws InterruptedException, IOException {
		 s= new ScreenShotCapture(driver);
		test.log(LogStatus.INFO,
				"To check that trying to add a product to the wishlist while not logged in shows the correct warning message");
		obj12 = new WishListPage(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");
		obj12.macWishlishbtnMethod(); // Added Product before login.

		if (obj12.successAlert.isDisplayed()) {
			test.log(LogStatus.PASS, "You must login or create an account to save MacBook to your wish list!");
		} else {
			test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\WishList\\" + "testCase006_"+ timeStamp +".PNG"))
					  +"Test Failed");
		}
		Thread.sleep(5000);
	}
	
    //TC_OC_WL_006
  @Test(priority=6)
  public void testCase006() throws InterruptedException {
	  s= new ScreenShotCapture(driver);
	  test.log(LogStatus.INFO, "TC_OC_WL_006-To check that the count of the number of products added to wishlist is reflected in the UI at the top of the Header");
	  try {
	  obj12=new WishListPage(driver);
	  obj12.iphonewishlishbtnMethod();
      WebDriverWait w1=new WebDriverWait(driver, 10);
      w1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[onclick=\"wishlist.add('40');\"]")));
      obj12.macWishlishbtnMethod();
      WebDriverWait w2=new WebDriverWait(driver,10);
	  w2.until(ExpectedConditions.attributeContains(By.id("wishlist-total"), "title", "Wish List (2)"));
      String title=driver.findElement(By.id("wishlist-total")).getAttribute("title");
	  String title11=Character.toString(title.charAt(11));
	  if(title11.equals("2")) {
		  test.log(LogStatus.PASS, "Wish List Count is reflected correctly");
	  }
	  else {
		  test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\WishList\\" + "testCase006_"+ timeStamp +".PNG"))
				  +"Wish List Count is not reflected correctly");
	  }}catch(Exception e) {
		  test.log(LogStatus.INFO, e);
	  }
  }

	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(Method m, String browser) throws IOException {
		reader.readExcel("src\\test\\resources", "loginDDT.xlsx", "Wishlist");
		test = report.startTest(m.getName());
		initialize(browser);
		driver.get(baseUrl);
	}

	@AfterMethod
	public void afterMethod() {
		report.endTest(test);
		report.flush();
		driver.quit();
	}

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		report = new ExtentReports(
				"ExtentReports\\Wish_List_Reports\\WishListTestCases_" + browser + "_" + timeStamp + ".html");
	}
}
