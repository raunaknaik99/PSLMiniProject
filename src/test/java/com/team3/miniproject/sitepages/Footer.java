package com.team3.miniproject.sitepages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

//POM for footer links. All the methods to click the various links are coded here.

public class Footer {
	WebDriver driver;
	JavascriptExecutor js;

	public Footer(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	// Click the contact us link
	public void getContactUs() {
		try {
			WebElement contactUsLink = driver.findElement(By.linkText("Contact Us"));
			js.executeScript("arguments[0].scrollIntoView();", contactUsLink);
			if (contactUsLink.isDisplayed()) {
				Assert.assertEquals(contactUsLink.getText(), "Contact Us");
				contactUsLink.click();
				String contactUsPageTitle = driver.getTitle();
				Assert.assertEquals("Contact Us", contactUsPageTitle);
			} else {
				System.out.println("Link Not Present");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// click the site map link
	public void getSiteMap() {
		try {
			WebElement siteMapLink = driver.findElement(By.linkText("Site Map"));
			js.executeScript("arguments[0].scrollIntoView();", siteMapLink);
			if (siteMapLink.isDisplayed()) {
				Assert.assertEquals(siteMapLink.getText(), "Site Map");
				siteMapLink.click();
				String siteMapPageTitle = driver.getTitle();
				Assert.assertEquals("Site Map", siteMapPageTitle);
			} else {
				System.out.println("Link Not Present");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// click the about us link
	public void getAboutUs() {
		try {
			WebElement aboutUsLink = driver.findElement(By.linkText("About Us"));
			js.executeScript("arguments[0].scrollIntoView();", aboutUsLink);
			if (aboutUsLink.isDisplayed()) {
				Assert.assertEquals(aboutUsLink.getText(), "About Us");
				aboutUsLink.click();
				String aboutUsPageTitle = driver.getTitle();
				Assert.assertEquals("About Us", aboutUsPageTitle);
			} else {
				System.out.println("Link Not Present");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// click the delivery information link
	public void getDeliveryInformation() {
		try {
			WebElement deliveryInformation = driver.findElement(By.linkText("Delivery Information"));
			js.executeScript("arguments[0].scrollIntoView();", deliveryInformation);
			if (deliveryInformation.isDisplayed()) {
				Assert.assertEquals(deliveryInformation.getText(), "Delivery Information");
				deliveryInformation.click();
				String actualTitle = driver.getTitle();
				Assert.assertEquals("Delivery Information", actualTitle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// click the privacy policy link
	public void getPrivacyPolicy() {
		try {
			WebElement privacyPolicy = driver.findElement(By.linkText("Privacy Policy"));
			js.executeScript("arguments[0].scrollIntoView();", privacyPolicy);
			if (privacyPolicy.isDisplayed()) {
				Assert.assertEquals(privacyPolicy.getText(), "Privacy Policy");
				privacyPolicy.click();
				String actualTitle = driver.getTitle();
				Assert.assertEquals("Privacy Policy", actualTitle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// click the returns link
	public void getReturns() {
		try {
			WebElement returns = driver.findElement(By.linkText("Returns"));
			js.executeScript("arguments[0].scrollIntoView();", returns);
			if (returns.isDisplayed()) {
				Assert.assertEquals(returns.getText(), "Returns");
				returns.click();
				String actualTitle = driver.getTitle();
				Assert.assertEquals("Product Returns", actualTitle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// click the brandspage link
	public void getBrandsPage() {
		try {
			WebElement brands = driver.findElement(By.linkText("Brands"));
			js.executeScript("arguments[0].scrollIntoView();", brands);
			if (brands.isDisplayed()) {
				Assert.assertEquals(brands.getText(), "Brands");
				brands.click();
				String actualTitle = driver.getTitle();
				Assert.assertEquals("Find Your Favorite Brand", actualTitle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// click the affiliate page link
	public void getAffiliatePage() {
		try {
			WebElement afl = driver.findElement(By.linkText("Affiliate"));
			js.executeScript("arguments[0].scrollIntoView();", afl);
			if (afl.isDisplayed()) {
				Assert.assertEquals(afl.getText(), "Affiliate");
				afl.click();
				String actualTitle = driver.getTitle();
				Assert.assertEquals("Affiliate Program", actualTitle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// click the terms and conditions link
	public void getTermsAndConditions() {
		try {
			WebElement tnc = driver.findElement(By.linkText("Terms & Conditions"));
			js.executeScript("arguments[0].scrollIntoView();", tnc);
			if (tnc.isDisplayed()) {
				Assert.assertEquals(tnc.getText(), "Terms & Conditions");
				tnc.click();
				String actualTitle = driver.getTitle();
				Assert.assertEquals("Terms & Conditions", actualTitle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// click the news letter link
	public void getNewsletter() {
		try {
			WebElement newsl = driver.findElement(By.linkText("Newsletter"));
			js.executeScript("arguments[0].scrollIntoView();", newsl);
			if (newsl.isDisplayed()) {
				Assert.assertEquals(newsl.getText(), "Newsletter");
				newsl.click();
				String actualTitle = driver.getTitle();
				Assert.assertEquals("Account Login", actualTitle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// click the My Account link
	public void getMyAccount() {
		try {
			WebElement myAcc = driver.findElement(By.linkText("My Account"));
			js.executeScript("arguments[0].scrollIntoView();", myAcc);
			if (myAcc.isDisplayed()) {
				Assert.assertEquals(myAcc.getText(), "My Account");
				myAcc.click();
				String actualTitle = driver.getTitle();
				Assert.assertEquals("Account Login", actualTitle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
