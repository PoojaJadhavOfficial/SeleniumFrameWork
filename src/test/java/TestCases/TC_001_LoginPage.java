package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage_PO;

public class TC_001_LoginPage extends BaseClass{

	@Test
	public  void LoginTest() {
		
		driver.get(BaseURL);
		logger.info("Launced Test Page");
		
		LoginPage_PO lp=new LoginPage_PO(driver);
		
		lp.setUsername(username);
		logger.info("Enterd Username");
		
		lp.setPassword(password);
		logger.info("Enetered Password");

		lp.clickLogin();
		logger.info("Clicked Login Button");


		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");

			
		}else
		{
			Assert.assertTrue(false);
			logger.info("Login Test Failed");


			
		}
		
	}
}
