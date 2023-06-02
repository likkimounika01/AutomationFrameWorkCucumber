package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.accelerators.BaseTest;
import com.automation.pages.AlertPage;

public class MouseActions extends BaseTest
{
	@Test
	public void verifyAlerts()
	{
		AlertPage alertPage=new AlertPage(driver);
		alertPage.handleAlerts(jsonUtilities.readJson("promptTextName"));
		
	}
	@Test
	public void verifyChoseFile()
	{
		AlertPage alertPage=new AlertPage(driver);
		alertPage.choseFile("mouseHover");
		
		
	}
	
}
