package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage_PO;

public class TC_001_LoginPage extends BaseClass{

	@Test
	public  void LoginTest() throws IOException {
				
		LoginPage_PO lp=new LoginPage_PO(driver);
		
		lp.setUsername(username);
		logger.info("Enterd Username");
		
		lp.setPassword(password);
		logger.info("Entered Password");

		lp.clickLogin();
		logger.info("Clicked Login Button");


		if(driver.getTitle().equals("Guru99 Bank Manager HomePage123"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");

			
		}else
		{
			captureScreen(driver,"LoginTest");

			Assert.assertTrue(false);
			logger.info("Login Test Failed");


			
		}
		
	}
}
