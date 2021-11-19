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
	public WebElement scrollAndClick1(String path) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement we = driver.findElement(By.xpath(path));
		js.executeScript("arguments[0].scrollIntoView();",we);
		we.click();
		return we;
	}
	public WebElement scrollAndClick2(String id) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement we = driver.findElement(By.id(id));
		js.executeScript("arguments[0].scrollIntoView();",we);
		we.click();
		return we;
	}
	
	public void clickAppleCinemaCart(String path) {
		scrollAndClick1(path);
	}
	
	public void clickRadioButton(String path) {
		//String path_temp="";
		scrollAndClick1(path);
	}
	
	public void clickCheckbox(String path) {
		//String path="";
		scrollAndClick1(path);
	}
	
	public void enterInTextbox(String text) {
		WebElement textbox= scrollAndClick2("input-option208");
		textbox.clear();
		textbox.sendKeys(text);
	}
	
	public void clickDropdown(String value) {
		WebElement dropdown =scrollAndClick2("input-option217");
		Select item = new Select(dropdown);
		item.selectByValue(value);
		dropdown.click();
	}
	
	public void enterInTextArea(String text) {
		WebElement textArea = scrollAndClick2("input-option209");
		textArea.clear();
		textArea.sendKeys(text);
	}
	
	//File upload part
	
	public void selectFileForUpload(String path) throws InterruptedException, AWTException {
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
	    alert.accept();
	    
	}
	
	public void enterQuantity(String num) {
		WebElement quantity = scrollAndClick2("input-quantity");
		quantity.clear();
		quantity.sendKeys(num);
	}


	public void clickAddToCart(String id) {
		//String id_temp="";
		scrollAndClick2(id);
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
	
	public void checkPageTitle(String title) {
		Assert.assertEquals(title, driver.getTitle());
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
