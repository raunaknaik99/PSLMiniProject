package com.team3.miniproject.testcases.login;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.team3.miniproject.sitepages.LoginPage;
import com.team3.miniproject.testcases.ddt.ReadInputs;


public class LoginTC_OC_001_to_005 {
	
	LoginPage login1 = new LoginPage();
	ReadInputs reader= new ReadInputs();
	String expectedTitle;
	String actualTitle;

  @Test
  public void Login_1_to_4() throws IOException {
	
	  
	  	reader.readExcel("C:\\Users\\diffa_pinto\\Desktop","loginDDT.xlsx","Sheet1");
		  for (reader.i = 1; reader.i<reader.rowCount+1; reader.i++) {  
		  String emailId=reader.getEmailId();
		  String password=reader.getPassword();  
		  login1.login(emailId,password);
		  actualTitle=login1.driver.getTitle();

		  //assert Login unsuccessful/unsuccessful
		  if(reader.i<reader.rowCount) {
			expectedTitle="Account Login";
		  }
		  if(reader.i==reader.rowCount) {
			  expectedTitle="My Account";
		  }
		  Assert.assertEquals(actualTitle, expectedTitle);
			
	  
		  }
  }
  @Test 
  public void Login_5() throws IOException {
	
		  login1.login("","");
		  actualTitle=login1.driver.getTitle();
		  expectedTitle="Account Login";
		  Assert.assertEquals(actualTitle, expectedTitle);
		 
	  }
  
  @BeforeMethod
  public void beforeMethod() {
	 	 login1.navigateToLogin();
	  
	  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  login1.finish();
  }
}


