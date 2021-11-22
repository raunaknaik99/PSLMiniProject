package com.team3.miniproject.testcases.wishlist;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.team3.miniproject.base.BrowserSetup;
import com.team3.miniproject.sitepages.WishListPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import screenshot.ScreenShotCapture;

public class WishListTestCases extends BrowserSetup {
	
	//WebDriver driver;
	String baseUrl="http://localhost/opencartsite/index.php?route=common/home";
	WishListPage wishListObject;
    ExtentTest test;
    ExtentReports report;
    ScreenShotCapture s;
	String timeStamp = new SimpleDateFormat("yyyy_MMM_dd_HH.mm.ss").format(new Date());

	
    //TC_OC_WL_006
  @Test
  public void testCase006() throws InterruptedException {
	  s= new ScreenShotCapture(driver);
	  test.log(LogStatus.INFO, "TC_OC_WL_006-To check that the count of the number of products added to wishlist is reflected in the UI at the top of the Header");
	  try {
	  wishListObject=new WishListPage(driver);
      wishListObject.iphonewishlishbtnMethod();
      WebDriverWait w1=new WebDriverWait(driver, 10);
      w1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[onclick=\"wishlist.add('40');\"]")));
	  wishListObject.macWishlishbtnMethod();
      WebDriverWait w2=new WebDriverWait(driver,10);
	  w2.until(ExpectedConditions.attributeContains(By.id("wishlist-total"), "title", "Wish List (2)"));
      String title=driver.findElement(By.id("wishlist-total")).getAttribute("title");
	  String title11=Character.toString(title.charAt(11));
	  if(title11.equals("2")) {
		  test.log(LogStatus.PASS, "Wish List Count is reflected correctly");
	  }
	  else {
		  test.log(LogStatus.FAIL, test.addScreenCapture(s.captureScreenshot("\\WishList\\" + "testCase006_"+ timeStamp +".PNG"))
				  +"Wish List Count is not reflected correctly");
	  }}catch(Exception e) {
		  test.log(LogStatus.INFO, e);
	  }
  }
  
  @Parameters("browser")
  @BeforeMethod
  public void beforeMethod(Method m,String browser) {
	  test=report.startTest(m.getName());
	  initialize(browser);
	  //WebDriverManager.chromedriver().setup();
	  //driver=new ChromeDriver();
	  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(baseUrl);
	 // driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  report.endTest(test);
	  report.flush();
	  driver.quit();
  }
  
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browser) {
	  report =new ExtentReports("ExtentReports\\Wish_List_Reports\\WishListTest6_"+browser+"_"+timeStamp+".html");
  }

}
