package com.wordpress.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import helper.BrowserFactory;

public class WordPressLogIntest {
	WebDriver driver;

	@Test
	public void checkValidUser() {
		try {
			driver = BrowserFactory.startBrowser("chrome", "https://wordpress.com/log-in");
			Thread.sleep(2000);
			LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.logIn("Test@123gmail.com");
			Thread.sleep(2000);

			Assert.assertEquals(loginPage.userNameErrorMsg.getText(), "User does not exist.");

		} catch (Exception e) {
			System.out.println("test case failed due to Exception: " + e.getMessage());
		} finally {
			driver.quit();
		}

	}
}
