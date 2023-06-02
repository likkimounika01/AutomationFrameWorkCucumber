package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.accelerators.BaseTest;
import com.automation.pages.AmazonHomePage;

public class ScrollingExample extends BaseTest {
	
	@Test
	public void verifyJavaScriptClick()
	{
		AmazonHomePage amazonHomePage=new AmazonHomePage(driver);
		amazonHomePage.clickCustomerService();
		Assert.assertTrue(amazonHomePage.isCustomerServiceScreenDisplayed());
	}
	
	@Test
	public void verifyScrollToBottomOfThePage()
	{
		AmazonHomePage amazonHomePage=new AmazonHomePage(driver);
		amazonHomePage.clickAmazonRenewed();
	}
	@Test
	public void verifyScrollToElement()
	{
		AmazonHomePage amazonHomePage=new AmazonHomePage(driver);
		//amazonHomePage.clickSealAllDeals();
		amazonHomePage.scrollByCoordinates(driver);
		
	}
	@Test
	public void verifyCssValues()
	{
		AmazonHomePage amazonHomePage=new AmazonHomePage(driver);
		//amazonHomePage.clickSealAllDeals();
		amazonHomePage.getCssValues();
		
	}
	@Test
	public void verifyAttributeValues()
	{
		AmazonHomePage amazonHomePage=new AmazonHomePage(driver);
		//amazonHomePage.clickSealAllDeals();
		amazonHomePage.getAttibuteValues();
		
	}
	
	

}
