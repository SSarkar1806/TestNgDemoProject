package com.TestNG.pckg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import org.testng.annotations.BeforeClass;

public class TestNGBasics {
	WebDriver driver;
	
	
	
	@BeforeSuite
	public void beforeSuiteMethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SOUVIK\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Suite is about to execute");
	}
	@BeforeClass
	public void launchBrowser() {
		System.out.println("You are about to launch the browser");
		
	}
	@BeforeMethod
	public void enterURL() {
		System.out.println("Launch the URL");
	}
	
	@BeforeTest
	public void login() throws InterruptedException {
		System.out.println("You are logging in");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void quitBrowser() {
		
		
		System.out.println("Browser is closed");
	}
	@Test
	public void test1() {
		System.out.println("You are executing testcase1");
		driver.get("https://google.com");
		AssertJUnit.assertEquals(driver.getTitle(), "Google");
		System.out.println("testcase1 execution is completed");
		System.out.println("  ");
		
	}

	
	@Test
	public void test2() {
		System.out.println("You are executing testcase2");
		driver.get("https://gmail.com");
		AssertJUnit.assertEquals(driver.getTitle().contains("Gmail"),"Gmail");
		System.out.println("testcase2 execution is completed");
		System.out.println("  ");
		
	}
	@AfterClass
	public void closeBrowser() {
		System.out.println("You are about to close the browser");
		driver.quit();
	}
	
	
	
	
	
	
	
	

}
