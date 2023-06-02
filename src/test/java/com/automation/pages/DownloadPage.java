package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.accelerators.BasePage;

public class DownloadPage extends BasePage{
	WebDriver driver;
    @FindBy(xpath="//span[contains(text(),'Code') and @class='Button-label']/../..")
    private WebElement btnCode;
    @FindBy(xpath="//a[contains(@href ,'/master.zip')]")
    private WebElement lnkDownloadZip;

    public DownloadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

}
    
    public void downloadFile()
    {
    	clickElement(btnCode);
    	clickElement(lnkDownloadZip);
    }
}
