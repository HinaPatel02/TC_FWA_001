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

public class FM_DieteryFilterPage {
	//AppiumDriver<MobileElement> driver;
	AndroidDriver <AndroidElement> driver;

	//Constructor
	public FM_DieteryFilterPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}
//	public FM_DieteryFilterPage(AppiumDriver<MobileElement> driver) {
//		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//		this.driver = driver;
//	}

	/* ============================ Page Elements =============================== */

	//Capture Done button
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/done")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/done")
	public MobileElement done_btn;



	/* ==================== Action Methods ================================ */
	//Click the required dietery filter
	public void clkRestrictedIngredient(String RestrictIngredient) {
		//List <MobileElement> ingredientsList = driver.findElementsById("com.tacitinnovations.freshii:id/chip");
		List<AndroidElement> ingredientsList = driver.findElementsById("com.tacitinnovations.freshii.dev:id/chip");
		for(AndroidElement ingredient :ingredientsList) {
			if(ingredient.getAttribute("text").equalsIgnoreCase(RestrictIngredient)) {
				ingredient.click();
				break;
			}
		}
	}

	//Click on Done button
	public void clkDoneButton() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(done_btn));
		wait.until(ExpectedConditions.elementToBeClickable(done_btn));
		done_btn.click();		
	}

}
