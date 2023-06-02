package com.automation.accelerators;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;


import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public boolean isElementPresent(WebElement ele) {
		boolean isDisplayed=false;
		try {
			ele.isDisplayed();
			isDisplayed = true;
		}
		catch (Exception e) {
			return isDisplayed;
		}
		return isDisplayed;
	}
	

	public void clickElement(WebElement element)
	{

		element.click();
	}

	public void enterText(WebElement element, String textToEnter)
	{
		element.sendKeys(textToEnter);
	}

	/**
	 * Method to select a value from drop down
	 * @param element Select web Element
	 * @param valueToSelect
	 */
	public void selectValueFromDropDown(WebElement element, String selectType, String valueToSelect)
	{
		Select select=new Select(element);
		switch (selectType) {
		case "ByVisibleText":
			select.selectByVisibleText(valueToSelect);
			break;
		case "ByIndex":
			select.selectByIndex(Integer.parseInt(valueToSelect));
			break;
		case "ByValue":
			select.selectByValue(valueToSelect);
			break;

		default:
			select.selectByVisibleText(valueToSelect);			
			break;
		}
	}
	/***
	 * Method to get text of an element
	 * @param element
	 */

	public String getElementText(WebElement element)
	{
		return element.getText();
	}
	/***
	 * Method to get an switch the alert box
	 * @param driver
	 * @param action to select the action 
	 * @param enterText enter the value
	 */
	public void handleAletrs(WebDriver driver,String actionType,String ...enterText)
	{
		switch (actionType) {
		case "accept":
			driver.switchTo().alert().accept();
			break;
		case "dismiss":
			driver.switchTo().alert().dismiss();
		case "sendkeys":
			if(enterText.length>0)
				driver.switchTo().alert().sendKeys(enterText[0]);		
		default:
			driver.switchTo().alert().accept();
			break;
		}
	}
	/***
	 * Method to Switch the other frame
	 * @param driver
	 * @param type
	 * @param idOrName
	 */

	public void switchToFrame(WebDriver driver, String type, String idOrName) {

		switch (type) {
		case "index":
			driver.switchTo().frame(Integer.parseInt(idOrName));
			break;
		case "nameOrId":
			driver.switchTo().frame(idOrName);
			break;
		case "webelement":
			driver.switchTo().frame(idOrName);
			break;

		default:
			driver.switchTo().frame(Integer.parseInt(idOrName));	
			break;
		}

	}
	/***
	 * waiting for element using fluent wait
	 * @param driver
	 * @param element
	 * @param time
	 */
	public void fluentWaitForAnElement(WebDriver driver, WebElement element, int time) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(time))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void waitForAnElement(WebDriver driver, WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/***
	 * Method to get current window handle
	 * @param driver
	 * @return
	 */
	public String getCurrentWindow(WebDriver driver) {
		return driver.getWindowHandle();
	}

	/***
	 * Method to switch to Child window
	 * @param driver
	 * @param parentWindow
	 */
	public void switchToWindow(WebDriver driver, String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for(String currentWindow:allWindows) {
			if(!currentWindow.equals(parentWindow)) {
				driver.switchTo().window(currentWindow);
			}
		}
	}
	public void mouseActions(WebDriver driver, String actionType, WebElement element)
	{
		Actions action=new Actions(driver);
		switch (actionType) {
		case "click":
			action.click(element).build().perform();
			break;
		case "mouseHover":
			action.moveToElement(element).build().perform();
			break;
		case "doubleClick":
			action.doubleClick(element).build().perform();;
			break;
		case "holdButton":
			action.clickAndHold(element).build().perform();;
			break;
		case "rightClick":
			action.contextClick(element).build().perform();;
			break;

		default:
			break;
		}

	}
	public void jsClick(WebDriver driver, WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	public void scrollToBottomOfPage(WebDriver driver)
	{
		((JavascriptExecutor) driver).executeScript("window.scroll(0,document.body.scrollHeight)");
	}
	public void scrollToElement(WebDriver driver,WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",element);
	}
	public void scrollByCoordinates(WebDriver driver)
	{
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
	}

	public String getCssValues(WebElement element,String cssType)
	{
		return element.getCssValue(cssType);

	}
	public String getAtttributeValues(WebElement element,String attributeName)
	{
		return element.getAttribute(attributeName);

	}

	public String getTableCellData(WebDriver driver,WebElement tableEle,String rowName, String columnName) {
		int rowNum=0; int colNum=0;

		List<WebElement>tableRows  = tableEle.findElements(By.xpath("//tr"));

		for(int i=0;i<tableRows.size();i++) {
			if( tableRows.get(i).getText().contains(rowName)) {
				rowNum=i;
				break;
			}
		}

		List<WebElement>tableHeaders  = tableEle.findElements(By.xpath("//tr//th"));

		for(int k=0;k<tableHeaders.size();k++) {

			if(tableHeaders.get(k).getText().equalsIgnoreCase(columnName)) {
				colNum=k;
			}
		}





		return "";
	}

	public boolean isFileDownloaded(String dirPath, String fileName) {
		boolean isDownloaded = false;
		File dFile = new File(dirPath);
		File[] dirContents  = dFile.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if(dirContents[i].getName().equals(fileName)) {
				isDownloaded = true;
				break;
			}
		}


		return isDownloaded;


	}
	public void handleCheckOrRadioButton(WebDriver driver, WebElement ele)
	{
		if(ele.isSelected()  ) {

		}
		else {
			ele.click();
		}
	}
	//Keyboard events can be handled in 3 ways one is 
	//SendKeys
	//Robot 
	//Actions
	public void handleKeyEvents()
	{
          
	}
	
	public void getScreenshot(WebDriver driver)
	{
		File scFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scFile, new File(System.getProperty("user.dir")+"/Reports/Screenshots/screen1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public String getPdfContext(String pdfUrl) {
		PDFTextStripper pdfTextStripper;
		PDDocument pdDoc;
		COSDocument cosDocument;
		String parsedText=null;
		
		try {
			URL url = new URL(pdfUrl);
			BufferedInputStream bfi = new BufferedInputStream(url.openStream());
			pdDoc = PDDocument.load(bfi);			
			pdfTextStripper = new PDFTextStripper();
			pdfTextStripper.setStartPage(1);
			pdfTextStripper.setEndPage(2);
			parsedText= new PDFTextStripper().getText(pdDoc);
			System.out.println("parsed text***"+parsedText);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return parsedText;
		
	}
}	








