package com.wordpress.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "usernameOrEmail")
	WebElement userName;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Continue']")
	WebElement submitButton;
	
	@FindBy(how = How.XPATH, using = "//*[text()='User does not exist.']")
	WebElement userNameErrorMsg;

	// Method to log in to the site
	public void logIn(String eMail) {
		userName.sendKeys(eMail);
		submitButton.click();

	}

}
