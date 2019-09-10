package com.automation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utility.BrowserFactory;
import com.automation.utility.Exceldataprovider;
import com.automation.utility.Helper;
import com.automation.utility.configdataprovider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Baseclass {
	public WebDriver driver;
	public Exceldataprovider excel;
	public configdataprovider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setupsuite() throws IOException {
		//hello from github
		Reporter.log("SETUPSUITE", true);
		excel = new Exceldataprovider();
		config = new configdataprovider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/FreeCRM_" + Helper.getCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}

	@BeforeClass
	public void setup() {

		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingUrl());
		Reporter.log("setup", true);
	}

	@AfterClass
	public void teardown() {
		BrowserFactory.quitBrowser(driver);

		Reporter.log("teardown", true);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
			logger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		if (result.getStatus() == ITestResult.SUCCESS) {
			Helper.captureScreenshot(driver);
			logger.pass("Test Passed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		Reporter.log("tearDownMethod", true);
		report.flush();
	}
}
