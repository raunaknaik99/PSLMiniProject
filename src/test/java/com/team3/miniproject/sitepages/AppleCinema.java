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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import screenshot.ScreenShotCapture;

public class AppleCinema {
	
	WebDriver driver;
	ScreenShotCapture ss;
	
	public AppleCinema(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickAppleCinemaCart(String path) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement cart=driver.findElement(By.xpath(path));
		js.executeScript("arguments[0].scrollIntoView();", cart);
		cart.click();
	}
	
	public void clickRadioButton(String path) {
		//String path_temp="";
		WebElement radiobtn=driver.findElement(By.xpath(path));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", radiobtn);
		radiobtn.click();
	}
	
	public void clickCheckbox(String path) {
		//String path="";
		WebElement checkbx=driver.findElement(By.xpath(path));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", checkbx);
		checkbx.click();
	}
	
	public void enterInTextbox(String text) {
		WebElement textbox = driver.findElement(By.id("input-option208"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", textbox);
		textbox.click();
		textbox.clear();
		textbox.sendKeys(text);
	}
	
	public void clickDropdown(String value) {
		WebElement dropdown = driver.findElement(By.id("input-option217"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", dropdown);
		dropdown.click();
		Select item = new Select(dropdown);
		item.selectByValue(value);
		dropdown.click();
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
		
		WebElement uploadBtn = driver.findElement(By.id("button-upload222"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
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
		WebElement quantity = driver.findElement(By.id("input-quantity"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", quantity);
		quantity.click();
		quantity.clear();
		quantity.sendKeys(num);
	}


	public void clickAddToCart(String id) {
		//String id_temp="";
		WebElement addbtn=driver.findElement(By.id(id));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", addbtn);
		addbtn.click();
	}
	
	public void checkMandatoryFieldsWarning(String path) {
		//String path_temp="";
		if(driver.findElement(By.xpath(path)).isDisplayed()) {
			System.out.println("Warning was displayed! Add to cart failed");
		}
	}
	
	public void checkSuccessAlert() throws InterruptedException {
		WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]"));
		if(successMessage.isDisplayed()) {
			System.out.println("Apple Cinema added to cart successfully!");
		}
	}
	
	public String checkPageTitle() {
		//Assert.assertEquals(title, driver.getTitle());
		return driver.getTitle();
	}
	
	//method to click fb like button
	public void clickFbLikeBtn() throws InterruptedException, IOException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[@class='rating']")));
		WebElement fbIframe=driver.findElement(By.xpath("//iframe[@title='fb:like Facebook Social Plugin']"));
		driver.switchTo().frame(fbIframe);
		Thread.sleep(5000);
		WebElement likeBtn=driver.findElement(By.xpath("//button[@title='Like']/span"));
		Actions hoverAction=new Actions(driver);
		hoverAction.moveToElement(likeBtn).perform();
		likeBtn.click();
		ss=new ScreenShotCapture(driver);
		ss.captureScreenshot("FBWindow.png");
		Thread.sleep(3000);//only to visualize the opening of new window
	}
	
	
    //method to click tweet button
	public void clickTweetBtn() throws InterruptedException, IOException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[@class='rating']")));
		driver.switchTo().frame("twitter-widget-0");
		WebDriverWait w=new WebDriverWait(driver,3);
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='b']")));
		driver.findElement(By.xpath("//a[@id='b']")).click();
		ss=new ScreenShotCapture(driver);
		ss.captureScreenshot("TwitterWindow.png");
		Thread.sleep(3000); //only to visualize the opening of new window
	}
}
