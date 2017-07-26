package com.hot.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Welcome extends Base{

	public Welcome(WebDriver driver) {
		super(driver);
		 PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@title='Create an ePly account']")
	private WebElement weCreateAccount;
	
	public void CreateAccount(){
		clickWebElement(weCreateAccount);
		boolean isExist = driver.findElement(By.xpath("//h1[contains(text(),'Start Your Free Trial Account')]")).isDisplayed();
		Assert.assertTrue(isExist);
	}

}
