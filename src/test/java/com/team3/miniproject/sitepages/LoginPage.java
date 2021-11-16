package com.team3.miniproject.sitepages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	public WebDriver driver;
	String baseUrl="http://localhost/miniproject/";
	String expectedTitle="Account Login";
	
	
	public void navigateToLogin() {
		WebDriverManager.chromedriver().setup(); 
		driver= new ChromeDriver();
		  driver.get(baseUrl);
		  String actualTitle=driver.getTitle();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  if ( actualTitle == expectedTitle) {
			  System.out.println("Page Title matched");
		  }
		  driver.manage().window().maximize();
		  driver.findElement(By.xpath("//*[@class='fa fa-user']")).click();
		  driver.findElement(By.xpath("//*[@id=\'top-links\']/ul/li[2]/ul/li[2]/a")).click();
	}
	public void  login(String user_name, String password) {
		driver.findElement(By.xpath("//input[@id='input-email']")).clear();
		 driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(user_name);
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 driver.findElement(By.xpath("//input[@id='input-password']")).clear();
		  driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  driver.findElement(By.xpath("//input[@value='Login']")).click();
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void finish() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	public static void main(String[] args) {
	
	
	}

}
