package seleniumGridTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testParallelTesting {
	WebDriver driver;

	@Test(priority = 1)
	public void setUp() throws MalformedURLException {
		// driver = new ChromeDriver();

		String nodeURL = "http://localhost:4444/";
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.ANY);
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
		
		driver = new RemoteWebDriver(new URL(nodeURL), cap);
	}
	@Test(priority = 2)
	public void performOnChrome() {
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(priority = 3)
	public void doSearchOnGoogle() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("SeleniumHqsite");
		Thread.sleep(5000);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

		String actual = driver.findElement(By.xpath("//h3[contains(text(),'SeleniumHQ Browser Automation')]"))
				.getText();
		Thread.sleep(5000);
		Assert.assertEquals(actual, "SeleniumHQ Browser Automation");

	}

	@Test(priority = 4)
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
