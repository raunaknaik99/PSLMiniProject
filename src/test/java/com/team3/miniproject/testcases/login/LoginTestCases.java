package com.team3.miniproject.testcases.login;
import java.io.IOException;
//package sitepages;
//
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.team3.miniproject.sitepages.LoginPage;
import com.team3.miniproject.testcases.ddt.ReadInputs;

public class LoginTestCases {
	WebDriver driver;
	LoginPage login1;
	ReadInputs reader = new ReadInputs();
	
	
 @Test
	  public void verifyTestCase001() throws IOException {
		  login1.forgotPassword();
		  
		  reader.readExcel("src\\sitepages", "loginDDT.xlsx", "Login");
		  reader.i = 10;
		  String emailId = reader.getEmailId();
		  login1.enterEmail(emailId);
		 
		  String actualTitle = driver.getTitle();
		  System.out.println(actualTitle);
	  }
	
	 @Test
	  public void verifyTestCase002() throws InterruptedException, IOException {
		 login1.forgotPassword();
		  
		  reader.readExcel("src\\sitepages", "loginDDT.xlsx", "Login");
		  reader.i = 11;
		  String emailId = reader.getEmailId();
		  login1.enterEmail(emailId);
		 
		  String actualTitle = driver.getTitle();
		  System.out.println(actualTitle);
	  }
	 
	 @Test
	  public void logoutTestCase001() throws InterruptedException, IOException {
		  login1.navigateToLogin();
		  reader.readExcel("src\\sitepages", "loginDDT.xlsx", "Login");
		  reader.i = 11;
		  String emailId = reader.getEmailId();
		  String password = reader.getPassword();
		  login1.login(emailId, password);
		  
		  login1.logout();
	  }
}
