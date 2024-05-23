package TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObjects.LoginPage_PO;
import Utilities.XLUtils;


public class TC_002_LoginTest_DDT extends BaseClass
{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException
	{
		LoginPage_PO lp=new LoginPage_PO(driver);
		lp.setUsername(username);
		logger.info("Enterd Username");
		
		lp.setPassword(password);
		logger.info("Entered Password");

		lp.clickLogin();
		logger.info("Clicked Login Button");

				
		if(isAlertPresent()==true)
		{
			captureScreen(driver,"loginDDTr");
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
			
	}
	
	public boolean isAlertPresent() //user defined method created to check alert is present or not
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
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/TestData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
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



