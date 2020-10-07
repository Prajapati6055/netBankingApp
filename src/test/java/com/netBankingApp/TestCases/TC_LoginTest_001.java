package com.netBankingApp.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.netBankingApp.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws IOException
	{  
		// here we are creating the instance of LoginPage class & perform the loginPage Actions 
	    
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(username);
		logger.info(" Entered UsarName ");
		lp.setPassword(password);
		logger.info(" Entered Password ");
		lp.clickSubmit();
		logger.info(" Clicked Submit Button ");
		
		// here we are verifying the app title 
		
		String expTitle=driver.getTitle(); 
		if(expTitle.equals(loginTitle))
		{
			Assert.assertTrue(true);
			logger.info(" Login test passed ");
		}
		else
		{
			captureScreen(driver,"loginTest"); 
			Assert.assertTrue(false);
			logger.info(" Login test failed ");
		}
		
	}
}
