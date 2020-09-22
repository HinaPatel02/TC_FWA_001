package com.freshii.pageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FM_StoreSelectionPage {
	//AppiumDriver<MobileElement> driver;
	AndroidDriver<AndroidElement> driver;

	public FM_StoreSelectionPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	/* =========================== Page Elements ============================= */

	//Capture Freshii Demo Store
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/pickup")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/pickup")
	public MobileElement storePickup_btn;


	/* =========================== Action Methods ============================= */	

	//Select Freshii Demo Store
	public void clcStorePickUpBtn(String storeName) throws InterruptedException {
		Thread.sleep(2000);
		storePickup_btn.click();
//		List<MobileElement> stores = driver.findElementsById("com.tacitinnovations.freshii:id/title");
//		for(MobileElement store : stores)
//		{
//			System.out.println(store.getText());
//		}
//			for(MobileElement store : stores)
//			{
//				if(store.getText().equalsIgnoreCase(storeName)) 
//				{
//					if(storePickup_btn.isDisplayed()) 
//					{
//						storePickup_btn.click();
//					}
//				}
//				break;
//			}

	}







}
