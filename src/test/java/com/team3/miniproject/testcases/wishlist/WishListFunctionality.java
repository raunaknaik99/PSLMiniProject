package com.team3.miniproject.testcases.wishlist;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.team3.miniproject.sitepages.WishList;

import io.github.bonigarcia.wdm.WebDriverManager;

//import Pages.NewTest1;
//import Pages.WishList;


	public class WishListFunctionality {
		
		WebDriver driver ;
		WishList obj12;
		
		@BeforeTest
		public void setup() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    
		driver.get("http://localhost/opencart/");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
			
		}	
		@Test(priority = 1) //To check that trying to add a product to the wishlist while not logged in shows the correct warning message
		 public void wishlist_TC007() throws InterruptedException  {
			obj12 = new WishList(driver);
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 //
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 Thread.sleep(5000);
			 js.executeScript("window.scrollBy(0,5000)");
			
			 Thread.sleep(5000);
			 obj12.macWishlishbtnMethod();
			
			 WebDriverWait w = new WebDriverWait(driver, 20);
			 w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"common-home\"]/div[1]")));
			 WebElement AlertMessage1=driver.findElement(By.xpath("//*[@id=\"common-home\"]/div[1]"));
			 Assert.assertTrue(AlertMessage1.isDisplayed());
			 Thread.sleep(5000);
			 }
		 
		@Test(priority = 2) 
		public void wishlist_Login() throws InterruptedException  {
			//
			
			obj12.loginbtnMethod();
			obj12.loginbtn1Method();
			obj12.email("123@gmail.com");
			obj12.passwordMethod("Shriya@123");
			Thread.sleep(5000);
            obj12.loginMethod();
            Thread.sleep(5000);
			obj12.homeMethod();
			
		}
		
		 @Test(priority = 3) //Check that user is able to add products  to wishlist.
		 public void wishlist_TC001() throws InterruptedException  {
			 //
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 //
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,5000)");
			// js.executeScript("arguments[0].scrollIntoView();", obj12.MacWishlishbtn);
			 Thread.sleep(5000);
			 obj12.macWishlishbtnMethod();
			 //
			 WebDriverWait w = new WebDriverWait(driver, 20);
			 w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"common-home\"]/div[1]")));
			 WebElement AlertMessage1=driver.findElement(By.xpath("//*[@id=\"common-home\"]/div[1]"));
			Assert.assertTrue(AlertMessage1.isDisplayed());
			Thread.sleep(5000);
			 }
		 @Test(priority = 4) //Verify that added product is present on the wishlist page.
		 public void wishlist_TC002() throws InterruptedException  {
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 
			 obj12.wishbtntopMethod();
			 Thread.sleep(5000);
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,5000)");
			 obj12.continuebtnMethod();
			 Thread.sleep(5000);
			 
			 obj12.homeMethod();
			 Thread.sleep(5000);
			 
		 }
		 
		 @Test(priority = 5)//Check that user is able to remove Product from wishlist.
		 public void wishlist_TC003() throws InterruptedException  {
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 obj12.wishbtntopMethod();
			 Thread.sleep(5000);
			 obj12.removemacMethod();
			 WebDriverWait w = new WebDriverWait(driver, 20);
			 w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"account-wishlist\"]/div[1]/i")));
			 WebElement AlertMessage13=driver.findElement(By.xpath("//*[@id=\"account-wishlist\"]/div[1]/i"));
			 Assert.assertTrue(AlertMessage13.isDisplayed());
			
			Thread.sleep(5000);
			obj12.homeMethod1();
		 }
		 
		 @Test(priority = 6)//Check that user is able to add products to Cart form wishlist.
		 public void wishlist_TC004() throws InterruptedException {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,5000)");
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 js.executeScript("window.scrollBy(0,5000)");
			 js.executeScript("window.scrollBy(0,5000)");
			 Thread.sleep(5000);
			 obj12.macWishlishbtnMethod();
			 
			 Thread.sleep(5000);
			 
			 obj12.wishbtntopMethod();
			 Thread.sleep(5000);

		     obj12.addcartmacMethod();
		     Thread.sleep(5000);
			 WebDriverWait w = new WebDriverWait(driver, 20);
			 w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"account-wishlist\"]/div[1]")));
			 WebElement AlertMessage13=driver.findElement(By.xpath("//*[@id=\"account-wishlist\"]/div[1]"));
			 Assert.assertTrue(AlertMessage13.isDisplayed());
			

			 obj12.removemacMethod();
			
			 w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"account-wishlist\"]/div[1]/i")));
			 WebElement AlertMessage14=driver.findElement(By.xpath("//*[@id=\"account-wishlist\"]/div[1]/i"));
			 Assert.assertTrue(AlertMessage14.isDisplayed());
			 Thread.sleep(5000);
			 			
			 obj12.shoppingcartMethod();
			 Thread.sleep(5000);
			
			 obj12.homeCartMethod();
			 Thread.sleep(5000);
		 }
		 
		
		 @Test(priority = 7)//Check that user is able to add more than one products to wishlist.
		 public void wishlist_TC005() throws InterruptedException {
			 
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			
			 js.executeScript("window.scrollBy(0,5000)");
			 Thread.sleep(5000);
			 obj12.macWishlishbtnMethod();
			 
			 WebDriverWait w = new WebDriverWait(driver, 20);
			 w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"common-home\"]/div[1]")));
			 WebElement AlertMessage1=driver.findElement(By.xpath("//*[@id=\"common-home\"]/div[1]"));
			 Assert.assertTrue(AlertMessage1.isDisplayed());

			Thread.sleep(5000);
			js.executeScript("window.scrollBy(0,5000)");
			Thread.sleep(5000);
			 obj12.iphonewishlishbtnMethod();
			 
			 w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"common-home\"]/div[1]")));
			 WebElement AlertMessage12=driver.findElement(By.xpath("//*[@id=\"common-home\"]/div[1]"));
			 Assert.assertTrue(AlertMessage1.isDisplayed());
			 Thread.sleep(5000);
			 
			
			 js.executeScript("window.scrollBy(0,5000)");
			 Thread.sleep(5000);
			 obj12.applecinemawishlishbtnMethod();
			 
			 w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"common-home\"]/div[1]")));
			 WebElement AlertMessage13=driver.findElement(By.xpath("//*[@id=\"common-home\"]/div[1]"));
			 Assert.assertTrue(AlertMessage1.isDisplayed());
			 Thread.sleep(5000);
			
			  obj12.wishbtntopMethod();
			  obj12.homeMethod1();
		 }
		 
		 
		 
		 
		 @AfterTest
			public void quit() {
				
				driver.quit();
			

		}

}
