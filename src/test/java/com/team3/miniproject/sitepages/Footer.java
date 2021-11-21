package com.team3.miniproject.sitepages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//POM for footer links. All the methods to click the various links are coded here.

public class Footer {
	WebDriver driver;
	JavascriptExecutor js;
	
	//contact us link element 
	@FindBy(linkText = "Contact Us")
	WebElement contactUsLink;
	
	//site map link element
	@FindBy(linkText = "Site Map")
	WebElement siteMapLink;
	
	//about us link element
	@FindBy(linkText = "About Us")
	WebElement aboutUsLink;
	
	//delivery information link element
	@FindBy(linkText = "Delivery Information")
	WebElement deliveryInformation;
	
	//privacy policy link element
	@FindBy(linkText = "Privacy Policy")
	WebElement privacyPolicy;

	//returns link element
	@FindBy(linkText = "Returns")
	WebElement returns;
	
	//brands link element
	@FindBy(linkText ="Brands")
	WebElement brands;
	
	//affiliate link element
	@FindBy(linkText = "Affiliate")
	WebElement afl;
	
	//terms and conditions link element
	@FindBy(linkText = "Terms & Conditions")
	WebElement tnc;
	
	//newsletter link element
	@FindBy(linkText = "Newsletter")
	WebElement newsl;
	
	//my account link element
	@FindBy(css="footer>div>div>div:nth-of-type(4)>ul>li:nth-of-type(1)>a")
	WebElement myAcc;
	
	public Footer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}

	// Click the contact us link
	public void getContactUs() {
		js.executeScript("arguments[0].scrollIntoView();", contactUsLink);
		contactUsLink.click();
	}
	
	//click the site map link
	public void getSiteMap() {
			js.executeScript("arguments[0].scrollIntoView();", siteMapLink);
			siteMapLink.click();
	}
	
	//click the about us link 
	public void getAboutUs() {
			js.executeScript("arguments[0].scrollIntoView();", aboutUsLink);
			aboutUsLink.click();
	}
	
	//click the delivery information link
	public void getDeliveryInformation() {
			js.executeScript("arguments[0].scrollIntoView();", deliveryInformation);
			deliveryInformation.click();
	}

	// click the privacy policy link
	public void getPrivacyPolicy() {
			js.executeScript("arguments[0].scrollIntoView();", privacyPolicy);
			privacyPolicy.click();
	}

	// click the returns link
	public void getReturns() {
			js.executeScript("arguments[0].scrollIntoView();", returns);
			returns.click();
	}

	// click the brandspage link
	public void getBrandsPage() {
			js.executeScript("arguments[0].scrollIntoView();", brands);
			brands.click();
	}

	// click the affiliate page link
	public void getAffiliatePage() {
			js.executeScript("arguments[0].scrollIntoView();", afl);
			afl.click();
	}

	// click the terms and conditions link
	public void getTermsAndConditions() {
			js.executeScript("arguments[0].scrollIntoView();", tnc);
			tnc.click();
	}

	// click the news letter link
	public void getNewsletter() {
			js.executeScript("arguments[0].scrollIntoView();", newsl);
			newsl.click();
	}

	// click the My Account link
	public void getMyAccount() {
			js.executeScript("arguments[0].scrollIntoView();", myAcc);
			myAcc.click();
	}

}

