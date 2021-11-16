package com.team3.miniproject.testcases.wishlist;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.team3.miniproject.sitepages.WishList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WishListTestCases {
	
	WebDriver driver;
	String baseUrl="http://localhost/opencartsite/index.php?route=common/home";
	WishList w_object;
	
  @Test
  public void testCase007() throws InterruptedException {
	  w_object=new WishList(driver);
      w_object.iphonewishlishbtnMethod();
      WebDriverWait w1=new WebDriverWait(driver, 10);
	  w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/div[2]/div[1]/div/div[3]/button[2]")));
      w_object.macWishlishbtnMethod();
      WebDriverWait w2=new WebDriverWait(driver,10);
	  w2.until(ExpectedConditions.attributeContains(By.id("wishlist-total"), "title", "Wish List (2)"));
      String title=driver.findElement(By.id("wishlist-total")).getAttribute("title");
	  String title11=Character.toString(title.charAt(11));
	  System.out.println(title11);
	  Assert.assertEquals("2", title11);
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(baseUrl);
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
