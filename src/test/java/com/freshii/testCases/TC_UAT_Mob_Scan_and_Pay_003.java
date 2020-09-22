package com.freshii.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freshii.base.BaseClass;
import com.freshii.pageObjects.FM_HomePage;
import com.freshii.pageObjects.FM_LandingPage;
import com.freshii.pageObjects.FM_LoginPage;
import com.freshii.pageObjects.FM_ScanAndPayPage;
import com.freshii.pageObjects.FM_SignUpLoginPage;
import com.freshii.utilities.Reporting;

public class TC_UAT_Mob_Scan_and_Pay_003 extends BaseClass{
	Reporting report = new Reporting();

	//Verify the user can tap the gift card
	@Test
	public void tapGiftCard() throws InterruptedException {
		logger.info("Started the test to verify the user can tap the gift card - positive scebario");

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

		//Click on Scan and Pay
		hp.clkScanAndPayBtn();
		logger.info("Clicked on Scan and Pay");

		//Verify whether Scan and Pay screen is displayed or not
		FM_ScanAndPayPage scanAndPayPg = new FM_ScanAndPayPage(driver);
		if(scanAndPayPg.isScanAndPayDisplayed())
		{
			logger.info("Scan and Pay screen is displayed");
		}
		else {
			logger.error("Scan and Pay screen is not displayed");
		}

		//Tap on Default Gift Card to see the number
		scanAndPayPg.tapGCNumber();
		logger.info("Tapped on the Gift Card to see the number");

		//Tap on Default Gift Card to see the front
		scanAndPayPg.tapGCFront();
		logger.info("Tapped on the Gift Card to see the front");

		//Navigate back to Home page
		driver.navigate().back();
		logger.info("Navigated to Home screen");

		//Sign out function
		hp.signOut();
		logger.info("User logged out successfully");

		logger.info("Completed the test to verify the user can tap the gift card - positive scebario");
	}
}
