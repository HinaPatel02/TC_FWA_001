/* Creator :Draupathi
 * Created on : 24-April-2020
 * Description : This Class contains all the Page Objects related to Scan & Earn Page
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

public class FM_ScanAndEarnPage {
	AndroidDriver<AndroidElement> driver;

	public FM_ScanAndEarnPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	//Page Elements

}
