package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.accelerators.BaseTest;
import com.automation.pages.AlertPage;
import com.automation.pages.BrokenLinksPage;

public class BrokenLinkExample extends BaseTest{
	
	@Test
	public void verifyBrokenLinks()
	{
		BrokenLinksPage brokenLinksPage=new BrokenLinksPage(driver);
		brokenLinksPage.validateInvaildLinks();
		
		
	}

}
