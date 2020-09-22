package com.freshii.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freshii.base.BaseClass;
import com.freshii.pageObjects.FM_ContactUsPage;
import com.freshii.pageObjects.FM_HomePage;
import com.freshii.pageObjects.FM_LandingPage;
import com.freshii.pageObjects.FM_LoginPage;
import com.freshii.pageObjects.FM_SignUpLoginPage;
import com.freshii.utilities.Reporting;

public class TC_FWA_154 extends BaseClass{
	Reporting report = new Reporting();
	//Verify the user can click contact us
	@Test
	public void contactUsTest() throws InterruptedException {
		//Started Contact Us page validation test (Positive)
		logger.info("Started Contact Us page validation test - positive scenario");

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
		
		//Click on Contact Us button
		hp.clkContactUs();
		logger.info("Contact us is clicked!");
		
		//Verify the Contact us screen elements
		FM_ContactUsPage contactUsPage = new FM_ContactUsPage(driver);
		String ticket_Title = contactUsPage.getViewMyTickets();
		System.out.println("The user can raise a ticket by clicking: "+ticket_Title);
		
		//Capture other options
		logger.info("All other options which are enabled to the user are:- ");
		contactUsPage.getAllOptions();		
		
		//Sign Out Function
		contactUsPage.signOut();
		logger.info("User logged out!");		
		
		softassert.assertAll();
		logger.info("Completed Contact Us page validation test - positive scenario");
	}

}
