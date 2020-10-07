package com.netBankingApp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver ldriver;
	
	// creating the constructor to initialize the remote driver 
	
	 public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	// creating the page elements objects in page class
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement textUserName;

	@FindBy(name="password")
	@CacheLookup
	WebElement textPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement loginButton;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	@CacheLookup
	WebElement logoutlink;  
	
	// creating the actions for login screen
	
	public void setUsername(String uname)
	{
		textUserName.sendKeys(uname);
	}
	
	public void setPassword(String upass)
	{
		textPassword.sendKeys(upass);
	}
	
	public void clickSubmit()
	{
		loginButton.click();
	}
	
	public void clickLogout()
	{
		logoutlink.click();
	}
	
}
