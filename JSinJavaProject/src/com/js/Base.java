package com.js;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Base {

	WebDriver driver;

	public Base(WebDriver driver) {
		this.driver = driver;
	}

	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

	public void printImage() throws Exception {
		String fileName = getRandomString(10) + ".png";
		String directory = "c://tmp//";

		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));

	}

	public void scrollToElement(WebElement element) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0, -190);");
	}
	
	public void Highlight(WebElement element) throws Exception {

		 JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i < 6; i++) {
			js.executeScript("arguments[0].style.border='4px groove yellow'", element);
			Thread.sleep(300);
			js.executeScript("arguments[0].style.border=''", element);
			Thread.sleep(300);
			
		}
	}
}
