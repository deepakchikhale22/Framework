package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage 
{
   WebDriver driver;
	public Loginpage(WebDriver ldriver) 
	{
		this.driver=ldriver;
		
	}
	
	@FindBy(name="username") WebElement uname;
	
	@FindBy(name="password") WebElement pass;
	
	@FindBy(xpath="//input[@value='Login']") WebElement loginbtn;
	
	public void loginToCrm(String username,String password) throws InterruptedException
	{
		Thread.sleep(2000);
		uname.sendKeys(username);
		pass.sendKeys(password);
		loginbtn.click();
	}

	
}
