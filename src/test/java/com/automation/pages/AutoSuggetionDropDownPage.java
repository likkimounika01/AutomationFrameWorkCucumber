package com.automation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.accelerators.BasePage;

public class AutoSuggetionDropDownPage extends BasePage {
	
	WebDriver driver;
    @FindBy(xpath="//textarea[@name='q']")
    private WebElement txtGoogleSearch;
    
    @FindBy(xpath="//div[@class='lnnVSe']/div[@class='wM6W7d']/span")
    private List<WebElement> autoSuggestedOptions;
    
    public AutoSuggetionDropDownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

}
    /***
     * 
     * @param keyword
     * @param value
     */
    
    public void handleSelectAutoSuggestion(String keyword, String value) {
    	txtGoogleSearch.sendKeys(keyword);
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Not suggestable
    	//fluentWaitForAnElement(driver, autoSuggestedOptions.get(0), 30);
    	waitForAnElement(driver, autoSuggestedOptions.get(0), 30);    	
    	for (int i = 0; i < autoSuggestedOptions.size(); i++) {
			if(autoSuggestedOptions.get(i).getText().contains(value)){
				autoSuggestedOptions.get(i).click();
				break;
			}
		}
    
    }
    }
    

