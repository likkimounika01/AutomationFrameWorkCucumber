package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.accelerators.BasePage;

public class FramesPage extends BasePage{
	WebDriver driver;
	@FindBy(id="sampleHeading")
	private WebElement hdrSamplePage;
	public FramesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void getHeaderText()
	{
		switchToFrame(driver,"nameOrId","frame1");
		String headerText = getElementText(hdrSamplePage);
		System.out.println("Title header"+headerText);
	}
}
