package TestCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import Utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String BaseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();

	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {

		logger = Logger.getLogger("E-Banking");
		PropertyConfigurator.configure("log4j.properties");

		if (browser.equals("chrome")) {
			
			System.setProperty("webdriver.driver.chromedriver", readconfig.getChromepath());
			driver = new ChromeDriver();
			
		} else if (browser.equals("firefox")) {
			
			System.setProperty("webdriver.driver.chromedriver", readconfig.getFirefoxpath());
			driver = new FirefoxDriver();
			
		} else if (browser.equals("edge")) {
			
			System.setProperty("webdriver.driver.chromedriver", readconfig.getedgepath());
			driver = new EdgeDriver();
		}
		
		driver.get(BaseURL);
		logger.info("Launced Test Page");


	}

	@AfterClass
	public void teardown() {
		driver.quit();

	}

}
