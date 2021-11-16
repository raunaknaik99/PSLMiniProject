package com.team3.miniproject.sitepages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class Tablets {
	WebDriver driver;
	JavascriptExecutor js;
	
	public Tablets(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) this.driver;
		PageFactory.initElements(driver, this);
	}

	public By tabletDescription = By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[1]/a/img");
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")
	public WebElement addTablet;
	
	public By wishlistTablet = By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[2]");
	public By compareTablet = By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[3]");
	@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[4]/a")
	public WebElement tabletTab;

	public void viewTabletDetails() {
		driver.findElement(tabletDescription).click();
	}
	
	public void addTabletToCart() {
		tabletTab.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", addTablet);
		addTablet.click();
	}
	
	public void addTabletToWishlist() {
		driver.findElement(wishlistTablet).click();
	}
	
	public void addTabletToCompare() {
		driver.findElement(compareTablet).click();
	}
	
}
