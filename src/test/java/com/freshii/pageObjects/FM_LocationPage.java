/* Created on : 24-April-2020
 * Description : This Class contains all the Page Objects related to Sign Up / Login Page
 * All rights reserved.Confidential
 * Copyright  Freshii.com 
 */

package com.freshii.pageObjects;

import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class FM_LocationPage {
	//AppiumDriver<MobileElement> driver;
	AndroidDriver<AndroidElement> driver;

	public FM_LocationPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	/* =========================== Page Elements ============================= */

	//Capture Search Text-box
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/search")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/search")
	public MobileElement search_txtbx;

	//Capture Search icon
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/ic_search")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/ic_search")
	public MobileElement search_icon;

	//Capture Share Location button
	//@AndroidFindBy(xpath="com.tacitinnovations.freshii:id/msgButton[contains(@text, 'SHARE LOCATION')]")
	@AndroidFindBy(xpath="com.tacitinnovations.freshii.dev:id/msgButton[contains(@text, 'ENABLE LOCATION')]")
	public MobileElement shareLoc_btn;

	//Capture Allow button
	@AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
	public MobileElement allow_btn;





	/* ===================== Action Methods ===========================*/

	//Select the location
	public void selectLocation(String freshiiLocation) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(search_txtbx));

		Point location = search_txtbx.getLocation();
		int x_axis = location.getX();
		int y_axis = location.getY();
		//System.out.println("x: "+ x_axis +"$$$" + " y: "+ y_axis);

		search_txtbx.click();
		search_txtbx.sendKeys(freshiiLocation);
		Thread.sleep(4000);
		TouchAction action= new TouchAction(driver);
		action.tap(PointOption.point(x_axis, y_axis+150)).perform();
		//action.press(PointOption.point(x_axis, y_axis+150)).perform();
	}

	//Share Location enable
	public void shareLocationPermission() {
		if(shareLoc_btn.isDisplayed())
		{
			shareLoc_btn.click();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(allow_btn));
			allow_btn.click();			
		}

	}
}



