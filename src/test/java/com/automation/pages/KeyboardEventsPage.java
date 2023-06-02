package com.automation.pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.accelerators.BasePage;

public class KeyboardEventsPage extends BasePage {
	@FindBy(id="currentAddress")
	private WebElement txtAreaCurrentAdd;
	@FindBy(id="permanentAddress")
	private WebElement txtAreaPermanetAdd;
	public KeyboardEventsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void enterCurrentAddress() {
		clickElement(txtAreaCurrentAdd);
		txtAreaCurrentAdd.sendKeys("Chicago is the city of illonis state");
		txtAreaCurrentAdd.sendKeys(Keys.CONTROL);
		txtAreaCurrentAdd.sendKeys("A");
		txtAreaCurrentAdd.sendKeys(Keys.CONTROL);
		txtAreaCurrentAdd.sendKeys("C");
		txtAreaCurrentAdd.sendKeys(Keys.TAB);
		txtAreaPermanetAdd.sendKeys(Keys.CONTROL);
		txtAreaPermanetAdd.sendKeys("V");
	}

}
