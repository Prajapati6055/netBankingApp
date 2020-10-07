package com.netBankingApp.TestCases;

//base class should also part of TestCase Package 

import org.apache.log4j.Logger;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;	
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import com.netBankingApp.Utilities.ReadConfig;

public class BaseClass 
{
	ReadConfig readconfig=new ReadConfig();
	
	public String appURL=readconfig.getApplicationURL();
	public String loginTitle=readconfig.getAppTitle();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	// common or repeating steps should be part of BaseClass  
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) 
	{
		logger=Logger.getLogger("netBanking");
	    BasicConfigurator.configure(); 

	    if(br.equals("chrome"))
	    {
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());

		//this code will handle the app launching privacy to chrome browser
		ChromeOptions capability = new ChromeOptions();
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		
		driver = new ChromeDriver(capability);
		logger.info(" Initialized Chrome Browser ");
	    }
	    else if(br.equals("firefox"))
	    {
	    	System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
	    	driver=new FirefoxDriver();
	    	logger.info(" Initialized Firefox Browser ");
	    }
	    else if(br.equals("ie"))
	    {
	    	System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
	    	driver=new InternetExplorerDriver();
	    	logger.info(" Initialized InternetExplorer Browser");
	    }
		
		driver.get(appURL);
		logger.info(" App URL is opened ");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	// whatever the common resources & common methods which are using across all the test cases should be part of BaseClass
	
    public void captureScreen(WebDriver driver,String testCaseName) throws IOException
    {
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File source=ts.getScreenshotAs(OutputType.FILE);
    	File target=new File(System.getProperty("user.dir") + "/ScreenShots/" + testCaseName +".png");
    	FileUtils.copyFile(source, target);
    	System.out.println(" ScreenShot Taken");
    }
    
	public String randomeString()
	{
		String ganeratedString=RandomStringUtils.randomAlphabetic(5);   // this method will generate any random string in between A to Z 
		return ganeratedString;
	}
	
	public static String randomeNumber()
	{
		String generatedNumber=RandomStringUtils.randomNumeric(4);      //  this method will generate any random numbers in between 0 to 9
		return generatedNumber;
	}
}
