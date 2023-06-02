package com.automation.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListners implements ITestListener{
	
	@Override	
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started");
	
	}
	
	@Override	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Sucess");
		System.out.println(result.getName());
	 }
	
	@Override	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed");
		System.out.println(result.getName());
		
	 }
	
	

}
