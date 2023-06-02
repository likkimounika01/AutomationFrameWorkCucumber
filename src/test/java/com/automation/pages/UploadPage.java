package com.automation.pages;

import com.automation.accelerators.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadPage extends BasePage {
WebDriver driver;
    @FindBy(xpath="//input[@id='photo']")
    private WebElement btnChoseFile;

    public UploadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void uploadFile()
    {
        btnChoseFile.sendKeys(System.getProperty("user.dir")+"/TestData/Test.jpg");
    }
    public void uploadFileUsingRobot() throws AWTException {
        Robot robo = new Robot();
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_V);
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyRelease(KeyEvent.VK_V);
        robo.keyPress(KeyEvent.VK_ENTER);
        robo.keyRelease(KeyEvent.VK_ENTER);
    }

    /***
     * Method to set Contents in Clipboard
      * @param content
     */
    public void setContentInClipBoard(String content)
    {
        StringSelection ss = new StringSelection(content);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
    }

    public void clickChoseFileButton(){
        scrollToElement(driver,btnChoseFile);
        jsClick(driver,btnChoseFile);
        //clickElement(btnChoseFile);
    }

}
