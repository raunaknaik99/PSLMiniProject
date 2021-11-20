package com.team3.miniproject.testcases.search;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.team3.miniproject.sitepages.Header;
import com.team3.miniproject.sitepages.SearchPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import screenshot.ScreenShotCapture;

public class SearchTest {
	Header h_object;
	SearchPage sp_object;
	WebDriver driver;
	String baseUrl = "http://localhost/opencartsite/";
	ExtentReports report;
	ExtentTest test;
	ScreenShotCapture s;
	String timeStamp;

	// To test if page title is correct after searching
	// Should pass
	@Test
	public void testCase001() throws InterruptedException, IOException {
		test.log(LogStatus.INFO, "To test if page title is correct after searching");
		s = new ScreenShotCapture(driver);
		sp_object = new SearchPage(driver);
		h_object = new Header(driver);

		test.log(LogStatus.INFO, "Searching for \"iPhone\"");
		h_object.enterSearchQuery("iPhone");
		h_object.clickSearchBtn();

		if (sp_object.getPageTitle().equals("Search - iPhone"))
			test.log(LogStatus.PASS, "Test Passed: The page title matched");
		else
			test.log(LogStatus.FAIL,
					test.addScreenCapture(s.captureScreenshot("\\Search\\testCase001_" + timeStamp + ".PNG"))
							+ "Test Failed: The page title did not match");
	}

	// To test if search header is correct after a search
	// Should pass
	@Test
	public void testCase002() throws InterruptedException, IOException {
		test.log(LogStatus.INFO, "To test if search header is correct after a search");
		s = new ScreenShotCapture(driver);
		sp_object = new SearchPage(driver);
		h_object = new Header(driver);

		test.log(LogStatus.INFO, "Searching for \"iPhone\"");
		h_object.enterSearchQuery("iPhone");
		h_object.clickSearchBtn();

		if (sp_object.getSearchHeader().equals("Search - iPhone"))
			test.log(LogStatus.PASS, "Test Passed: The search header is correct");
		else
			test.log(LogStatus.FAIL,
					test.addScreenCapture(s.captureScreenshot("\\Search\\testCase002_" + timeStamp + ".PNG"))
							+ "Test Failed: The search header is incorrect");
	}

	// To test if No results found text is displayed when search gives no results
	// should fail
	@Test
	public void testCase003() throws InterruptedException, IOException {
		test.log(LogStatus.INFO, "To test if \"No results found\" text is displayed when search gives no results");
		s = new ScreenShotCapture(driver);
		sp_object = new SearchPage(driver);
		h_object = new Header(driver);

		test.log(LogStatus.INFO, "Clicking search button");
		h_object.clickSearchBtn();

		if (sp_object.getNoResultsText().equals("No results found"))
			test.log(LogStatus.PASS, "Test Passed: \"No results found\" is displayed");
		else
			test.log(LogStatus.FAIL,
					test.addScreenCapture(s.captureScreenshot("\\Search\\testCase003_" + timeStamp + ".PNG"))
							+ "Test Failed: \"No results found\" is not displayed");
	}

	// To test if search is done even when there is no search input
	@Test
	public void testCase004() throws InterruptedException, IOException {
		test.log(LogStatus.INFO, "To test if search is done even when there is no search input");
		s = new ScreenShotCapture(driver);
		sp_object = new SearchPage(driver);
		h_object = new Header(driver);

		test.log(LogStatus.INFO, "Clicking search button");
		h_object.clickSearchBtn();

		if (sp_object.getPageTitle().equals("Your Store"))
			test.log(LogStatus.PASS, "Test Passed: A search was not done");
		else
			test.log(LogStatus.FAIL,
					test.addScreenCapture(s.captureScreenshot("\\Search\\testCase004_" + timeStamp + ".PNG"))
							+ "Test Failed: A search was done");
	}

	// To test if no products found when searching with an input having no results
	// should pass
	@Test
	public void testCase005() throws InterruptedException, IOException {
		test.log(LogStatus.INFO, "To test if no products found when searching with an input having no results");
		s = new ScreenShotCapture(driver);
		sp_object = new SearchPage(driver);
		h_object = new Header(driver);

		test.log(LogStatus.INFO, "Searching for \"lenovo\"");
		h_object.enterSearchQuery("lenovo");
		h_object.clickSearchBtn();

		if (sp_object.numProductsFound() == 0)
			test.log(LogStatus.PASS, "Test Passed: No results were found, as expected");
		else
			test.log(LogStatus.FAIL,
					test.addScreenCapture(s.captureScreenshot("\\Search\\testCase005_" + timeStamp + ".PNG"))
							+ "Test Failed: Unexpected results were found");
	}

