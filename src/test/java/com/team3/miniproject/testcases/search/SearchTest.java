package com.team3.miniproject.testcases.search;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.team3.miniproject.sitepages.SearchPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest {
  SearchPage sp_object;
  WebDriver driver;
  String baseUrl = "http://localhost/opencartsite/index.php?route=product/search";
	
  @Test
  public void f() throws InterruptedException {
	  sp_object = new SearchPage(driver);
	  sp_object.enterSearchQuery("mac");
	  sp_object.clickSearchBtn();
//	  sp_object.clickListViewBtn();
//	  System.out.println(sp_object.getProductNames());
//	  System.out.println(sp_object.getProductPrices());
//	  sp_object.clickProductImg(2);
//	  Thread.sleep(2000);
//	  sp_object.addToCart(2);
//	  Thread.sleep(2000);
//	  sp_object.addToWishlist(3);
//	  Thread.sleep(2000);
//	  sp_object.addToCompare(1);
//	  Thread.sleep(2000);
//	  sp_object.addToCompare(2);
//	  Thread.sleep(2000);
//	  sp_object.clickCompareLink();
//	  sp_object.selectSort(3);
//	  sp_object.selectProductsLimit(3);
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
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.quit();
  }

}
