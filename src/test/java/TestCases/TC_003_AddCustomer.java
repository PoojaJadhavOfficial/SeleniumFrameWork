package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage_PO;

public class TC_003_AddCustomer extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage_PO lp=new LoginPage_PO(driver);
		lp.setUsername(username);
		logger.info("Enterd Username");
		
		lp.setPassword(password);
		logger.info("Entered Password");

		lp.clickLogin();
		logger.info("Clicked Login Button");
		
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName("NewUSer");
		addcust.custgender("male");
		addcust.custDOB("11","11","2000");
		addcust.custAddress("INDIA");
		addcust.custCity("HYD");
		addcust.custState("AP");
		addcust.custPinNo("123456");
		addcust.custTelephoneNo("9876543210");
		
		String email=randomestring()+"@gmail.com";
		addcust.custEmailId(email);
		addcust.custPassword("abcdef");
		addcust.custSubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}
	
	
}
