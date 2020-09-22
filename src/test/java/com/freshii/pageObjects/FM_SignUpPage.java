/* Created on : 24-April-2020
 * Description : This Class contains all the Page Objects related to Sign Up Page
 * All rights reserved.Confidential
 * Copyright  Freshii.com 
 */
package com.freshii.pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FM_SignUpPage {
	//AppiumDriver<MobileElement> driver;
	AndroidDriver<AndroidElement> driver;

	public FM_SignUpPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	//Page Elements
	//Capture First Name Text-box
	//@AndroidFindBy(id = "com.tacitinnovations.freshii:id/edit_first_name")
	@AndroidFindBy(id = "com.tacitinnovations.freshii.dev:id/edit_first_name")
	public MobileElement firstName_txtbx;

	//Capture Last Name Text-box
	//@AndroidFindBy(id = "com.tacitinnovations.freshii:id/edit_last_name")
	@AndroidFindBy(id = "com.tacitinnovations.freshii.dev:id/edit_last_name")
	public MobileElement lastName_txtbx;

	//Capture Next Button
	//@AndroidFindBy(id = "com.tacitinnovations.freshii:id/btn_next")
	@AndroidFindBy(id = "com.tacitinnovations.freshii.dev:id/btn_next")
	public MobileElement next_btn;

	//Capture Email Text-box
	//@AndroidFindBy(id = "com.tacitinnovations.freshii:id/email")
	@AndroidFindBy(id = "com.tacitinnovations.freshii.dev:id/email")
	public MobileElement email_txtbx;

	//Capture Phone(Optional) Text-box
	//@AndroidFindBy(id = "com.tacitinnovations.freshii:id/phone")
	@AndroidFindBy(id = "com.tacitinnovations.freshii.dev:id/phone")
	public MobileElement phone_txtbx;

	//Capture Create Password Text-box
	//@AndroidFindBy(xpath = "//com.tacitinnovations.freshii:id/edit_text[contains(@text, 'Create Password')]")
	//@AndroidFindBy(xpath = "//com.tacitinnovations.freshii.dev:id/edit_text[contains(@text, 'Create Password')]")
	@AndroidFindBy(xpath="//*[@text='Create Password']")
	public MobileElement createPswd_txtbx;

	//Capture Confirm Password Text-box
	//@AndroidFindBy(xpath = "//com.tacitinnovations.freshii:id/edit_text[contains(@text, 'Confirm password')]")
	//@AndroidFindBy(xpath = "//com.tacitinnovations.freshii.dev:id/edit_text[contains(@text, 'Confirm password')]")
	@AndroidFindBy(xpath="//*[@text='Confirm password']")
	public MobileElement confirmPswd_txtbx;

	//Capture Zipcode Text-box
	//@AndroidFindBy(id = "com.tacitinnovations.freshii:id/layout_postal_code")
	@AndroidFindBy(id = "com.tacitinnovations.freshii.dev:id/layout_postal_code")
	public MobileElement zipCode_txtbx;

	//Capture Birthdate Text-box
	//@AndroidFindBy(id = "com.tacitinnovations.freshii:id/edit_birth_date")
	@AndroidFindBy(id ="com.tacitinnovations.freshii.dev:id/edit_birth_date")
	//@AndroidFindBy(xpath="//*[@text='Birth Date (date/month)']")
	public MobileElement birthDate_txtbx;

	
	@AndroidFindBy(id = "com.tacitinnovations.freshii.dev:id/btn_skip")
	public MobileElement btn_skip;

	
	
	//Capture Day Drop-down
	//@AndroidFindBy(id = "com.tacitinnovations.freshii:id/day")
	@AndroidFindBy(id = "com.tacitinnovations.freshii.dev:id/day")
	public MobileElement day_dropDown;	

	//Capture Month Drop-down
	//@AndroidFindBy(id = "com.tacitinnovations.freshii:id/month")
	@AndroidFindBy(id = "com.tacitinnovations.freshii.dev:id/month")
	public MobileElement month_dropDown;

	//Capture Subscribe Check-box
	//@AndroidFindBy(id = "com.tacitinnovations.freshii:id/checkbox_subscribe")
	@AndroidFindBy(id = "com.tacitinnovations.freshii.dev:id/checkbox_subscribe")
	public MobileElement subscribe_checkbox;

	//Capture Sign Up button
	//@AndroidFindBy(id = "com.tacitinnovations.freshii:id/btn_next")
	@AndroidFindBy(id = "com.tacitinnovations.freshii.dev:id/btn_next")
	public MobileElement signUp_btn;
	
	@AndroidFindBy(id="com.tacitinnovations.freshii:id/btn_close")
	public MobileElement close_btn;
	


	//=================== Action Methods ============================

	//Sign Up function - Yet to complete written to check whether it is passing the values to the fields
	public void signUpFunction() {
		firstName_txtbx.sendKeys("Abc");
		lastName_txtbx.sendKeys("Abc");
		next_btn.click();
		email_txtbx.sendKeys("abcd2@getnada.com");
		phone_txtbx.sendKeys("2128010022");
		next_btn.click();
		createPswd_txtbx.sendKeys("abc@123ABC");
		confirmPswd_txtbx.sendKeys("abc@123ABC");
		next_btn.click();
		zipCode_txtbx.sendKeys("A1A1A1");
		next_btn.click();
		//birthDate_txtbx.click();
		
		
		//driver.findElement(By.id("com.tacitinnovations.freshii:id/btn_skip")).click();
		btn_skip.click();	
	
		//Skipping the birthday selection as need to find more ways to scroll and select the date from pop-up
		//driver.findElement(By.id("com.tacitinnovations.freshii:id/btn_skip")).click();
		//		birthDate_txtbx.click();
		//		String expMonth = "March";
		//		int expDate = 21;//		
		//		List <AndroidElement> datePicker = driver.findElementsByClassName("android.widget.LinearLayout");
		//		datePicker.get(0).getAttribute("content-desc");		
		//String daySelected []= day_dropDown.getAttribute("content-desc");
		//TouchAction action= new TouchAction(driver);
		//action.tap(PointOption.point(saladMenu)).perform();

		signUp_btn.click();
	}
}
