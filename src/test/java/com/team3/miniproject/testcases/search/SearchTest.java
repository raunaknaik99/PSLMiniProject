package com.team3.miniproject.testcases.search;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.team3.miniproject.sitepages.Header;
import com.team3.miniproject.sitepages.SearchPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest {
	Header h_object;
	SearchPage sp_object;
	WebDriver driver;
	String baseUrl = "http://localhost/opencartsite/";

	// Utility function
	public void assertProductDetails(String actualName, String actualDescription, String actualPrice,
			String expectedName, String expectedDescription, String expectedPrice) {
		Assert.assertEquals(actualName, expectedName);
		Assert.assertEquals(actualDescription, expectedDescription);
		Assert.assertEquals(actualPrice, expectedPrice);
	}

	// no search input
	// should pass
	@Test
	public void testCase001() throws InterruptedException {
		sp_object = new SearchPage(driver);
		h_object = new Header(driver);

		h_object.clickSearchBtn();
		Assert.assertEquals(sp_object.getSearchHeader(), "Search");
		Assert.assertEquals(sp_object.getNoResultsText(), "Your shopping cart is empty!");
		Assert.assertEquals(sp_object.getProductNames().size(), 0);
	}

	// exact product as search input
	// should pass
	@Test
	public void testCase002() throws InterruptedException {
		sp_object = new SearchPage(driver);
		h_object = new Header(driver);

		h_object.enterSearchQuery("iPhone");
		h_object.clickSearchBtn();

		ArrayList<String> foundProductNames = sp_object.getProductNames();
		ArrayList<String> foundProductDescriptions = sp_object.getProductDescriptions();
		ArrayList<String> foundProductPrices = sp_object.getProductPrices();

		assertProductDetails(foundProductNames.get(0), foundProductDescriptions.get(0), foundProductPrices.get(0),
				"iPhone",
				"iPhone is a revolutionary new mobile phone that allows you to make a call by simply tapping a name o..",
				"$123.20");

	}

	// check case sensitivity of searched input
	// should pass
	@Test
	public void testCase003() {
		sp_object = new SearchPage(driver);
		h_object = new Header(driver);

		h_object.enterSearchQuery("IPHONE");
		h_object.clickSearchBtn();

		ArrayList<String> foundProductNames = sp_object.getProductNames();
		Assert.assertEquals(foundProductNames.get(0), "iPhone");
	}

	// contains part of searched input
	// should pass
	@Test
	public void testCase004() {
		sp_object = new SearchPage(driver);
		h_object = new Header(driver);

		h_object.enterSearchQuery("mac");
		h_object.clickSearchBtn();

		ArrayList<String> foundProductNames = sp_object.getProductNames();
		Assert.assertEquals(foundProductNames.get(0), "iMac");
		Assert.assertEquals(foundProductNames.get(1), "MacBook");
		Assert.assertEquals(foundProductNames.get(2), "MacBook Air");
		Assert.assertEquals(foundProductNames.get(3), "MacBook Pro");
	}

	// Check if enter key works when search bar is active
	// Should pass
	@Test
	public void testCase005() {
		sp_object = new SearchPage(driver);
		h_object = new Header(driver);

		h_object.enterSearchQuery("iphone");
		h_object.pressEnterOnSearchBar();

		Assert.assertEquals(sp_object.getPageTitle(), "Search - iphone");
	}

	// Check if search is maintained when going to a product page and coming back
	// Should pass
	@Test
	public void testCase006() {
		sp_object = new SearchPage(driver);
		h_object = new Header(driver);

		h_object.enterSearchQuery("mac");
		h_object.clickSearchBtn();

		sp_object.clickProductName(1);
		driver.navigate().back();

		ArrayList<String> foundProductNames = sp_object.getProductNames();
		Assert.assertEquals(foundProductNames.get(0), "iMac");
		Assert.assertEquals(foundProductNames.get(1), "MacBook");
		Assert.assertEquals(foundProductNames.get(2), "MacBook Air");
		Assert.assertEquals(foundProductNames.get(3), "MacBook Pro");
	}

	// Check if correct search header is shown
	// Should pass
	@Test
	public void testCase007() {
		sp_object = new SearchPage(driver);
		h_object = new Header(driver);

		h_object.enterSearchQuery("iPhone");
		h_object.clickSearchBtn();

		Assert.assertEquals(sp_object.getSearchHeader(), "Search - iPhone");
	}

	// Check if correct sorting is done
	// Should pass
	@Test
	public void testCase008() {
		sp_object = new SearchPage(driver);
		h_object = new Header(driver);

		h_object.enterSearchQuery("mac");
		h_object.clickSearchBtn();

		ArrayList<String> foundProductNames;

		// Name(A-Z) sort
		sp_object.selectSort(1);
		foundProductNames = sp_object.getProductNames();
		Assert.assertEquals(foundProductNames.get(0), "iMac");
		Assert.assertEquals(foundProductNames.get(1), "MacBook");
		Assert.assertEquals(foundProductNames.get(2), "MacBook Air");
		Assert.assertEquals(foundProductNames.get(3), "MacBook Pro");

		// Name(Z-A) sort
		sp_object.selectSort(2);
		foundProductNames = sp_object.getProductNames();
		Assert.assertEquals(foundProductNames.get(0), "MacBook Pro");
		Assert.assertEquals(foundProductNames.get(1), "MacBook Air");
		Assert.assertEquals(foundProductNames.get(2), "MacBook");
		Assert.assertEquals(foundProductNames.get(3), "iMac");

		// Price (Low to High) sort
		sp_object.selectSort(3);
		foundProductNames = sp_object.getProductNames();
		Assert.assertEquals(foundProductNames.get(0), "iMac");
		Assert.assertEquals(foundProductNames.get(1), "MacBook");
		Assert.assertEquals(foundProductNames.get(2), "MacBook Air");
		Assert.assertEquals(foundProductNames.get(3), "MacBook Pro");

		// Price (High to Low) sort
		sp_object.selectSort(4);
		foundProductNames = sp_object.getProductNames();
		Assert.assertEquals(foundProductNames.get(0), "MacBook Pro");
		Assert.assertEquals(foundProductNames.get(1), "MacBook Air");
		Assert.assertEquals(foundProductNames.get(2), "MacBook");
		Assert.assertEquals(foundProductNames.get(3), "iMac");
	}

	@Test
	public void testCase009() {
		sp_object = new SearchPage(driver);
		h_object = new Header(driver);

		h_object.enterSearchQuery("iPhone");
		h_object.clickSearchBtn();

		sp_object.clickProductImg(0);

		Assert.assertEquals(sp_object.getPageTitle(), "iPhone");
	}

	@Test
//	public void f() throws InterruptedException {
//		sp_object = new SearchPage(driver);
//		h_object = new Header(driver);
//
//		h_object.enterSearchQuery("mac");
//		h_object.clickSearchBtn();
//		sp_object.addToCart(0);
//		sp_object.addToCart(1);
//		sp_object.addToCart(2);
//		sp_object.addToCart(3);
//
//		sp_object.addToWishlist(2);
//		sp_object.addToCompare(0);
//		sp_object.addToCompare(1);
//
//		sp_object.clickCompareLink();
//	}

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
