/* Created on : 24-April-2020
 * Description : This Class contains all the Page Objects related to Sign Up / Login Page
 * All rights reserved.Confidential
 * Copyright  Freshii.com 
 */
package com.freshii.pageObjects;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FM_SignUpLoginPage {
	//MobileDriver<MobileElement> driver;
	AndroidDriver<AndroidElement> driver;

	public FM_SignUpLoginPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	/* ============== Page Elements============= */

	//Capture Login Button
	//@AndroidFindBy(id = "com.tacitinnovations.freshii:id/btn_login")
	@AndroidFindBy(id = "com.tacitinnovations.freshii.dev:id/btn_login")
	public MobileElement login_btn;

	//Capture Sign Up Button
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/btn_signup")
	@AndroidFindBy(xpath="//*[@text='SIGN UP']")
	//@AndroidFindBy(xpath="//android.widget.TextView 218[@text=‘ADD’]")
	public MobileElement signUp_btn;

	//Capture Google Login Button
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/btn_sign_up_with_google")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/btn_sign_up_with_google")
	public MobileElement googleLogin_btn;

	//Capture Proceed as Guest user label
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/label_proceed_as_guest")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/label_proceed_as_guest")
	public MobileElement guestUser_label;

	//Capture Logged in email id
	@AndroidFindBy(id="com.google.android.gms:id/account_name")
	public MobileElement loggedinGoogleUser;

	//Capture Google Email Text-box
	@AndroidFindBy(className="android.widget.EditText")
	public MobileElement googleEmailtxt_box;

	//Capture Next button 
	@AndroidFindBy(xpath="//android.widget.Button[contains(@text, 'Next')]")
	public MobileElement googleNext_btn;

	//Capture Google Email Text-box
	@AndroidFindBy(className="android.widget.EditText")
	public MobileElement googlePswdtxt_box;


	/*================= Action Methods =================*/

	//Click Login button
	public void clkLoginBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(login_btn));
		wait.until(ExpectedConditions.elementToBeClickable(login_btn));
		login_btn.click();

	}

	//Click Sign Up button
	public void clkSignUpBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(signUp_btn));
		wait.until(ExpectedConditions.elementToBeClickable(signUp_btn));
		signUp_btn.click();

	}

	//Click Google Login button
	public void clkGoogleLoginBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(googleLogin_btn));
		wait.until(ExpectedConditions.elementToBeClickable(googleLogin_btn));
		googleLogin_btn.click();

	}

	//Click Proceed As Guest Label
	public void clkProceedAsGuestLbl() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(guestUser_label));
		wait.until(ExpectedConditions.elementToBeClickable(guestUser_label));
		guestUser_label.click();

	}

	//Google Login Function
	public void googleLogin(String gEmail, String gPswd) throws InterruptedException {
		String user = loggedinGoogleUser.getAttribute("text");
		System.out.println("Google User is:- "+user);
		if(user.equalsIgnoreCase(gEmail)) {
			loggedinGoogleUser.click();
		}
		else {			
			driver.findElementById("com.google.android.gms:id/add_account_chip_title").click();
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOf(googleEmailtxt_box));
			googleEmailtxt_box.click();
			googleEmailtxt_box.sendKeys(gEmail);
			googleNext_btn.click();
			wait.until(ExpectedConditions.visibilityOf(googlePswdtxt_box));
			googlePswdtxt_box.sendKeys(gPswd);
			googleNext_btn.click();	





			//		driver.findElementByClassName("android.widget.EditText").click();
			//		driver.findElementByClassName("android.widget.EditText").sendKeys(gEmail);
			//		driver.findElementByXPath("//android.widget.Button[contains(@text, 'Next')]").click();
			//		Thread.sleep(3000);
			//		wait.until(ExpectedConditions.visibilityOf(driver.findElementByClassName("android.widget.EditText")));
			//		//driver.findElementByClassName("android.widget.EditText").click();
			//		driver.findElementByClassName("android.widget.EditText").sendKeys(gPswd);
			//		driver.findElementByXPath("//android.widget.Button[contains(@text, 'Next')]").click();
			Thread.sleep(3000);
			//Agree button
			driver.findElementById("signinconsentNext").click();
			//	driver.findElementByXPath("//android.widget.Button[contains(@text, 'I agree')]").click();


			if(driver.findElementById("com.google.android.gms:id/sud_items_switch").isEnabled())
			{
				driver.findElementById("com.google.android.gms:id/sud_items_switch").click();
			}
			//More Navigation button
			driver.findElementById("com.google.android.gms:id/sud_navbar_more").click();
			//Accept button
			driver.findElementByXPath("//android.widget.Button[contains(@text, 'ACCEPT')]").click();

		}
	}



}

