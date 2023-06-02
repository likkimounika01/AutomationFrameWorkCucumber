package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.accelerators.BaseTest;
import com.automation.pages.AlertPage;
import com.automation.pages.FramesPage;
import com.automation.pages.WindowsPage;

public class AlertFramesWindows extends BaseTest {
	@Test
	public void verifyAlerts()
	{
		AlertPage alertPage=new AlertPage(driver);
		alertPage.handleAlerts(jsonUtilities.readJson("promptTextName"));
		
	}
	
	@Test
	public void verifyFrames()
	{
		FramesPage framesPage=new FramesPage(driver);
		framesPage.getHeaderText();
	}
	
	@Test
	public void verifyWindows()
	{
		WindowsPage windowsPage=new WindowsPage(driver);
		windowsPage.handleWindows();
	}
	
}
