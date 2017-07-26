package com.automation.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import com.automation.utils.Utils;




public class Homepage extends BasePage{


	@FindBy(css="#s-header")
	WebElement sHeader;

	@FindBy(css=".search-button")
	WebElement sButton;
	
	@FindBy(css="#menu-item-56>a")
	WebElement sTitle;


	public Homepage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void searchSite(String expectedTxt){
		fillText(sHeader, expectedTxt);
		sHeader.submit();
		Utils.Sleep(2000);
		SearchResults sr = new SearchResults(driver);
		//Assert.assertTrue(sr.VerifyResultsAppear(expectedTxt));
		Assert.assertTrue(sr.VerifyResultsAppear(expectedTxt), "Search was not found");
		//Assert.assertEquals(sr.VerifyResultsAppear(expectedTxt), true);
		driver.navigate().back();
		Utils.Sleep(2000);
		
	}

	public void searchSiteOpenPage(String expectedTxt) throws InterruptedException{
	Assert.assertTrue(VerifyTextAppearInWL(sTitle, expectedTxt));
	}

}



