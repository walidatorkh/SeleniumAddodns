package com.hot.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hot.pages.Welcome;
import com.hot.utilities.GeneralUtility;


public class RegressionTC {

	WebDriver driver;
	private static final Logger log = LogManager.getLogger(RegressionTC.class.getName());
	
	@BeforeClass
	public void setUp() throws Exception {	
		driver = GeneralUtility.getWebDriver(GeneralUtility.getProperty("browser2"), GeneralUtility.getProperty("url"));
		log.info("Begin suite 1");
	}

	@Test(priority=1,enabled = true)
	public void testCase1() {
		log.info("Start test Case 1");
		Welcome wel = new Welcome(driver);
		wel.CreateAccount();
		log.info("Finish test  1");
	}
	
	
	@Test(priority=2,enabled = true)
	public void testCase2() {
		log.info("Start test Case 2");
		Welcome wel = new Welcome(driver);
		wel.CreateAccount();
		log.info("Finish test  2");
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		GeneralUtility.tearDown(driver);
		log.info("Finish suite 1");
	}

	

}
