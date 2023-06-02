package com.automation.pages;


import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.accelerators.BasePage;

import dev.failsafe.internal.util.Assert;

public class BrokenLinksPage  extends BasePage{
	WebDriver driver;

	@FindBy(xpath="//a")
    private List<WebElement> lnkAll;

    public BrokenLinksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	public void validateInvaildLinks()
	{
		int validLinks = 0;
		for(WebElement ele : lnkAll) {
			String url = getAtttributeValues(ele, "href");
			if(url!=null) {
				validLinks++;				
				Assert.isTrue(verifyLinks(url)==200, "", "");
			}
		}
		
		
	}
	
	
	public int verifyLinks(String link) {
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet getRequest = new HttpGet(link);
		try {
			HttpResponse response = httpClient.execute(getRequest);
			return response.getCode();				
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
		
		
		
	}

}
