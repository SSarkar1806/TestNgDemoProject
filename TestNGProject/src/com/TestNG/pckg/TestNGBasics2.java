package com.TestNG.pckg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

public class TestNGBasics2 {
	
	/*
	 * PRECONSITIONS for TEST 
	 * 	@BeforeSuite -- Set Up system property for chrome
		@BeforeTest -- Launch Chrome Browser
		@BeforeClass -- Log in
		
		TEST CASEs
		
		@BeforeMethod -- Enter URL
		@Test 2 -- Check google Logo
		@AfterMethod -- Log out
		
		@BeforeMethod -- Enter URL
		@Test 3 -- Check google Search
		@AfterMethod -- Log out
		
		@BeforeMethod -- Enter URL
		@Test 1 -- Check google title
		@AfterMethod -- Log out
		
		POSTCONSTIONS for TEST
		
		@AfterClass -- Close Browser
		@AfterTest -- Delete all cookies
	 * 
	 */
	

	@BeforeMethod
	@BeforeSuite // 1
	public void setUp() {
		System.out.println("@BeforeSuite -- Set Up system property for chrome");
	}

	
	@BeforeTest// 2
	public void launchBrowser() {
		System.out.println("@BeforeTest -- Launch Chrome Browser");
	}

	@BeforeClass// 3
	public void logIn() {
		System.out.println("@BeforeClass -- Log in");
	}

	@BeforeMethod // 4
	public void enterURL() {
		System.out.println("@BeforeMethod -- Enter URL");
	}

	@Test // 5
	public void googleTitleTest() {
		System.out.println("@Test 1 -- Check google title");
	}
	
	@Test // 5
	public void googleLogoTest() {
		System.out.println("@Test 2 -- Check google Logo");
	}
	
	@Test // 5
	public void googleSearchTest() {
		System.out.println("@Test 3 -- Check google Search");
	}

	@AfterMethod //6
	public void logOut() {
		System.out.println("@AfterMethod -- Log out");
	}
	
	@AfterClass //7
	public void closeBrowser() {
		System.out.println("@AfterClass -- Close Browser");
	}

	@AfterTest //8
	public void deleteAllCookies() {
		System.out.println("@AfterTest -- Delete all cookies");
	}
		
	@AfterSuite //9
	public void generateTestReport() {
		System.out.println("@AfterSuite -- Generate Test Report");
	}

}
