package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.accelerators.BasePage;

public class AlertPage extends BasePage {
	
	WebDriver driver;
	@FindBy(id="alertButton")
	private WebElement btnClickMe;
	@FindBy(id="confirmButton")
	private WebElement btnClickMeConfirm;
	@FindBy(id="promtButton")
	private WebElement btnClickMePrompt;
	@FindBy(xpath="//input[@id='uploadPicture']")
	private WebElement flChoseFile;
	public AlertPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void handleAlerts(String alertText) {
		clickElement(btnClickMe);
		handleAletrs(driver,"accept");
		driver.switchTo().alert().accept(); //To handle simple Ok alert
		waitForAnElement(driver,btnClickMeConfirm,30);		
		clickElement(btnClickMeConfirm);
		driver.switchTo().alert().dismiss();//To handle cancel alert
		clickElement(btnClickMePrompt);
		handleAletrs(driver,"accept","test");//To handle Text alert
	}
	//Method to choosefile
	public void choseFile(String actionType)
	{
		scrollToElement(driver, flChoseFile);
		mouseActions(driver, "mouseHover", flChoseFile);
		System.out.println(getAtttributeValues(flChoseFile,"title"));
	}

}

