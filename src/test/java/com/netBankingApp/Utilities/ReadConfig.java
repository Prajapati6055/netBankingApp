package com.netBankingApp.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig
{
	Properties prop;
	
	public ReadConfig()
	{
     File src=new File("./Configuration/config.properties");
     
     try
     {
    	 FileInputStream fis=new FileInputStream(src);
    	 prop=new Properties();
    	 prop.load(fis);
     }catch(Exception e) {
			System.out.println(" Exception is :"+e.getMessage());
			e.printStackTrace();
     }		
	}
	
	public String getApplicationURL()
	{
	  String url=prop.getProperty("appURL");
	  return url;
	}
	
	public String getUsername()
	{
	  String username=prop.getProperty("username");
	  return username;
	}

	public String getPassword()
	{
		String password=prop.getProperty("password");
		return password;
	}

    public String getChromePath()
    {
    	String chromepath=prop.getProperty("chromePath");
    	return chromepath;
    }
    
    public String getFirefoxPath()
    {
    	String firefoxpath=prop.getProperty("firefoxPath");
    	return firefoxpath;
    }

    public String getIEpath()
    {
    	String iepath=prop.getProperty("iePath");
        return iepath;
    }
    
    public String getAppTitle()
    {
    	String appTitle=prop.getProperty("loginTitle");
    	return appTitle;
    }
    
}

