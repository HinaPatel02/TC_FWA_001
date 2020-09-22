package com.freshii.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freshii.base.BaseClass;
import com.freshii.pageObjects.FM_HomePage;
import com.freshii.pageObjects.FM_LandingPage;
import com.freshii.pageObjects.FM_LoginPage;
import com.freshii.pageObjects.FM_OrderHistoryPage;
import com.freshii.pageObjects.FM_SignUpLoginPage;
import com.freshii.utilities.Reporting;

public class TC_UAT_Mob_OrderHistory_100 extends BaseClass{
	Reporting report = new Reporting();
	//Verify Order History
	
	@Test
	public void freshiiOrderHistoryTest() throws IOException, InterruptedException {
		//Started Order History Test (Positive)
		logger.info("Started Order History Test - positive scenario");

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
			logger.info("User is logged in and Home Page is displayed!");	
		else
			logger.info("User is not logged in as Home Page is not displayed!");

		//Click on Order History to view the screen
		hp.orderHistory();
		logger.info("Clicked on Order History");

		//Validate if Order History page is displayed
		FM_OrderHistoryPage ohp = new FM_OrderHistoryPage(driver);
		boolean verify_OrderHistory = ohp.isOrderHistoryDisplayed();
		if(verify_OrderHistory)
			logger.info("Order History is displayed");
		else
			logger.info("Order History is not displayed");
		
		//Sign Out Function
		ohp.signOut();
		logger.info("User Signed out!");

		softassert.assertAll();
		logger.info("Completed Order history verification test - positive scenario");
	}
}

