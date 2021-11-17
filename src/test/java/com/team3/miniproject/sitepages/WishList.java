package com.team3.miniproject.sitepages;

import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

	public class WishList {
		WebDriver driver;
		JavascriptExecutor js;
		 
	@FindBy(xpath="//*[@id='content']/div[2]/div[1]/div/div[3]/button[2]") //MacBook Wishlist Button
	WebElement MacWishlishbtn;
    
	@FindBy(xpath="//*[@id='content']/div[2]/div[2]/div/div[3]/button[2]") //iPhone Wishlist Button
	WebElement iphonewishlishbtn;
	
	 @FindBy(xpath="//*[@id=\"content\"]/div[2]/div[3]/div/div[3]/button[2]") //Apple Cinema 30 Wishlist button
	 WebElement applecinemawishlishbtn;
	
	 @FindBy(xpath="//*[@id=\"wishlist-total\"]") //Wishlist button Top
	 WebElement Wishbtntop;
	 
	 @FindBy(xpath="//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/a") //Remove Button for wishlist
	 WebElement removemac;
	
	 @FindBy(xpath="//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/button") //Add to Cart Button for wishlist
	public WebElement addcartmac;
	 
	 @FindBy(xpath="//*[@id=\"content\"]/div[2]/div/a") //Continue Button for wishlist
	 WebElement continuebtn;
	 
	 @FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a") //MyAccount Button present in header
	 WebElement  Loginbtn;
	 
	 
	 @FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a") //Login button present under MyAccount
	 WebElement  Loginbtn1;
	 
	 @FindBy(xpath="//*[@id=\"input-email\"]") //Email text box for login
	 WebElement  email;
	 
	 @FindBy(xpath="//*[@id=\"input-password\"]") //Password text box for login
     WebElement  password;
	 
	 @FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input") //Login Button after entering password and email
	 WebElement  Login;
	 
	 @FindBy(xpath="//*[@id=\"account-account\"]/ul/li[1]") //Home button present in header tab
	 WebElement  Home;
	 
	 @FindBy(xpath="//*[@id=\"top-links\"]/ul/li[4]/a")  //shopping cart button present on the top
	 WebElement  shoppingcart;
	 
	 @FindBy(xpath="//*[@id=\"content\"]/div[3]/div[1]/a") //Home button form cart
	 WebElement  Home13;
	 
	 @FindBy(xpath="//*[@id=\"account-wishlist\"]/ul/li[1]/a")//Home button form wishlist
	 WebElement  Homecart;	
	 
	 public WishList(WebDriver driver) {
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
		 email.sendKeys(id1);;
		}
	//Password text box for login
	public void passwordMethod(String id) {
		password.sendKeys(id);;
		}
	//Login Button after entering password and email

	public void loginMethod() {
		Login.click();
		}
	
	
	}
