package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.accelerators.BasePage;

public class WebTablePage extends BasePage{
	WebDriver driver;
	@FindBy(xpath="//p[contains(text(),'so it looks like ')]/preceding-sibling::table")
	private WebElement tblEmployee;
	
	
	public WebTablePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void handleWebTable()
	{
		getTableCellData(driver,tblEmployee,"Steve","City");
	}
	
	
	

}
