package com.freshii.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freshii.base.BaseClass;
import com.freshii.pageObjects.FM_HomePage;
import com.freshii.pageObjects.FM_LandingPage;
import com.freshii.pageObjects.FM_LoginPage;
import com.freshii.pageObjects.FM_MyProfilePage;
import com.freshii.pageObjects.FM_SignUpLoginPage;

public class TC_UAT_UFreshii_016 extends BaseClass{
	//Test Case - Verify User Profile options : My Account
	@Test
	public void freshiiUserProfileTest() throws IOException, InterruptedException {
		//Started My Account Test (Positive)
		logger.info("Started User Profile Test - positive scenario");

		
		//Create the object for Landing Page
		FM_LandingPage lp = new FM_LandingPage(driver);
		driver.resetApp();
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
		hp.myProfile();
		logger.info("Clicked on My Profile");

		//Validate if My Profile page is displayed
		FM_MyProfilePage myProfilePg = new FM_MyProfilePage(driver);
		boolean verify_MyProfile = myProfilePg.isMyProfileDisplayed();
		if(verify_MyProfile)
			logger.info("User profile page is displayed");
		else
			logger.info("User profile page is not displayed");
		
		//Hide Keyboard
		driver.hideKeyboard();

		//Verify whether the fields First name, Last name, Phone, Zip and Birthday are editable 
		//and Email field is Cards are added to the profile
		System.out.println("First Name is:- "+myProfilePg.getFirstName());
		System.out.println("Last Name is:- "+myProfilePg.getLastName());
		System.out.println("Email is:- "+myProfilePg.getEmail());	
		String phoneNumber = myProfilePg.getPhone();
		if(phoneNumber!= null) {
			System.out.println("Phone is:- "+phoneNumber);
		}
		else
		{
			logger.info("Phone number field is optional");
		}
				
		//Navigate back
		driver.navigate().back();
		
		hp.ClickMenu();
		String text="Sign Out";		
		
		
		String uiSelector = "new UiSelector().textMatches(\"" + text   + "\")";

			String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + uiSelector + ");";

			driver.findElementByAndroidUIAutomator(command);

		
		//Sign Out Function
		hp.signOut();
		logger.info("User Signed out!");
	
		softassert.assertAll();
		logger.info("Completed User profile page test - positive scenario");
	}
}


