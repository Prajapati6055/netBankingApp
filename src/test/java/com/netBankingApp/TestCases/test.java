package com.netBankingApp.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class test 
{
	
	/*
	 * private String username; private String password;
	 * 
	 * // generate constructor from super class
	 * 
	 * public test() { super(); }
	 * 
	 * // generate constructor using fields
	 * 
	 * public test(String username, String password) { super(); this.username =
	 * username; this.password = password; }
	 * 
	 * 
	 * // generate the public getter & setter method to access the private variables
	 * 
	 * public String getUsername() { return username; }
	 * 
	 * public void setUsername(String username) { this.username = username; }
	 * 
	 * public String getPassword() { return password; }
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 */
	
	
	
	  public static void check()
	  { 
		  try 
		  { 
			  int num=5/0; 
		  }
		  catch(Throwable e) 
		  {
			  e.printStackTrace(); // It is a method of Java’s throwable class 
		  }
	  }
	  
	  public static void main(String args[])
	  { 
		  check(); 
	  }
	 

	/*
	 * @Test public void displayAllDropDownOptions() {
	 * System.setProperty("webdriver.chrome.driver",
	 * "C:\\Users\\Harry\\eclipse-workspace\\netBankingApp\\Drivers\\chromedriver.exe"
	 * ); WebDriver driver=new ChromeDriver();
	 * driver.navigate().to("https://www.cleartrip.com/");
	 * 
	 * Select dropdown=new Select(driver.findElement(By.id("Adults"))); List
	 * <WebElement> opt = dropdown.getOptions(); int size=opt.size(); for(int i=0 ;
	 * i<size ;i++) { String options = opt.get(i).getText();
	 * System.out.println(options); }
	 * 
	 * driver.quit();
	 * 
	 * }
	 */
	
	
	/*
	 * public static void main(String args[]) { int num=12345 , rev=0;
	 * 
	 * while(num!=0) { rev=rev*10; rev=rev+num%10; num=num/10; }
	 * System.out.println(rev); }
	 */
	
	
}
