package com.team3.miniproject.testcases.header;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.team3.miniproject.sitepages.Header;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeaderTest {
	Header h_object;
	WebDriver driver;
	String baseUrl = "http://localhost/opencartsite/";

	@Test(enabled = false)
	public void f() {
//	  h_object=new Header(driver);
//	  Assert.assertEquals(h_object.getPageTitle(), "xxxxxxx");
	}

	@Test(enabled = true)
	public void g() {
		h_object = new Header(driver);
		h_object.selectFromMyAccountDropDown(1);
		h_object.clickHomePageLink();
	}

	@Test(enabled = true)
	public void h() throws InterruptedException {
		h_object = new Header(driver);
		h_object.selectFromMyAccountDropDown(1);
		driver.findElement(By.id("input-email")).sendKeys("demo1@example.com");
		driver.findElement(By.id("input-password")).sendKeys("testing123");
		driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/form/input")).click();
		h_object = new Header(driver);
		h_object.clickHomePageLink();
		driver.findElement(By.xpath("//*[@id='content']/div[2]/div[1]/div/div[3]/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[3]/button[1]")).click();
		Thread.sleep(2000);
		h_object.clickCartDropDown();
//		System.out.println(h_object.getCartTotal());
//		System.out.println(h_object.getCartSubTotal());
		Thread.sleep(2000);
//		h_object.clickCartProductName(0);
		h_object.removeItemFromCart(1);
		Thread.sleep(2000);
		h_object.clickCartDropDown();
		h_object.removeItemFromCart(0);
//		Thread.sleep(2000);
//		h_object.clickViewCartOption();
	}

	@Test
	public void j() throws InterruptedException {
		h_object = new Header(driver);
		h_object.getEmptyCartText();
	}

	@Test
	public void k() throws InterruptedException {
		h_object = new Header(driver);
		h_object.selectFromMp3PlayersDropDown(5);
	}

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	};
}
