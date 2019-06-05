package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	static WebDriver driver;

	public static WebDriver startBrowser(String browserName, String uRL) {
		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\\\Users\\\\SOUVIK\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("No valid driver is present");
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(uRL);

		return driver;

	}

}
