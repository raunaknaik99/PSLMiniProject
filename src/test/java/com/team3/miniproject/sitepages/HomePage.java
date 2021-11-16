package com.team3.miniproject.sitepages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	JavascriptExecutor js;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) this.driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/div[2]/div[1]/div/div[1]/a/img")
	public WebElement macbook;
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/div[2]/div[2]/div/div[1]/a/img")
	public WebElement iPhone;
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/div[2]/div[3]/div/div[1]/a/img")
	public WebElement cinema;
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/div[2]/div[4]/div/div[1]/a/img")
	public WebElement canon;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1]")
	public WebElement addMacbook;
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/div/div[3]/button[1]")
	public WebElement addIphone;
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[3]/div/div[3]/button[1]")
	public WebElement addCinema;
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[4]/div/div[3]/button[1]")
	public WebElement addCanon;
	
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/div[2]/div[1]/div/div[3]/button[2]")
	public WebElement wishlistMacbook;
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/div[2]/div[2]/div/div[3]/button[2]")
	public WebElement wishlistIphone;
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/div[2]/div[3]/div/div[3]/button[2]")
	public WebElement wishlistCinema;
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/div[2]/div[4]/div/div[3]/button[2]")
	public WebElement wishlistCanon;
	
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/div[2]/div[1]/div/div[3]/button[3]")
	public WebElement compareMacbook;
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/div[2]/div[2]/div/div[3]/button[3]")
	public WebElement compareIphone;
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/div[2]/div[3]/div/div[3]/button[3]")
	public WebElement compareCinema;
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/div[2]/div[4]/div/div[3]/button[3]")
	public WebElement compareCanon;
	
	@FindBy(xpath = "//*[@id=\"common-home\"]/div[1]")
	public WebElement successAlert;
	
	
	//product description
	public void getMacbookDetails() {
		js.executeScript("arguments[0].scrollIntoView();", addMacbook);
		macbook.click();
	}
	
	public void getIphoneDetails() {
		js.executeScript("arguments[0].scrollIntoView();", addIphone);
		iPhone.click();
	}
	
	public void getCinemaDetails() {
		js.executeScript("arguments[0].scrollIntoView();", addCinema);
		cinema.click();
	}
	
	public void getCanonDetails() {
		js.executeScript("arguments[0].scrollIntoView();", addCanon);
		canon.click();
	}
	
	//add products to cart
	public void addMacbookToCart() {
		js.executeScript("window.scrollBy(0,800);");
		addMacbook.click();
	}
	
	public void addIphoneToCart() {
		js.executeScript("arguments[0].scrollIntoView();", addIphone);
		addIphone.click();
	}
	
	public void addCinemaToCart() {
		js.executeScript("arguments[0].scrollIntoView();", addCinema);
		addCinema.click();
	}
	
	public void addCanonToCart() {
		js.executeScript("arguments[0].scrollIntoView();", addCanon);
		addCanon.click();
	}
	//wishlist products
	public void addMackbookToWishlist() {
		js.executeScript("arguments[0].scrollIntoView();", wishlistMacbook);
		wishlistMacbook.click();
	}
	
	public void addIphoneToWishList() {
		js.executeScript("arguments[0].scrollIntoView();", wishlistIphone);
		wishlistIphone.click();
	}
	
	public void addCinemaToWishlist() {
		js.executeScript("arguments[0].scrollIntoView();", wishlistCinema);
		addCinema.click();
	}
	
	public void addCanonToWishlist() {
		js.executeScript("arguments[0].scrollIntoView();", wishlistCanon);
		wishlistCanon.click();
	}
	
	//compare products
	public void addMacbookToCompare() {
		js.executeScript("arguments[0].scrollIntoView();", compareMacbook);
		compareMacbook.click();
	}
	
	public void addIphoneToCompare() {
		js.executeScript("arguments[0].scrollIntoView();", compareIphone);
		compareIphone.click();
	}
	
	public void addCinemaToCompare() {
		js.executeScript("arguments[0].scrollIntoView();", compareCinema);
		compareCinema.click();
	}
	
	public void addCanonToCompare() {
		js.executeScript("arguments[0].scrollIntoView();", compareCanon);
		compareCanon.click();
	}
}
