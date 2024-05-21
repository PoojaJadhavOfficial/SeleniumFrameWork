package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestCases.BaseClass;

public class LoginPage_PO extends BaseClass {
	
	
	WebDriver ldriver;
	
	public LoginPage_PO(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(name="uid")
	WebElement userName;
	
	
	@FindBy(name="password")
	WebElement passWord;
	
	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	public  void setUsername(String usrnm)
	{
		userName.sendKeys(usrnm);
	}
	
	public  void setPassword(String pwrd)
	{
		passWord.sendKeys(pwrd);
	}
	
	public  void clickLogin()
	{
		loginBtn.click();
	}

}
