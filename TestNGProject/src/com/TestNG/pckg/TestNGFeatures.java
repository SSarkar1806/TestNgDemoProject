package com.TestNG.pckg;

import org.testng.annotations.Test;
import org.testng.annotations.*;

public class TestNGFeatures {
	
	@Test
	public void test1() {
		System.out.println("This is Testcase1");
	}
	
	@Test(dependsOnMethods="test1")
	public void test2() {
		System.out.println("This is Testcase2");
	}

}
