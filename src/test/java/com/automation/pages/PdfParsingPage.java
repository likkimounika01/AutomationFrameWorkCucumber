package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.accelerators.BasePage;

public class PdfParsingPage extends BasePage {
	WebDriver driver;
	@FindBy(xpath="//p//a[contains(@href,'drylab.pdf')]")
	private WebElement lnkPdf;
	public PdfParsingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickPdfLink()
	{
		clickElement(lnkPdf);
	}
}
