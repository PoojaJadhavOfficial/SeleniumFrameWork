package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		File src = new File("./Configurations/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}

	}

	public String getApplicationURL() {

		String url = pro.getProperty("BaseURL");
		return url;
	}

	public String getUsername() {

		String username = pro.getProperty("username");
		return username;
	}
	
	public String getPassword() {

		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromepath() {

		String chromepath = pro.getProperty("chromePath");
		return chromepath;
	}
	public String getFirefoxpath() {

		String firefoxpath = pro.getProperty("geckoPath");
		return firefoxpath;
	}
	public String getedgepath() {

		String edgepath = pro.getProperty("edgepath");
		return edgepath;
	}
	

}