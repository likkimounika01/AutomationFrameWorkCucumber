package com.automation.tests;


import org.testng.annotations.Test;

import com.automation.accelerators.BaseTest;
import com.automation.pages.PdfParsingPage;

public class PdfParsingTest extends BaseTest {
	@Test
	public void validatePdf() {
		PdfParsingPage pdfParsingPage = new PdfParsingPage(driver);
		pdfParsingPage.clickPdfLink();
		System.out.println(driver.getCurrentUrl());
		pdfParsingPage.getPdfContext(driver.getCurrentUrl());
		
	}

}
