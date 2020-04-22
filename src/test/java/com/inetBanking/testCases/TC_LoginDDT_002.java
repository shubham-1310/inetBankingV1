package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(3000L);
	
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.warn("Login failed");
			Assert.assertTrue(false);
			
		}
		else 
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Login Passed");
			Thread.sleep(3000L);
		}
		
	}
	
	public boolean isAlertPresent()
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
	String[][] getData() throws IOException
	{
		String path= System.getProperty("user.dir")+"/src/test/java/testData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");		
		int colcount =XLUtils.getCellCount(path,"Sheet1", 1);
		
		String logindata[][]= new String[rownum][colcount];
		
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
		return logindata;
		
	}
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
