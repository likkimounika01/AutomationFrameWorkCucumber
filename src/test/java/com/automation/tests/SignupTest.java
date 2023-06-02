package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.accelerators.BaseTest;
import com.automation.pages.HomePage;
import com.automation.pages.RegisterPage;

public class SignupTest extends BaseTest {
	@Test
	public void verifySignup()
	{
       HomePage homePage=new HomePage(driver);
       homePage.clickSignUp();
       RegisterPage registerpage=new RegisterPage(driver);
       //registerpage.enterFirstName(jsonUtilities.readJson("firstName"));
       registerpage.registerUser(jsonUtilities);
	}
}
