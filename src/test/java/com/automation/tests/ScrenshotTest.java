package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.accelerators.BaseTest;
import com.automation.pages.AlertPage;
import com.automation.pages.GooglePage;

public class ScrenshotTest extends BaseTest{
	
	@Test(priority = 0)
	public void validateScreenshot()
	{
		GooglePage googlePage = new GooglePage(driver);
		googlePage.searchElement("Selenium");
		driver.navigate().refresh();
		googlePage.searchElement("Selenium");
		googlePage.getScreenshot(driver);
	}

}
