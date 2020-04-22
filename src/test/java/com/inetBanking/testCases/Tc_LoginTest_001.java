package com.inetBanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;

public class Tc_LoginTest_001 extends BaseClass
{


	@Test
	public void loginTest() throws IOException
	{
		
		
		LoginPage lp= new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickSubmit();
		logger.info("Clicked on submit button");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
				{
		
				Assert.assertTrue(true);
				logger.info("Login Test Passed");
		}
		else 
		{
			
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test failed");
			
			
		}
	
	
		
	
}
	
}