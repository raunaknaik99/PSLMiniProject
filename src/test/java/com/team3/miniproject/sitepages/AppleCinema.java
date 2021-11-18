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
	

	//add apple cinema to cart btn
	//button[onclick="cart.add('42');"]
	@FindBy(xpath = "//button[@onclick=\"cart.add('42');\"]")
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
	
	//iframe for fb like btn
	@FindBy(xpath = "//iframe[@title='fb:like Facebook Social Plugin']")
	WebElement fbIframe;
	
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
	
	public AppleCinema(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickAppleCinemaCart() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", appleCinemaCart);
		appleCinemaCart.click();
	}
	
	public void clickRadioButton() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", radioBtn);
		radioBtn.click();
	}
	
	public void clickCheckbox() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", checkBx);
		checkBx.click();
	}
	
	public void enterInTextbox(String text) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", textBx);
		textBx.click();
		textBx.clear();
		textBx.sendKeys(text);
	}
	
	public void clickDropdown(String value) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//WebElement dropdown = driver.findElement(By.id("input-option217"));
		js.executeScript("arguments[0].scrollIntoView();", dropDown);
		dropDown.click();
		Select item = new Select(dropDown);
		item.selectByValue(value);
		dropDown.click();
	}
	
	public void enterInTextArea(String text) {
		WebElement textArea = driver.findElement(By.id("input-option209"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", textArea);
		textArea.click();
		textArea.clear();
		textArea.sendKeys(text);
	}
	
	//File upload part
	
	public void selectFileForUpload(String path) throws InterruptedException, AWTException {
		StringSelection stringSelection = new StringSelection(path); // StringSelction class is used for copy and paste operations
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		JavascriptExecutor js=(JavascriptExecutor)driver;

		WebElement uploadBtn = driver.findElement(By.id("button-upload222"));
		js.executeScript("arguments[0].scrollIntoView();", uploadBtn);
		uploadBtn.click();
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
	    alert.accept();
	    
	}
	
	public void enterQuantity(String num) {
		//WebElement quantity = driver.findElement(By.id("input-quantity"));
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		JavascriptExecutor js=(JavascriptExecutor)driver;

		js.executeScript("arguments[0].scrollIntoView();", quantity);
		quantity.click();
		quantity.clear();
		quantity.sendKeys(num);
	}


	public void clickAddToCart() {
		//String id_temp="";
		//WebElement addbtn=driver.findElement(By.id(id));
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		JavascriptExecutor js=(JavascriptExecutor)driver;

		js.executeScript("arguments[0].scrollIntoView();", addBtn);
		addBtn.click();
	}
	
	public void checkMandatoryFieldsWarning() {
		//String path_temp="";
		if(mandatoryWarning.isDisplayed()) {
			System.out.println("Warning was displayed! Add to cart failed");
		}
	}
	
	public void checkSuccessAlert() throws InterruptedException {
		WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]"));
		if(successMessage.isDisplayed()) {
			System.out.println("Apple Cinema added to cart successfully!");
		}
	}
	
	//returns page title
	public String checkPageTitle() {
		return driver.getTitle();
	}
	
	//method to click fb like button
	public void clickFbLikeBtn() throws InterruptedException, IOException {
		JavascriptExecutor js=(JavascriptExecutor)driver;

		ss=new ScreenShotCapture(driver);
		js.executeScript("arguments[0].scrollIntoView();", ratingArea);
		//WebElement fbIframe=driver.findElement(By.xpath());
		driver.switchTo().frame(fbIframe);
		Thread.sleep(5000);
		//WebElement likeBtn1=driver.findElement(By.xpath("//button[@title='Like']"));
		//WebElement likeBtn=driver.findElement(By.xpath("//span[@class='_8f1i']"));
		Actions hoverAction=new Actions(driver);
		hoverAction.moveToElement(likeBtnSpan).perform();
		Thread.sleep(3000);
		likeBtn.click();
		//
		ss.captureScreenshot("FBWindow.png");
		Thread.sleep(3000);//only to visualize the opening of new window
	}
	
	
    //method to click tweet button
	public void clickTweetBtn() throws InterruptedException, IOException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView();", ratingArea);
		WebDriverWait w=new WebDriverWait(driver,5);
		w.until(ExpectedConditions.presenceOfElementLocated(By.id("twitter-widget-0")));
		driver.switchTo().frame("twitter-widget-0");
		//WebDriverWait w2=new WebDriverWait(driver,3);
		w.until(ExpectedConditions.presenceOfElementLocated(By.id("b")));
		//driver.findElement(By.xpath("//a[@id='b']")).click();
		tweetBtn.click();
		ss=new ScreenShotCapture(driver);
		ss.captureScreenshot("TwitterWindow.png");
		Thread.sleep(3000); //only to visualize the opening of new window
	}
}
