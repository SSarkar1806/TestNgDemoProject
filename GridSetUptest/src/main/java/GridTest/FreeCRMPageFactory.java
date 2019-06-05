package GridTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FreeCRMPageFactory {
	WebDriver driver;

	public FreeCRMPageFactory(WebDriver driver) {
		this.driver = driver;
	}
	// login button
	@FindBy(how = How.XPATH, using = "//span[.='Log In']/ancestor::a")
	WebElement logInButton;

	// email text box
	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	WebElement emailTxtBx;

	// password text box
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	WebElement passwordTxtBx;
	
	//login form submt button
	@FindBy(how=How.XPATH,using="//div[text()='Login']")
	WebElement logInSubmitBtn;
	
	// Invaid login error message
	@FindBy(how=How.XPATH,using ="//p[.='Invalid login']")
	WebElement invalidLogInMsg;

// wait for an element to be appear
	public void waitForElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	


	// check if such element is present
	public boolean isElementPresent(WebElement ele) {
		try {
			waitForElement(ele);
			boolean isPresent = ele.isDisplayed();

			if (isPresent) {
				System.out.println("Element is displayed");
			} else {
				System.out.println("Element is not displayed");
			}
			return isPresent;
			
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
		
		return false;

	}

	// method to login button with invalid credentials
	public void invalidLogIn(String eMail, String password) {
		
		// click on log in button to enable the email and password field
		if(isElementPresent(logInButton)) {
			logInButton.click();
		}else {
			System.out.println("Login Button is not displayed");
		}
		
		// enter email and password
		if(isElementPresent(emailTxtBx)) {
			emailTxtBx.clear();
			emailTxtBx.sendKeys(eMail);
			if(isElementPresent(passwordTxtBx)) {
				passwordTxtBx.clear();
				passwordTxtBx.sendKeys(password);
			}else {
				System.out.println("password text box is not displayed");
			}
		}else {
			System.out.println("Email text box is not displayed");
		}
		
		if(isElementPresent(logInSubmitBtn)) {
			logInSubmitBtn.click();
		}else {
			System.out.println("Login submit button is not displayed");
		}
		
		assertEquals(invalidLogInMsg.getText(), "Invalid login");
		
	}

}
