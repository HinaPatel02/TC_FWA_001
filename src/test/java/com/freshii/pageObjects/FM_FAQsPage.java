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

public class FM_FAQsPage {
	//AppiumDriver<MobileElement> driver;
	AndroidDriver<AndroidElement> driver;

	public FM_FAQsPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	/* ============================ Page Elements =============================== */
	//Capture first FAQ
	@AndroidFindBy(xpath = "android.widget.TextView[@text='Where can I find nutritional information? ']")	
	public MobileElement first_FAQ;
	
	/*================= Action Methods =================*/

	//Click first FAQ
	public void clkFAQ1() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(first_FAQ));
		wait.until(ExpectedConditions.elementToBeClickable(first_FAQ));
		first_FAQ.click();
	}

}
