package com.freshii.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freshii.base.BaseClass;
import com.freshii.pageObjects.FM_HomePage;
import com.freshii.pageObjects.FM_LandingPage;
import com.freshii.pageObjects.FM_PickUpDeliveryOptionPage;
import com.freshii.pageObjects.FM_LocationPage;
import com.freshii.pageObjects.FM_LoginPage;
import com.freshii.pageObjects.FM_MenuIngredientPage;
import com.freshii.pageObjects.FM_MenuPage;
import com.freshii.pageObjects.FM_SignUpLoginPage;
import com.freshii.pageObjects.FM_StoreSelectionPage;
import com.freshii.utilities.Reporting;

import io.appium.java_client.MobileBy;

public class TC_UAT_UFreshii_003 extends BaseClass {
	Reporting report = new Reporting();
	
	//Test Case - Verify end-end workflow using Freshii User for Salad
	@Test
	public void e2eSaladOrder() throws InterruptedException, IOException {
		//Started Freshii Salad Test (Positive)
		logger.info("Started the test to verify whether user can select Salads - positive scenario");

		//Create the object for Landing Page
		FM_LandingPage lp = new FM_LandingPage(driver);

		//Click on Sign Up / Login button
		lp.clkSignUpLoginBtn();
		logger.info("Clicked on Sign Up / Login button");

		//Create the object for Sign Up & Login Page
		FM_SignUpLoginPage slp = new FM_SignUpLoginPage(driver);

		//Click on Login button
		slp.clkLoginBtn();
		logger.info("Clicked on Login button");

		//Create the object for Login Page
		FM_LoginPage loginpg = new FM_LoginPage(driver);

		//Steps 1,2 & 3 covered
		loginpg.login(email, password);
		logger.info("Login function performed!");

		//Validate if Home Page is displayed
		SoftAssert softassert = new SoftAssert();
		
		//Create object for Home Page
		FM_HomePage hp = new FM_HomePage(driver);
		boolean verify_homePg = hp.validateHomePage();
		if(verify_homePg)
		{
			softassert.assertTrue(true);
			logger.info("User is logged in and Home Page is displayed!");
		}
		else
		{
			softassert.assertTrue(false);
			logger.info("User is not logged in as Home Page is not displayed!");

		}

		//Click Order button
		hp.clkOrderBtn();
		logger.info("Order button is clicked");

		//Create object for Location Option Page
		FM_PickUpDeliveryOptionPage pickDelPg = new FM_PickUpDeliveryOptionPage(driver);
		pickDelPg.clkPickUp();
		logger.info("Pick Up option selected");

		//Create object for Location Page
		FM_LocationPage locPg = new FM_LocationPage(driver);
		locPg.selectLocation(freshiiLocation);
		logger.info("Location clicked");

		FM_StoreSelectionPage storeSelPg = new  FM_StoreSelectionPage(driver);
		storeSelPg.clcStorePickUpBtn(freshiiStore);
		logger.info("Store selected");
		
		//Create object for MenuPage, Menu Ingredient and Order page
		FM_MenuPage menuPage = new FM_MenuPage(driver);
		FM_MenuIngredientPage menuIngredientPage = new FM_MenuIngredientPage(driver); 
		
		//Create an array to store all the Salads to be selected
		String[] salads= {"Cobb Salad","Fiesta Salad", "Metaboost Salad", "Market Salad", "Umamii Salad", "Kale Caesar Salad", "Market Salad"};

		for(int i=0; i<salads.length;i++)
		{
			//Click into each salads
			menuPage.selectSalad(salads[i]);
			logger.info("Select the required salad type:"+salads[i]);
			
			//Click Add to bag button
			menuIngredientPage.clkAddtoBagBtn();
			logger.info("Add to Bag button clicked");
			
			//Click No Thanks button
			menuIngredientPage.clkNoThanksBtn();
			logger.info("No Thanks button clicked");			
			
			//Click Done button
			menuIngredientPage.clkDoneBtn();
			logger.info("Done button clicked");

			//if its the last salad, click Check Out Button
			if(i==salads.length-1)
			{
				menuIngredientPage.clkCheckOutBtn();
				logger.info("Checkout button clicked");
				break;
			}
					
			//If it's not last salad, Click Add More Button
			menuIngredientPage.clkAddMoreBtn();
			logger.info("Clicked Add More button");
		}
		
		//If upsell section is displayed then click on NO, THANKS button		
		
		if(driver.findElementById("com.tacitinnovations.freshii.dev:id/btn_no_thanks").isDisplayed()) {
			driver.findElementById("com.tacitinnovations.freshii.dev:id/btn_no_thanks").click();
		}
		
		//Scroll and click on payment option
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.tacitinnovations.freshii.dev:id/nested_scroll_view\")).scrollIntoView(new UiSelector().textMatches(\"PLACE ORDER\").instance(0))")).click();


		

		






	}
}



