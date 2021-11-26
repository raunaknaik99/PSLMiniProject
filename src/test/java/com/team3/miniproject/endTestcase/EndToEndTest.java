package com.team3.miniproject.endTestcase;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
import com.team3.miniproject.sitepages.CartPage;
import com.team3.miniproject.sitepages.CheckoutPage;
import com.team3.miniproject.sitepages.ContactUsPage;
import com.team3.miniproject.sitepages.Footer;
import com.team3.miniproject.sitepages.Header;
import com.team3.miniproject.sitepages.HomePage;
import com.team3.miniproject.sitepages.LoginPage;
import com.team3.miniproject.sitepages.RegistrationPage;
import com.team3.miniproject.sitepages.SearchPage;
import com.team3.miniproject.sitepages.TabletsPage;
import com.team3.miniproject.sitepages.WishListPage;
import com.team3.miniproject.testcases.ddt.LoginData;
import com.team3.miniproject.testcases.ddt.ReadInputs;
import com.team3.miniproject.testcases.ddt.RegistrationData;
import com.team3.miniproject.testcases.ddt.SearchQueryData;

import io.github.bonigarcia.wdm.WebDriverManager;
import screenshot.ScreenShotCapture;

public class EndToEndTest extends BrowserSetup{
	String baseUrl = "http://localhost/miniproject";

	ExtentReports report;
	ExtentTest test;

	CartPage objCart;
	ContactUsPage objContactUs;
	CheckoutPage objCheckout;
	Footer objFooter;
	Header objHeader;
	HomePage objHomePage;
	LoginPage objLoginPage;
	RegistrationPage objRegistration;
	SearchPage objSearch;
	TabletsPage objTablets;
	WishListPage objWishlist;
	RegistrationData objRegister;
	LoginData objLogin;
	SearchQueryData objSearchItem;

	ScreenShotCapture objScreenshot;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	String timeStamp = new SimpleDateFormat("yyyy_MMM_dd_HH.mm.ss").format(new Date());
	ReadInputs reader = new ReadInputs();

