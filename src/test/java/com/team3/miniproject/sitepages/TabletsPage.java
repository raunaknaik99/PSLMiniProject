package com.team3.miniproject.sitepages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class TabletsPage {
	WebDriver driver;
	JavascriptExecutor js;
	
	public TabletsPage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) this.driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content > div:nth-child(3) > div > div > div.image > a > img" )
	WebElement tabletDescription;
	@FindBy(css = "#content > div:nth-child(3) > div > div > div:nth-child(2) > div.button-group > button:nth-child(1)")
	public WebElement addTablet;
	
	@FindBy(css = "#content > div:nth-child(3) > div > div > div:nth-child(2) > div.button-group > button:nth-child(2)")
	WebElement wishlistTablet;
	@FindBy(css = "")
	WebElement compareTablet;
	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(4) > a")
	public WebElement tabletTab;

	public void viewTabletDetails() {
		tabletDescription.click();
	}
	
	public void addTabletToCart() {
		tabletTab.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", addTablet);
		addTablet.click();
	}
	
	public void addTabletToWishlist() {
		wishlistTablet.click();
	}
	
	public void addTabletToCompare() {
		compareTablet.click();
	}
	
}
