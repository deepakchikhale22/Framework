package com.automation.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.Baseclass;
import com.automation.pages.Loginpage;
import com.automation.utility.BrowserFactory;
import com.automation.utility.Helper;

public class LoginTestcrm extends Baseclass
{
	
	@Test(priority=1)
	public void loginApp() throws InterruptedException, IOException 
	{
		
		logger=report.createTest("Login to Crm");
		Loginpage loginpage =PageFactory.initElements(driver, Loginpage.class);
		logger.info("starting application");
		loginpage.loginToCrm(excel.getstringData("login1", 0, 0),excel.getstringData("login1", 0, 1));
		logger.pass("login done successfully");
		Helper.captureScreenshot(driver);
		System.out.println(driver.getTitle());
	}
	
	@Test(priority=2)
	public void loginApp1()
	{
		
		logger=report.createTest("Logout");
		logger.fail("logout failed");
		
	}

}
