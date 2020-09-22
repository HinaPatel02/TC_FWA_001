package com.freshii.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freshii.base.BaseClass;
import com.freshii.pageObjects.FM_HomePage;
import com.freshii.pageObjects.FM_LandingPage;
import com.freshii.pageObjects.FM_SignUpLoginPage;
import com.freshii.pageObjects.FM_SignUpPage;

public class TC_UAT_UFreshii_001 extends BaseClass {
	//Test Case - Verify end-end workflow using Freshii User: Sign Up
	@Test
	public void freshiiSignUpTest() {
		//Started Freshii Sign Up Test (Positive)
		logger.info("Started End to End Freshii Sign Up Test - positive scenario");

		//Create the object for Landing Page
		FM_LandingPage lp = new FM_LandingPage(driver);
        
		driver.resetApp();	
		logger.info("Reset the app");

		//Click on Sign Up / Login button
		lp.clkSignUpLoginBtn();
		logger.info("Clicked on Sign Up / Login button");

		//Create the object for Sign Up & Login Page
		FM_SignUpLoginPage slp = new FM_SignUpLoginPage(driver);
		slp.clkSignUpBtn();
		logger.info("Sign Up button clicked");

		//Create the object for Sign Up page
		FM_SignUpPage sup = new FM_SignUpPage(driver);
		sup.signUpFunction();
		logger.info("Entered the values and clicked Sign Up button");

		//Validate if Home Page is displayed
		SoftAssert softassert = new SoftAssert();

		//Create object for Home Page
		FM_HomePage hp = new FM_HomePage(driver);
		boolean verify_homePg = hp.validateHomePage();
		if(verify_homePg)
			logger.info("User is signed up and Home Page is displayed!");	
		else
			logger.error("User is not signed up as Home Page is not displayed!");

		hp.ClickMenu();
		
		String text="Sign Out";				
		String uiSelector = "new UiSelector().textMatches(\"" + text   + "\")";

			String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + uiSelector + ");";

			driver.findElementByAndroidUIAutomator(command);

		
		//Sign Out Function
		hp.signOut();
		logger.info("Sign Out Function performed");

		//Validate if Landing page is displayed
		boolean verify_landingPg = lp.validateLandingPage();
		if(verify_landingPg)
			logger.info("User successfully logged out");
		else
			logger.error("User is not logged out");

		softassert.assertAll();
		logger.info("Completed End to End Freshii Sign Up Test - positive scenario");
	}

}

