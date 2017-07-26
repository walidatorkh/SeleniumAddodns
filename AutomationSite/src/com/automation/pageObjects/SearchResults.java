package com.automation.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.utils.Utils;

public class SearchResults extends BasePage {

	@FindBy(css=".page-title")
	WebElement pageTitle;
	boolean fPassFail = false;

	public SearchResults(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean VerifyResultsAppear(String sExpectedText)
	{
		try{
			if(IsObjectExist(pageTitle)){
				//System.out.println("Title of search page is: " + pageTitle.getText());
				Utils.Sleep(2000);
				if (pageTitle.getText().contains("Search Results for: " + sExpectedText))
					return true;
			}
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			throw (e);
		}

		return fPassFail;
	}

}
