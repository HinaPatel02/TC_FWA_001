package com.freshii.pageObjects;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FM_MyProfilePage {
	//AppiumDriver<MobileElement> driver;
	AndroidDriver<AndroidElement> driver;

	//Constructor
	public FM_MyProfilePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	//=============Page Elements=====================

	//Capture Payment Methods Title
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'User profile')]")
	public MobileElement userProfileTitle;

	//Capture First Name field
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/edit_first_name")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/edit_first_name")
	public MobileElement userFirstName;

	//Capture Last Name field
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/edit_last_name")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/edit_last_name")
	public MobileElement userLastName;

	//Capture Email field
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/edit_email")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/edit_email")
	public MobileElement userEmail;

	//Capture Phone field
	//@AndroidFindBy(id="com.tacitinnovations.freshii:id/edit_phone")
	@AndroidFindBy(id="com.tacitinnovations.freshii.dev:id/edit_phone")
	public MobileElement userPhone;



	//==============Action Methods ======================

	//Verify whether Payment Methods page is displayed
	public boolean isMyProfileDisplayed() {
		boolean b = false;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(userProfileTitle));
		if(userProfileTitle.isDisplayed())
		{
			b = true;
		}
		return b;
	}

	//Get the First Name
	public String getFirstName() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(userFirstName));
		String firstName = userFirstName.getText();
		return firstName;
	}

	//Get the Last Name
	public String getLastName() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(userLastName));
		String lastName = userLastName.getText();
		return lastName;
	}

	//Get the Email
	public String getEmail() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(userEmail));
		String email = userEmail.getText();
		return email;
	}

	//Get the Phone
	public String getPhone() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(userPhone));
		String email = userPhone.getText();
		return email;
	}
}