	@Test
	public void endTestOpenCart001() throws InterruptedException, IOException {
		test.log(LogStatus.INFO, "End Test Case - Tests the overall flow of the application.");
		objScreenshot = new ScreenShotCapture(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//objects for pages

		objHeader = new Header(driver);
		objRegistration = new RegistrationPage(driver);
		objLoginPage = new LoginPage(driver);
		objSearch = new SearchPage(driver);
		objFooter = new Footer(driver);
		objWishlist = new WishListPage(driver);
		objCart = new CartPage(driver);
		objCheckout = new CheckoutPage(driver);

		// objects for DDT
		objRegister = new RegistrationData();
		objLogin = new LoginData();
		objSearchItem = new SearchQueryData();
//
		ArrayList<ArrayList<String>> myData = objRegister.userData();
		ArrayList<ArrayList<String>> myLoginData = objLogin.loginData();
		ArrayList<ArrayList<String>> mySearchData = objSearchItem.searchBarData();

		// verify title
		test.log(LogStatus.INFO, "Title Verification:");
		if(driver.getTitle().equals("Your Store")) {
			test.log(LogStatus.PASS, "Title matched!");
		}
		else {
			test.log(LogStatus.FAIL, test.addScreenCapture(objScreenshot.captureScreenshot("\\EndTestCase\\endTestCase001.1_" + timeStamp +".PNG")) + "Title did not match.");
		}
		// click on registration link

//	  objHeader.selectFromMyAccountDropDown(0);

//	 
//	  objRegistration.fillRegistrationForm(myData.get(0).get(0), myData.get(0).get(1), myData.get(6).get(2), myData.get(0).get(3), myData.get(0).get(4), myData.get(0).get(5));
//	  objRegistration.checkPrivacyPolicy();
//	  objRegistration.clickContinueBtn();
//		
//		test.log(LogStatus.INFO, "Registration Validation:");
//		if(driver.getTitle().equals("Your Account Has Been Created!")) {
//			test.log(LogStatus.PASS, "Registration successful!");
//		}
//		else {
//			test.log(LogStatus.FAIL, test.addScreenCapture(objScreenshot.captureScreenshot("\\EndTestCase\\endTestCase001.2_" + timeStamp +".PNG")) + "Registration is not successful.");
//		}
//	  //logout
//	  objHeader.selectFromMyAccountDropDown(4);

	  //click on login
	  objHeader.selectFromMyAccountDropDown(1);
	  objLoginPage.login(myLoginData.get(5).get(0), myLoginData.get(5).get(1));
	  
	  test.log(LogStatus.INFO, "Login Validation:");
		if(driver.getTitle().equals("My Account")) {
			test.log(LogStatus.PASS, "User has successfully logged in!");
		} else {
			test.log(LogStatus.FAIL,
					objScreenshot.captureScreenshot("\\EndTestCase\\" + "endTestCase001.3_" + timeStamp + ".PNG")
							+ "Login was not successful!");
		}
		
	  // navigate to homepage
	  objHeader.clickHomePageLink();
	  
	  test.log(LogStatus.INFO, "Navigation to HomePage Validation");
		if(driver.getTitle().equals("Your Store")) {
			test.log(LogStatus.PASS, "Succesfully navigated to the Home Page.");
		} else {
			test.log(LogStatus.FAIL,
					objScreenshot.captureScreenshot("\\EndTestCase\\" + "endTestCase001.4_" + timeStamp + ".PNG")
							+ "The user was not redirected to the Home Page.");
		}

		// search product
		objHeader.enterSearchQuery(mySearchData.get(0).get(0));
		objHeader.clickSearchBtn();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Your Store")));
		js.executeScript("window.scrollBy(0, 600);");

		Thread.sleep(3000);

		// add product to wishlist
		objSearch.addToWishlist(0);

		// product added to wishlist validation
		test.log(LogStatus.INFO, "Validation for adding product to the Wishlist.");
		if (driver.findElement(By.cssSelector("#product-search > div.alert.alert-success.alert-dismissible"))
				.isDisplayed()) {
			test.log(LogStatus.PASS, "Product was successfully added to the wishlist!");
		} else {
			test.log(LogStatus.FAIL,
					objScreenshot.captureScreenshot("\\EndTestCase\\" + "endTestCase001.5_" + timeStamp + ".PNG")
							+ "Product was not added to the wishlist.");
		}

		// search for another product
		Thread.sleep(4000);
		objHeader.enterSearchQuery(mySearchData.get(1).get(0));
		objHeader.clickSearchBtn();

		// add product to cart
		objSearch.addToCart(0);

		// product added to cart validation
		test.log(LogStatus.INFO, "Validation for adding product to the Cart.");
		if (driver.findElement(By.cssSelector("#product-search > div.alert.alert-success.alert-dismissible"))
				.isDisplayed()) {
			test.log(LogStatus.PASS, "Product was successfully added to the Cart!");
		} else {
			test.log(LogStatus.FAIL,
					objScreenshot.captureScreenshot("\\EndTestCase\\" + "endTestCase001.6_" + timeStamp + ".PNG")
							+ "Product was not added to the Cart.");
		}

		Thread.sleep(2000);
		// navigate to wishlist
		objHeader.clickWishlistLink();
		Thread.sleep(3000);
		objWishlist.addcartmacMethod(); // adds item from wishlist to cart

		// Validation for adding product from wishlist to cart
		test.log(LogStatus.INFO, "Validation for adding product to the Cart from the wishlist.");
		if (driver.findElement(By.cssSelector("#account-wishlist > div.alert.alert-success.alert-dismissible"))
				.isDisplayed()) {
			test.log(LogStatus.PASS, "Product was succesfully added from the wishlist to the Cart!");
		} else {
			test.log(LogStatus.FAIL,
					objScreenshot.captureScreenshot("\\EndTestCase\\" + "endTestCase001.7_" + timeStamp + ".PNG")
							+ "Product was not added to the Cart.");
		}

		Thread.sleep(2000);
		objHeader.clickShoppingCartLink();
		Thread.sleep(3000);
		reader.i=8;
		objCart.enterQuantity((reader.getQuantity()));
		objCart.updateQuantity();

		test.log(LogStatus.INFO, "Validation for updating quantity  of a product in the Cart.");
		if (driver.findElement(By.cssSelector("#checkout-cart > div.alert.alert-success.alert-dismissible"))
				.isDisplayed()) {
			test.log(LogStatus.PASS, "Product was successfully added to the Cart!");
		} else {
			test.log(LogStatus.FAIL,
					objScreenshot.captureScreenshot("\\EndTestCase\\" + "endTestCase001.8_" + timeStamp + ".PNG")
							+ "Product was not added to the Cart.");
		}

		Thread.sleep(2000);
		// apply coupon
		objCart.clickCouponDropdown();
		Thread.sleep(2000);
		reader.i=1;
		objCart.enterCouponCode(reader.getCouponCode()); // custom code for 15% discount
		Thread.sleep(2000);
		objCart.clickApplyCoupon();

		// validation for Apply coupon
		test.log(LogStatus.INFO, "Validation for applying coupons for the products in the cart.");
		if (driver.findElement(By.cssSelector("#checkout-cart > div.alert.alert-success.alert-dismissible"))
				.isDisplayed()) {
			test.log(LogStatus.PASS, "Coupon was successfully applied!");
		} else {
			test.log(LogStatus.FAIL,
					objScreenshot.captureScreenshot("\\EndTestCase\\" + "endTestCase001.9_" + timeStamp + ".PNG")
							+ "Coupon was not applied!");
		}
	  
	  Thread.sleep(3000);
	  
	  //click on Checkout button in the cart
	  objCart.checkout();
	  
	  //checkout process
	  objCheckout.enterNewBillingDetails(2);
	  objCheckout.enterExistingDeliveryDetailsAndContinue();
	  objCheckout.enterDeliveryMethodAndContinue();
	  objCheckout.enterPaymentMethod();
	  objCheckout.agreeToTermsAndConditionsAndContinue();
	  objCheckout.confirmOrder();
	  
	  //validation of checkout
	  test.log(LogStatus.INFO, "Validation for confirmed order.");
	  Thread.sleep(3000);
	  if(driver.getTitle().equals("Your order has been placed!")) {
		  test.log(LogStatus.PASS, "Order was succesfully placed!");
	  }
	  else {
		  test.log(LogStatus.FAIL,  test.addScreenCapture(objScreenshot.captureScreenshot("\\EndTestCase\\endTestCase001.10_" + timeStamp +".PNG")) + "The order could not be placed!");
	  }
	  Thread.sleep(5000);
  }
	
  @Parameters("browser")
  @BeforeMethod
  public void beforeMethod(Method m, String browser) throws IOException {
	  reader.readExcel("src\\test\\resources", "loginDDT.xlsx", "Coupon Codes and Quantity");
	  test = report.startTest(m.getName());
	  initialize(browser);
	  driver.get(baseUrl);
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(5000);
	  report.endTest(test);
	  report.flush();
	  driver.close();
  }
  
  @Parameters("browser")
  @BeforeClass
  public void beforeClassMethod(String browser) {
	  timeStamp = new SimpleDateFormat("yyyy_MMM_dd_HH.mm.ss").format(new Date());
	  report = new ExtentReports("ExtentReports\\EndTestCase\\EndTests_" + browser + "_" + timeStamp + ".html");
  }

}
