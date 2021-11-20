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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.team3.miniproject.testcases.ddt.ReadInputs;


public class CheckoutPage {
	public WebDriver driver;
	String baseUrl="http://localhost/opencartsite";
	ReadInputs reader= new ReadInputs();
	JavascriptExecutor js;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) this.driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="#top-links > ul > li:nth-child(5) > a > i")
	WebElement checkoutIcon;
	
	@FindBy(css="[name='payment_address'][value='existing']")
	WebElement existingPaymentAddress;
	
	@FindBy(id="button-payment-address")
	WebElement paymentAddressContinueButton;
	
	@FindBy(css="#collapse-payment-address > div > form > div:nth-child(3) > label > input[type=radio]")
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
	
	@FindBy(css="div#content> div>div:nth-of-type(3)>div>h4")
	WebElement stepTitle;
	
	@FindBy(css="div#payment-new>div:nth-of-type(6)>div>div")
	WebElement cityWarning;

	@FindBy(css="div#payment-new>div:nth-of-type(2)>div>div")
	WebElement lNameWarning;
	
	public void navigateToHomepage() {

//		System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
//		driver= new FirefoxDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void checkout() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#top-links > ul > li:nth-child(5) > a > i")));
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

	public void enterNewBillingDetails(int val) throws InterruptedException{
		System.out.println("reacehd enter new deatils");
		WebDriverWait wait = new WebDriverWait(driver,30);
		System.out.println(val);
		
		if(val==3 || val==4) {
			System.out.println("entered if");
			reader.i=val;
			try {
				reader.readExcel("src\\test\\resources","loginDDT.xlsx","Checkout");
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
		else {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#collapse-payment-address > div > form > div:nth-child(3) > label > input[type=radio]")));
			newPaymentAddress.click();
			reader.i=val;
			try {
				reader.readExcel("src\\test\\resources","loginDDT.xlsx","Checkout");
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
	
	//get firstname element
	public WebElement getFnameElement() {
		return firstNameField;
	}
	
	//get last name element
	public WebElement getLnameElement() {
		return lastNameField;
	}
	
	//get company element
	public WebElement getCompanyElement() {
		return company;
	}

	//get address1 element
	public WebElement getAddress1() {
		return address1Field;
	}
	
	//get city element
	public WebElement getCity() {
		return cityField;
	}
	
	//get post code element
	public WebElement getPostCode() {
		return postcodeField;
	}
	
	public WebElement getStep3Title() {
		return stepTitle;
	}
	
	public WebElement getCityWarning() {
		return cityWarning;
	}
	
	public WebElement getLnameWarning() {
		return lNameWarning;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
/*--------------------------------------------------------------*/
	//css for add to cart button
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/div/div[3]/button[1]")
	WebElement addToCart;
	
	//link text of Checkout link
	@FindBy(linkText = "Checkout")
	WebElement checkout;
	
	//css to click on guest radio button 
	@FindBy(css = "[name='account'][value='guest']")
	WebElement guestRadioBtn;
		
	//method to fill all the details of guest customer
	public void fillBillingDetails(String fname,String lname,String eml,String tel,String address,String city,String pCode) {
		driver.findElement(By.id("input-payment-firstname")).sendKeys(fname);
		driver.findElement(By.id("input-payment-lastname")).sendKeys(lname);		
		driver.findElement(By.id("input-payment-email")).sendKeys(eml);
		driver.findElement(By.id("input-payment-telephone")).sendKeys(tel);
		driver.findElement(By.id("input-payment-address-1")).sendKeys(address);
		driver.findElement(By.id("input-payment-city")).sendKeys(city);
		driver.findElement(By.id("input-payment-postcode")).sendKeys(pCode);
	}
	
	//method to fill delivery details if 'My billing and delivery address is same' checkbox is not ticked.
	public void fillDeliveryDetails(String fname,String lname,String address,String city,String pCode) {
		driver.findElement(By.id("input-shipping-firstname")).sendKeys(fname);
		driver.findElement(By.id("input-shipping-lastname")).sendKeys(lname);
		driver.findElement(By.id("input-shipping-address-1")).sendKeys(address);
		driver.findElement(By.id("input-shipping-city")).sendKeys(city);
		driver.findElement(By.id("input-shipping-postcode")).sendKeys(pCode);
	}
	
	//to select country and state from dropdown from billing details section
	public void selectCountryAndState(String country,String state) throws InterruptedException {
			Select drpCountry1 = new Select(driver.findElement(By.id("input-payment-country")));
			drpCountry1.selectByVisibleText(country);
			
			Thread.sleep(2000);
			Select drpState1 = new Select(driver.findElement(By.id("input-payment-zone")));
			drpState1.selectByVisibleText(state);
	}
	
	//to select country and state from dropdown from delivery details section
	public void selectCountryAndStateAgain(String countryName,String stateName) throws InterruptedException {
		Select drpCountry2 = new Select(driver.findElement(By.id("input-shipping-country")));
		drpCountry2.selectByVisibleText(countryName);
	
		Thread.sleep(2000);
		Select drpState2 = new Select(driver.findElement(By.id("input-shipping-zone")));
		drpState2.selectByVisibleText(stateName);
	}
	
	//method to check the checkbox of terms and conditions
	public void privacyCheckbox() {
		agree.click();
	}
	
	//method to confirm the order
//	public void confirmOrder() {
//		confirmButton.click();
//	}
	
	//method to accept alert while confirming the order
	public void acceptAlert() throws InterruptedException {
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(2000);
		alert1.accept();
	}
	
	//method to click on the guest radio button
	public void guestClick() throws InterruptedException {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,500)", "");
		  addToCart.click();
		  Thread.sleep(3000);
		  checkout.click();
		  Thread.sleep(2000);
		  guestRadioBtn.click();
	}
	
	//to confirm whether guest radio button is selected or not
	public boolean guestBtnSelected() {
		return guestRadioBtn.isSelected();
	}	
}

