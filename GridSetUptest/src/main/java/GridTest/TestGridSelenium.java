package GridTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

public class TestGridSelenium {
	
	@Test
	public void test1() throws MalformedURLException, InterruptedException {
		
		System.setProperty("webdriver.IE.driver", "C:\\Do not touch it\\Software\\Selenium Jars\\IEDriverServer.exe");
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();

		caps.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		caps.setPlatform(Platform.WIN10);
		
		URL url = new URL("http://192.168.100.8:4444/wd/hub");
		WebDriver driver = new RemoteWebDriver(url, caps);
		
		driver.get("https://www.freecrm.com");
		System.out.println("Page Title is : "+driver.getTitle());
		//Thread.sleep(2000);
		
		FreeCRMPageFactory freeCRMPageFactory = PageFactory.initElements(driver, FreeCRMPageFactory.class);
		freeCRMPageFactory.invalidLogIn("test123@freecrm.com","Password123");

		
		
		
		driver.close();
		driver.quit();
		
		
		
	}

}
