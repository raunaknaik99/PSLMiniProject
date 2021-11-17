package com.team3.miniproject.testcases.checkout;

import org.testng.annotations.Test;
import com.team3.miniproject.sitepages.CheckoutPage;
import com.team3.miniproject.sitepages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

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
	  driver.findElement(By.xpath("//button[@onclick=\"cart.add('40');\"]")).click();
	  Assert.assertEquals(checkout.checkIfCartIsEmpty(),false);
	  checkout.checkout();
	  //Assert user is redirected to checkout page
	  Assert.assertEquals(checkout.driver.getTitle(), "Checkout");
	  //Assert "Your shopping cart is empty" message is displayed
	  checkout.enterNewBillingDetails();
	  checkout.enterFirstName("Diffa");
	  //checkout.enterLastName("Pinto");  Mandatory Field is not entered
	  checkout.enterAddress1("H.No 493, Somewhere, Some Place");
	  checkout.enterCity("Somewhere");
	  checkout.enterPostCode("12345");
	  checkout.enterCountry("India");
	  checkout.enterState("Goa");
	  checkout.clickContinue();
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
	  Thread.sleep(2000);
	  Assert.assertEquals(checkout.isClickable(By.xpath("//*[@id='accordion']/div[4]/div[1]/h4/a")),false);
	  Thread.sleep(2000);
	  Assert.assertEquals(checkout.isClickable(By.xpath("//*[@id='accordion']/div[5]/div[1]/h4/a")),false);
	  Thread.sleep(2000);
	  Assert.assertEquals(checkout.isClickable(By.xpath("//*[@id='accordion']/div[6]/div[1]/h4/a")),false);
	  Thread.sleep(5000);
	 
	  login.logout();
  }
