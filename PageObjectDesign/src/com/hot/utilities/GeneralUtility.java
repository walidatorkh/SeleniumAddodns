package com.hot.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GeneralUtility {

	public static WebDriver getWebDriver(String sBrowser, String sUrl) {

		WebDriver driver = null;
		
		switch (sBrowser.toLowerCase()) {
		case "firefox":
			System.setProperty("webdriver.firefox.marionette","D:\\data\\JB\\Selenium\\download\\geckodriver.exe");
	    	driver = new FirefoxDriver();
			break;

		case "chrome":
			 System.setProperty("webdriver.chrome.driver", "D:\\data\\JB\\Selenium\\download\\chromedriver.exe");
			 driver = new ChromeDriver();
			break;

		case "ie":
			File file = new File("D:\\data\\JB\\Selenium\\download\\iexploredriver.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver();
			break;

		default:
			System.setProperty("webdriver.firefox.marionette","D:\\data\\JB\\Selenium\\download\\geckodriver.exe");
	    	driver = new FirefoxDriver();
			break;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(sUrl);
		return driver;

	}
	
	public static void tearDown(WebDriver driver) throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}


	
	public static String getProperty(String key) throws IOException{
		Properties prop = new Properties();
		String workDir = System.getProperty("user.dir");
		
		InputStream input = new FileInputStream(workDir + "\\src\\com\\hot\\data\\datafile.properties");
		prop.load(input);
		//System.out.println(prop.getProperty("browser"));
		return prop.getProperty(key);
	}
}
