package com.freshii.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freshii.base.BaseClass;
import com.freshii.pageObjects.FM_DieteryFilterPage;
import com.freshii.pageObjects.FM_HomePage;
import com.freshii.pageObjects.FM_LandingPage;
import com.freshii.pageObjects.FM_LocationMenuPage;
import com.freshii.pageObjects.FM_LocationPage;
import com.freshii.pageObjects.FM_LoginPage;
import com.freshii.pageObjects.FM_PickUpDeliveryOptionPage;
import com.freshii.pageObjects.FM_SignUpLoginPage;
import com.freshii.pageObjects.FM_StoreSelectionPage;
import com.freshii.utilities.Reporting;
import com.freshii.utilities.XLUtils;

public class TC_UAT_UFreshii_044 extends BaseClass{
	Reporting report = new Reporting();
	//Reading data from excel
	@DataProvider(name="DietaryIngredient")
	public Object [][] getData() throws IOException
	{	 
		logger.info("Getting excel file path");
		// Excel file path 
		String path=System.getProperty("user.dir")+"/src/test/java/com/freshii/testData/MenuItems.xlsx";
		logger.info("Trying to get the row count from excel sheet....");
		int rownum=XLUtils.getRowCount(path, "Dietary_Restriction");
		logger.info("Trying to get the column count from excel sheet....");
		int colcount=XLUtils.getCellCount(path,"Dietary_Restriction",0);
		logger.info("Store into dietary data");
		Object dietaryData[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				dietaryData[i-1][j]=XLUtils.getCellData(path,"Dietary_Restriction", i,j);
			}
		}
		return dietaryData;
	}

	//Test Case - User is able to specify their dietary restrictions while browsing menu
	@Test
	public void dietaryPageNavigation() throws InterruptedException, IOException {
		//Started Freshii Login Test (Positive)
		logger.info("Started Dietary Restriction - positive scenario");

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
			logger.error("User is not logged in as Home Page is not displayed!");
		}

		//Click Order button
		hp.clkOrderBtn();
		logger.info("Order button is clicked");

		//Create object for Location Option Page
		FM_PickUpDeliveryOptionPage pickDelPg = new FM_PickUpDeliveryOptionPage(driver);
		pickDelPg.clkPickUp();
		logger.info("Pick Up option selected");

		//Create object for Location Page
		FM_LocationPage locPg = new FM_LocationPage(driver);
		locPg.selectLocation(freshiiLocation);
		logger.info("Location clicked");

		FM_StoreSelectionPage storeSelPg = new  FM_StoreSelectionPage(driver);
		storeSelPg.clcStorePickUpBtn(freshiiStore);
		logger.info("Store selected");
	}

	@Test(dataProvider = "DietaryIngredient", dependsOnMethods= {"dietaryPageNavigation"})
	public void dietaryRestriction(String scenarioNum, String dietIngrdient) {
		logger.info("Selecting the dietary ingredient");
		//Create object for Location Menu Page
		FM_LocationMenuPage locMenuPg = new FM_LocationMenuPage(driver);
		locMenuPg.clkDietaryPreferenceBtn();
		logger.info("Dietary Preference button is clicked");

		//Create object for Dietery Filter Page		
		FM_DieteryFilterPage dietFilterpg = new FM_DieteryFilterPage(driver);

		//Passing Scenario Number from excel
		int sNum= Integer.parseInt(scenarioNum);

		//Using switch case to perform the same function for different menu ingredient
		switch(sNum) {
		case 1:
			//Selecting the first ingredient
			dietFilterpg.clkRestrictedIngredient(dietIngrdient);
			logger.info("The ingredient selected is : "+dietIngrdient);		
			//Click on Done button
			dietFilterpg.clkDoneButton();
			logger.info("Clicked on Done button");	

			//Disable the dietary restriction
			locMenuPg.clkDietaryPreferenceBtn();
			logger.info("Dietary Preference button is clicked");
			dietFilterpg.clkRestrictedIngredient(dietIngrdient);
			logger.info(dietIngrdient +" is de-selected");				
			//Click on Done button
			dietFilterpg.clkDoneButton();
			logger.info("Clicked on Done button and dietary restriction is disabled ");
			break;

		case 2:
			//Selecting the first ingredient
			dietFilterpg.clkRestrictedIngredient(dietIngrdient);
			logger.info("The ingredient selected is : "+dietIngrdient);		
			//Click on Done button
			dietFilterpg.clkDoneButton();
			logger.info("Clicked on Done button");	

			//Disable the dietary restriction
			locMenuPg.clkDietaryPreferenceBtn();
			logger.info("Dietary Preference button is clicked");
			dietFilterpg.clkRestrictedIngredient(dietIngrdient);
			logger.info(dietIngrdient +" is de-selected");				
			//Click on Done button
			dietFilterpg.clkDoneButton();
			logger.info("Clicked on Done button and dietary restriction is disabled ");
			break;

		case 3:
			//Selecting the first ingredient
			dietFilterpg.clkRestrictedIngredient(dietIngrdient);
			logger.info("The ingredient selected is : "+dietIngrdient);		
			//Click on Done button
			dietFilterpg.clkDoneButton();
			logger.info("Clicked on Done button");	

			//Disable the dietary restriction
			locMenuPg.clkDietaryPreferenceBtn();
			logger.info("Dietary Preference button is clicked");
			dietFilterpg.clkRestrictedIngredient(dietIngrdient);
			logger.info(dietIngrdient +" is de-selected");				
			//Click on Done button
			dietFilterpg.clkDoneButton();
			logger.info("Clicked on Done button and dietary restriction is disabled ");
			break;
		}
	}

	@Test(dependsOnMethods= {"dietaryRestriction"})
	public void freshiiSignOut() {
		logger.info("User is about to sign out");
		//Create object for Location Menu Page
		FM_LocationMenuPage locMenuPg = new FM_LocationMenuPage(driver);
		//Sign out function
		locMenuPg.signOut();
		logger.info("User Signed Out!");

		logger.info("Completed setting of dietary restrictions by Freshii user - positive scenario");
	}
}
