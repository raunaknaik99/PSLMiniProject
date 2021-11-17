package com.team3.miniproject.sitepages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	
	// Locators for topmost Navbar
	
	@FindBy(xpath="//*[@id='form-currency']/div/button")
	WebElement currencyDropDown;
	
	@FindBy(xpath="//*[@id='form-currency']/div/ul/li")
	List<WebElement> currencyOptions;
	
	@FindBy(xpath="//*[@id='top-links']/ul/li[1]/a")
	WebElement contactUsLink;
	
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/a")
	WebElement myAccountDropDown;
	
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/ul/li")
	List<WebElement> myAccountOptions;
	
	@FindBy(id="wishlist-total")
	WebElement wishlistLink;
	
	@FindBy(xpath="//*[@id='top-links']/ul/li[4]/a")
	WebElement shoppingCartLink;
	
	@FindBy(xpath="//*[@id='top-links']/ul/li[5]/a")
	WebElement checkoutLink;
	
	//HomeLink
	@FindBy(xpath = "//*[@id=\"logo\"]/h1/a")
	WebElement homepageLink;
	
	// Locators for search bar and shopping cart
	
	@FindBy(name="search")
	WebElement searchBar;
	
	@FindBy(xpath="//*[@id='search']/span/button")
	WebElement searchBtn;
	
	//Cart Drop Down
	@FindBy(id="cart")
	WebElement cartDropDown;
	
	@FindBy(xpath="//*[@id='cart']/ul/li[1]/table/tbody/tr")
	List<WebElement> itemsInCart;
	
	@FindBy(xpath="//*[@id='cart']/ul/li[2]/div/p/a[1]")
	WebElement viewCartOption;
	
	@FindBy(xpath="//*[@id='cart']/ul/li[2]/div/p/a[2]")
	WebElement checkoutOption;
	
	@FindBy(xpath="//*[@id='logo']/h1/a")
	WebElement yourStoreLink;
	
	// Locators for Blue Navbar
	
	@FindBy(xpath="//*[@id='menu']/div[2]/ul/li[1]")
	WebElement desktopsDropDown;
	
	@FindBy(xpath="//*[@id='menu']/div[2]/ul/li[1]/div/div/ul/li")
	List<WebElement> desktopsOptions;
	
	@FindBy(xpath="//*[@id='menu']/div[2]/ul/li[2]")
	WebElement laptopsNotebooksDropDown;
	
	@FindBy(xpath="//*[@id='menu']/div[2]/ul/li[2]/div/div/ul/li")
	List<WebElement> laptopsNotebooksOptions;
	
	@FindBy(xpath="//*[@id='menu']/div[2]/ul/li[3]")
	WebElement componentsDropDown;
	
	@FindBy(xpath="//*[@id='menu']/div[2]/ul/li[3]/div/div/ul/li")
	List<WebElement> componentsOptions;
	
	@FindBy(xpath="//*[@id='menu']/div[2]/ul/li[4]")
	WebElement tabletsDropDown;
	
	@FindBy(xpath="//*[@id='menu']/div[2]/ul/li[5]")
	WebElement softwareDropDown;
	
	@FindBy(xpath="//*[@id='menu']/div[2]/ul/li[6]")
	WebElement phonesPdasDropDown;
	
	@FindBy(xpath="//*[@id='menu']/div[2]/ul/li[7]")
	WebElement camerasDropDown;
	
	@FindBy(xpath="//*[@id='menu']/div[2]/ul/li[8]")
	WebElement mp3PlayersDropDown;
	
	@FindBy(xpath="//*[@id='menu']/div[2]/ul/li[8]/descendant::li")
	List<WebElement> mp3PlayersOptions;
	
	public Header(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	// Actions for topmost Navbar
	public void selectFromCurrencyDropDown(int index) {
		currencyDropDown.click();
		currencyOptions.get(index).click();
	}
	
	public void clickContactUsLink() {
		contactUsLink.click();
	}
	
	public void selectFromMyAccountDropDown(int index) {
		myAccountDropDown.click();
		myAccountOptions.get(index).click();
	}
	
	public void clickWishlistLink() {
		wishlistLink.click();
	}
	
	public void clickShoppingCartLink() {
		shoppingCartLink.click();
	}
	
	public void clickCheckoutLink() {
		checkoutLink.click();
	}
	
	//Enter HomePage Link
	public void clickHomePageLink() {
		homepageLink.click();
	}
	
	// Actions for search bar and shopping cart
	public void enterSearchQuery(String query) {
		searchBar.clear();
		searchBar.sendKeys(query);
	}
	
	public void clickSearchBtn() {
		searchBtn.click();
	}
	
	public void removeItemFromCart(int index) {
		cartDropDown.click();
		//Gives error without thread.sleep
		itemsInCart.get(index).findElement(By.tagName("button")).click();
	}
	
	public void clickViewCartOption() {
		cartDropDown.click();
		//Gives error without thread.sleep
        viewCartOption.click();
	}
	
	public void clickCheckoutOption() {
		cartDropDown.click();
		//Gives error without thread.sleep
		checkoutOption.click();
	}

	public void clickYourStoreLink() {
		yourStoreLink.click();
	}
	
	// Actions for Blue Navbar
	public void clickDesktopsDropDown() {
		desktopsDropDown.click();
	}
	
	public void selectFromDesktopsDropDown(int index) {
		action = new Actions(driver);
		action.moveToElement(desktopsDropDown);
		desktopsOptions.get(index).click();
	}
	
	public void clickLaptopsNotebooksDropDown() {
		laptopsNotebooksDropDown.click();
	}
	
	public void selectFromLaptopsNotebooksDropDown(int index) {
		action = new Actions(driver);
		action.moveToElement(laptopsNotebooksDropDown).perform();
		laptopsNotebooksOptions.get(index).click();
	}
	
	public void clickComponentsDropDown() {
		componentsDropDown.click();
	}
	
	public void selectFromComponentsDropDown(int index) {
		action = new Actions(driver);
		action.moveToElement(componentsDropDown).perform();
		componentsOptions.get(index).click();
	}
	
	public void clickTabletsDropDown() {
		tabletsDropDown.click();
	}
	
	public void clickSoftwareDropDown() {
		softwareDropDown.click();
	}
	
	public void clickPhonesPDAsDropDown() {
		phonesPdasDropDown.click();
	}
	
	public void clickCamerasDropDown() {
		camerasDropDown.click();
	}
	
	public void clickMp3PlayersDropDown() {
		mp3PlayersDropDown.click();
	}
	
	public void selectFromMp3PlayersDropDown(int index) {
		action = new Actions(driver);
		action.moveToElement(mp3PlayersDropDown).perform();
		mp3PlayersOptions.get(index).click();
	}
}
