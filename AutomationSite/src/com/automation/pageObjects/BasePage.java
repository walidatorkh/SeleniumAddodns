package com.automation.pageObjects;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.Utils;

public class BasePage {
	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	public void click(WebElement el){
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", el);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Utils.Sleep(10);
		////Sample of wait until element to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(el));
		
		////Sample of wait until text in page:
		//wait.until(ExpectedConditions.textToBePresentInElement(el, "fdfdfd"));
		
		
		el.click();
	}
	
	public boolean IsObjectExist(WebElement el){
	
		try {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Utils.Sleep(10);
		////Sample of wait until element to be clickable
		
		wait.until(ExpectedConditions.elementToBeClickable(el));
		el.click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", el);
		
		return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("could not find element id: ");
			return false;
		}
		////Sample of wait until text in page:
		//wait.until(ExpectedConditions.textToBePresentInElement(el, "fdfdfd"));
		
		
		
	}

	
	public void fillText(WebElement el,String text){
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", el);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(el));
		
		el.clear();
		el.sendKeys(text);
	}
	
	//create highlight method
	
	public boolean clickElementById(String id)
	{
		try {
			//WebElement element = driver.findElement(By.id(id));
			WebElement element = (new WebDriverWait(driver, 10))
					   .until(ExpectedConditions.elementToBeClickable(By.id(id)));
			
			highlight(element);
			
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			click(element);
			System.out.println("Clicked element by id "+ id);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("could not find element id: " + id);
			return false;
		}
	}
	
	
	public boolean clickElementByCss(String css)
	{
		try {
			//WebElement element = driver.findElement(By.id(id));
			WebElement element = (new WebDriverWait(driver, 10))
					   .until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
			
			highlight(element);			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			click(element);
			
			System.out.println("Clicked element by xpath "+ css);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("could not find element xpath: " + css);
			return false;
		}
	}
	
	public boolean clickElementByxPath(String xpath)
	{
		try {
			//WebElement element = driver.findElement(By.id(id));
			WebElement element = (new WebDriverWait(driver, 10))
					   .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			highlight(element);
						
			click(element);
			System.out.println("Clicked element by xpath "+ xpath);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("could not find element xpath: " + xpath);
			return false;
		}
	}
	
	
	public boolean sendkeysElementById(String id, String text)
	{
		try {
			//WebElement element = driver.findElement(By.id(id));
			WebElement element = (new WebDriverWait(driver, 10))
					   .until(ExpectedConditions.elementToBeClickable(By.id(id)));
				
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			highlight(element);
			
			element.clear();
			element.sendKeys(text);
			System.out.println("Send keys: " + text + " to element: " + id);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("could not find element id " + id);
			return false;
		}
	}
	
	
	
	public boolean sendkeysElementByCss(String css, String text)
	{
		try {
			//WebElement element = driver.findElement(By.id(id));
			WebElement element = (new WebDriverWait(driver, 10))
					   .until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			highlight(element);
			element.clear();
			element.sendKeys(text);
			System.out.println("Send keys: " + text + " to element: " + css);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("could not find element css " + css);
			return false;
		}
	}
	
	public boolean sendkeysElementByXpath(String xpath, String text)
	{
		try {
			//WebElement element = driver.findElement(By.id(id));
			WebElement element = (new WebDriverWait(driver, 10))
					   .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			highlight(element);
			element.clear();
			element.sendKeys(text);
			System.out.println("Send keys: " + text + " to element: " + xpath);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("could not find element css " + xpath);
			return false;
		}
	}
	
	public WebElement getElementByCss(String css)
	{
		try {
			//WebElement element = driver.findElement(By.id(id));
			WebElement element = (new WebDriverWait(driver, 10))
					   .until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			highlight(element);
			return element;
			
			/*element.clear();
			element.sendKeys(text);
			System.out.println("Send keys: " + text + " to element: " + css);
			return true;*/
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("could not find element css " + css);
			return null;
		}
		
	}
	
	public WebElement getElementByxPath(String xpath)
	{
		try {
			//WebElement element = driver.findElement(By.id(id));
			WebElement element = (new WebDriverWait(driver, 10))
					   .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			highlight(element);
			return element;
			
			/*element.clear();
			element.sendKeys(text);
			System.out.println("Send keys: " + text + " to element: " + xpath);
			return true;*/
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("could not find element css " + xpath);
			return null;
		}
		
	}
	
	
	public boolean submitElementById(String id)
	{
		try {
			//WebElement element = driver.findElement(By.id(id));
			WebElement element = (new WebDriverWait(driver, 10))
					   .until(ExpectedConditions.elementToBeClickable(By.id(id)));
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			highlight(element);
			element.submit();
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("could not find element id " + id);
			return false;
		}
	}
	
	
	public boolean isTextApperInTitle(String text)
	{
		String siteTitle = driver.getTitle();
		if (siteTitle.toLowerCase().contains(text))
		return true;
		else 
			return false;
	}

