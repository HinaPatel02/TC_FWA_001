package com.freshii.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freshii.base.BaseClass;
import com.freshii.pageObjects.FM_ContactUsPage;
import com.freshii.pageObjects.FM_HomePage;
import com.freshii.pageObjects.FM_LandingPage;
import com.freshii.pageObjects.FM_LoginPage;
import com.freshii.pageObjects.FM_OrderHistoryPage;
import com.freshii.pageObjects.FM_SignUpLoginPage;
import com.freshii.utilities.Reporting;

public class TC_UAT_Mob_Contact_Us_Help_with_order_010 extends BaseClass{
	Reporting report = new Reporting();
	//Verify the user can click help in order history page

	@Test
	public void orderHistoryHelp() throws InterruptedException {
		//Started Order History page Help button test (Positive)
		logger.info("Started Order History page Help button test - positive scenario");

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
			logger.error("User is not logged in as Home Page is not displayed!");

		//Click on Order History button
		hp.orderHistory();
		logger.info("Order History button is clicked!");

		//Click on Help button
		FM_OrderHistoryPage orderhistoryPg = new FM_OrderHistoryPage(driver);
		orderhistoryPg.clkHelpBtn();
		logger.info("Help button is clicked!");

		//Validate whether View my tickets option is displayed
		FM_ContactUsPage contactUsPg = new FM_ContactUsPage(driver);
		String ticket_Title = contactUsPg.getViewMyTickets();
		if(ticket_Title.equalsIgnoreCase("View my tickets")) 
			logger.info("View my tickets option is displayed and the user can raise a ticket by clicking it");
		else
			logger.error("View my tickets option is not displayed!");

		//Sign Out Function
		contactUsPg.signOut();
		logger.info("User logged out!");

		softassert.assertAll();
		logger.info("Completed Order History page Help button test - positive scenario");
	}
}
