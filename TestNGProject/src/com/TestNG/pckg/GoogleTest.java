package com.TestNG.pckg;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class GoogleTest {
	
	
	WebDriver driver;
	DesiredCapabilities caps;
	
	
	
	@BeforeMethod
	public void setUp() {
		// Set system property for Chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SOUVIK\\Downloads\\chromedriver\\chromedriver.exe");
// setting desired capabilities to ignore the browser protected mode settings
		//caps = new DesiredCapabilities();
		//caps.setCapability("ignoreProtectedModeSettings", true);
				
		
		// Launch browser
		//driver = new InternetExplorerDriver(caps);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://google.com");
	}
	
	@Test
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	@Test
	public void googleLogoTest() {
		WebElement googleLogo = driver.findElement(By.xpath("(//div[@id = 'main']//a)[1]/img"));
		boolean isLogoDisplayed = googleLogo.isDisplayed();
		
		AssertJUnit.assertTrue(isLogoDisplayed);
	}
	
	@Test
	public void searchTest() {
		WebElement searchBx = driver.findElement(By.xpath("//input[@title = 'Search']"));
		searchBx.sendKeys("Google AI");
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	

}
