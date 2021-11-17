package com.team3.miniproject.sitepages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class CheckoutPage {
	public WebDriver driver;
	String baseUrl="http://localhost/opencartsite/index.php?route=common/home";
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
	}
	public void navigateToHomepage() {
    	
//		System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
//		driver= new FirefoxDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	public void checkout() {
		driver.findElement(By.xpath("//*[@id='top-links']/ul/li[5]/a")).click();
	}
	public void enterExistingBillingDetailsAndContinue() {
		driver.findElement(By.xpath("//*[@name='payment_address' and @value='existing']")).click();
		driver.findElement(By.xpath("//*[@id='button-payment-address']")).click();
		
	}
	public void enterNewBillingDetails() {
		driver.findElement(By.xpath("//*[@name='payment_address' and @value='new']")).click();

		
		
	}
	public void enterExistingDeliveryDetailsAndContinue() {
		driver.findElement(By.xpath("//*[@name='shipping_address' and @value='existing']")).click();
		driver.findElement(By.xpath("//*[@id='button-shipping-address']")).click();
		
	}
	public void enterDeliveryMethodAndContinue() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='shipping_method'  and @value='flat.flat']")).click();
		driver.findElement(By.xpath("//*[@id='button-shipping-method']")).click();
		
		
	}
	public void enterPaymentMethod() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='payment_method'  and @value='cod']")).click();
		
		
		
	}
	public void agreeToTermsAndConditionsAndContinue(){
		WebElement we=driver.findElement(By.linkText("Terms & Conditions"));
		Assert.assertEquals(we.getCssValue("color"), "rgba(35, 161, 209, 1)", "CSS Property matches!");
		driver.findElement(By.xpath("//*[@name='agree']")).click();
		driver.findElement(By.xpath("//*[@id='button-payment-method']")).click();
	}
	public void confirmOrder() {
	    String cartTotal=driver.findElement(By.xpath("//*[@id='cart-total']")).getText();
	    String orderTotal=driver.findElement(By.xpath("//*[@id='collapse-checkout-confirm']/div/div[1]/table/tbody/tr/td[5]")).getText();
	    boolean test1=cartTotal.contains(orderTotal);
	    Assert.assertEquals(test1, true);
		driver.findElement(By.xpath("//*[@id='button-confirm']")).click();
		
	}
	
	public void registerAccount() {
		driver.findElement(By.xpath("//*[@name='account' and @value='register']")).click();
		WebElement we=driver.findElement(By.xpath("//*[@id='button-account']"));
		Assert.assertEquals(we.getCssValue("color"), "#229ac8", "CSS Property matches!");
		we.click();
		
	}
	public void enterFirstName(String firstName) {
		driver.findElement(By.id("input-payment-firstname")).sendKeys(firstName);
	}
	public void enterLastName(String lastName) {
		driver.findElement(By.id("input-payment-lastname")).sendKeys(lastName);
	}
	public void enterEmail(String email) {
		driver.findElement(By.id("input-payment-email")).sendKeys(email);
	}
	public void enterTelephone(String phoneNumber) {
		driver.findElement(By.id("input-payment-telephone")).sendKeys(phoneNumber);
	}
	public void enterPassword(String password) {
		driver.findElement(By.id("input-payment-password")).sendKeys(password);
	}
	public void confirmPassword(String password) {
		driver.findElement(By.id("input-payment-confirm")).sendKeys(password);
	}
	public void enterAddress1(String address1) {
		driver.findElement(By.id("input-payment-address-1")).sendKeys(address1);
	}
	public void enterCity(String city) {
		driver.findElement(By.id("input-payment-city")).sendKeys(city);
	}
	public void enterPostCode(String postCode) {
		driver.findElement(By.id("input-payment-postcode")).sendKeys(postCode);
	}
	
	public void enterCountry(String country) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement we= driver.findElement(By.id("input-payment-country"));
		js.executeScript("arguments[0].scrollIntoView(true)", we);
		Select s = new Select(we);
		s.selectByVisibleText(country);
//		we.click();
		
		
	}
	public void enterState(String state) {
//		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement we= driver.findElement(By.id("input-payment-zone"));
		Select s = new Select(we);
		s.selectByVisibleText(state);
//		we.click();
//		js.executeScript("arguments[0].scrollIntoView(true)", country);
		
	}
	public void clickContinue() {
		driver.findElement(By.xpath("//*[@value='Continue']")).click();
	}
	public boolean checkIfUserLoggedIn(){
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a/i")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.findElement(By.linkText("My Account")).isDisplayed()){
			return true;
		}
		else {
			return false;
		}
	}
	public boolean checkIfCartIsEmpty(){
			System.out.println(driver.findElement(By.id("cart-total")).getText());
			if (driver.findElement(By.id("cart-total")).getText().contains("0 item(s) - $0.00")){
				return true;
			}
			else {
				return false;
			}
	}
	public  boolean isClickable(WebElement webe)      
	{
	    try
	    {
	        WebDriverWait wait = new WebDriverWait(driver, 5);
	        wait.until(ExpectedConditions.elementToBeClickable(webe));
	        return true;
	    }
	    catch (Exception e)
	    {
	        return false;
	    }
	}
	public void closeBrowser() {
		driver.quit();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	}

}
