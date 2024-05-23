package TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

}
