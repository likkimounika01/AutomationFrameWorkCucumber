package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.accelerators.BasePage;

public class GooglePage extends BasePage {
	WebDriver driver;
	@FindBy(xpath="//textarea[@class='gLFyf']")
	private WebElement txtGoogleSearch;
	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void searchElement(String searchValue)
	{
		enterText(txtGoogleSearch, searchValue);
	}

}
