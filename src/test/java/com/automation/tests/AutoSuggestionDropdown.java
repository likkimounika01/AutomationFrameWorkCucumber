package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.accelerators.BaseTest;
import com.automation.pages.AutoSuggetionDropDownPage;
import com.automation.pages.BrokenLinksPage;

public class AutoSuggestionDropdown extends BaseTest{
	

	@Test
	public void verifyAutoCompleteText()
	{
		excelUtilities.getCellValues();
		AutoSuggetionDropDownPage autoSuggetionDropDownPage=new AutoSuggetionDropDownPage(driver);
		autoSuggetionDropDownPage.handleSelectAutoSuggestion("a","amazon");
		//excelUtilities.getCellValues();
		
		
	} 

}