	// To test if search is successful when exact product name is search input
	// should pass
	@Test
	public void testCase006() throws InterruptedException, IOException {
		test.log(LogStatus.INFO, "To test if search is successful when exact product name is search input");
		s = new ScreenShotCapture(driver);
		sp_object = new SearchPage(driver);
		h_object = new Header(driver);

		test.log(LogStatus.INFO, "Searching for \"iPhone\"");
		h_object.enterSearchQuery("iPhone");
		h_object.clickSearchBtn();

		if (sp_object.numProductsFound() == 1)
			test.log(LogStatus.PASS, "Test Passed: 1 result was found, as expected");
		else if (sp_object.numProductsFound() < 1)
			test.log(LogStatus.FAIL,
					test.addScreenCapture(s.captureScreenshot("\\Search\\testCase006_" + timeStamp + ".PNG"))
							+ "Test Failed: No results were found");
		else if (sp_object.numProductsFound() > 1)
			test.log(LogStatus.FAIL,
					test.addScreenCapture(s.captureScreenshot("\\Search\\testCase006_" + timeStamp + ".PNG"))
							+ "Test Failed: More than one result was found");
	}

	// To test if pressing enter key on search bar will initiate a search
	// Should pass
	@Test
	public void testCase007() throws IOException {
		test.log(LogStatus.INFO, "To test if pressing enter key on search bar will initiate a search");
		s = new ScreenShotCapture(driver);
		sp_object = new SearchPage(driver);
		h_object = new Header(driver);

		test.log(LogStatus.INFO, "Entering \"iPhone in search bar\"");
		h_object.enterSearchQuery("iPhone");
		test.log(LogStatus.INFO, "Pressing Enter key");
		h_object.pressEnterOnSearchBar();

		if (sp_object.getPageTitle().equals("Search - iPhone"))
			test.log(LogStatus.PASS, "Test Passed: Search page was reached");
		else
			test.log(LogStatus.FAIL,
					test.addScreenCapture(s.captureScreenshot("\\Search\\testCase007_" + timeStamp + ".PNG"))
							+ "Test Failed: Search page was not reached");
	}

	// To test if found product details displayed after search are correct
	// should pass
	@Test
	public void testCase008() throws InterruptedException, IOException {
		test.log(LogStatus.INFO, "To test if found product details displayed after search are correct");
		s = new ScreenShotCapture(driver);
		sp_object = new SearchPage(driver);
		h_object = new Header(driver);

		test.log(LogStatus.INFO, "Searching for \"iPhone\"");
		h_object.enterSearchQuery("iPhone");
		h_object.clickSearchBtn();

		int flag = 0;

		String expectedProductName = "iPhone";
		String expectedProductDescription = "iPhone is a revolutionary new mobile phone that allows you to make a call by simply tapping a name o..";
		String expectedProductPrice = "$123.20";

		if (!sp_object.getProductNames().get(0).equals(expectedProductName)) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(s.captureScreenshot("\\Search\\testCase008.1_" + timeStamp + ".PNG"))
							+ "Test Failed: Expected product name = " + expectedProductName + ", Actual Product name = "
							+ sp_object.getProductNames().get(0));
			flag++;
		}
		if (!sp_object.getProductDescriptions().get(0).equals(expectedProductDescription)) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(s.captureScreenshot("\\Search\\testCase008.2_" + timeStamp + ".PNG"))
							+ "Test Failed: Expected product description = " + expectedProductDescription
							+ ", Actual Product description = " + sp_object.getProductDescriptions().get(0));
			flag++;
		}
		if (!sp_object.getProductPrices().get(0).equals(expectedProductPrice)) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(s.captureScreenshot("\\Search\\testCase008.3_" + timeStamp + ".PNG"))
							+ "Test Failed: Expected product price = " + expectedProductPrice
							+ ", Actual Product price = " + sp_object.getProductPrices().get(0));
			flag++;
		}

		if (flag == 0)
			test.log(LogStatus.PASS, "Test Passed: Displayed product details were accurate");
	}

	// To test if search is case sensitive
	// should pass
	@Test
	public void testCase009() throws IOException {
		test.log(LogStatus.INFO, "To test if search is case sensitive");
		s = new ScreenShotCapture(driver);
		sp_object = new SearchPage(driver);
		h_object = new Header(driver);

		test.log(LogStatus.INFO, "Searching for \"IPHONE\"");
		h_object.enterSearchQuery("IPHONE");
		h_object.clickSearchBtn();

		if (sp_object.numProductsFound() == 1)
			test.log(LogStatus.PASS, "Test Passed: 1 result was found, as expected");
		else if (sp_object.numProductsFound() < 1)
			test.log(LogStatus.FAIL,
					test.addScreenCapture(s.captureScreenshot("\\Search\\testCase009_" + timeStamp + ".PNG"))
							+ "Test Failed: No results were found");
		else if (sp_object.numProductsFound() > 1)
			test.log(LogStatus.FAIL,
					test.addScreenCapture(s.captureScreenshot("\\Search\\testCase009_" + timeStamp + ".PNG"))
							+ "Test Failed: More than 1 result was found");
	}

	// To test if search is successful if query contains part of product name
	// should pass
	@Test
	public void testCase010() throws IOException {
		test.log(LogStatus.INFO, "To test if search is successful if query contains part of product name");
		s = new ScreenShotCapture(driver);
		sp_object = new SearchPage(driver);
		h_object = new Header(driver);

		test.log(LogStatus.INFO, "Searching for \"mac\"");
		h_object.enterSearchQuery("mac");
		h_object.clickSearchBtn();

		if (sp_object.numProductsFound() == 4)
			test.log(LogStatus.PASS, "Test Passed: 4 results were found, as expected");
		else if (sp_object.numProductsFound() < 1)
			test.log(LogStatus.FAIL,
					test.addScreenCapture(s.captureScreenshot("\\Search\\testCase010_" + timeStamp + ".PNG"))
							+ "Test Failed: No results were found");
		else if (sp_object.numProductsFound() > 1)
			test.log(LogStatus.FAIL,
					test.addScreenCapture(s.captureScreenshot("\\Search\\testCase010_" + timeStamp + ".PNG"))
							+ "Test Failed: More than 4 results were found");
	}

	// To test if search is maintained when going to a product page and coming back
	// Should pass
	@Test
	public void testCase011() throws IOException {
		test.log(LogStatus.INFO, "To test if search result is maintained when going to a product page and coming back");
		s = new ScreenShotCapture(driver);
		sp_object = new SearchPage(driver);
		h_object = new Header(driver);

		test.log(LogStatus.INFO, "Searching for \"mac\"");
		h_object.enterSearchQuery("mac");
		h_object.clickSearchBtn();

		test.log(LogStatus.INFO, "Clicking the product name link of \"" + sp_object.getProductNames().get(1) + "\"");
		sp_object.clickProductName(1);

		test.log(LogStatus.INFO, "Clicking the back button on the browser");
		driver.navigate().back();

		if (sp_object.numProductsFound() == 4)
			test.log(LogStatus.PASS, "Test Passed: Search results were maintained on the page");
		else
			test.log(LogStatus.FAIL,
					test.addScreenCapture(s.captureScreenshot("\\Search\\testCase011_" + timeStamp + ".PNG"))
							+ "Test Failed: Search results were not maintained on the page");
	}

	// Check if correct sorting is done
	// Should pass
