package com.team3.miniproject.sitepages;

import java.util.List;

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
	
	@FindBy(css = "#content > div.row > div:nth-child(1)")
	public List<WebElement> homeProducts;
	
	@FindBy(css = "#content > div.row > div:nth-child > div > div.image > a")
	public List<WebElement> homeImageLinks;
	
	@FindBy(css = "#content > div.row > div > div > div.button-group > button:nth-child(1)")
	public List<WebElement> homeAddToCartBtns;
	
	@FindBy(css = "#content > div.row > div:nth-child > div > div.button-group > button:nth-child(2)")
	public List<WebElement> homeWishlistBtns;
	
	@FindBy(css = "#content > div.row > div:nth-child > div > div.button-group > button:nth-child(3)")
	public List<WebElement> homeCompareBtns;
	
	
	//success alert Message
	@FindBy(css = "#common-home > div.alert.alert-success.alert-dismissible")
	public WebElement successAlert;
	
	
	//product description
	public void getProductDetails(int index) {
		js.executeScript("arguments[0].scrollIntoView();", homeImageLinks.get(index));
		homeImageLinks.get(index).click();
	}
	
	//add products to cart
	public void addProductToCart(int index) {
		System.out.println(homeAddToCartBtns.size());
		js.executeScript("arguments[0].scrollIntoView();", homeAddToCartBtns.get(index));
		homeAddToCartBtns.get(index).click();
	}
	
	//wishlist products
	public void addProductToWishlist(int index) {
		js.executeScript("arguments[0].scrollIntoView();", homeWishlistBtns.get(index));
		homeWishlistBtns.get(index);
	}
	
	//compare products
	public void addProductToCompare(int index) {
		js.executeScript("arguments[0].scrollIntoView();", homeCompareBtns.get(index));
		homeCompareBtns.get(index);
	}
	
}
