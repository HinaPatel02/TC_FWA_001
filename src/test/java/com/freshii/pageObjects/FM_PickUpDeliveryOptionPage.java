/* Created on : 24-April-2020
 * Description : This Class contains all the Page Objects related to Sign Up / Login Page
 * All rights reserved.Confidential
 * Copyright  Freshii.com 
 */

package com.freshii.pageObjects;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FM_PickUpDeliveryOptionPage {
	//AppiumDriver<MobileElement> driver;
	AndroidDriver<AndroidElement> driver;
	
	public FM_PickUpDeliveryOptionPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	/* =========================== Page Elements ============================= */
	
	//Capture Pickup Option
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/pickup")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/pickup")
	public MobileElement pickup_btn;
	
	
	
	/* ===================== Action Methods ===========================*/
	
	//Click Pickup option
	public void clkPickUp() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(pickup_btn));
		wait.until(ExpectedConditions.elementToBeClickable(pickup_btn));
		pickup_btn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
