/* Created on : 24-April-2020
 * Description : This Class contains all the Page Objects related to Home Page
 * All rights reserved.Confidential
 * Copyright  Freshii.com 
 */

package com.freshii.pageObjects;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class FM_MyOrderPage {
	//AppiumDriver<MobileElement> driver;
	AndroidDriver<AndroidElement> driver;

	//Constructor
	public FM_MyOrderPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}
	
	// ==================== Page Elements =========================
	
	//Capture Place Order button
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/btn_place_order")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/btn_place_order")
	MobileElement placeOrder_btn;
	
	
	// ==================== Action Methods =========================
	//Click Place Order button
	public void clkPlaceOrderBtn() {
		TouchAction t=new TouchAction(driver);
		//scroll
		t.press(ElementOption.element(placeOrder_btn))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
		.moveTo(PointOption.point(0, -3500))
		.release().perform();
		placeOrder_btn.click();		
	}
	
	
	

}