//	@Test
//	public void testCase012() {
//		sp_object = new SearchPage(driver);
//		h_object = new Header(driver);
//
//		h_object.enterSearchQuery("mac");
//		h_object.clickSearchBtn();
//
//		ArrayList<String> foundProductNames;
//		String expectedProductNames[] = { "iMac", "MacBook", "Macbook Air", "Macbook Pro" };
//
//		// Name(A-Z) sort
//		sp_object.selectSort(1);
//		foundProductNames = sp_object.getProductNames();
//		Assert.assertEquals(foundProductNames.get(0), "iMac");
//		Assert.assertEquals(foundProductNames.get(1), "MacBook");
//		Assert.assertEquals(foundProductNames.get(2), "MacBook Air");
//		Assert.assertEquals(foundProductNames.get(3), "MacBook Pro");
//
//		// Name(Z-A) sort
//		sp_object.selectSort(2);
//		foundProductNames = sp_object.getProductNames();
////		expectedProductNames.reverse();
//		Assert.assertEquals(foundProductNames.get(0), "MacBook Pro");
//		Assert.assertEquals(foundProductNames.get(1), "MacBook Air");
//		Assert.assertEquals(foundProductNames.get(2), "MacBook");
//		Assert.assertEquals(foundProductNames.get(3), "iMac");
//
//		// Price (Low to High) sort
//		sp_object.selectSort(3);
//		foundProductNames = sp_object.getProductNames();
//		expectedProductNames = new String[] { "iMac", "MacBook", "Macbook Air", "Macbook Pro" };
//		Assert.assertEquals(foundProductNames.get(0), "iMac");
//		Assert.assertEquals(foundProductNames.get(1), "MacBook");
//		Assert.assertEquals(foundProductNames.get(2), "MacBook Air");
//		Assert.assertEquals(foundProductNames.get(3), "MacBook Pro");
//
//		// Price (High to Low) sort
//		sp_object.selectSort(4);
//		foundProductNames = sp_object.getProductNames();
//		expectedProductNames = new String[] { "iMac", "MacBook", "Macbook Air", "Macbook Pro" };
//		Assert.assertEquals(foundProductNames.get(0), "MacBook Pro");
//		Assert.assertEquals(foundProductNames.get(1), "MacBook Air");
//		Assert.assertEquals(foundProductNames.get(2), "MacBook");
//		Assert.assertEquals(foundProductNames.get(3), "iMac");
//	}

	@BeforeMethod
	public void beforeMethod(Method m) {
		test = report.startTest(m.getName());
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		report.endTest(test);
		report.flush();
		Thread.sleep(2000);
		driver.quit();
	}

	@BeforeClass
	public void beforeClass() {
		timeStamp = new SimpleDateFormat("yyyy_MMM_dd_HH.mm.ss").format(new Date());
		report = new ExtentReports("ExtentReports\\Search\\SearchTests " + timeStamp + ".html");
	}

}
