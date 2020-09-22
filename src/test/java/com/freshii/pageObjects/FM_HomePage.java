/* Created on : 24-April-2020
 * Description : This Class contains all the Page Objects related to Home Page
 * All rights reserved.Confidential
 * Copyright  Freshii.com 
 */
package com.freshii.pageObjects;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.freshii.base.BaseClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FM_HomePage extends BaseClass{
	//AppiumDriver<MobileElement> driver;
	AndroidDriver<AndroidElement> driver;

	public FM_HomePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	/* ============================ Page Elements =============================== */
	//Capture Side Menu button
	@AndroidFindBy(className="android.widget.ImageButton")
	public MobileElement sideMenu_btn;

	//Capture Order button
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/fab")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/fab")
	public MobileElement order_btn;

	//Capture Sign Out button
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Sign Out')]")
	public MobileElement signOut_btn;

	//Capture Home button
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/home")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/home")
	public MobileElement home_btn;

	//Capture Order History button
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Order history')]")
	public MobileElement orderHistory_btn;

	//Capture Payment Method History button
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Payment method')]")
	public MobileElement paymentMethod_btn;

	//Capture Payment Method History button
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'My profile')]")
	public MobileElement myProfile_btn;

	//Capture Contact Us button
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Contact us')]")
	public MobileElement contactUs_btn;

	//Capture FAQs button
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'FAQs')]")
	public MobileElement faqs_btn;

	//Capture Scan and Pay button
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Scan and Pay')]")
	public MobileElement scanAndPay_btn;

	//Capture Rewards & Offers button
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Rewards & Offers')]")
	public MobileElement rewardsAndOffers_btn;

	/*================= Action Methods =================*/

	//Click Login button
	public void clkOrderBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(order_btn));
		wait.until(ExpectedConditions.elementToBeClickable(order_btn));
		order_btn.click();
	}

	//Sign Out Function
	
	public void ClickMenu()
	{
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(sideMenu_btn));
		wait.until(ExpectedConditions.elementToBeClickable(sideMenu_btn));
		sideMenu_btn.click();
	}
	public void signOut() {
		/*WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(sideMenu_btn));
		wait.until(ExpectedConditions.elementToBeClickable(sideMenu_btn));
		sideMenu_btn.click();*/
		signOut_btn.click();
	}

	//Validate whether Home Page is displayed by checking Home button visibility
	public boolean validateHomePage() {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(home_btn));
		return home_btn.isDisplayed();
	}

	//Click Order History
	public void orderHistory() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(sideMenu_btn));
		wait.until(ExpectedConditions.elementToBeClickable(sideMenu_btn));
		sideMenu_btn.click();
		wait.until(ExpectedConditions.elementToBeClickable(orderHistory_btn));
		orderHistory_btn.click();
	}

	//Click Payment Method
	public void paymentMethod() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(sideMenu_btn));
		wait.until(ExpectedConditions.elementToBeClickable(sideMenu_btn));
		sideMenu_btn.click();
		wait.until(ExpectedConditions.elementToBeClickable(paymentMethod_btn));
		paymentMethod_btn.click();
	}

	//Click My Profile 
	public void myProfile() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(sideMenu_btn));
		wait.until(ExpectedConditions.elementToBeClickable(sideMenu_btn));
		sideMenu_btn.click();
		wait.until(ExpectedConditions.elementToBeClickable(myProfile_btn));
		myProfile_btn.click();
	}

	//Click Contact Us 
	public void clkContactUs() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(sideMenu_btn));
		wait.until(ExpectedConditions.elementToBeClickable(sideMenu_btn));
		sideMenu_btn.click();
		wait.until(ExpectedConditions.elementToBeClickable(contactUs_btn));
		contactUs_btn.click();
	}

	//Click FAQs
	public void clickFaqs() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(sideMenu_btn));
		wait.until(ExpectedConditions.elementToBeClickable(sideMenu_btn));
		sideMenu_btn.click();
		wait.until(ExpectedConditions.elementToBeClickable(faqs_btn));
		faqs_btn.click();
	}

	//Click Scan and Pay button
	public void clkScanAndPayBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(scanAndPay_btn));
		wait.until(ExpectedConditions.elementToBeClickable(scanAndPay_btn));
		scanAndPay_btn.click();
	}

}
