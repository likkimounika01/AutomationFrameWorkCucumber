package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.accelerators.BaseTest;
import com.automation.pages.DownloadPage;
import com.automation.pages.SeleniumHomePage;

import dev.failsafe.internal.util.Assert;

public class DownloadFileExample extends BaseTest {
	
	@Test
	
	public void verifyDownloadWindowsIE() throws InterruptedException {
		
		DownloadPage downloadPage=new DownloadPage(driver);
		downloadPage.downloadFile();
		Thread.sleep(20000);
		Assert.isTrue(downloadPage.isFileDownloaded(System.getProperty("user.dir")+"\\TestData", "behave-rest-master.zip"), "file downloaded");
	}
	

}
