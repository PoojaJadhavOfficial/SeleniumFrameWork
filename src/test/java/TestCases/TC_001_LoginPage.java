package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage_PO;

public class TC_001_LoginPage extends BaseClass{

	@Test
	public  void LoginTest() {
		
		driver.get(BaseURL);
		
		LoginPage_PO lp=new LoginPage_PO(driver);
		
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			
		}else
		{
			Assert.assertTrue(false);

			
		}
		
	}
}
