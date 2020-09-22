/* Created on : 24-April-2020
 * Description : This Class contains all the Page Objects related to Landing Page
 * All rights reserved.Confidential
 * Copyright  Freshii.com 
 */

package com.freshii.pageObjects;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FM_LandingPage {
	//MobileDriver<MobileElement> driver;
	AndroidDriver <AndroidElement> driver;

	//Constructor
	public FM_LandingPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	/*================= Page Elements =============================*/

	//Capture Sign Up / Login button
	//@AndroidFindBy(id = "com.tacitinnovations.freshii:id/home_guest_btn_registration")	
	@AndroidFindBy(id = "com.tacitinnovations.freshii.dev:id/home_guest_btn_registration")
	public MobileElement signUpLogin_btn;

	//Capture Side Menu button
	@AndroidFindBy(className="android.widget.ImageButton")
	public MobileElement sideMenu_btn;

	//Capture Payment Method button
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Payment method')]")
	public MobileElement paymentMethod_btn;

	//Capture FAQ button
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'FAQs')]")
	public MobileElement faqs_btn;

	/*================= Action Methods =================*/

	//Click Sign Up / Login button
	public void clkSignUpLoginBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(signUpLogin_btn));
		wait.until(ExpectedConditions.elementToBeClickable(signUpLogin_btn));
		signUpLogin_btn.click();
	}

	//Validate Landing Page
	public boolean validateLandingPage(){
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(signUpLogin_btn));
		return signUpLogin_btn.isDisplayed();
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

	//Click FAQ
	public void clickFAQs() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(sideMenu_btn));
		wait.until(ExpectedConditions.elementToBeClickable(sideMenu_btn));
		sideMenu_btn.click();
		wait.until(ExpectedConditions.elementToBeClickable(faqs_btn));
		faqs_btn.click();
	}

}
