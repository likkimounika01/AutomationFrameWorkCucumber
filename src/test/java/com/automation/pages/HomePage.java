package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.accelerators.BasePage;

public class HomePage extends BasePage {

	@FindBy(xpath="//a[contains(text(),'Sign Up') and contains(@class,'dynamic')]")
	private WebElement btnSignUp;


	public void clickSignUp() {
		clickElement(btnSignUp);
	}


	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


}
