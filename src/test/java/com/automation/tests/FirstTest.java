package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.accelerators.BaseTest;

public class FirstTest extends BaseTest{
	
	@Test
	public void firstTestMethod() {
		System.out.println("opened URL");
		System.out.println(jsonUtilities.readJson("userName"));
	}
	
	
}
