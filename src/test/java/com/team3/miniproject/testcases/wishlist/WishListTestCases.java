package com.team3.miniproject.testcases.wishlist;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.team3.miniproject.sitepages.WishList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WishListTestCases {
	
	WebDriver driver;
	String baseUrl="http://localhost/opencartsite/index.php?route=common/home";
	WishList w_object;
    ExtentTest test;
    ExtentReports report;
	
    //TC_OC_WL_006
  @Test
  public void testCase006() throws InterruptedException {
	  test.log(LogStatus.INFO, "TC_OC_WL_006-To check that the count of the number of products added to wishlist is reflected in the UI at the top of the Header");
	  w_object=new WishList(driver);
      w_object.iphonewishlishbtnMethod();
      WebDriverWait w1=new WebDriverWait(driver, 10);
	  w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/div[2]/div[1]/div/div[3]/button[2]")));
      w_object.macWishlishbtnMethod();
      WebDriverWait w2=new WebDriverWait(driver,10);
	  w2.until(ExpectedConditions.attributeContains(By.id("wishlist-total"), "title", "Wish List (2)"));
      String title=driver.findElement(By.id("wishlist-total")).getAttribute("title");
	  String title11=Character.toString(title.charAt(11));
	  //System.out.println(title11);
	  //Assert.assertEquals("2", title11);
	  if(title11.equals("2")) {
		  test.log(LogStatus.PASS, "Wish List Count is reflected correctly");
	  }
	  else {
		  test.log(LogStatus.FAIL, "Wish List Count is not reflected correctly");
	  }
  }
  @BeforeMethod
  public void beforeMethod(Method m) {
	  report =new ExtentReports("ExtentReports\\Wish_List_Reports\\"+m.getName()+".html");
	  test=report.startTest(m.getName());
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(baseUrl);
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  report.endTest(test);
	  report.flush();
	  driver.quit();
  }

}
