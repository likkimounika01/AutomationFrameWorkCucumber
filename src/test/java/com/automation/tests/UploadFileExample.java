package com.automation.tests;

import com.automation.accelerators.BaseTest;
import com.automation.pages.UploadPage;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;


public class UploadFileExample extends BaseTest {

	@Test
	public void verifyFileUpload() throws AWTException

	{
		UploadPage uploadPage=new UploadPage(driver);
		// uploadPage.uploadFile();
		uploadPage.clickChoseFileButton();
		uploadPage.setContentInClipBoard(System.getProperty("user.dir")+"/TestData/Test.jpg");
		uploadPage.uploadFileUsingRobot();
	}
	@Test
	public void fileUploadUsingAutoIt() throws IOException
	{
		UploadPage uploadPage=new UploadPage(driver);
		// uploadPage.uploadFile();
		uploadPage.clickChoseFileButton();
		Runtime.getRuntime().exec("C:\\Users\\14087\\Desktop\\FileUpload.exe");
	}
	}

