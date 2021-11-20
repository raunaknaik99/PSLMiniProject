package com.team3.miniproject.endTestcase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.team3.miniproject.sitepages.Cart;
import com.team3.miniproject.sitepages.CheckoutPage;
import com.team3.miniproject.sitepages.ContactUs;
import com.team3.miniproject.sitepages.Footer;
import com.team3.miniproject.sitepages.Header;
import com.team3.miniproject.sitepages.HomePage;
import com.team3.miniproject.sitepages.LoginPage;
import com.team3.miniproject.sitepages.RegistrationPage;
import com.team3.miniproject.sitepages.SearchPage;
import com.team3.miniproject.sitepages.Tablets;
import com.team3.miniproject.sitepages.WishList;
import com.team3.miniproject.testcases.ddt.LoginData;
import com.team3.miniproject.testcases.ddt.RegistrationData;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EndToEndTest {
	WebDriver driver;
	String baseUrl = "http://localhost";

	Cart objCart;
	ContactUs objContactUs;
	CheckoutPage objCheckout;
	Footer objFooter;
	Header objHeader;
	HomePage objHomePage;
	LoginPage objLoginPage;
	RegistrationPage objRegistration;
	SearchPage objSearch;
	Tablets objTablets;
	WishList objWishlist;
	RegistrationData objRegister;
	LoginData objLogin;

	@Test
	public void endTestOpenCart_001() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//objects for pages
		objHeader = new Header(driver);
		objRegistration = new RegistrationPage(driver);
		objLoginPage = new LoginPage(driver);
		objSearch = new SearchPage(driver);
		objFooter = new Footer(driver);
		objWishlist = new WishList(driver);
		objCart = new Cart(driver);
		objCheckout = new CheckoutPage(driver);
		
		//objects for DDT
		objRegister = new RegistrationData();
		objLogin = new LoginData();
		
		ArrayList<ArrayList<String>> myData = objRegister.userData();
		ArrayList<ArrayList<String>> myLoginData = objLogin.loginData();
		// click on registration link
//	  objHeader.selectFromMyAccountDropDown(0);
//	//	  
//	  objRegistration.fillRegistrationForm(myData.get(0).get(0), myData.get(0).get(1), myData.get(2).get(2), myData.get(0).get(3), myData.get(0).get(4), myData.get(0).get(5));
//	  objRegistration.checkPrivacyPolicy();
//	  objRegistration.clickContinueBtn();
//
//	  //logout
//	  objHeader.selectFromMyAccountDropDown(4);
	  
	  //click on login
	  objHeader.selectFromMyAccountDropDown(1);
	  objLoginPage.login(myLoginData.get(0).get(0), myLoginData.get(0).get(1));
	  
	  // navigate to homepage
	  objHeader.clickHomePageLink();
	  
	  //search product
	  objHeader.enterSearchQuery("macbook");
	  objHeader.clickSearchBtn();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Your Store")));
	  js.executeScript("window.scrollBy(0, 600);");
	  
	  Thread.sleep(3000);
	  
	  objSearch.addToWishlist(0);
	  
	  //search for another product
	  objHeader.enterSearchQuery("iphone");
	  objHeader.clickSearchBtn();
	  
	  objSearch.addToCart(0);
	  
	  Thread.sleep(2000);
	  //navigate to wishlist
	  objHeader.clickWishlistLink();
	  Thread.sleep(3000);
	  objWishlist.addcartmacMethod(); // adds item from wishlist to cart
	  
	  Thread.sleep(2000);
	  objHeader.clickShoppingCartLink();
	  Thread.sleep(3000);
	  objCart.enterQuantity("3");
	  objCart.updateQuantity();
	  
	  Thread.sleep(2000);
	  //apply coupon
	  objCart.clickCouponDropdown();
	  Thread.sleep(2000);
	  objCart.enterCouponCode("15Off"); // custom code for 15% discount
	  Thread.sleep(2000);
	  objCart.clickApplyCoupon();
	  
	  Thread.sleep(3000);
	  
	  //click on Checkout button in the cart
	  objCart.checkout();
	  
	  //checkout process
	  objCheckout.enterExistingBillingDetailsAndContinue();
	  objCheckout.enterExistingDeliveryDetailsAndContinue();
	  objCheckout.enterDeliveryMethodAndContinue();
	  objCheckout.enterPaymentMethod();
	  objCheckout.agreeToTermsAndConditionsAndContinue();
	  objCheckout.confirmOrder();
	  Thread.sleep(5000);
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(baseUrl);
	  driver.manage().window().maximize();
	  JavascriptExecutor js;
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.close();
  }

}
