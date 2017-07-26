package com.automation.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.pageObjects.Homepage;

import com.automation.utils.ExcelUtils;
import com.automation.utils.Utils;


public class Sanity {
	WebDriver driver;
	
	
	@BeforeClass
	public void setup(){
		//initiate the driver according to key='browser' in data\config.propoerties file
		driver = Utils.getDriver();
		driver.get(Utils.readProp("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	@Test(priority=1,enabled = true)
	public void searchTextInSite() throws InterruptedException 
		{
		
		Homepage hp = new Homepage(driver);
		hp.searchSiteOpenPage("בודק תוכנה? הקידום שלך לאוטומציה מתחיל כאן");
	}
	

	@DataProvider
	public static Object[][] getDataFromExcel_AdvancedSearch() throws Exception{
		//Excel excel = new Excel();
		String sExcelPath = Utils.readProp("excel");
		String sExcelSheet = Utils.readProp("excelsheet");		
		String workingDir = System.getProperty("user.dir");
		
		return ExcelUtils.getTableArray(workingDir +sExcelPath, sExcelSheet);
	}
	
	
	@AfterClass
	public void tearDown()
	{
		Utils.quiteDriver(driver);
		//System.out.println("Quit driver!");
	}
}
