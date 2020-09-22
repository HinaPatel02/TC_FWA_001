/* Creator :Draupathi
 * Created on : 24-April-2020
 * Description : This Class contains all the Page Objects related to Scan & Pay Page
 * All rights reserved.Confidential
 * Copyright  Freshii.com 
 */
package com.freshii.pageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FM_ScanAndPayPage {
	AndroidDriver<AndroidElement> driver;

	public FM_ScanAndPayPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	//Page Elements

	//Action Method
	//Verify whether Scan and Pay Screen is displayed
	public boolean isScanAndPayDisplayed() {
		String expectedMsg = "Scan this QR code to pay with your digital wallet and earn loyalty";
		String actualMsg = driver.findElementById("com.tacitinnovations.freshii.dev:id/msg").getAttribute("text");
		boolean bool = false;
		if(actualMsg.equalsIgnoreCase(expectedMsg)) {
			bool = true;
		}
		return bool;
	}

	//Tap on Gift Card to get Number
	public void tapGCNumber() {
		String expNumberLabel = "Tap to see the number";
		
		if(driver.findElementById("com.tacitinnovations.freshii.dev:id/label_tap_to_see").getAttribute("text").equalsIgnoreCase(expNumberLabel)){
			driver.findElementById("com.tacitinnovations.freshii.dev:id/frontImage").click();
			System.out.println("Tapped on the Gift Card to see the number");
			String number = driver.findElementById("com.tacitinnovations.freshii.dev:id/cardNumber").getAttribute("text");
			System.out.println("Card Number is: "+number);
		}
	}
	
	//Tap on Gift Card to view the front after seeing the number
	public void tapGCFront() {
		String expFrontLabel = "Tap to see front";
		if(driver.findElementById("com.tacitinnovations.freshii.dev:id/label_tap_to_see").getAttribute("text").equalsIgnoreCase(expFrontLabel)){
			driver.findElementById("com.tacitinnovations.freshii.dev:id/backImage").click();
			System.out.println("Tapped on the Gift Card to see the front");
		}
	}
}
