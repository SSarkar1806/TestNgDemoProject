package GridTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class IEGridTest {

	@Test
	public void testIEGrid() {
		// it is used to define IE capability
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

		capabilities.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

		System.setProperty("webdriver.ie.driver", "C:\\Do not touch it\\Software\\Selenium Jars\\IEDriverServer.exe");

		// it is used to initialize the IE driver
		WebDriver driver = new InternetExplorerDriver(capabilities);

		driver.manage().window().maximize();

		driver.get("http://www.gmail.com/");
		System.out.println(driver.getTitle());

		
		driver.close();
		driver.quit();
	}
}
