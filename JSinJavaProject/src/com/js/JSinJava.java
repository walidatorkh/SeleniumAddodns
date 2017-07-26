package com.js;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSinJava {

	static WebDriver driver;
	static JavascriptExecutor js;

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\data\\JB\\Selenium\\download\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		js = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.elementToBeClickable(myWebElement));

		//Option get url using JS
		js.executeScript("window.location = 'https://letskodeit.teachable.com/pages/practice'");
		WebElement weTitle = driver.findElement(By.xpath("//*[@id='block-1069048']//h1[text()='Practice Page']"));
		
		//Verify sync
		wait.until(ExpectedConditions.visibilityOf(weTitle));

		// Scroll Element Into View
		WebElement element = driver.findElement(By.id("mousehover"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -190);");

		// Highlight element

		for (int i = 0; i < 6; i++) {
			js.executeScript("arguments[0].style.border='4px groove yellow'", element);
			Thread.sleep(300);
			js.executeScript("arguments[0].style.border=''", element);
			Thread.sleep(300);
		}
		Base b = new Base(driver);
		b.printImage();
	}

}
