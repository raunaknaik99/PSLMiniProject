package com.team3.miniproject.testcases.login;
//package sitepages;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.Test;
//
//public class LoginTestCases {
//	WebDriver driver;
//	
//	public LoginTestCases(WebDriver driver) {
//		this.driver = driver;
//	}
//  @Test
//  public void verifyTC_01() {
//	  driver.manage().window().maximize();
//	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	  driver.findElement(By.linkText("My Account")).click();
//	  driver.findElement(By.linkText("Login")).click();
//	  driver.findElement(By.linkText("Forgotten Password")).click();
//	  
//	  WebElement email = driver.findElement(By.id("input-email"));
//	  email.sendKeys("deekshavishwakarma@yahoo.com");
//	  
//	  driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
//	  
//	  String message = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
//	  
//	  System.out.println(message);
//	  String actualTitle = driver.getTitle();
//	  System.out.println(actualTitle);
//  }
//  @Test
//  public void verifyTC_02() throws InterruptedException {
//	  driver.manage().window().maximize();
//	  driver.findElement(By.linkText("My Account")).click();
//	  driver.findElement(By.linkText("Login")).click();
//	  Thread.sleep(2000);
//	  driver.findElement(By.linkText("Forgotten Password")).click();
//	  
//	  WebElement email = driver.findElement(By.id("input-email"));
//	  email.sendKeys("xyz-123@gmail.com");
//	  
//	  driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
//	  
//	  WebElement warning = driver.findElement(By.xpath("//*[@id=\"account-forgotten\"]/div[1]"));
//	  System.out.println(warning.getText());
//	  String actualTitle = driver.getTitle();
//	  System.out.println(actualTitle);
//  }
//  @Test
//  public void logoutTC_01() throws InterruptedException {
//	  driver.manage().window().maximize();
//	  driver.findElement(By.linkText("My Account")).click();
//	  driver.findElement(By.linkText("Login")).click();
//	  
//	  WebElement email = driver.findElement(By.id("input-email"));
//	  email.sendKeys("deekshavishwakarma@yahoo.com");
//	  
//	  WebElement password = driver.findElement(By.id("input-password"));
//	  password.sendKeys("deeksha");
//	  
//	  Thread.sleep(2000);
//	  driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
//	  
//	  driver.findElement(By.linkText("My Account")).click();
//	  Thread.sleep(2000);
//	  driver.findElement(By.linkText("Logout")).click();
//	  System.out.println(driver.getTitle());
//	  //log.info(driver.getTitle());
//	  
//	  Thread.sleep(2000);
//	  driver.findElement(By.linkText("Continue")).click();
//	 
//	  System.out.println(driver.getTitle());
//	  
//  }
//}
