package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.accelerators.BasePage;

public class WindowsPage extends BasePage {
	WebDriver driver;
	@FindBy(id="windowButton")
	private WebElement btnNewWindow;
	@FindBy(id="sampleHeading")
	private WebElement txtSampleHeading;
	public WindowsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	public void handleWindows()
	{
		String parentWindow = getCurrentWindow(driver);
		clickElement(btnNewWindow);
		switchToWindow(driver, parentWindow);
		System.out.println(getElementText(txtSampleHeading));
	
	}
	
}
