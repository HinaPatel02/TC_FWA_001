/* Created on : 24-April-2020
 * Description : This Class contains all the Page Objects related to Home Page
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


public class FM_LocationMenuPage {
	//AppiumDriver<MobileElement> driver;
	AndroidDriver<AndroidElement> driver;

	//Constructor
	public FM_LocationMenuPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	//================== Page Elements =====================

	//Capture Dietary Preference Button
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/allergy")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/allergy")
	public MobileElement dietPref_btn;

	//Capture Side Menu button
	@AndroidFindBy(className="android.widget.ImageButton")
	public MobileElement sideMenu_btn;

	//Capture Sign Out button
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Sign Out')]")
	public MobileElement signOut_btn;

	//======================== Action Methods =======================
	//Click Dietary Preference button
	public void clkDietaryPreferenceBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(dietPref_btn));
		wait.until(ExpectedConditions.elementToBeClickable(dietPref_btn));
		dietPref_btn.click();

	}

	//Sign Out Function
	public void signOut() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(sideMenu_btn));
		wait.until(ExpectedConditions.elementToBeClickable(sideMenu_btn));
		sideMenu_btn.click();
		signOut_btn.click();
	}






	//Select Salad (Cobb Salad) from the menu
	public void selectCobbSalad() {
		//MobileElement saladMenu = driver.findElementByXPath("//android.widget.TextView[contains(@text,'SALADs')]"));
		//TouchAction action= new TouchAction(driver);
		//action.tap(PointOption.point(saladMenu)).perform();


	}









	public static void scrollTillText(String text) {
		//MobileElement item = (MobileElement)driver.findElement(MobileBy.AndroidUIAutomator(
		//		"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))"));
	}


	//	public void saladSelect(String menuName) {
	//		//Capture all the Menu items
	//		((AndroidDriver<MobileElement>)MobileDriver.getDriver()).findElementBy





}

