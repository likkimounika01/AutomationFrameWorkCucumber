package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.accelerators.BaseTest;
import com.automation.pages.KeyboardEventsPage;

public class KeyBoardEvents extends BaseTest{
	
	
	@Test
	
	public void verifyPermenetAddress()
	{
		KeyboardEventsPage keyBoardEventsPage=new KeyboardEventsPage(driver);
		keyBoardEventsPage.enterCurrentAddress();
	}
}
