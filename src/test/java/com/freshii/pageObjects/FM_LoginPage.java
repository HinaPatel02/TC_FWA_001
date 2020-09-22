/* Created on : 24-April-2020
 * Description : This Class contains all the Page Objects related to Login Page
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

public class FM_LoginPage {
	//MobileDriver<MobileElement> driver;
	AndroidDriver<AndroidElement> driver;

	public FM_LoginPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	/* ================ Page Elements ======================== */	
	//Capture Email Text-box
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/email")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/email")
	public MobileElement userEmail_txt;

	//Capture Password Text-box	
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/password")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/password")
	public MobileElement userPswd_txt;
	
	//Capture Proceed Next button
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/btn_proceed_next")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/btn_proceed_next")
	public MobileElement proceedLogin_btn;

	//Capture Log In button	
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/btn_login")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/btn_login")
	public MobileElement login_btn;



	/* ================= Action Methods ================= */
	
	//Login function for Freshii User
	public void login(String email, String pswd) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(userEmail_txt));
		wait.until(ExpectedConditions.elementToBeClickable(userEmail_txt));
		userEmail_txt.sendKeys(email);
		userPswd_txt.sendKeys(pswd);
		login_btn.click();	
		Thread.sleep(5000);
	}

	//Set Email text-box value
	public void setEmail(String email) {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(userEmail_txt));
		wait.until(ExpectedConditions.elementToBeClickable(userEmail_txt));
		userEmail_txt.sendKeys(email);
		
		
	}

	//Set Password text-box value
	public void setPassword(String pswd) {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(userPswd_txt));
		wait.until(ExpectedConditions.elementToBeClickable(userPswd_txt));
		userPswd_txt.sendKeys(pswd);
	}

	//Click Login button
	public void clkLoginBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(login_btn));
		wait.until(ExpectedConditions.elementToBeClickable(login_btn));
		login_btn.click();
		Thread.sleep(3000);
	}
}