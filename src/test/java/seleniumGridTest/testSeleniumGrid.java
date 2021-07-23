package seleniumGridTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class testSeleniumGrid {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.name("q")).sendKeys("SeleniumHqsite");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

		String actual = driver.findElement(By.xpath("//h3[contains(text(),'SeleniumHQ Browser Automation')]"))
				.getText();
		Assert.assertEquals(actual, "SeleniumHQ Browser Automation");

	}

}



