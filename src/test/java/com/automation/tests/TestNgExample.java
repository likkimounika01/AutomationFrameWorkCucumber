package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.accelerators.BaseTest;

public class TestNgExample extends BaseTest{

	@Test(priority = 1)
	public void test1() {
		System.out.println("test1");
	}
	@Test
	public void test2() {
		System.out.println("test2");
	}
	@Test(priority = 2)
	public void test3() {
		System.out.println("test3");
	}

}
