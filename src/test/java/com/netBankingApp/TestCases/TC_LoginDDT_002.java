package com.netBankingApp.TestCases;

import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.netBankingApp.PageObjects.LoginPage;
import com.netBankingApp.Utilities.XLUtils;


public class TC_LoginDDT_002 extends BaseClass
{
	
	@Test(dataProvider="LoginData")
	public void LoginDDT(String user ,String pass) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(user);
		logger.info("username provided");
		lp.setPassword(pass);
		logger.info("password provided");
		lp.clickSubmit();
        Thread.sleep(3000);
		
		if(isAlertPesent()==true)
		{
			driver.switchTo().alert().accept();   // close the alert 
			driver.switchTo().defaultContent();      // this will return the default content of page 
			Assert.assertTrue(false);
			logger.info("Login Failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();   // close logout alert
			driver.switchTo().defaultContent();    
		}
	}
	
	
	public boolean isAlertPesent()    // created user defined method to check alert is present or not  
	{
		try
		{
			driver.switchTo().alert();
			return true;
			
        }
		 catch(NoAlertPresentException e)
		{
			 return false;
		}
	}
	

	@DataProvider(name="LoginData")
    String [][] getData() throws IOException
	{
	    String path=System.getProperty("user.dir")+"/src/test/java/com/netBankingApp/TestData/LoginData.xlsx"; // specify xlfile path
	    //String path="C:\\Users\\Harry\\eclipse-workspace\\netBankingApp\\src\\test\\java\\com\\netBankingApp\\TestData\\LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];   // created 2D array to store xl data in the form of rows & column
		
		for(int i=1;i<=rownum;i++)     // outer for-loop represents the number of rows
		{
			for(int j=0;j<colcount;j++)   // inner for loop represents the number of column
					{
						logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
					}
		}
		
		return logindata;	
	}

}
