package com.netBankingApp.TestCases;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demoTestNG_Sequence 
{
	/*
	 * @BeforeTest public void methodone() {
	 * System.out.println(" executing before test annotation "); }
	 */

    @BeforeClass
	public void methodsecond() 
	{
		System.out.println(" executing before class annotation ");
	}

	/*
	 * @BeforeSuite public void methodthird() {
	 * System.out.println(" executing before suite annotation "); }
	 */
	/*
	 * @AfterTest public void methodfour() {
	 * System.out.println(" executing after test annotation "); }
	 */
    @AfterClass
	public void methodfive() 
	{
		System.out.println(" executing after class annotation ");
	}

	/*
	 * @AfterMethod public void methodsix() {
	 * System.out.println(" executing after method annotation "); }
	 * 
	 * @BeforeMethod public void methodseven() {
	 * System.out.println(" executing before method annotation "); }
	 */

	
	  @Test public void methodeight() {
	  System.out.println(" executing test annotation "); }
	 
    
    @AfterSuite
 	public void methodnine() 
 	{
 		System.out.println(" executing after suite annotation ");
 	}
}


