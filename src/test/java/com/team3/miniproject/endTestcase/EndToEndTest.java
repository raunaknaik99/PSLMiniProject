package com.team3.miniproject.endTestcase;

import org.testng.annotations.Test;

import com.team3.miniproject.sitepages.Cart;
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

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class EndToEndTest {
	WebDriver driver;
	String baseUrl = "http://localhost";
	Cart objCart;
	ContactUs objContactUs;
	Footer objFooter;
	Header objHeader;
	HomePage objHomePage;
	LoginPage objLoginPage;
	RegistrationPage objRegistration;
	SearchPage objSearch;
	Tablets objTablets;
	WishList objWishlist;
	
  @Test
  public void TC_OpenCart_001() {
	  objHeader = new Header(driver);
	  objRegistration = new RegistrationPage(driver);
	  objLoginPage = new LoginPage();
	  
	  //click on registration link
	  objHeader.selectFromMyAccountDropDown(0);
	  
	  objRegistration.fillRegistrationForm("Tony", "Stark", "tony6@starkenterprises.com", "9999999999", "ironman", "ironman");
	  objRegistration.checkPrivacyPolicy();
	  objRegistration.clickContinueBtn();
	  
	  objHeader.selectFromMyAccountDropDown(4);
	  
	  objHeader.selectFromMyAccountDropDown(1);
	  objLoginPage.login("tony1@starkenterprises.com", "ironman");
	  
	  objHeader.clickHomePageLink();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
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
