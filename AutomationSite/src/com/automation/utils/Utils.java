package com.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;



import org.apache.commons.io.FileUtils;

public class Utils {

	/*
	 * Read the data from data\config.propoerties
	 * Use Properties class to easily read from *.properties file  
	 */


public static String readProp(String key){
	Properties prop = new Properties();

	try {
		String workingDir = System.getProperty("user.dir");
		InputStream input = new FileInputStream(workingDir + "\\src\\com\\automation\\data\\config.properties");
		//load a properties file
		prop.load(input);

		// get the property value 
		return prop.getProperty(key);
	}
	catch(Exception err)
	{
		//return empty string in case of error
		System.out.println("Empty value from config");
		return "";
	}
}

	/*
	 * Read the driver type from data\config.propoerties 
	 */
	public static WebDriver getDriver(){
		WebDriver driver;
		//read the driver according to your definition in Const.browser
		String driverType = readProp("browser");
		switch (driverType){
		case "FireFox":
			driver = new FirefoxDriver();
			break;
		case "FireFoxProfile":
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile ffprofile = profile.getProfile("SELENIUM");
			driver = new FirefoxDriver(ffprofile);
			break;
		case "Chrome":
			//System.setProperty("webdriver.chrome.driver", "C:\\Automation\\drivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			
			//driver.get("https://www.discountbank.co.il/DB/private");
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", "C:\\Data\\Selenium\\IE\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			driver = new FirefoxDriver();
			break;
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public static void printScreen(WebDriver driver) throws IOException{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("c:\\Temp\\screenshot.png"));
	}

	
	public static void Sleep(int time){
		try {
			Thread.sleep(time);
		} 
		catch (Exception e){ //Sample for general exeption
		//catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void quiteDriver(WebDriver driver){
		System.out.println("Quit driver!");
		driver.quit();	
	}
	
	
	
}
