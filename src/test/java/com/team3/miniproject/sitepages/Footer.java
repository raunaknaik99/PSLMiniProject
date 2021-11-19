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
		this.driver=driver;
		js=(JavascriptExecutor)driver;
	}
	public void verifyFooterLink(WebElement we, String linkText, String expectedTitle){
		
			js.executeScript("arguments[0].scrollIntoView();", we);
			if(we.isDisplayed()) {
				Assert.assertEquals(we.getText(),linkText);
				we.click();
				String actualTitle=driver.getTitle();
				Assert.assertEquals(expectedTitle, actualTitle);
			}
			else {
				System.out.println("Link Not Present");
			}
	}
	
	
	//Click the contact us link
	public void getContactUs() {
		try {
			WebElement contactUsLink=driver.findElement(By.linkText("Contact Us"));
			verifyFooterLink(contactUsLink,"Contact Us", "Contact Us");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//click the site map link
	public void getSiteMap() {
		try {
			WebElement siteMapLink=driver.findElement(By.linkText("Site Map"));
			verifyFooterLink(siteMapLink,"Site Map", "Site Map");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	//click the about us link 
	public void getAboutUs() {
		try {
			WebElement aboutUsLink=driver.findElement(By.linkText("About Us"));
			verifyFooterLink(aboutUsLink,"About Us", "About Us");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//click the delivery information link
	public void getDeliveryInformation() {
		try {
			WebElement deliveryInformation = driver.findElement(By.linkText("Delivery Information"));
			verifyFooterLink(deliveryInformation,"Delivery Information", "Delivery Information");
			}
		catch(Exception e) {
			e.printStackTrace();
		}
  	}
	
	//click the privacy policy link
	public void getPrivacyPolicy() {
		try {
			WebElement privacyPolicy = driver.findElement(By.linkText("Privacy Policy"));
			verifyFooterLink(privacyPolicy,"Privacy Policy", "Privacy Policy");
			}
		catch(Exception e) {
			e.printStackTrace();
		}
  	}
	
	//click the returns link
	public void getReturns() {
		try {
			WebElement returns = driver.findElement(By.linkText("Returns"));
			verifyFooterLink(returns,"Returns", "Product Returns");
			}
		catch(Exception e) {
			e.printStackTrace();
		}
  	}
	
	//click the brandspage link
	public void getBrandsPage() {
		try {
			WebElement brands = driver.findElement(By.linkText("Brands"));
			verifyFooterLink(brands,"Brands", "Find Your Favorite Brand");
			}
		catch(Exception e) {
			e.printStackTrace();
		}
  	}
	
	//click the affiliate page link
	public void getAffiliatePage() {
	  	try {
			WebElement afl = driver.findElement(By.linkText("Affiliate"));
			verifyFooterLink(afl,"Affiliate", "Affiliate Program");
			}
		catch(Exception e) {
			e.printStackTrace();
		}
  	}
	
	
	//click the terms and conditions link
	public void getTermsAndConditions() {
	  	try {
			WebElement tnc = driver.findElement(By.linkText("Terms & Conditions"));
			verifyFooterLink(tnc,"Terms & Conditions", "Terms & Conditions");
			}
		catch(Exception e) {
			e.printStackTrace();
		}
  	}
	
	
	//click the news letter link
	public void getNewsletter() {
	  try {
			WebElement newsl = driver.findElement(By.linkText("Newsletter"));
			verifyFooterLink(newsl,"Newsletter","Account Login");
		}catch(Exception e) {
			e.printStackTrace();
		}
  	}
        public void getMyAccount() {
		try {
			WebElement myAcc = driver.findElement(By.linkText("My Account"));
		        verifyFooterLink(myAcc,"My Account","Account Login");
			}
		 catch (Exception e) {
			e.printStackTrace();
		}
	}

}

