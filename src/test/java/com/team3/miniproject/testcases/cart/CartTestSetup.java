package com.team3.miniproject.testcases.cart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.team3.miniproject.sitepages.AppleCinema;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CartTestSetup {
	
	WebDriver driver;
	String baseUrl="http://localhost/opencartsite/";
	AppleCinema hpc_object;
	
	
  @Test
  public void testCase008() {
	  hpc_object=new AppleCinema(driver);
	  hpc_object.clickAppleCinemaCart("//button[@onclick=\"cart.add('42');\"]");
	  hpc_object.clickRadioButton("//input[@name='option[218]' and @value='6']");
	  hpc_object.clickCheckbox("//input[@name='option[223][]' and @value='10']");
	  hpc_object.clickAddToCart("button-cart");
	  hpc_object.checkMandatoryFieldsWarning("//div[@class='text-danger']");
	  hpc_object.checkPageTitle("Apple Cinema 30");
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
