package com.team3.miniproject.sitepages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {
	WebDriver driver;

	// Page Locators
	@FindBy(xpath = "//*[@id='content']/h1")
	WebElement searchHeader;

	@FindBy(id = "input-search")
	WebElement searchTextBox;

	@FindBy(name = "category_id")
	WebElement categoriesDropDown;

	@FindBy(name = "sub_category")
	WebElement subcategoriesCheckBox;

	@FindBy(name = "description")
	WebElement descriptionCheckBox;

	@FindBy(id = "button-search")
	WebElement searchBtn;

	@FindBy(id = "list-view")
	WebElement listViewBtn;

	@FindBy(id = "grid-view")
	WebElement gridViewBtn;

	@FindBy(id = "compare-total")
	WebElement compareLink;

	@FindBy(id = "input-sort")
	WebElement sortDropDown;

	@FindBy(id = "input-limit")
	WebElement limitProductsDropDown;

	@FindBy(xpath = "//*[@id='content']/p[2]")
	WebElement noResultsText;

	@FindBy(xpath = "//*[@id='content']/div[3]/div")
	public List<WebElement> foundProducts;

	@FindBy(xpath = "//*[@id='content']/div[3]/div/div/div/a")
	List<WebElement> foundProductsImgLinks;

	@FindBy(xpath = "//*[@id='content']/div[3]/div/div/div[2]/div[1]/h4/a")
	List<WebElement> foundProductsNameLinks;

	@FindBy(xpath = "//*[@id='content']/div[3]/div/div/div[2]/div[1]/p[1]")
	List<WebElement> foundProductsDescriptions;

	@FindBy(xpath = "//*[@id='content']/div[3]/div/div/div[2]/div[1]/p[2]")
	List<WebElement> foundProductsPrices;

	@FindBy(xpath = "//*[@id='content']/div[3]/div/div/div[2]/div[2]/button[1]")
	public List<WebElement> addToCartBtns;

	@FindBy(xpath = "//*[@id='content']/div[3]/div/div/div[2]/div[2]/button[2]")
	List<WebElement> addToWishlistBtns;

	@FindBy(xpath = "//*[@id='content']/div[3]/div/div/div[2]/div[2]/button[3]")
	List<WebElement> addToCompareBtns;

	// Utility function
	public static String getTextNode(WebElement e) {
		String text = e.getText().trim();
		List<WebElement> children = e.findElements(By.xpath("./*"));
		for (WebElement child : children) {
			text = text.replace(child.getText(), "").trim();
		}
		return text;
	}

	// Constructor
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page Actions
	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getSearchHeader() {
		return searchHeader.getText();
	}

	public void enterSearchQuery(String query) {
		searchTextBox.clear();
		searchTextBox.sendKeys(query);
	}

	public void pressEnterOnSearchBar() {
		searchTextBox.sendKeys(Keys.ENTER);
	}

	public void clickSearchBtn() {
		searchBtn.click();
	}

	public void selectCategory(int index) {
		categoriesDropDown.click();
		Select categories = new Select(categoriesDropDown);
		categories.selectByIndex(index);
	}

	public void clickSubcategoriesCheckBox() {
		subcategoriesCheckBox.click();
	}

	public void clickDescriptionCheckBox() {
		descriptionCheckBox.click();
	}

	public void clickListViewBtn() {
		listViewBtn.click();
	}

	public void clickGridViewBtn() {
		gridViewBtn.click();
	}

	public void clickCompareLink() {
		compareLink.click();
	}

	public void selectSort(int index) {
		sortDropDown.click();
		Select sort = new Select(sortDropDown);
		sort.selectByIndex(index);
	}

	public void selectProductsLimit(int index) {
		limitProductsDropDown.click();
		Select ProductsLimit = new Select(limitProductsDropDown);
		ProductsLimit.selectByIndex(index);
	}

	public String getNoResultsText() {
		return noResultsText.getText();
	}

	public ArrayList<String> getProductNames() {
		ArrayList<String> productNames = new ArrayList<String>();
		for (WebElement productNameLink : foundProductsNameLinks) {
			productNames.add(productNameLink.getText());
		}
		return productNames;
	}

	public ArrayList<String> getProductDescriptions() {
		ArrayList<String> productDescriptions = new ArrayList<String>();
		for (WebElement productDescription : foundProductsDescriptions) {
			productDescriptions.add(productDescription.getText());
		}
		return productDescriptions;
	}

	public ArrayList<String> getProductPrices() {
		ArrayList<String> productPrices = new ArrayList<String>();
		for (WebElement productPrice : foundProductsPrices) {
			productPrices.add(getTextNode(productPrice));
		}
		return productPrices;
	}

	public void clickProductName(int index) {
		foundProductsNameLinks.get(index).click();
	}

	public void clickProductImg(int index) {
		foundProductsImgLinks.get(index).click();
	}

	public void addToCart(int index) {
		addToCartBtns.get(index).click();
	}

	public void addToWishlist(int index) {
		addToWishlistBtns.get(index).click();
	}

	public void addToCompare(int index) {
		addToCompareBtns.get(index).click();
	}
}
