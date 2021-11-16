package com.team3.miniproject.sitepages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Cart {
	WebDriver driver;
	JavascriptExecutor js;
	
	public Cart(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) this.driver;
	}
	
	@FindBy(name = "search")
	WebElement searchBar;
	@FindBy(xpath = "//*[@id=\\\"search\\\"]/span/button")
	WebElement searchBtn;
	@FindBy(xpath = "//*[@id=\\\"cart\\\"]/button")
	WebElement cartBtn;
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/div/div/a")
	WebElement continueBtn;
	@FindBy(name = "quantity[51]")
	WebElement quantity;
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/form/div/table/tbody/tr/td[4]/div/span/button[1]")
	WebElement updateBtn;
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/form/div/table/tbody/tr/td[4]/div/span/button[2]")
	WebElement removeBtn;
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/div[3]/div[2]/a")
	WebElement checkout;
	@FindBy(xpath = "//*[@id=\\\"content\\\"]/div[3]/div[1]/a")
	WebElement addMoreItems;
	
	
	//coupons, estimate shipping and gift certificate dropdowns
	@FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div[1]/div[1]/h4/a")
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
	
	public void searchItems(String itemName) {
		searchBar.sendKeys(itemName);
	}
	
	public void clickSearch() {
		searchBtn.click();
	}
	
	public void clickCart() {
		cartBtn.click();
	}
	
	public void continueShopping() {
		continueBtn.click();
	}
	
	public void enterQuantity(String q) {
		quantity.clear();
		quantity.sendKeys(q);
	}
	
	public void updateQuantity() {
		updateBtn.click();
	}
	
	public void removeProduct() {
		removeBtn.click();
	}
	
	public void checkout() {
		checkout.click();
	}
	public void addMoreItemsToCart() {
		addMoreItems.click();
	}
	
	//methods for the coupons tab
	public void clickCouponDropdown() {
		js.executeScript("arguments[0].scrollIntoView();", couponDropdown);
		couponDropdown.click();
	}
	
	public void enterCouponCode(String code) {
		couponCode.sendKeys(code);
	}
	
	public void clickApplyCoupon() {
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
		getQuote.click();
	}
	
	//methods for the gift certificate tab
	public void clickGiftCertificateDropdown() {
		js.executeScript("arguments[0].scrollIntoView();", couponDropdown);
		giftCertificateDropdown.click();
	}
	
	public void enterGiftCertificateCode(String code) {
		giftCode.sendKeys(code);
	}
	
	public void clickApplyGiftCertificate() {
		applyGiftCertificate.click();
	}
}
