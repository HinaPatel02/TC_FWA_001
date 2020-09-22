package com.freshii.pageObjects;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FM_AddNewCardPage {
	AndroidDriver<AndroidElement> driver;

	//Constructor
	public FM_AddNewCardPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}
	
	/* ============================ Page Elements =============================== */
	//Capture Card Holder's Name field
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/cardholder_name_edit")
	public MobileElement cardHolderName_txt;
	
	//Capture Card Number field
		@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/card_number_edit")
		public MobileElement cardNumber_txt;
		
		//Capture Expiry date field
		@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/expire_date_edit")
		public MobileElement expiryDate_txt;
		
		//Capture CVV/CVC field
		@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/cvv_edit")
		public MobileElement cvv_txt;
		
		//Capture Postal Code field
		@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/postal_code_edit")
		public MobileElement postalCode_txt;
		
		//Capture Confirm Card button
		@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/btn_add_card")
		public MobileElement confirmCard_btn;
		
		//========================Action Method===============================
		
		//Add Card Details
		public void addCardDetails(String name, String cardNumber, String expiry, String cvv, String postalCode) {
			WebDriverWait wait = new WebDriverWait(driver, 25);
			wait.until(ExpectedConditions.visibilityOf(cardHolderName_txt));
			wait.until(ExpectedConditions.elementToBeClickable(cardHolderName_txt));
			cardHolderName_txt.sendKeys(name);
			cardNumber_txt.sendKeys(cardNumber);
			expiryDate_txt.sendKeys(expiry);
			cvv_txt.sendKeys(cvv);
			postalCode_txt.sendKeys(postalCode);
			confirmCard_btn.click();			
		}
	
	


}
