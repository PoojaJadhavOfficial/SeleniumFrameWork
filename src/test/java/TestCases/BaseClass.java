package TestCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import Utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();

	public  String BaseURL = readconfig.getApplicationURL();
	public  String username = readconfig.getUsername();
	public  String password = readconfig.getPassword();

	public static WebDriver driver;
	public static Logger logger;
	
	
    @BeforeClass
	public  void setup() {
		
		System.setProperty("webdriver.driver.chromedriver", readconfig.getChromepath());
		driver=new ChromeDriver();
		
		logger = Logger.getLogger("E-Banking");
		PropertyConfigurator.configure("log4j.properties");

	}

    @AfterClass
	public  void teardown() {
    	driver.quit();

	}

}
