package com.team3.miniproject.sitepages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Cart {
	WebDriver driver;
	JavascriptExecutor js;
	
	public Cart(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) this.driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "search")
	WebElement searchBar;
	@FindBy(xpath = "//*[@id=\\\"search\\\"]/span/button")
	WebElement searchBtn;
	@FindBy(xpath = "//*[@id=\\\"cart\\\"]/button")
	WebElement cartBtn;
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/div/div/a")
	WebElement continueBtn; //continue button when the cart is empty
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input")
	WebElement quantity;
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[1]")
	WebElement updateBtn;
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/form/div/table/tbody/tr/td[4]/div/span/button[2]")
	WebElement removeBtn;
	@FindBy(linkText = "Checkout")
	WebElement checkoutBtn;
	@FindBy(linkText = "Continue Shopping")
	public WebElement addMoreItems; // continue button when the cart has items
	
	
	//coupons, estimate shipping and gift certificate dropdowns
	@FindBy(xpath = "//*[@id=\"accordion\"]/div[1]/div[1]/h4/a")
	WebElement couponDropdown;
	@FindBy(xpath = "//*[@id=\"accordion\"]/div[2]/div[1]/h4/a")
	WebElement shippingDropdown;
	@FindBy(xpath = "//*[@id=\"accordion\"]/div[3]/div[1]/h4/a")
	WebElement giftCertificateDropdown;
	
	//textfields and continue for coupons
	@FindBy(id = "input-coupon")
	WebElement couponCode;
	@FindBy(id = "button-coupon")
	WebElement applyCoupon;
	
	
	//textfields and continue for gift certificate
	@FindBy(id = "input-voucher")
	WebElement giftCode;
	@FindBy(id = "button-voucher")
	WebElement applyGiftCertificate;
	
	//textFields for Estimate shipping and taxes
	@FindBy(id = "input-country")
	WebElement countryDropdown;
	@FindBy(id = "input-zone")
	WebElement regionDropDown;
	@FindBy(id = "input-postcode")
	WebElement postalCode;
	@FindBy(id = "button-quote")
	WebElement getQuote;
	
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/table")
	public List<WebElement> cartItems;
	
	@FindAll(value = { @FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr") })
	List<WebElement> tableRows;
	
	@FindAll(value = { @FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]") })
	List<WebElement> prodCells;
	
//	@FindAll(value = { @FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]") })
//	List<WebElement> QuantityCells;
	
	//xpath for product details cell in cart
	String bfrXpath = "//*[@id=\"content\"]/form/div/table/tbody/tr[";
	String aftrXpath = "]/td[2]";
	
	//xpath for remove item button
	String bfrXpathBtn = "//*[@id=\"content\"]/form/div/table/tbody/tr[";
	String aftrXpathBtn = "]/td[4]/div/span/button[2]";
	
	
	public void removeOutOfStockItems() {
		int index;
		for(WebElement element : prodCells) {
			if(element.getAttribute("span") != null) {
				index = prodCells.indexOf(element) + 1;
				WebElement quantityCell = driver.findElement(By.xpath(bfrXpath + index + aftrXpath));
				WebElement removeItem = driver.findElement(By.xpath(bfrXpathBtn + index + aftrXpathBtn));
				js.executeScript("arguments[0].scrollIntoView();", removeItem);
				removeItem.click();
			}
			else {
				continue;
			}
		}
	}
	
	public void searchItems(String itemName) {
		js.executeScript("arguments[0].scrollIntoView();", searchBar);
		searchBar.sendKeys(itemName);
	}
	
	public void clickSearch() {
		js.executeScript("arguments[0].scrollIntoView();", searchBtn);
		searchBtn.click();
	}
	
	public void clickCart() {
		js.executeScript("arguments[0].scrollIntoView();", cartBtn);
		cartBtn.click();
	}
	
	public void continueShopping() {
		js.executeScript("arguments[0].scrollIntoView();", continueBtn);
		continueBtn.click();
	}
	
	public void enterQuantity(String q) {
		js.executeScript("arguments[0].scrollIntoView();", quantity);
		quantity.clear();
		quantity.sendKeys(q);
	}
	
	public void updateQuantity() {
		js.executeScript("arguments[0].scrollIntoView();", updateBtn);
		updateBtn.click();
	}
	
	public void removeProduct() {
		js.executeScript("arguments[0].scrollIntoView();", removeBtn);
		removeBtn.click();
	}
	
	public void checkout() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView();", checkoutBtn);
		checkoutBtn.click();
	}
	public void addMoreItemsToCart() {
		js.executeScript("arguments[0].scrollIntoView();", addMoreItems);
		addMoreItems.click();
	}
	
	//methods for the coupons tab
	public void clickCouponDropdown() {
		js.executeScript("arguments[0].scrollIntoView();", couponDropdown);
		couponDropdown.click();
	}
	
	public void enterCouponCode(String code) {
		couponCode.clear();
		js.executeScript("arguments[0].scrollIntoView();", couponCode);
		couponCode.sendKeys(code);
	}
	
	public void clickApplyCoupon() {
		js.executeScript("arguments[0].scrollIntoView();", applyCoupon);
		applyCoupon.click();
	}
	
	//methods for estimate shipping tab
	public void clickShippingDropdown() {
		js.executeScript("arguments[0].scrollIntoView();", shippingDropdown);
		shippingDropdown.click();
	}
	public void selectCountry(String country) {
		Select dropdown = new Select(countryDropdown);
		dropdown.selectByVisibleText(country);
		countryDropdown.click();
	}
	public void selectRegion(String region) {
		Select dropdown = new Select(countryDropdown);
		dropdown.selectByVisibleText(region);
		regionDropDown.click();
	}
	public void clickGetQuote() {
		js.executeScript("arguments[0].scrollIntoView();", getQuote);
		getQuote.click();
	}
	
	//methods for the gift certificate tab
	public void clickGiftCertificateDropdown() {
		js.executeScript("arguments[0].scrollIntoView();", giftCertificateDropdown);
		giftCertificateDropdown.click();
	}
	
	public void enterGiftCertificateCode(String code) {
		giftCode.clear();
		js.executeScript("arguments[0].scrollIntoView();", giftCode);
		giftCode.sendKeys(code);
	}
	
	public void clickApplyGiftCertificate() {
		js.executeScript("arguments[0].scrollIntoView();", applyGiftCertificate);
		applyGiftCertificate.click();
	}
}
