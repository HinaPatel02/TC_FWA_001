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

public class FM_MenuIngredientPage {
	//AppiumDriver<MobileElement> driver;
	AndroidDriver<AndroidElement> driver;

	public FM_MenuIngredientPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	/* =========================== Page Elements ============================= */
	//Capture Add to bag button
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/add_to_bag_btn")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/add_to_bag_btn")
	MobileElement addToBag_btn;

	//Click No Thanks button
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/btn_no_thanks")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/btn_no_thanks")
	MobileElement noThanks_btn;

	//Click Done button
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/btn_done")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/btn_done")
	MobileElement done_btn;

	//Click Checkout button
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/btn_checkout")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/btn_checkout")
	MobileElement checkout_btn;

	//Click Add More button
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/btn_add_more")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/btn_add_more")
	MobileElement addMore_btn;




	/* =========================== Action Methods ============================= */
	//Click Add to bag button
	public void clkAddtoBagBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(addToBag_btn));
		wait.until(ExpectedConditions.elementToBeClickable(addToBag_btn));
		addToBag_btn.click();
	}

	//Click No Thanks button
	public void clkNoThanksBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(noThanks_btn));
		wait.until(ExpectedConditions.elementToBeClickable(noThanks_btn));
		noThanks_btn.click();
	}

	//Click Done button
	public void clkDoneBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(done_btn));
		wait.until(ExpectedConditions.elementToBeClickable(done_btn));
		done_btn.click();
	}

	//Click Done button
	public void clkCheckOutBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(checkout_btn));
		wait.until(ExpectedConditions.elementToBeClickable(checkout_btn));
		checkout_btn.click();
	}

	//Click Add More button
	public void clkAddMoreBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(addMore_btn));
		wait.until(ExpectedConditions.elementToBeClickable(addMore_btn));
		addMore_btn.click();
	}




}
