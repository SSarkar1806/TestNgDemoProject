package GridTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class ChromeGridTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		// Define desired capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		caps.setVersion("");
		caps.setPlatform(Platform.WIN10);
		
		// Chrome Options	
		ChromeOptions options = new ChromeOptions();
		options.merge(caps);
		
		String hubUrl = "http://192.168.100.8:4444/wd/hub";
		
		WebDriver driver = new RemoteWebDriver(new URL(hubUrl),options);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.close();
		driver.quit();
		

	}

}
