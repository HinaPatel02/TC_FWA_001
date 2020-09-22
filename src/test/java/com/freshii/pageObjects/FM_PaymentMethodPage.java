/* Created on : 24-April-2020
 * Description : This Class contains all the Page Objects related to Home Page
 * All rights reserved.Confidential
 * Copyright  Freshii.com 
 */

package com.freshii.pageObjects;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FM_PaymentMethodPage {
	//AppiumDriver<MobileElement> driver;
	AndroidDriver<AndroidElement> driver;

	//Constructor
	public FM_PaymentMethodPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	/* ============================ Page Elements =============================== */
	//Capture Side Menu button
	@AndroidFindBy(className="android.widget.ImageButton")
	public MobileElement sideMenu_btn;

	//Capture Sign Out button
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Sign Out')]")
	public MobileElement signOut_btn;

	//Capture Payment Methods Title
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Payment methods')]")
	public MobileElement paymentMethodsTitle;
	
	//Capture Add Payment method button
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/btn_add_new_payment_method")
	public MobileElement addNewPayment_btn;
	
	
	/* ============================ Action Methods =============================== */

	//Verify whether Payment Methods page is displayed
	public boolean isPaymentMethodDisplayed() {
		boolean b = false;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(paymentMethodsTitle));
		if(paymentMethodsTitle.isDisplayed())
		{
			b = true;
		}
		return b;
	}

	//Verify whether Payment Details are added
	public int isPaymentDetailsAdded() {
		//List <MobileElement> cards = driver.findElementsById("com.tacitinnovations.freshii:id/card_number");
		List <AndroidElement> cards = driver.findElementsById("com.tacitinnovations.freshii.dev:id/card_number");
		int cardNumbers = cards.size();
		return cardNumbers;		
	}

	//Sign Out Function
	public void signOut() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(sideMenu_btn));
		wait.until(ExpectedConditions.elementToBeClickable(sideMenu_btn));
		sideMenu_btn.click();
		signOut_btn.click();
	}
	
	//Add Payment method
	public void clkaddPaymentMethod() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(addNewPayment_btn));
		wait.until(ExpectedConditions.elementToBeClickable(addNewPayment_btn));
		addNewPayment_btn.click();
		
	}
}
