package com.team3.miniproject.sitepages;

import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

	public class WishListPage {
		WebDriver driver;
		JavascriptExecutor js;
		 
	@FindBy(css="button[onclick=\"wishlist.add('43');\"]") //MacBook Wishlist Button
	WebElement MacWishlishbtn;
    
	@FindBy(css="button[onclick=\"wishlist.add('40');\"]") //iPhone Wishlist Button
	WebElement iphonewishlishbtn;
	
	 @FindBy(css="button[onclick=\"wishlist.add('42');\"]") //Apple Cinema 30 Wishlist button
	 WebElement applecinemawishlishbtn;
	
	 @FindBy(css="a#wishlist-total") //Wishlist button Top
	 WebElement Wishbtntop;
	 
	 @FindBy(css="a[data-original-title=\"Remove\"]") //Remove Button for wishlist
	 WebElement removemac;
	
	 @FindBy(css="#content > div.table-responsive > table > tbody > tr > td:nth-child(6) > button") //Add to Cart Button for wishlist
	WebElement addcartmac;
	 
	 @FindBy(css="a.btn.btn-primary") //Continue Button for wishlist
	 WebElement continuebtn;
	 
	 @FindBy(css="a[title=\"My Account\"]") //MyAccount Button present in header
	 WebElement  Loginbtn;
	 
	 
	 @FindBy(linkText="Login") //Login button present under MyAccount
	 WebElement  Loginbtn1;
	 
	 @FindBy(css="input#input-email") //Email text box for login
	 WebElement  email;
	 
	 @FindBy(css="input#input-password") //Password text box for login
     WebElement  password;
	 
	 @FindBy(css="input[value=\"Login\"]") //Login Button after entering password and email
	 WebElement  Login;
	 
	 @FindBy(xpath="//*[@id=\"account-account\"]/ul/li[1]") //Home button present in header tab
	 WebElement  Home;
	 
	 @FindBy(css="a[title=\"Shopping Cart\"]")  //shopping cart button present on the top
	 WebElement  shoppingcart;
	 
	 @FindBy(xpath="//*[@id=\"content\"]/div[3]/div[1]/a") //Home button form cart
	 WebElement  Home13;
	 
	 @FindBy(xpath="//*[@id=\"account-wishlist\"]/ul/li[1]/a")//Home button form wishlist
	 WebElement  Homecart;
		
	 @FindBy(css = "div.alert.alert-success.alert-dismissible")
		public WebElement successAlert;
		
	 public WishListPage(WebDriver driver) {
		 this.driver = driver;
		 js = (JavascriptExecutor) this.driver;
		 PageFactory.initElements(driver, this);
		}
		//Method for shopping cart button which located on top. 
	public void shoppingcartMethod(){
		shoppingcart.click();
	}
	//Method for returning to homepage from cart
	public void homeCartMethod(){
		Home13.click();
	}
	//method for returning to home page from account page
	public void homeMethod() {
		Home.click();
		}
//method for returning to home page from wishlist page
	public void homeMethod1() {
		Homecart.click();
		}
	//method for adding MacBook to wishlist
	public void macWishlishbtnMethod() {
		MacWishlishbtn.click();
		}
	//method for adding iPhone to wishlist
	public void iphonewishlishbtnMethod() {
		iphonewishlishbtn.click();
		}
	//method for adding apple cinema 30 to wishlist
	public void applecinemawishlishbtnMethod() {
		applecinemawishlishbtn.click();
		 }
	//Method wishlist top button.
	public void wishbtntopMethod() {
		Wishbtntop.click();
		}
	//Method remove button for wishlist
	public void removemacMethod() {
		removemac.click();
		 }
	//Method adding MacBook to cart from wishlist
	public void addcartmacMethod() {
		 addcartmac.click();
		}
	//Continue button from wishlist
	public void  continuebtnMethod() {
		 continuebtn.click();
		 }
	//MyAccount Button present in header
	public void loginbtnMethod() {
		Loginbtn.click();
		 }
	//Login button present under MyAccount
	public void loginbtn1Method() {
		Loginbtn1.click();
		}
	//Email text box for login
	public void  email(String id1) {
		 email.sendKeys(id1);
		}
	//Password text box for login
	public void passwordMethod(String id) {
		password.sendKeys(id);
		}
	//Login Button after entering password and email

	public void loginMethod() {
		Login.click();
		}
	
	
	}

