package TestCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseClass {

	public static String BaseURL = "https://demo.guru99.com/V4/";
	public static String username = "mngr570900";
	public static String password = "paheqAg";

	public static WebDriver driver;
	public static Logger logger;
	
	
    @BeforeClass
	public static void setup() {
		
		System.setProperty("webdriver.driver.chromedriver", "/Users/poojajadhav/eclipse-workspace/SeleniumFramework/Drivers/chromedriver");
		driver=new ChromeDriver();
		
		logger = Logger.getLogger("E-Banking");
		PropertyConfigurator.configure("log4j.properties");

	}

    @AfterClass
	public static void teardown() {
    	driver.quit();

	}

}
