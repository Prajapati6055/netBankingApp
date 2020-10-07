package com.netBankingApp.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.netBankingApp.PageObjects.AddCustomerPage;
import com.netBankingApp.PageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);     // create the object of LoginPage class & driver is came from base class
		lp.setUsername(username);
		logger.info("username provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver); // create the object of AddCustomerPage class & driver is came from base class
		
		addcust.clickAddNewCustomer();	
		logger.info("providing customer details.....");
		
		addcust.enterCustName("Harry");
		addcust.selectGender();
		addcust.selectDateOfBirth(01, 02, 2020);
		addcust.enterCustAdds("India");
		addcust.selectCity("Pune");
		addcust.selectState("Maharashtra");
		addcust.enterPin(400400);
		addcust.enterMobNumber(1234567890);
		
		String email=randomeString()+"@gmail.com";        // it will ganerated random string & it will append with domain like(@gmail.com) 
		addcust.enterMailId(email);	
		
		addcust.enterPassword("Hello@123");
		addcust.clickSubmitButton(); 
		Thread.sleep(3000); 
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed..");
		}
		else
		{
			captureScreen(driver,"TC_AddCustomerTest_003");
			Assert.assertTrue(false);
			logger.info("test case failed..");
		}
	}


}
