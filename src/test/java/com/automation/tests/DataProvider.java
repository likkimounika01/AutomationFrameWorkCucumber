package com.automation.tests;


import org.testng.annotations.Test;

import com.automation.accelerators.BaseTest;

import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;

public class DataProvider extends BaseTest{
	
	@Test(dataProvider = "getData")
	public void dataProvider(String one, String two) {
		
		System.out.println(one);
		System.out.println(two);
	}
	
	@org.testng.annotations.DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[3][2];
		 data[0][0]="Test1";
		 data[0][1]="Test2";
		 data[1][0]="Test3";
		 data[1][1]="Test4";
		 data[2][0]="Test5";
		 data[2][1]="Test6"; 
		 
		 return data;
		
	}
	

}
