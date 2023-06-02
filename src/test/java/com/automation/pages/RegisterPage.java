package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.accelerators.BasePage;
import com.automation.utilities.JsonUtilities;

public class RegisterPage extends BasePage{
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='inputFirstName']")
	 public WebElement txtFirstName;
	
	public void enterFirstName(String firstName) {
		enterText(txtFirstName, firstName);
	}
	@FindBy(xpath="//input[@id='inputLastName']")
	 public WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='inputEmail']")
	public WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@id='inputPhone']")
	public WebElement txtPhoneNumber;
	
	@FindBy(xpath="//input[@id='inputCompanyName']")
	public WebElement txtCompanyName;
	
	@FindBy(xpath="//input[@id='inputAddress1']")
	public WebElement txtStreetAddress;
	
	@FindBy(xpath="//input[@id='inputCity']")
	public WebElement txtcity;
	
	@FindBy(xpath="//input[@id='stateinput']")
	public WebElement txtState;
	
	@FindBy(xpath="//input[@id='inputPostcode']")
	public WebElement txtPostCode;
	
	@FindBy(xpath="//select[@id='inputCountry']")
	public WebElement txtCountry;
	
	@FindBy(xpath="//input[@id='customfield2']")
	public WebElement txtWhatsppNumber;
	
	@FindBy(xpath="//input[@id='inputNewPassword1']")
	public WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='inputNewPassword2']")
	public WebElement txtConfirmPassword;
	
	@FindBy(xpath="//button[contains(text(), 'Generate Password')]")
	public WebElement btnGenratePassword;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement btnRegister;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}




	public void registerUser(JsonUtilities data) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		
		
		enterText(txtFirstName, data.readJson(""));
		enterText(txtLastName, data.readJson(""));
		enterText(txtEmailAddress, data.readJson(""));
		
		
		
		enterText(txtPhoneNumber, data.readJson(""));
		enterText(txtCompanyName, data.readJson(""));
		enterText(txtStreetAddress, data.readJson(""));
		enterText(txtcity, data.readJson(""));
		selectValueFromDropDown(txtCountry,"ByVisibleText",data.readJson("country"));
	}



}
