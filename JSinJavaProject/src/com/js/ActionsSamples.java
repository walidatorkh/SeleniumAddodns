package com.js;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsSamples {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.firefox.marionette","D:\\data\\JB\\Selenium\\download\\geckodriver.exe");
    	driver = new FirefoxDriver();

    	String baseUrl = "http://www.dhtmlx.com/docs/products/dhtmlxTree/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(baseUrl);
		Thread.sleep(1000);
		
		WebElement fromElement = driver.findElement(By.xpath(".//*[@id='treebox1']//span[text()='Nancy Atherton']"));
		WebElement toElement = driver.findElement(By.xpath(".//*[@id='treebox2']//span[text()='History']"));
	
		
		Base b = new Base(driver);
		b.scrollToElement(toElement);
		b.Highlight(fromElement);
		b.Highlight(toElement);
		
		//Initiate action object instance
		Actions action = new Actions(driver);
		
		// Click and hold, move to element, release, build and perform
		
		action.clickAndHold(fromElement).perform();
		Thread.sleep(1000);
		action.moveToElement(toElement).perform();
		Thread.sleep(2000);
		action.release(toElement).perform();
		

	}

}