//TC_OC_CF_002
   @Test(enabled=false)
  public void testCase002() throws InterruptedException {
	  login.login("tester234@gmail.com", "tester234");
	  Assert.assertEquals(checkout.checkIfUserLoggedIn(), true);
	  checkout.navigateToHomepage();
	  driver.findElement(By.xpath("//button[@onclick=\"cart.add('40');\"]")).click();
	  Assert.assertEquals(checkout.checkIfCartIsEmpty(),false);
	  checkout.checkout();
	  //Assert user is redirected to checkout page
	  Assert.assertEquals(driver.getTitle(), "Checkout");
	  checkout.enterNewBillingDetails();
	  checkout.enterFirstName("Diffa");
	  checkout.enterLastName("Pinto");  
	  checkout.enterAddress1("H.No 493, Somewhere, Some Place");
	  checkout.enterCity("Somewhere");
	  checkout.enterPostCode("hdjhdsh"); //Non alpha numeric postal code
	  checkout.enterCountry("India");
	  checkout.enterState("Goa");
	  checkout.clickContinue();
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
	  driver.findElement(By.xpath("//button[@onclick=\"cart.add('40');\"]")).click();
	  Assert.assertEquals(checkout.checkIfCartIsEmpty(),false);
	  checkout.checkout();
	  //Assert user is redirected to checkout page
	  Assert.assertEquals(driver.getTitle(), "Checkout");
	  checkout.enterNewBillingDetails();
	  checkout.enterFirstName("Diffa");
	  checkout.enterLastName("Pinto");  
	  checkout.enterAddress1("H.No 493, Somewhere, Some Place");
	  checkout.enterCity("Somewhere");
	  checkout.enterPostCode("12345");
	  checkout.enterCountry("India");
	  checkout.enterState("Goa");
//	  Thread.sleep(10000);
	  checkout.clickContinue();
	  checkout.enterExistingDeliveryDetailsAndContinue();
	  checkout.enterDeliveryMethodAndContinue();
	  checkout.enterPaymentMethod(); //Did not agree to Terms and Conditions
	  driver.findElement(By.id("button-payment-method")).click();
	  //Assert Warning is displayed
	  Assert.assertEquals(driver.findElement(By.xpath("//*[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: You must agree to the Terms & Conditions!"),true);
	 
	  //login.logout();
  }
	//TC_OC_CF_004
	@Test(enabled=true)
  public void testCase004() throws InterruptedException {
		
	  login.login("tester234@gmail.com", "tester234");
	  Assert.assertEquals(checkout.checkIfUserLoggedIn(), true);
	  checkout.navigateToHomepage();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[@onclick=\"cart.add('40');\"]")).click();
	  Assert.assertEquals(checkout.checkIfCartIsEmpty(),false);
	  checkout.checkout();
	  //Assert user is redirected to checkout page
	  Thread.sleep(2000);
	  Assert.assertEquals(driver.getTitle(), "Checkout");
	  checkout.enterNewBillingDetails();
	  checkout.enterFirstName("Diffa");
	  checkout.enterLastName("Pinto");  
	  checkout.enterAddress1("H.No 493, Somewhere, Some Place");
	  checkout.enterCity("Somewhere");
	  checkout.enterPostCode("12345"); //Non alpha numeric postal code
	  checkout.enterCountry("India");
	  checkout.enterState("Goa");
	  checkout.clickContinue();
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
		  login.login("tester234", "tester234");
		  Assert.assertEquals(checkout.checkIfUserLoggedIn(), true);
		  checkout.navigateToHomepage();
		  driver.findElement(By.xpath("//button[@onclick=\"cart.add('40');\"]")).click();
		  checkout.checkout();
		  String fnamePlaceholder=driver.findElement(By.id("input-payment-firstname")).getAttribute("placeholder");
		  String lnamePlaceholder=driver.findElement(By.id("input-payment-lastname")).getAttribute("placeholder");
		  String company=driver.findElement(By.id("input-payment-company")).getAttribute("placeholder");
		  String address1=driver.findElement(By.id("input-payment-address-1")).getAttribute("placeholder");
		  String city=driver.findElement(By.id("input-payment-city")).getAttribute("placeholder");
		  String postCode=driver.findElement(By.id("input-payment-postcode")).getAttribute("placeholder");
		  Assert.assertEquals("First Name", fnamePlaceholder);
		  Assert.assertEquals("Last Name", lnamePlaceholder);
		  Assert.assertEquals("Company", company);
		  Assert.assertEquals("Address 1", address1);
		  Assert.assertEquals("City", city);
		  Assert.assertEquals("Post Code", postCode);
	}
	
	
	//TC_OC_CF_006
	@Test(enabled=false)
	public void testCase006() {
		  login.login("tester234@gmail.com", "tester234");
		  Assert.assertEquals(checkout.checkIfUserLoggedIn(), true);
		  checkout.navigateToHomepage();
		  driver.findElement(By.xpath("//button[@onclick=\"cart.add('40');\"]")).click();
		  checkout.checkout();
		  checkout.enterNewBillingDetails();
		  checkout.enterFirstName("Errol");
		  checkout.enterLastName("C");  
		  checkout.enterAddress1("Somewhere, Some Place");
		  checkout.enterCity("A");
		  checkout.enterPostCode("12345");
		  checkout.enterCountry("India");
		  checkout.enterState("Goa");
		  checkout.clickContinue();
		  Assert.assertEquals("Step 3: Delivery Details", driver.findElement(By.xpath("//h4[text()='Step 3: Delivery Details']")).getText());
		  Assert.assertTrue(driver.findElement(By.xpath("//div[text()='City must be between 2 and 128 characters!']")).isDisplayed());
	}
	
	
	//TC_OC_CF_007
	@Test(enabled=false)
	public void testCase007() {
		login.login("tester234@gmail.com", "tester234");
		  Assert.assertEquals(checkout.checkIfUserLoggedIn(), true);
		  checkout.navigateToHomepage();
		  driver.findElement(By.xpath("//button[@onclick=\"cart.add('40');\"]")).click();
		  checkout.checkout();
		  checkout.enterNewBillingDetails();
		  checkout.enterFirstName("Errol");
		  checkout.enterLastName("Costabirfernandeserrolcostabirmenezesdsouzacabralsouzapereira");  
		  checkout.enterAddress1("Somewhere, Some Place");
		  checkout.enterCity("Goa");
		  checkout.enterPostCode("12345");
		  checkout.enterCountry("India");
		  checkout.enterState("Goa");
		  checkout.clickContinue();
		  Assert.assertEquals("Step 3: Delivery Details", driver.findElement(By.xpath("//h4[text()='Step 3: Delivery Details']")).getText());
		  Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Last Name must be between 1 and 32 characters!']")).isDisplayed());
	}
	
	
  @BeforeMethod
  public void beforeMethod() {
	  //System.setProperty("webdriver.chrome.driver", "C:\\Users\\diffa_pinto\\eclipse-workspace-new\\Project1\\resources\\chromedriver.exe");
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  login=new LoginPage(driver);
	  checkout=new CheckoutPage(driver);
	  login.navigateToLogin();	 
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(5000);
	  checkout.closeBrowser();
  }

}

