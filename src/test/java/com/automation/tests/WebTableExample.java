package com.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.accelerators.BaseTest;
import com.automation.pages.WebTablePage;

public class WebTableExample extends BaseTest{
	
	@Test
	public void verifyWebTable()
	{
		WebTablePage webTablePage=new WebTablePage(driver);
		webTablePage.handleWebTable();
	}
	

}
