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

public class FM_ContactUsPage {
	//AppiumDriver<MobileElement> driver;
	AndroidDriver<AndroidElement> driver;
	
	public FM_ContactUsPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	/* ============================ Page Elements =============================== */
	
	//Capture Element for View my tickets
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/viewMyTickets")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/viewMyTickets")
	public MobileElement viewMyTickets_btn;
	
	//Capture Side Menu button
		@AndroidFindBy(className="android.widget.ImageButton")
		public MobileElement sideMenu_btn;
		
		//Capture Sign Out button
		@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Sign Out')]")
		public MobileElement signOut_btn;
	
	
	/* ============================ Action Methods =============================== */
	//Capture the View my tickets title
	public String getViewMyTickets() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(viewMyTickets_btn));
		String viewMyTicket_title = viewMyTickets_btn.getAttribute("text");
		return viewMyTicket_title;
	}
	
	//Capture other options
	public void getAllOptions() {
		//List<MobileElement> allOptions = driver.findElementsById("com.tacitinnovations.freshii:id/title");
		List<AndroidElement> allOptions = driver.findElementsById("com.tacitinnovations.freshii.dev:id/title");
		for(MobileElement option : allOptions) {
			System.out.println(option.getAttribute("text"));
		}
		
	}
	
	//Sign Out Function
		public void signOut() {
			WebDriverWait wait = new WebDriverWait(driver, 25);
			wait.until(ExpectedConditions.visibilityOf(sideMenu_btn));
			wait.until(ExpectedConditions.elementToBeClickable(sideMenu_btn));
			sideMenu_btn.click();
			signOut_btn.click();
		}


}
