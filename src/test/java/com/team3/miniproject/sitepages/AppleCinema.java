package com.team3.miniproject.sitepages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import screenshot.ScreenShotCapture;

public class AppleCinema {
	
	WebDriver driver;
	ScreenShotCapture ss;
	JavascriptExecutor js;
	
	//add apple cinema to cart btn
	@FindBy(css = "button[onclick=\"cart.add('42');\"]")
	WebElement appleCinemaCart;
	
	//radio button on apple cinema form
	@FindBy(xpath = "//input[@name='option[218]' and @value='5']")
	WebElement radioBtn;
	
	//checkbox on apple cinema form
	@FindBy(css = "input[value=\"8\"]")
	WebElement checkBx;
	
	//textbox on apple cinema form
	@FindBy(id = "input-option208")
	WebElement textBx;
	
	//dropdown on apple cinema form
	@FindBy(id = "input-option217")
	WebElement dropDown;
	
	//textarea on apple cinema form
	@FindBy(id="input-option209")
	WebElement textArea;
	
    //quantity on apple cinema form
	@FindBy(id="input-quantity")
	WebElement quantity;
	
	// twitter btn on apple cinema 
	@FindBy(id="b")
	WebElement tweetBtn;
	
	//add to cart button
	@FindBy(id="button-cart")
	WebElement addBtn;
	
	//element for rating Area
	@FindBy(css = "div[class='rating']")
	WebElement ratingArea;
	
	//element to click like btn
	@FindBy(css = "button[title='Like']")
	WebElement likeBtn;
	
	//element to hover over like btn
	@FindBy(css="span[class='_8f1i']")
	WebElement likeBtnSpan;
	
	//mandatory warning element
	@FindBy(css = "div[class='text-danger']")
	WebElement mandatoryWarning;
	
	//Success message element
	@FindBy(xpath = "//*[@id=\"product-product\"]/div[1]")
	WebElement successMessage;
	
	public AppleCinema(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		js=(JavascriptExecutor)driver;
	}
	
	//method to scroll and click
	public WebElement scrollAndClick2(String id) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement we = driver.findElement(By.id(id));
		js.executeScript("arguments[0].scrollIntoView();",we);
		we.click();
		return we;
	}
	
	
	//click the apple cinema cart button on home page
	public void clickAppleCinemaCart() {
		appleCinemaCart.click();
	}
	
	//click the radio btn on apple cinema form page
	public void clickRadioButton() {
		radioBtn.click();
	}
	
	//method to click checkbox
	public void clickCheckbox() {
		checkBx.click();
	}
	
	//method to enter text in textbox on apple cinema form page
	public void enterInTextbox(String text) {
		textBx.click();
		textBx.clear();
		textBx.sendKeys(text);
	}
	
	//method to select from dropdown on apple cinema form page
	public void clickDropdown(String value) {
		Select item = new Select(dropDown);
		item.selectByValue(value);
		dropDown.click();
	}
	
	//method to enter text in text area field on apple cinema form page
	public void enterInTextArea(String text) {
		textArea.clear();
		textArea.sendKeys(text);
	}
	
	//File upload part
	public boolean selectFileForUpload(String path) throws InterruptedException, AWTException {
		StringSelection stringSelection = new StringSelection(path); // StringSelction class is used for copy and paste operations
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		scrollAndClick2("button-upload222");
		Thread.sleep(5000);		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(2000);
	    Alert alert = driver.switchTo().alert();
	    if(alert != null) {
	    	alert.accept();
	    	return true;
	    }
	    else {
	    	return false;
	    }
	}
	
	//method to enter quantity in apply cinema form page
	public void enterQuantity(String num) {
		quantity.clear();
		quantity.sendKeys(num);
	}


    //method to click add to cart button on apple cinema form page
	public void clickAddToCart() {
		js.executeScript("arguments[0].scrollIntoView();", addBtn);
		addBtn.click();
	}
	
	//method to check if mandatory field warning is visible
	public WebElement checkMandatoryFieldsWarning() {
		return mandatoryWarning;
	}
	
	//method to check success alert
	public boolean checkSuccessAlert() throws InterruptedException {
		if(successMessage.isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//returns page title
	public String checkPageTitle() {
		return driver.getTitle();
	}	
	
    //method to click tweet button
	public void clickTweetBtn() throws InterruptedException, IOException {
		js.executeScript("arguments[0].scrollIntoView();", ratingArea);
		WebDriverWait w=new WebDriverWait(driver,5);
		w.until(ExpectedConditions.presenceOfElementLocated(By.id("twitter-widget-0")));
		driver.switchTo().frame("twitter-widget-0");
		w.until(ExpectedConditions.presenceOfElementLocated(By.id("b")));
		tweetBtn.click();
		Thread.sleep(5000); //only to visualize the opening of new window
	}
}
