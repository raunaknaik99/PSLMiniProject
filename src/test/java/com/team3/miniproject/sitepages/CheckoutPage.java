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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class CheckoutPage {
	public WebDriver driver;
	String baseUrl="http://localhost/miniproject";
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id='top-links']/ul/li[5]/a")
	WebElement checkoutIcon;
	@FindBy(xpath="//*[@name='payment_address' and @value='existing']")
	WebElement existingPaymentAddress;
	@FindBy(xpath="//*[@id='button-payment-address']")
	WebElement paymentAddressContinueButton;
	@FindBy(xpath="//*[@name='payment_address' and @value='new']")
	WebElement newPaymentAddress;
	@FindBy(xpath="//*[@name='shipping_address' and @value='existing']")
	WebElement existingShippingAddress;
	@FindBy(xpath="//*[@id='button-shipping-address']")
	WebElement shippingAddressContinueButton;
	@FindBy(xpath="//*[@name='shipping_method'  and @value='flat.flat']")
	WebElement shippingMethodFlat;
	@FindBy(xpath="//*[@name='payment_method'  and @value='cod']")
	WebElement paymentMethod;
	@FindBy(xpath="//*[@id='button-shipping-method']")
	WebElement shippingMethodContinueButton;
	@FindBy(linkText="Terms & Conditions")
	WebElement termsAndConditions;
	@FindBy(xpath="//*[@name='agree']")
	WebElement agree;
	@FindBy(xpath="//*[@id='button-payment-method']")
	WebElement paymentMethodContinueButton;
	@FindBy(xpath="//*[@id='cart-total']")
	WebElement cartTotal;
	@FindBy(xpath="//*[@name='account' and @value='register']")
	WebElement registerAccount;
	@FindBy(xpath="//*[@id='button-confirm']")
	WebElement confirmButton;
	@FindBy(xpath="//*[@id='button-account']")
	WebElement accountContinueButton;
	@FindBy(id="input-payment-firstname")
	WebElement firstNameField;
	@FindBy(id="input-payment-lastname")
	WebElement lastNameField;
	@FindBy(id="input-payment-email")
	WebElement emailField;
	@FindBy(id="input-payment-telephone")
	WebElement telephoneField;
	@FindBy(id="input-payment-password")
	WebElement passwordField;
	@FindBy(id="input-payment-confirm")
	WebElement confirmPasswordField;
	@FindBy(id="input-payment-address-1")
	WebElement address1Field;
	@FindBy(id="input-payment-city")
	WebElement cityField;
	@FindBy(id="input-payment-postcode")
	WebElement postcodeField;
	@FindBy(id="input-payment-country")
	WebElement countryField;
	@FindBy(id="input-payment-zone")
	WebElement stateField;
	@FindBy(xpath="//*[@value='Continue']")
	WebElement continueButton;
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/a/i")
	WebElement myAccountIcon;
	@FindBy(linkText="My Account")
	WebElement myAccountLinkText;
	
	public void navigateToHomepage(){
    	
//		System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
//		driver= new FirefoxDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	public void checkout(){
		checkoutIcon.click();
	}
	public void enterExistingBillingDetailsAndContinue(){
		existingPaymentAddress.click();
		paymentAddressContinueButton.click();	
	}
	public void enterNewBillingDetails(){
		newPaymentAddress.click();
	}
	public void enterExistingDeliveryDetailsAndContinue() {
		existingShippingAddress.click();
		shippingAddressContinueButton.click();
	}
	public void enterDeliveryMethodAndContinue() throws InterruptedException {
		Thread.sleep(2000);
		shippingMethodFlat.click();
		shippingMethodContinueButton.click();
	}
	public void enterPaymentMethod() throws InterruptedException {
		Thread.sleep(2000);
		paymentMethod.click();
	}
	public void agreeToTermsAndConditionsAndContinue(){
		Assert.assertEquals(termsAndConditions.getCssValue("color"), "rgba(35, 161, 209, 1)", "CSS Property matches!");
		agree.click();
		paymentMethodContinueButton.click();
	}
	public void confirmOrder() {
		confirmButton.click();
	}
	
	public void registerAccount() {
		registerAccount.click();
		Assert.assertEquals(accountContinueButton.getCssValue("color"), "#229ac8", "CSS Property matches!");
		accountContinueButton.click();
	}
	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}
	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	public void enterTelephone(String phoneNumber) {
		telephoneField.sendKeys(phoneNumber);
	}
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	public void confirmPassword(String password) {
		confirmPasswordField.sendKeys(password);
	}
	public void enterAddress1(String address1) {
		address1Field.sendKeys(address1);
	}
	public void enterCity(String city) {
		cityField.sendKeys(city);
	}
	public void enterPostCode(String postCode) {
		postcodeField.sendKeys(postCode);
	}
	
	public void enterCountry(String country) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", countryField);
		Select s = new Select(countryField);
		s.selectByVisibleText(country);
	}
	public void enterState(String state) {
		Select s = new Select(stateField);
		s.selectByVisibleText(state);
	}
	public void clickContinue() {
		continueButton.click();
	}
	public boolean checkIfUserLoggedIn(){
		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		myAccountIcon.click();
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		if (myAccountLinkText.isDisplayed()){
			return true;
		}
		else {
			return false;
		}
	}
	public boolean checkIfCartIsEmpty(){
			System.out.println(cartTotal.getText());
			if (cartTotal.getText().contains("0 item(s) - $0.00")){
				return true;
			}
			else {
				return false;
			}
	}
	public  boolean isClickable(By by)      
	{
		
	      try{
	    	  driver.findElement(by);
	    	  return true;
	      }
	      catch(Exception e) {
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
