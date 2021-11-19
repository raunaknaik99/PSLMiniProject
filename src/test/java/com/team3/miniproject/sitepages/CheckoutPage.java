package com.team3.miniproject.sitepages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.team3.miniproject.testcases.ddt.ReadInputs;


public class CheckoutPage {
	public WebDriver driver;
	String baseUrl="http://localhost/miniproject";
	ReadInputs reader= new ReadInputs();
	JavascriptExecutor js;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) this.driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Checkout")
	WebElement checkoutIcon;
	
	@FindBy(css="[name='payment_address'][value='existing']")
	WebElement existingPaymentAddress;
	
	@FindBy(id="button-payment-address")
	WebElement paymentAddressContinueButton;
	
	@FindBy(css="[name='payment_address'][value='new']")
	WebElement newPaymentAddress;
	
	@FindBy(css="[name='shipping_address'][value='existing']")
	WebElement existingShippingAddress;
	
	@FindBy(id="button-shipping-address")
	WebElement shippingAddressContinueButton;
	
	@FindBy(css="[name='shipping_method'][value='flat.flat']")
	WebElement shippingMethodFlat;
	
	@FindBy(css="[name='payment_method'][value='cod']")
	WebElement paymentMethod;
	
	@FindBy(id="button-shipping-method")
	WebElement shippingMethodContinueButton;
	
	@FindBy(linkText = "Terms & Conditions")
	WebElement termsAndConditions;
	
	@FindBy(name="agree")
	WebElement agree;
	
	@FindBy(id="button-payment-method")
	WebElement paymentMethodContinueButton;
	
	@FindBy(id="cart-total")
	WebElement cartTotal;
	
	@FindBy(css="[name='account'][value='register']")
	WebElement registerAccount;
	
	@FindBy(id="button-confirm")
	WebElement confirmButton;
	
	@FindBy(id="button-account")
	WebElement accountContinueButton;
	
	@FindBy(id = "input-payment-firstname")
	WebElement firstNameField;
	
	@FindBy(id = "input-payment-lastname")
	WebElement lastNameField;
	
	@FindBy(id = "input-payment-email")
	WebElement emailField;
	
	@FindBy(id="input-payment-company")
	WebElement company;
	
	@FindBy(id = "input-payment-telephone")
	WebElement telephoneField;
	
	@FindBy(id = "input-payment-password")
	WebElement passwordField;
	
	@FindBy(id = "input-payment-confirm")
	WebElement confirmPasswordField;
	
	@FindBy(id = "input-payment-address-1")
	WebElement address1Field;
	
	@FindBy(id = "input-payment-city")
	WebElement cityField;
	
	@FindBy(id = "input-payment-postcode")
	WebElement postcodeField;
	
	@FindBy(id = "input-payment-country")
	WebElement countryField;
	
	@FindBy(id = "input-payment-zone")
	WebElement stateField;
	
	@FindBy(id="button-payment-address")
	WebElement continueButton;
	
	@FindBy(css="#top-links > ul > li.dropdown > a > i")
	WebElement myAccountIcon;
	
	@FindBy(linkText = "My Account")
	WebElement myAccountLinkText;

	public void navigateToHomepage() {

//		System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
//		driver= new FirefoxDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void checkout() {
		checkoutIcon.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterExistingBillingDetailsAndContinue() {
		existingPaymentAddress.click();
		paymentAddressContinueButton.click();
	}

	public void enterNewBillingDetails(int val){
		newPaymentAddress.click();
		reader.i=val;
		try {
			reader.readExcel("C:\\Users\\diffa_pinto\\Desktop","loginDDT.xlsx","Checkout");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		enterFirstName(reader.getFirstName());
		enterLastName(reader.getLastName());
		enterAddress1(reader.getAddress1());
		enterCity(reader.getCity());
		enterPostCode(reader.getPostCode());
		enterCountry(reader.getCountry());
		enterState(reader.getState());
		clickContinue();
	}

	public void enterExistingDeliveryDetailsAndContinue() {
		js.executeScript("arguments[0].scrollIntoView();", existingShippingAddress);
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

	public void agreeToTermsAndConditionsAndContinue() {
		Assert.assertEquals(termsAndConditions.getCssValue("color"), "rgba(35, 161, 209, 1)", "CSS Property matches!");
		agree.click();
		paymentMethodContinueButton.click();
	}

	public void confirmOrder() throws InterruptedException {
		confirmButton.click();
		Thread.sleep(6000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		confirmButton.click();
	}

	public void registerAccount() {
		registerAccount.click();
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
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

	public boolean checkIfUserLoggedIn() {

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
		if (myAccountLinkText.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkIfCartIsEmpty() {
		System.out.println(cartTotal.getText());
		if (cartTotal.getText().contains("0 item(s) - $0.00")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isClickable(By by) {

		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void closeBrowser() {
		driver.quit();
	}
	
	public WebElement getFnameElement() {
		return firstNameField;
	}
	
	public WebElement getLnameElement() {
		return lastNameField;
	}
	
	public WebElement getCompanyElement() {
		return company;
	}

	public WebElement getAddress1() {
		return address1Field;
	}
	
	public WebElement getCity() {
		return cityField;
	}
	
	public WebElement getPostCode() {
		return postcodeField;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
