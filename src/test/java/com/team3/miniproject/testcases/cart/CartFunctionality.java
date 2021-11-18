package com.team3.miniproject.testcases.cart;

import java.awt.AWTException;
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

import com.team3.miniproject.sitepages.AppleCinema;
import com.team3.miniproject.sitepages.Cart;
import com.team3.miniproject.sitepages.Header;
import com.team3.miniproject.sitepages.HomePage;
import com.team3.miniproject.sitepages.Tablets;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CartFunctionality {
	WebDriver driver;
	String baseUrl = "http://localhost";
	HomePage objHomePage;
	Cart objCart;
	Tablets objTablets;
	Header objHeader;
	AppleCinema hpc_object;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
  @Test // working
  public void cart_TC001() throws InterruptedException{
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  objHomePage = new HomePage(driver);
	  objHeader = new Header(driver);
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView();", objHomePage.addMacbook);
	  objHomePage.addMacbookToCart();
	  
	  Thread.sleep(3000);
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"common-home\"]/div[1]")));
	  WebElement successAlert = driver.findElement(By.xpath("//*[@id=\"common-home\"]/div[1]"));
	  Assert.assertTrue(successAlert.isDisplayed());

	  Thread.sleep(5000);
	  objHeader.clickViewCartOption();
	  WebElement productInCart = driver.findElement(By.linkText("MacBook"));
	  Assert.assertTrue(productInCart.isDisplayed());
	  
}
  @Test // working
  public void cart_TC002() throws InterruptedException, AWTException {
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  objHomePage = new HomePage(driver);
	  hpc_object = new AppleCinema(driver);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView();", objHomePage.addCinema);
	  objHomePage.addCinemaToCart();
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  hpc_object.clickRadioButton();
	  hpc_object.clickCheckbox();	  
	  hpc_object.enterInTextbox("test");
	  	  
	  hpc_object.clickDropdown("4");

	  hpc_object.enterInTextArea("This is a test order");
	  
	  hpc_object.selectFileForUpload("D:\\Mini Project\\PSLMiniProject\\Resources\\test.txt");	  
	  
	  Thread.sleep(2000);
	  hpc_object.enterQuantity("2");
	  hpc_object.clickAddToCart();
	  Thread.sleep(2000);
	  hpc_object.checkSuccessAlert();
	  
  }
  @Test // working
  public void Cart_TC003() throws InterruptedException {
	  objHomePage = new HomePage(driver);
	  objTablets = new Tablets(driver);
	  objCart = new Cart(driver);
	  objHeader = new Header(driver);
	  Thread.sleep(5000);
		
	  objTablets.addTabletToCart();
	  Thread.sleep(5000);
	  
	  objHeader.clickShoppingCartLink();
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkout-cart\"]/div[1]")));
	  WebElement AlertMessage=driver.findElement(By.xpath("//*[@id=\"checkout-cart\"]/div[1]"));
	  Assert.assertTrue(AlertMessage.isDisplayed());
	  
}
  @Test // working
  public void Cart_TC004() throws InterruptedException {
	  objHomePage = new HomePage(driver);
	  objHeader = new Header(driver);
	  objHomePage.addMacbookToCart();
	  Thread.sleep(5000);
	  objHeader.clickViewCartOption(); 
	  Thread.sleep(5000);
	  objHeader.removeItemFromCart(0);
	  Thread.sleep(5000);	
} 
@Test
  public void cart_TC005() throws InterruptedException {
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
	 System.out.println("Success: You have added ");
  }
  @Test // working
  public void cart_TC006() throws InterruptedException, AWTException {
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  objHomePage = new HomePage(driver);
	  hpc_object = new AppleCinema(driver);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView();", objHomePage.addCinema);
	  objHomePage.addCinemaToCart();
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  hpc_object.clickRadioButton();
	  hpc_object.clickCheckbox();	  
	  hpc_object.enterInTextbox("test");
	  	  
	  hpc_object.clickDropdown("4");
	  
	  hpc_object.enterInTextArea("This is a test order");
	  
	  hpc_object.selectFileForUpload("D:\\Mini Project\\PSLMiniProject\\Resources\\test.txt");	
  	  Thread.sleep(2000);
	  hpc_object.enterQuantity("1");
	  hpc_object.clickAddToCart(); 
	  Thread.sleep(2000);
	  hpc_object.checkSuccessAlert();
  }
   @Test
  public void cart_TC007() throws InterruptedException {
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
	 System.out.println("Success: You have added ");
  }
  @Test //working
  public void TC_OC_CART_008() {
	  hpc_object=new AppleCinema(driver);
	  hpc_object.clickAppleCinemaCart();
	  hpc_object.clickRadioButton();
	  hpc_object.clickCheckbox();
	  hpc_object.clickAddToCart();
	  hpc_object.checkMandatoryFieldsWarning();
	  Assert.assertEquals("Apple Cinema 30", hpc_object.checkPageTitle());
	  
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
