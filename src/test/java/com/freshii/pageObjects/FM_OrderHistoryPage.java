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

public class FM_OrderHistoryPage {
	//AppiumDriver<MobileElement> driver;
	AndroidDriver<AndroidElement> driver;
	//Constructor
	public FM_OrderHistoryPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}
	/* ============================ Page Elements =============================== */
	//Capture Side Menu button
	@AndroidFindBy(className="android.widget.ImageButton")
	public MobileElement sideMenu_btn;

	//Capture Order history Title
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Order history')]")
	public MobileElement orderHistoryTitle;

	//Capture Sign Out button
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Sign Out')]")
	public MobileElement signOut_btn;

	/* ============================ Action Methods =============================== */
	//Verify whether Order History screen is displayed
	public boolean isOrderHistoryDisplayed() {
		boolean b = false;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(orderHistoryTitle));
		if(orderHistoryTitle.isDisplayed())
		{
			b = true;
		}
		return b;
	}

	//Sign Out Function
	public void signOut() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(sideMenu_btn));
		wait.until(ExpectedConditions.elementToBeClickable(sideMenu_btn));
		sideMenu_btn.click();
		signOut_btn.click();
	}
	
	//Click on Help button
	public void clkHelpBtn() {
		//List<MobileElement> allHelp_btns = driver.findElementsById("com.tacitinnovations.freshii:id/btn_action_help");
		List<AndroidElement> allHelp_btns = driver.findElementsById("com.tacitinnovations.freshii.dev:id/btn_action_help");
		for(MobileElement help_btn : allHelp_btns ) {
			help_btn.click();
			break;			
		}
	}


}

