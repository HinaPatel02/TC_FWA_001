package com.freshii.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freshii.base.BaseClass;
import com.freshii.pageObjects.FM_LandingPage;
import com.freshii.pageObjects.FM_SignUpLoginPage;
import com.freshii.utilities.Reporting;

import io.appium.java_client.MobileElement;

@Listeners(com.freshii.utilities.Reporting.class)
public class FM_GoogleLogin extends BaseClass {
	Reporting report = new Reporting();
	//Testing Continue with Google functionality
	@Test
	public void freshiiGoogleLoginTest() throws IOException, InterruptedException {
		//Started Freshii Google Login Test (Positive)
		logger.info("Started Freshii Google Login Test - positive scenario");

		//Create the object for Landing Page
		FM_LandingPage landingpg = new FM_LandingPage(driver);

		//Click on Sign Up / Login button
		landingpg.clkSignUpLoginBtn();
		logger.info("Clicked on Sign Up / Login button");

		//Create the object for Sign Up & Login Page
		FM_SignUpLoginPage signuploginpg = new FM_SignUpLoginPage(driver);

		//Click Continue with Google button
		signuploginpg.clkGoogleLoginBtn();
		logger.info("Clicked on Continue with Google button");

		//Continue with Google Function
		signuploginpg.googleLogin(googleEmail, googlePassword);
		logger.info("Continue with Google performed!");

		//Verify whether Home Page is displayed
		SoftAssert softassert = new SoftAssert();
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("com.tacitinnovations.freshii:id/home"))));
		if(element.isDisplayed()) {
			softassert.assertTrue(true);
			logger.info("Home page is displayed");
		}
		else 
		{
			softassert.assertTrue(false);
			logger.error("Home page is not displayed");				
		}

		softassert.assertAll();
		logger.info("Completed Google Login Test");
	}
}
