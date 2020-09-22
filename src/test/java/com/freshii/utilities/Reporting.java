package com.freshii.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;
	
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp

		String repName="Freshii_ExtentReport-"+timeStamp+".html"; // Report name and time stamp in html format
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/ExtentReports/"+repName);

		//htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/Reports/"+repName);//specify location of the report

		htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report - given by the user
		htmlReporter.config().setReportName("Functional Testing"); // name of the report - given by the user
		//htmlReporter.config().setTheme(Theme.DARK); // Theme of the report - Dark
		htmlReporter.config().setTheme(Theme.STANDARD); // Theme of the report - Standard
		String css = ".r-img {width: 50%;}";
		htmlReporter.config().setCSS(css);
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		// System info can be any info defined by the User that comes in the report
		// populate the common details
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("user","busyQA");
		extent.setSystemInfo("OS","Android");
		extent.setSystemInfo("Device name","Nexus 6P API 24");
	}
	
	public void onTestSuccess (ITestResult result)
	{
		String feature = result.getMethod().getRealClass().getName()+ ":" + result.getMethod().getMethodName();
		feature = feature.substring(feature.lastIndexOf(".") + 1);	
		test=extent.createTest(feature); // create new entry in the report
		//test=extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.PASS, "Test Case PASSED IS " + feature);
		
//		test=extent.createTest(result.getName()); // create new entry in the report
//		test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
	}

	public void onTestFailure (ITestResult result)
	{

		test=extent.createTest(result.getName()); // create new entry in the report

		test.log(Status.FAIL, "Test Case FAILED IS " + result.getName());
		test.log(Status.FAIL, "Test Method FAILED IS " + result.getMethod());
		test.log(Status.FAIL, "Test Case FAILED IS " + result.getThrowable());

		//String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+" .png";

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		//String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getMethod().getMethodName()+" "+timeStamp+".png";//original
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getMethod().getMethodName()+timeStamp+".png";

		System.out.println("Screenshot path is: "+screenshotPath);
		try 
		{
			test.addScreenCaptureFromPath(screenshotPath);// adding screen shot	
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void onTestSkipped (ITestResult result)
	{
		test=extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.SKIP, "Test Case SKIPPED  IS " + result.getName());
	}

	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}

}
