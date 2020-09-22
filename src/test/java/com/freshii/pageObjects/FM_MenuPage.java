package com.freshii.pageObjects;

import java.time.Duration;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;


public class FM_MenuPage {
	//AppiumDriver <MobileElement> driver;
	AndroidDriver<AndroidElement> driver;

	public FM_MenuPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	/* =========================== Page Elements ============================= */



	/* =========================== Action Methods ============================= */

	//Select Salad Section
	public void selectSalad(String saladItem) {	
		//Scroll till the element and click
		driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().resourceId(\"com.tacitinnovations.freshii.dev:id/recycle\")).scrollIntoView(new UiSelector().textMatches(\""+saladItem+"\").instance(0))")).click();


				





	}

}
