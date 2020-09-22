package com.freshii.base;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.freshii.utilities.WebEventListener;
import com.freshii.utilities.ReadConfig;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	// Integrating data from ReadConfig
	File appDir = new File("src");
	File app = new File(appDir,(String) readconfig.getAppPath());	
	public String email=readconfig.getUserEmail();
	public String password=readconfig.getPassword(); 
	public String googleEmail = readconfig.getGoogleEmail();
	public String googlePassword = readconfig.getGooglePassword();
	public String freshiiLocation=readconfig.getLocation();
	public String freshiiStore=readconfig.getStore();
	public static Logger logger;

	//Capture Events
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	DesiredCapabilities caps; 
	public AndroidDriver<AndroidElement> driver = null;
	//public AppiumDriver<MobileElement> driver=null;
			
	@BeforeTest
	public void setUp() 
	{
		// Logger initiated within the setup method
		logger=Logger.getLogger("Freshii Mobile");// Project Name 
		PropertyConfigurator.configure("log4j.properties"); // Added Logger
		logger.setLevel(Level.DEBUG); // to get the debug log
		logger.debug("Debug logging has started ");

		//DesiredCapabilities set for Android Emulator
		caps = new DesiredCapabilities();
		// caps.setCapability("deviceName", "Pixel 2 6P API 24");
		//caps.setCapability("deviceName", "Nexus 6P API 24");
		caps.setCapability("deviceName", "Nexus");
		caps.setCapability("udid", "emulator-5554"); //Give Device ID of your mobile phone 
		//caps.setCapability("udid", "10.0.2.15:4723");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.0");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		//Freshii appPackage and appActivity
		//caps.setCapability("appPackage", "com.tacitinnovations.freshii");		
		//caps.setCapability("appActivity", "com.tacitinnovations.freshii.MainActivity");

		caps.setCapability("noReset", "true");		

		//Instantiate Appium Driver
		try 
		{
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			//driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			//Capture Events
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
		} 
		catch (MalformedURLException e)
		{
			System.out.println(e.getMessage());
		}

		//Added 10 seconds wait so that the app loads completely before starting with element identification
		try 
		{
			Thread.sleep(10000);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	//Disable the driver after EACH test has been executed
	//@AfterTest
	public void tearDown() 
	{
		driver.quit();
	}

	//Method to take screenshot
	public String screenshot(String testMethodName)
	{
		File source =( (TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String destination  = System.getProperty("user.dir") + "/Screenshots/" + testMethodName + "-" + timeStamp+ ".png" ;
		try
		{
			FileUtils.copyFile(source, new File(destination));
		}
		catch (IOException e) {
			e.printStackTrace();}

		return destination;
	}

	public static String randomestring() 
	{
		String generatedString1 = RandomStringUtils.randomAlphabetic(5); // generate random char string with the specified values passed 
		return (generatedString1);										 
	}

	public static String randomeNum() 
	{
		String generatedString2 = RandomStringUtils.randomNumeric(4);// generate random digits with the specified values passed
		return (generatedString2);
	}
}


