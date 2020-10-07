 package com.netBankingApp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage
{

	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)     // create the constructor to initialized the remote driver
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// creating the page elements objects in page class 
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement newCustomerOption;
	
	@FindBy(name="name")
	WebElement nameTextField;
	
	@FindBy(name="rad1")
	WebElement radioBtnMale;
	
	@FindBy(name="dob")
	WebElement custdob;
	
	@FindBy(name="addr")
	WebElement custAddress;
	
	@FindBy(name="city")
	WebElement custCity;
	
	@FindBy(name="state")
	WebElement custState;
	
	@FindBy(name="pinno")
	WebElement custPin;
	
	@FindBy(name="telephoneno")
	WebElement mobNumber;
	
	@FindBy(name="emailid")
	WebElement email_id;
	 
	@FindBy(name="password")
	WebElement passTextField;
	
	@FindBy(name="sub")
	WebElement submitBtn;
	
	
	
	
	
	public void clickAddNewCustomer()
	{
		newCustomerOption.click();
	}
	
	public void enterCustName(String name)
	{
		nameTextField.sendKeys(name);
	}
	
	public void selectGender()
	{
		radioBtnMale.click();
	}
	
	public void selectDateOfBirth(int mm,int dd,int yyyy)
	{
		custdob.sendKeys(String.valueOf(mm));
		custdob.sendKeys(String.valueOf(dd));
		custdob.sendKeys(String.valueOf(yyyy));
	}
	
	public void enterCustAdds(String adds)
	{
		custAddress.sendKeys(adds);
	}
	
	public void selectCity(String city)
	{
		custCity.sendKeys(city);
	}
	
	public void selectState(String state)
	{
		custState.sendKeys(state);
	}
	
	public void enterPin(int pin)
	{
		custPin.sendKeys(String.valueOf(pin));    // converting value form int to string
	}
	
	public void enterMobNumber(long mobnum)
	{
		mobNumber.sendKeys(String.valueOf(mobnum));   // converting value form int to string
	}
	
	public void enterMailId(String mailid)
	{
		email_id.sendKeys(mailid);
	}
	
	public void enterPassword(String pass)
	{
		passTextField.sendKeys(pass);
	}
	
	public void clickSubmitButton()
	{
		submitBtn.click();
	}
	
}
