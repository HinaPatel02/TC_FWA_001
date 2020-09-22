package com.freshii.testCases;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freshii.base.BaseClass;
import com.freshii.pageObjects.FM_HomePage;
import com.freshii.pageObjects.FM_LandingPage;
import com.freshii.pageObjects.FM_LoginPage;
import com.freshii.pageObjects.FM_SignUpLoginPage;
import com.freshii.utilities.Reporting;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

public class TC_UAT_Mob_FAQ_018 extends BaseClass{
	Reporting report = new Reporting();
	//Verify the guest/user can click FAQ
	@Test(priority = 1)
	public void guestUserFAQ1(){
		//Starting the test to verify whether Guest User can navigate to FAQ screen
		logger.info("Started to verify whether Guest User can navigate to FAQ - positive scenario");

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
		landingpg.clickFAQs();
		logger.info("Clicked on FAQs");

		//Clicking and validating on first FAQ
		String faq1 = "Where can I find nutritional information? ";
		List<AndroidElement> faqs = driver.findElementsByXPath("//android.view.ViewGroup/android.widget.TextView[@id='com.tacitinnovations.freshii.dev:id/title']");
	//	List<MobileElement> faqs = driver.findElementsById("com.tacitinnovations.freshii.dev:id/title");
		for(MobileElement faq :faqs) {
			if(faq.getAttribute("text").equalsIgnoreCase(faq1)) {
				faq.click();
				break;
			}
		}

		//Retrieve the FAQ answer
		SoftAssert softassert = new SoftAssert(); 
		String exp_FAQ1 = "You can find nutritional information for any of our menu items by selecting the 'Nutrition' tab. If you are looking for a downloadable nutrition guide, or for any other nutrition questions, please reach out directly to our guest experience team at guest@freshii.com ";
		String act_FAQ1 = driver.findElementById("com.tacitinnovations.freshii.dev:id/answer").getAttribute("text");
		System.out.println("Actual FAQ answer is : "+act_FAQ1);
		if(exp_FAQ1.equalsIgnoreCase(act_FAQ1)) {
			softassert.assertTrue(true);
			logger.info("FAQ answer is matching");
		}
		else
		{
			logger.error("FAQ answer is not matching");
		}
		logger.info("Completed the verification of Guest User's navigation to FAQ - positive scenario");
		driver.resetApp();
	}

	@Test(priority = 2)
	public void freshiiUserFAQ1() throws InterruptedException {
		driver.resetApp();
		logger.info("Started to verify whether Freshii User can navigate to FAQ - positive scenario");

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
		hp.clickFaqs();
		logger.info("Clicked on FAQs");
		//Clicking and validating on first FAQ
		String faq1 = "Where can I find nutritional information? ";
		List<AndroidElement> faqs = driver.findElementsByXPath("//android.view.ViewGroup/android.widget.TextView[@id='com.tacitinnovations.freshii.dev:id/title']");
		//List<MobileElement> faqs = driver.findElementsById("com.tacitinnovations.freshii:id/title");
		//List<MobileElement> Userfaqs = driver.findElementsById("com.tacitinnovations.freshii.dev:id/title");
		for(MobileElement Userfaq :faqs) {
			if(Userfaq.getAttribute("text").equalsIgnoreCase(faq1)) {
				Userfaq.click();
				break;
			}
		}

		//Retrieve the FAQ answer
		String exp_FAQ1 = "You can find nutritional information for any of our menu items by selecting the 'Nutrition' tab. If you are looking for a downloadable nutrition guide, or for any other nutrition questions, please reach out directly to our guest experience team at guest@freshii.com ";
		//String act_FAQ1 = driver.findElementById("com.tacitinnovations.freshii:id/answer").getAttribute("text");
		String act_FAQ1 = driver.findElementById("com.tacitinnovations.freshii.dev:id/answer").getAttribute("text");
		System.out.println("Actual FAQ answer is : "+act_FAQ1);
		if(exp_FAQ1.equalsIgnoreCase(act_FAQ1)) {
			softassert.assertTrue(true);
			logger.info("FAQ answer is matching");
		}
		else
		{
			logger.error("FAQ answer is not matching");
		}
		logger.info("Completed the verification of Guest User's navigation to FAQ - positive scenario");
	}

}