	public boolean isTextApperInPage(String text)
	{
		String siteText = driver.getPageSource();
		if (siteText.toLowerCase().contains(text))
			return true;
		else 
			return false;
	}


	
	public boolean isPageExist(String URL, String text) throws InterruptedException
	{
		driver.navigate().to(URL);
		Thread.sleep(1000);
		
		String siteText = driver.getPageSource();
		if (siteText.toLowerCase().contains(text))
			return true;
		else 
			return false;
	}
	
	public void highlight(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='6px groove blue'", element);
	}
	
	public void getURL(String sUrl) throws InterruptedException
	{
		driver.get(sUrl);
		Thread.sleep(3000);
	}
	
	public void SwitchTabandClose(String tabName) throws InterruptedException
	{
	    Set <String> windows = driver.getWindowHandles();
	    String mainwindow = driver.getWindowHandle();
	    System.out.println("main window: " +mainwindow);

	    for (String handle: windows)
	    {
	        driver.switchTo().window(handle);
	        System.out.println("switched to "+ driver.getTitle()+" Window");
	        String pagetitle = driver.getTitle();
	        System.out.println("page Title:: " +pagetitle);
	        if(pagetitle.equalsIgnoreCase(tabName))
	        {
	            //driver.close();
	        	Thread.sleep(1000);
	        	driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "w");
	            System.out.println("Closed the  '"+ pagetitle +"' Tab now ...");
	            Thread.sleep(2000);
	        }
	    }

	  //  driver.switchTo().window(mainwindow);
	 }
	
	
	public void SwitchTabByTitle(String tabName)
	{
	    Set <String> windows = driver.getWindowHandles();
	    //String mainwindow = driver.getWindowHandle();
	    

	    for (String handle: windows)
	    {
	        driver.switchTo().window(handle);
	        //System.out.println("switched to "+ driver.getTitle()+"  Window");
	        String pagetitle = driver.getTitle();
	        if(pagetitle.equalsIgnoreCase(tabName))
	        {
	           // driver.close();
	            System.out.println("Switch to  '"+ pagetitle +"' Tab now ...");
	            return;
	        }
	  }
	}
	
	
	public boolean VerifyTextAppearInWL(WebElement el, String text) throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", el);
		
		String ActualText = el.getText();
		//Assert.assertTrue("Text not found!", bodyText.contains(text));
		try {
			if (ActualText.contains(text)){
				System.out.println(el + ": " + text +" - Text in web element successfully found");
				return true;
			}
			else
			{
				System.out.println("Text in web element was not found");
				return false;
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to verify Text");
			e.printStackTrace();
			
		}
		return false;
	}

	
	public boolean VerifyTextNotAppearInWL(WebElement el, String text) throws InterruptedException
	{
		
		String ActualText = el.getText();
		//Assert.assertTrue("Text not found!", bodyText.contains(text));
		try {
			if (ActualText.contains(text)){
				System.out.println(el + ": " + text +" - Text in web element unsuccessfully found");
				return false;
			}
			else
			{
				System.out.println("text in web element successfully Not found");
				return true;
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to verify Text");
			e.printStackTrace();
			
		}
		return false;
	}
	
	public void writeTextToTargetFile(String input, List <WebElement> List) throws IOException
	{
		//Create File In D: Driver.  
		  String TestFile = input; //"D:\\temp.txt";
		  File FC = new File(TestFile);//Created object of java File class.
		 
		  try {
		  FC.createNewFile();//Create file.
		  
		  //Writing In to file.
		  //Create Object of java FileWriter and BufferedWriter class.
		  FileWriter FW = new FileWriter(TestFile);
		  BufferedWriter BW = new BufferedWriter(FW);
		  
		  int i = 1;
			for (WebElement results: List){ 
				BW.write(i + ": "+ results.getText());
				BW.newLine();
				i+=1;
			}
		  BW.close();
		  
		  }
		  catch (IOException e) {
			  e.printStackTrace();
		
			}
	}
	
}
