package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.accelerators.BasePage;

public class SeleniumHomePage extends BasePage {
	WebDriver driver;
	@FindBy(xpath="//a[contains(text(),'32 bit Windows IE')]")
	private WebElement lnkDownloadWindowsIE;
	public SeleniumHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void downloadFile()
	{
		clickElement(lnkDownloadWindowsIE);
	}
}
