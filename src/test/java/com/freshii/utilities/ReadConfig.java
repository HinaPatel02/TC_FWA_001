package com.freshii.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {	

	// Properties Class
	Properties pro; 

	// Constructor
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");// Creating File object

		try 
		{
			// Open FileInputStream and Read data 
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis); // Load config.properties file
		} 
		catch (Exception e) 
		{	
			// If config.properties file is not available it will throw an exception
			System.out.println("Exception is " + e.getMessage());
		}
	}

	// Methods to read data from config.properties 
	
	public String getUserEmail()
	{
		String email=pro.getProperty("freshii_email");
		return email;
	}

	public String getPassword() 
	{
		String password=pro.getProperty("freshii_password");
		return password;
	}
	
	public String getLocation() 
	{
		String location=pro.getProperty("freshii_location");
		return location;
	}
	
	public String getStore() 
	{
		String store=pro.getProperty("freshii_store");
		return store;
	}

	public String getChromePath() 
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getAppPath()
	{
		String appPath = pro.getProperty("AndroidApp");
		//System.out.println(appPath);
		return appPath;
	}
	
	public String getGoogleEmail()
	{
		String gmail=pro.getProperty("google_email");
		return gmail;
	}

	public String getGooglePassword() 
	{
		String gpassword=pro.getProperty("google_password");
		return gpassword;
	}
}



