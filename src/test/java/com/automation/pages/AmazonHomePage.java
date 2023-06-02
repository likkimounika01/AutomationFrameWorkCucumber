package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.accelerators.BasePage;

public class AmazonHomePage extends BasePage{
	WebDriver driver;
	@FindBy(xpath="//a[contains(@href,'customerservice')]")
	private WebElement lnkCustomerService;
	@FindBy(xpath="//a[contains(@href,'usrenew')]")
	private WebElement lnkAmazonRenewed;
	@FindBy(xpath="//div[@class='a-cardui-footer']//a[contains(text(),'See all deals')]")
	private WebElement lnkSeeAllDeals;
	@FindBy(xpath="//h1[contains(text(),'Service')]")
	private WebElement txtCustomerService;
	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickCustomerService(){
		jsClick(driver, lnkCustomerService);
	}
	//test
	public boolean isCustomerServiceScreenDisplayed() {
	return	isElementPresent(txtCustomerService);
	}

	public void clickAmazonRenewed(){
		waitForAnElement(driver,lnkAmazonRenewed,20);
		scrollToBottomOfPage(driver);
		jsClick(driver, lnkAmazonRenewed);
	}
	public void clickSealAllDeals(){
		waitForAnElement(driver,lnkSeeAllDeals,20);
		scrollToElement(driver,lnkSeeAllDeals);
		jsClick(driver, lnkSeeAllDeals);
	}
	public void getCssValues() {
		System.out.println(getCssValues(lnkAmazonRenewed, "color"));
		System.out.println(getCssValues(lnkAmazonRenewed, "font-size"));
		System.out.println(getCssValues(lnkAmazonRenewed, "font-weight"));
	}
	public void getAttibuteValues() {
		System.out.println(getAtttributeValues(lnkAmazonRenewed, "href"));
	}
}
