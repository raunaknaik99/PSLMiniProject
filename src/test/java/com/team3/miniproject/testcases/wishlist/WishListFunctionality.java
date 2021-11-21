package com.team3.miniproject.testcases.wishlist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.team3.miniproject.sitepages.LoginPage;
import com.team3.miniproject.sitepages.WishList;

import io.github.bonigarcia.wdm.WebDriverManager;
public class WishListFunctionality {
	
	  	WebDriver driver ;
		WishList obj12;
		ExtentTest test;
	    ExtentReports report;
	    
	    @Test(priority=1) //Check that user is able to add products  to wishlist.
		 public void testCase001() throws InterruptedException, IOException  {
			
			 test.log(LogStatus.INFO, "Check that user is able to add products  to wishlist");
			 obj12 = new WishList(driver);
			 obj12.loginbtnMethod(); //Account
			 obj12.loginbtn1Method();
			 File file = new File("src\\test\\resources\\loginDDT.xlsx");
		        FileInputStream inputStream = new FileInputStream(file);
		        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
		        XSSFSheet sheet=wb.getSheet("Wishlist");
		        XSSFRow row2=sheet.getRow(1);
		        XSSFCell cell12=row2.getCell(0);
		        XSSFCell cell1=row2.getCell(1);
		        String userName= cell12.getStringCellValue();
		        String password= cell1.getStringCellValue();
		        obj12.email(userName);
		        obj12.passwordMethod(password);
	                obj12.loginMethod(); //Login Button
	            //Login Into Account
				obj12.homeMethod(); //Navigating To Home Page
				
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,5000)");
			 obj12.macWishlishbtnMethod(); //Adding MacBook To Wishlsit
             Thread.sleep(5000);
             //Checking Alert Displayed or Not
			 if(obj12.successAlert.isDisplayed())
			  {
			  test.log(LogStatus.PASS, "Success: You have added MacBook to your wish list!");
			  }
			  else
			  {
			  test.log(LogStatus.FAIL, "Test Failed");
			  }
			 
			 }
		 @Test(priority=2) //Verify that added product is present on the wishlist page.
		 public void testCase002() throws InterruptedException, IOException  {
			 test.log(LogStatus.INFO, "Verify that added product is present on the wishlist page");
			 obj12 = new WishList(driver);
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			    obj12.loginbtnMethod();
				obj12.loginbtn1Method();
				File file = new File("src\\test\\resources\\loginDDT.xlsx");
		        FileInputStream inputStream = new FileInputStream(file);
		        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
		        XSSFSheet sheet=wb.getSheet("Wishlist");
		        XSSFRow row2=sheet.getRow(1);
		        XSSFCell cell12=row2.getCell(0);
		        XSSFCell cell1=row2.getCell(1);
		        String userName= cell12.getStringCellValue();
		        String password= cell1.getStringCellValue();
		        obj12.email(userName);
		        obj12.passwordMethod(password);
	            obj12.loginMethod();
	            //Login Into Account
				obj12.homeMethod(); //Navigating To Home Page
				
			 obj12.wishbtntopMethod(); //Checking Element is displayed into Wishlist or not
			 WebElement product=driver.findElement(By.linkText("MacBook"));
			 if(product.isDisplayed()) {
				  test.log(LogStatus.PASS, "The added product is visible in the WishList.");
			  }
			  else {
				  test.log(LogStatus.FAIL, "The added product is not visible in the WishList.");
			  }

			 obj12.continuebtnMethod();
			 obj12.homeMethod(); //Navigating To Home Page
			  }
		 
		 @Test(priority=3)//Check that user is able to remove Product from wishlist.
		 public void testCase003() throws InterruptedException, IOException  {
			 test.log(LogStatus.INFO, "Check that user is able to remove Product from wishlist");
			 obj12 = new WishList(driver);
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			    obj12.loginbtnMethod();
				obj12.loginbtn1Method();
				File file = new File("src\\test\\resources\\loginDDT.xlsx");
		        FileInputStream inputStream = new FileInputStream(file);
		        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
		        XSSFSheet sheet=wb.getSheet("Wishlist");
		        XSSFRow row2=sheet.getRow(1);
		        XSSFCell cell12=row2.getCell(0);
		        XSSFCell cell1=row2.getCell(1);
		        String userName= cell12.getStringCellValue();
		        String password= cell1.getStringCellValue();
		        obj12.email(userName);
		        obj12.passwordMethod(password);
	            obj12.loginMethod(); //Login into Account
				obj12.homeMethod(); //Navigating To Home Page
			    obj12.wishbtntopMethod();
			   
			  obj12.removemacMethod(); //Remove product from wishlsit
			  Thread.sleep(5000);
			  if(obj12.successAlert.isDisplayed())
			  {
			  test.log(LogStatus.PASS, "Success: You have modified your wish list!");
			  test.log(LogStatus.PASS, "The added product is remove from WishList.");
			  }
			  else
			  {
			  test.log(LogStatus.FAIL, "Test Failed");
			  }
			obj12.continuebtnMethod();  
			  obj12.homeMethod(); //Navigating To Home Page
		 }
		 
		 @Test(priority=4)//Check that user is able to add products to Cart form wishlist.
		 public void testCase004() throws InterruptedException, IOException {
			
			 test.log(LogStatus.INFO, "Check that user is able to add products to Cart form wishlist");
			 obj12 = new WishList(driver);
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			    obj12.loginbtnMethod();
				obj12.loginbtn1Method();
				File file = new File("src\\test\\resources\\loginDDT.xlsx");
		        FileInputStream inputStream = new FileInputStream(file);
		        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
		        XSSFSheet sheet=wb.getSheet("Wishlist");
		        XSSFRow row2=sheet.getRow(1);
		        XSSFCell cell12=row2.getCell(0);
		        XSSFCell cell1=row2.getCell(1);
		        String userName= cell12.getStringCellValue();
		        String password= cell1.getStringCellValue();
		        obj12.email(userName);
		        obj12.passwordMethod(password);
	            obj12.loginMethod();//Login into account
				obj12.homeMethod(); //Navigating To Home Page
				
			    JavascriptExecutor js = (JavascriptExecutor) driver;
			    js.executeScript("window.scrollBy(0,5000)");
			    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 
			    obj12.macWishlishbtnMethod();//Added product into wishlist
			    obj12.wishbtntopMethod();
			    obj12.addcartmacMethod();//Added product into cart from wishlist
			 
			    if(obj12.successAlert.isDisplayed())
			    {
			    test.log(LogStatus.PASS, "Success: You have added MacBook to your shopping cart!");
			    }
			    else
			    {
			    test.log(LogStatus.FAIL, "Test Failed");
			    }
			    Thread.sleep(5000);
		        obj12.shoppingcartMethod();
			    WebElement product=driver.findElement(By.linkText("MacBook"));
			    if(product.isDisplayed()) {
				  test.log(LogStatus.PASS, "The added product is visible in the Shopping Cart.");
			     }
			    else {
				  test.log(LogStatus.FAIL, "The added product is not visible in the Shopping Cart.");
			     }
			    obj12.homeCartMethod();//Navigating To Home Page
			 }
		
		 @Test(priority=5)//Check that user is able to add more than one products to wishlist.
		 public void testCase005() throws InterruptedException, IOException {
			 
			    test.log(LogStatus.INFO, "Check that user is able to add more than one products to wishlist");
			    obj12 = new WishList(driver);
			    obj12.loginbtnMethod();
				obj12.loginbtn1Method();
				File file = new File("src\\test\\resources\\loginDDT.xlsx");
		        FileInputStream inputStream = new FileInputStream(file);
		        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
		        XSSFSheet sheet=wb.getSheet("Wishlist");
		        XSSFRow row2=sheet.getRow(1);
		        XSSFCell cell12=row2.getCell(0);
		        XSSFCell cell1=row2.getCell(1);
		        String userName= cell12.getStringCellValue();
		        String password= cell1.getStringCellValue();
		        obj12.email(userName);
		        obj12.passwordMethod(password);
	                obj12.loginMethod();//Login into account
			   obj12.homeMethod();//Navigating To Home Page
				
			    JavascriptExecutor js = (JavascriptExecutor) driver;
			    js.executeScript("window.scrollBy(0,5000)");
			    obj12.iphonewishlishbtnMethod(); //Added iphone into wishlist
			    if(obj12.successAlert.isDisplayed())
			    {
			    test.log(LogStatus.PASS, "Success: You have added iPhone to your wish list!");
			    }
			    else
			     {
			    test.log(LogStatus.FAIL, "Test Failed");
			     }
			    Thread.sleep(5000);
			    js.executeScript("window.scrollBy(0,5000)");
			    obj12.applecinemawishlishbtnMethod();//Added apple cinema into wishlist
			    if(obj12.successAlert.isDisplayed())
			    {
			     test.log(LogStatus.PASS, "Success: You have added Apple Cinema 30\" to your wish list!");
			    }
			    else
			    {
			    test.log(LogStatus.FAIL, "Test Failed");
			    }
			    Thread.sleep(5000);
			    obj12.wishbtntopMethod();
			    WebElement product1=driver.findElement(By.linkText("iPhone"));
			    WebElement product2=driver.findElement(By.linkText("Apple Cinema 30\""));
			//Checking alert diplayed for not
			 if(product1.isDisplayed()) {
				  test.log(LogStatus.PASS, "The first added product is visible in the WishList.");
			  }
			  else {
				  test.log(LogStatus.FAIL, "The  first added product is not  visible in the WishList.");
			  }
			 if(product2.isDisplayed()) {
				  test.log(LogStatus.PASS, "The second added product is visible in the WishList.");
			  }
			  else {
				  test.log(LogStatus.FAIL, "The second added product is not  visible in the Shopping Cart.");
			  }
			 obj12.homeMethod1();
			 
		 }
		 @Test(priority=6) //To check that trying to add a product to the wishlist while not logged in shows the correct warning message
		 public void testCase007() throws InterruptedException  {
			
					
					test.log(LogStatus.INFO, "To check that trying to add a product to the wishlist while not logged in shows the correct warning message");
					obj12 = new WishList(driver);
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,5000)");
					obj12.macWishlishbtnMethod(); //Added Product before login.
					
					if(obj12.successAlert.isDisplayed())
					  {
					  test.log(LogStatus.PASS, "You must login or create an account to save MacBook to your wish list!");
					  }
					  else
					  {
					  test.log(LogStatus.FAIL, "Test Failed");
					  }
					  Thread.sleep(5000);
					}
			@Parameters("browser")		 
			 @BeforeMethod
			public void setup(Method m,String browser) {
				  test=report.startTest(m.getName());
			          //WebDriverManager.chromedriver().setup();
		                // driver = new ChromeDriver();
				initialize(browser);
		                driver.get("http://localhost/opencart/");
			         //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			         //driver.manage().window().maximize();
				}	
		 
		      @AfterMethod
			public void quit() {
				
				driver.quit();
				report.endTest(test);
				report.flush();
			}
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browser) {
	   String timeStamp = new SimpleDateFormat("yyyy_MMM_dd_HH.mm.ss").format(new Date());
	  report =new ExtentReports("ExtentReports\\Wish_List_Reports\\WishListTestCases_"+browser+"_"+timeStamp+".html");
  }
		 
}


		
			


