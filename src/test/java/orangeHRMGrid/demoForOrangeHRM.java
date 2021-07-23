package orangeHRMGrid;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class demoForOrangeHRM {


	//   
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		//Login Here
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		//check user is on landing page
		 List<WebElement> listEle  =  driver.findElements(By.cssSelector("div.quickLaunge>a>span"));
		 for (WebElement webElement : listEle) {
			System.out.println(webElement.getText());
		}
		 
		 System.out.println("----------------------------");
		 
		
		 for (WebElement webElement :  driver.findElements(By.cssSelector("#mainMenuFirstLevelUnorderedList > li > a > b"))) {
			System.out.println(webElement.getText());
		}
		 
		driver.close();
		
	}
}
