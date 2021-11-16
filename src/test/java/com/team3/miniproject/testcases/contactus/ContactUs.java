package com.team3.miniproject.testcases.contactus;
//package sitepages;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class ContactUs {
//	WebDriver driver;
//	String baseUrl;
//  @Test(priority=1)
//  public void contactTC_001() throws InterruptedException {
//	  driver.findElement(By.linkText("My Account")).click();
//	  driver.findElement(By.linkText("Login")).click();
//	  
//	  WebElement email = driver.findElement(By.id("input-email"));
//	  email.sendKeys("deekshavishwakarma@yahoo.com");
//	  
//	  driver.findElement(By.id("input-password")).sendKeys("deeksha");
//	  driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
//	  //Thread.sleep(4000);
//	  JavascriptExecutor js = (JavascriptExecutor) driver;
//	  js.executeScript("window.scrollBy(0,500)", "");
//	  
//	  Thread.sleep(3000);
//	  driver.findElement(By.linkText("Contact Us")).click();
//	  driver.findElement(By.id("input-enquiry")).sendKeys("This is the input for enquiry field");
//	  Thread.sleep(3000);
//	  driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input")).click();
//	  Thread.sleep(3000);
//	  System.out.println(driver.getTitle());
//	  driver.findElement(By.linkText("Continue"));
//  }
//  
//  @Test(priority=2)
//  public void contactTC_002() throws InterruptedException {
//	  driver.findElement(By.linkText("My Account")).click();
//	  driver.findElement(By.linkText("Login")).click();
//	  
//	  WebElement email = driver.findElement(By.id("input-email"));
//	  email.sendKeys("deekshavishwakarma@yahoo.com");
//	  
//	  driver.findElement(By.id("input-password")).sendKeys("deeksha");
//	  driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
//	  //Thread.sleep(4000);
//	  JavascriptExecutor js = (JavascriptExecutor) driver;
//	  js.executeScript("window.scrollBy(0,500)", "");
//	  
//	  Thread.sleep(3000);
//	  driver.findElement(By.linkText("Contact Us")).click();
//	  
//	  WebElement name = driver.findElement(By.id("input-name"));
//	  name.clear();
//	  name.sendKeys("Joe");
//	  
//	  Thread.sleep(2000);
//	  WebElement email_field = driver.findElement(By.id("input-email"));
//	  email_field.clear();
//	  email_field.sendKeys("joe@demo.com");
//	  
//	  driver.findElement(By.id("input-enquiry")).sendKeys("This is the input for enquiry field");
//	  Thread.sleep(3000);
//	  driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input")).click();
//	  Thread.sleep(3000);
//	  System.out.println(driver.getTitle());
//	  driver.findElement(By.linkText("Continue"));
//  }
//  @BeforeMethod
//  public void beforeMethod() {
//	  WebDriverManager.chromedriver().setup();
//	  driver = new ChromeDriver();
//	  
//	  baseUrl = "http://localhost/webcreation/upload/index.php";
//	  driver.get(baseUrl);
//	  driver.manage().window().maximize();
//	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	  
//  }
//
//  @AfterMethod
//  public void afterMethod() {
//	  driver.quit();
//  }
//}
