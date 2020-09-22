package com.freshii.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freshii.base.BaseClass;
import com.freshii.pageObjects.FM_HomePage;
import com.freshii.pageObjects.FM_LandingPage;
import com.freshii.pageObjects.FM_LoginPage;
import com.freshii.pageObjects.FM_SignUpLoginPage;
import com.freshii.utilities.Reporting;

import io.appium.java_client.MobileElement;

@Listeners(com.freshii.utilities.Reporting.class)
public class FM_FreshiiLoginTest extends BaseClass{
	Reporting report = new Reporting();
	//Testing Freshii Login functionality
	@Test
	public void freshiiLoginTest() throws IOException, InterruptedException {
		//Started Freshii Login Test (Positive)
		logger.info("Started Freshii Login Test - positive scenario");

		//Create the object for Landing Page
		FM_LandingPage landingpg = new FM_LandingPage(driver);

		//Click on Sign Up / Login button
		landingpg.clkSignUpLoginBtn();
		logger.info("Clicked on Sign Up / Login button");

		//Validate whether Sign Up / Login page is displayed	
		SoftAssert softassert = new SoftAssert();
		//Verifying if Proceed as guest label is displayed
		if(driver.findElement(By.id("com.tacitinnovations.freshii.dev:id/label_proceed_as_guest")).isDisplayed())
		{	
			softassert.assertTrue(true);
			logger.info("Sign Up / Login page is displayed!");
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Sign Up / Login page is not displayed!");			
		}

		//Create the object for Sign Up & Login Page
		FM_SignUpLoginPage signUploginpg = new FM_SignUpLoginPage(driver);

		//Click on Login button
		signUploginpg.clkLoginBtn();
		logger.info("Clicked on Login button");

		//Validate if Log in Label is displayed in Login Page
		String loginLabel = driver.findElement(By.id("com.tacitinnovations.freshii.dev:id/label_login")).getText();
		System.out.println("The label is: " + loginLabel);
		if(loginLabel.equalsIgnoreCase("Log in"))
		{
			softassert.assertTrue(true);
			logger.info("Login page is displayed!");				
		}
		else
		{
			softassert.assertTrue(false);
			logger.error("Login page is not displayed!");
		}

		//Create the object for Login Page
		FM_LoginPage loginpg = new FM_LoginPage(driver);

		//Set the values in Email & Password fields
		loginpg.setEmail(email);
		logger.info("Email value is set");
		loginpg.setPassword(password);
		logger.info("Password value is set");

		//Click on Login button
		loginpg.clkLoginBtn();
		logger.info("Clicked on Login button");

		//Create object for Home Page
		FM_HomePage homepg = new FM_HomePage(driver);
		boolean verify_homePg = homepg.validateHomePage();
		if(verify_homePg)
		{
			softassert.assertTrue(true);
			logger.info("User is logged in and Home Page is displayed!");	
		}
		else 
		{
			softassert.assertTrue(false);
			logger.error("User is not logged in as Home Page is not displayed!");
		}

		//Sign Out Function - Steps - 4 & 5 covered
		homepg.signOut();
		logger.info("Sign Out Function performed");

		//Validate if Landing page is displayed
		boolean verify_landingPg = landingpg.validateLandingPage();
		if(verify_landingPg)
			logger.info("User successfully logged out");
		else
			logger.info("User is not logged out");

		softassert.assertAll();
		logger.info("Completed Freshii Login Test - Positive Scenario");
	}
}

