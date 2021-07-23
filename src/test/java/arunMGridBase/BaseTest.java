package arunMGridBase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {

	public WebDriver driver = null;

	public void openBrowser(String browserName) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		if (browserName.equalsIgnoreCase("chrome")) {

			capabilities.setPlatform(Platform.ANY);
			capabilities.setBrowserName(BrowserType.CHROME);

		} else if (browserName.equalsIgnoreCase("firefox")) {

			capabilities.setPlatform(Platform.ANY);
			capabilities.setBrowserName(BrowserType.FIREFOX);

		} 
//		
//		else if (browserName.equalsIgnoreCase("IE")) {
//
//			capabilities.setPlatform(Platform.ANY);
//			capabilities.setBrowserName(BrowserType.IE);
//
//		} else if (browserName.equalsIgnoreCase("Edge")) {
//
//			capabilities.setPlatform(Platform.ANY);
//			capabilities.setBrowserName(BrowserType.EDGE);
//		}
//		

		driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);

	}

	@AfterMethod
	public void tearDownBrowser() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	
}
