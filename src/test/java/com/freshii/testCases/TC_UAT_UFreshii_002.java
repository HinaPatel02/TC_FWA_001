package com.freshii.testCases;
import java.io.IOException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.freshii.base.BaseClass;
import com.freshii.pageObjects.FM_HomePage;
import com.freshii.pageObjects.FM_LandingPage;
import com.freshii.pageObjects.FM_LoginPage;
import com.freshii.pageObjects.FM_SignUpLoginPage;
import com.freshii.utilities.Reporting;

import io.appium.java_client.android.AndroidElement;

@Listeners(com.freshii.utilities.Reporting.class)
public class TC_UAT_UFreshii_002 extends BaseClass{
	Reporting report = new Reporting();

	//Test Case - Verify end-end workflow using Freshii User : Login
	@Test
	public void freshiiLoginTest() throws IOException, InterruptedException {
		//Started Freshii Login Test (Positive)
		logger.info("Started End to End Freshii Login Test - positive scenario");

		//Create the object for Landing Page
		FM_LandingPage lp = new FM_LandingPage(driver);
		
		driver.resetApp();	
		logger.info("Reset the app");

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
			logger.info("User is logged in and Home Page is displayed!");	
		else
			logger.info("User is not logged in as Home Page is not displayed!");

		//Sign Out Function - Steps - 4 & 5 covered
		//Thread.sleep(2000);
		hp.ClickMenu();
	//Scrolling down to Sign out button.	
		String text="Sign Out";		
		
		
		String uiSelector = "new UiSelector().textMatches(\"" + text   + "\")";

			String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + uiSelector + ");";

			driver.findElementByAndroidUIAutomator(command);
		
		hp.signOut();
		logger.info("Sign Out Function performed");

		//Validate if Landing page is displayed
		boolean verify_landingPg = lp.validateLandingPage();
		if(verify_landingPg)
			logger.info("User successfully logged out");
		else
			logger.info("User is not logged out");

		softassert.assertAll();
		logger.info("Completed End to End Freshii Login Test - positive scenario");
	}
}



