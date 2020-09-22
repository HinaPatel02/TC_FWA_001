package com.freshii.testCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freshii.base.BaseClass;
import com.freshii.pageObjects.FM_LandingPage;
import com.freshii.pageObjects.FM_SignUpLoginPage;
import com.freshii.utilities.Reporting;

import io.appium.java_client.MobileElement;

public class TC_UAT_Mob_Credit_044 extends BaseClass{
	Reporting report = new Reporting();

	@Test
	public void guestUserPaymentMethod() {
		//Starting the test to verify whether Guest User can navigate to Payment Method screen
		logger.info("Started Payment Method Test for Guest User - positive scenario");

		//Create the object for Landing Page
		FM_LandingPage landingpg = new FM_LandingPage(driver);

		//Click on Sign Up / Login button
		landingpg.clkSignUpLoginBtn();
		logger.info("Clicked on Sign Up / Login button");

		//Click on 'Proceed as a guest' label
		FM_SignUpLoginPage signUpLoginpg = new FM_SignUpLoginPage(driver);
		signUpLoginpg.clkProceedAsGuestLbl();
		logger.info("Clicked on 'Proceed as a guest' label");

		//Navigating to the usual landing page
		landingpg.paymentMethod();
		logger.info("Clicked on Payment method");

		//Verify whether error message is displayed
		SoftAssert softassert = new SoftAssert(); 
		//MobileElement txt_element = driver.findElementById("com.tacitinnovations.freshii:id/messageToShow");
		MobileElement txt_element = driver.findElementById("com.tacitinnovations.freshii.dev:id/messageToShow");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(txt_element));
		String actualErrorMessage = txt_element.getText();
		System.out.println("The error message displayed is : "+actualErrorMessage);
		String expectedErrorMessage = "Please sign up to see payment methods for your profile";
		if(actualErrorMessage.equalsIgnoreCase(expectedErrorMessage))
		{
			softassert.assertTrue(true);
			logger.info("Error message displayed as expected!");
		}
		else
		{
			softassert.assertTrue(true);
			logger.error("Error message not displayed");
		}
		softassert.assertAll();
		logger.info("Completed Payment Method Test for Guest User - positive scenario");
	}

}
