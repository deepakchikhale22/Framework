package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configdataprovider 
{
    Properties pro;
	public configdataprovider() throws IOException
	{
		File src=new File("./Config/config.properties");
		FileInputStream fis=new FileInputStream(src);
	    pro=new Properties();
	    pro.load(fis);
		
	}
	public String getDataFromConfig(String keytosearch) 
	{
		return pro.getProperty(keytosearch);
		
		
	}
	public String getBrowser() 
	{
		return pro.getProperty("Browser");
		
		
	}
	public String getStagingUrl() 
	{
		return pro.getProperty("qaurl");
		
		
	}
	
}
