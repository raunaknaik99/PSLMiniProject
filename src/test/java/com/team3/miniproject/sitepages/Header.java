package com.team3.miniproject.sitepages;

import java.util.List;

import org.openqa.selenium.Keys;
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

	@FindBy(css = "#form-currency > div > button")
	WebElement currencyDropDown;

	@FindBy(css = "#form-currency > div > ul > li")
	List<WebElement> currencyOptions;

	@FindBy(css = "#top-links > ul > li:nth-child(1) > a")
	WebElement contactUsLink;

	@FindBy(css = "#top-links > ul > li.dropdown > a")
	WebElement myAccountDropDown;

	@FindBy(css = "#top-links > ul > li.dropdown.open > ul > li")
	List<WebElement> myAccountOptions;

	@FindBy(id = "wishlist-total")
	WebElement wishlistLink;

	@FindBy(css = "#top-links > ul > li:nth-child(4) > a")
	WebElement shoppingCartLink;

	@FindBy(css = "#top-links > ul > li:nth-child(5) > a")
	WebElement checkoutLink;

	// Locator for home(Your Store) link
	@FindBy(css = "#logo > h1 > a")
	public WebElement homePageLink;

	// Locators for search bar and shopping cart

	@FindBy(name = "search")
	WebElement searchBar;

	@FindBy(css = "#search > span > button")
	WebElement searchBtn;

	// Cart Drop Down
	@FindBy(id = "cart")
	public WebElement cartDropDown;

	@FindBy(css = "#cart > ul > li > p")
	WebElement emptyCartText;

	@FindBy(css = "#cart > ul > li:nth-child(1) > table > tbody > tr")
	List<WebElement> productsInCart;

	@FindBy(css = "#cart > ul > li:nth-child(1) > table > tbody > tr > td:nth-child(1) > a > img")
	List<WebElement> cartProductImg;

	@FindBy(css = "#cart > ul > li:nth-child(1) > table > tbody > tr > td:nth-child(2) > a")
	List<WebElement> cartProductNames;
//
	@FindBy(css = "#cart > ul > li:nth-child(1) > table > tbody > tr > td:nth-child(3)")
	List<WebElement> cartProductQuantities;

	@FindBy(css = "#cart > ul > li:nth-child(1) > table > tbody > tr > td:nth-child(4)")
	List<WebElement> cartProductPrices;

	@FindBy(css = "#cart > ul > li:nth-child(1) > table > tbody > tr > td:nth-child(5) > button")
	List<WebElement> cartRemoveBtns;

	@FindBy(css = "#cart > ul > li:nth-child(2) > div > table > tbody > tr:nth-child(1) > td:nth-child(2)")
	WebElement cartSubTotal;

	@FindBy(css = "#cart > ul > li:nth-child(2) > div > table > tbody > tr:nth-child(4) > td:nth-child(2)")
	WebElement cartTotal;

	@FindBy(css = "#cart > ul > li:nth-child(2) > div > p > a:nth-child(1)")
	WebElement viewCartOption;

	@FindBy(css = "#cart > ul > li:nth-child(2) > div > p > a:nth-child(2)")
	WebElement checkoutOption;

	// Locators for Blue Navbar

	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(1)")
	WebElement desktopsDropDown;

	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(1) > div > div > ul > li")
	List<WebElement> desktopsOptions;

	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(2)")
	WebElement laptopsNotebooksDropDown;

	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(2) > div > div > ul > li")
	List<WebElement> laptopsNotebooksOptions;

	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(3)")
	WebElement componentsDropDown;

	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(3) > div > div > ul > li")
	List<WebElement> componentsOptions;

	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(4)")
	WebElement tabletsDropDown;

	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(5)")
	WebElement softwareDropDown;

	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(6)")
	WebElement phonesPdasDropDown;

	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(7)")
	WebElement camerasDropDown;

	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(8)")
	WebElement mp3PlayersDropDown;

	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(8) > div > div > ul > li")
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

	// Action HomePage Link
	public void clickHomePageLink() {
		homePageLink.click();
	}

	// Actions for search bar
	public void clickSearchBar() {
		searchBar.click();
	}

	public void enterSearchQuery(String query) {
		searchBar.clear();
		searchBar.sendKeys(query);
	}

	public void pressEnterOnSearchBar() {
		searchBar.sendKeys(Keys.ENTER);
	}

	public void clickSearchBtn() {
		searchBtn.click();
	}

	// Actions for shopping cart
	public void clickCartDropDown() {
		cartDropDown.click();
	}

	public String getEmptyCartText() {
		return emptyCartText.getText();
	}

	public void clickCartProductImg(int index) {
		cartProductImg.get(index).click();
	}

	public void clickCartProductName(int index) {
		cartProductNames.get(index).click();
	}

//	public void getCartProductNames(int index) {
//		cartProductNames.get(index).click();
//	}
//
//	public String getCartProductQuantities() {
//		return emptyCartText.getText();
//	}
//
//	public String getCartProductPrices() {
//		return emptyCartText.getText();
//	}

	public void removeItemFromCart(int index) {
		cartRemoveBtns.get(index).click();
	}

	public String getCartSubTotal() {
		return cartSubTotal.getText();
	}

	public String getCartTotal() {
		return cartTotal.getText();
	}

	public void clickViewCartOption() {
		shoppingCartLink.click();
	}

	public void clickCheckoutOption() {
		checkoutOption.click();
	}

	// Actions for Blue Navbar
	public void clickDesktopsDropDown() {
		desktopsDropDown.click();
	}

	public void selectFromDesktopsDropDown(int index) {
		action = new Actions(driver);
		action.moveToElement(desktopsDropDown).perform();
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
