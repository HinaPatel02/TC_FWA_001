package com.freshii.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freshii.base.BaseClass;
import com.freshii.pageObjects.FM_HomePage;
import com.freshii.pageObjects.FM_LandingPage;
import com.freshii.pageObjects.FM_LoginPage;
import com.freshii.pageObjects.FM_PaymentMethodPage;
import com.freshii.pageObjects.FM_SignUpLoginPage;

public class TC_UAT_UFreshii_017 extends BaseClass{
	//Test Case - Verify User -Profile options : Payment Method
	@Test
	public void freshiiPaymentMethodTest() throws IOException, InterruptedException {
		//Started Payment Method Test (Positive)
		logger.info("Started Payment Method Test - positive scenario");

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
		hp.paymentMethod();
		logger.info("Clicked on Payment Method");

		//Validate if Payment Method page is displayed
		FM_PaymentMethodPage pmp = new FM_PaymentMethodPage(driver);
		boolean verify_PaymentMethod = pmp.isPaymentMethodDisplayed();
		if(verify_PaymentMethod)
			logger.info("Payment methods page is displayed");
		else
			logger.info("Payment methods page is not displayed");

		//Verify whether Cards are added to the profile
		int numberOfCards = pmp.isPaymentDetailsAdded();
		if(numberOfCards == 0)
		{
			System.out.println("Payment details are not added to the profile");
		}
		else
		{
			System.out.println("Payment details are added to the profile and there are " +numberOfCards +" Cards");
		}
		
		//Sign Out Function
		pmp.signOut();
		logger.info("User Signed Out!");
		
		softassert.assertAll();
		logger.info("Completed Payment methods page test - positive scenario");
	}
}


