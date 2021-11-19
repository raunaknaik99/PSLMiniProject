package com.team3.miniproject.endTestcase;

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

	@Test
	public void endTestOpenCart_001() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		objHeader = new Header(driver);
		objRegistration = new RegistrationPage(driver);
		objLoginPage = new LoginPage(driver);
		objSearch = new SearchPage(driver);
		objFooter = new Footer(driver);
		objWishlist = new WishList(driver);
		objCart = new Cart(driver);
		objCheckout = new CheckoutPage(driver);

		// click on registration link
//	  objHeader.selectFromMyAccountDropDown(0);
//	  
//	  objRegistration.fillRegistrationForm("Tony", "Stark", "tony004@starkenterprises.com", "9999999999", "ironman", "ironman");
//	  objRegistration.checkPrivacyPolicy();
//	  objRegistration.clickContinueBtn();
//	  
//	  //logout
//	  objHeader.selectFromMyAccountDropDown(4);

		// click on login
		objHeader.selectFromMyAccountDropDown(1);
		objLoginPage.login("tony1@starkenterprises.com", "ironman");

		// navigate to homepage
		objHeader.clickHomePageLink();

		// search product
		objHeader.enterSearchQuery("macbook");
		objHeader.clickSearchBtn();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Your Store")));
		js.executeScript("window.scrollBy(0, 600);");

		Thread.sleep(3000);
		objSearch.addToWishlist(0);

		Thread.sleep(2000);
		// navigate to wishlist
		objHeader.clickWishlistLink();
		Thread.sleep(3000);
		objWishlist.addcartmacMethod(); // adds item from wishlist to cart

		Thread.sleep(2000);
		objHeader.clickShoppingCartLink();
		Thread.sleep(3000);
		objCart.enterQuantity("3");
		objCart.updateQuantity();

		Thread.sleep(2000);
		// apply coupon
		objCart.clickCouponDropdown();
		Thread.sleep(2000);
		objCart.enterCouponCode("15Off"); // custom code for 15% discount
		Thread.sleep(2000);
		objCart.clickApplyCoupon();

		Thread.sleep(3000);

		// click on Checkout button in the cart
		objCart.checkout();

		// checkout process
//	  objCheckout.enterExistingBillingDetailsAndContinue();
//	  objCheckout.enterExistingDeliveryDetailsAndContinue();
//	  objCheckout.enterDeliveryMethodAndContinue();
//	  objCheckout.enterPaymentMethod();
//	  objCheckout.confirmOrder();

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
