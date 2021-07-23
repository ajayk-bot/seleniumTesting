package orangeHRMGrid;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class DataEntryOrangeHrm {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\execuatables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		// Login Here
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

		driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
		//driver.findElement(By.linkText("User Management")).click();
		//driver.findElement(By.linkText("Users")).click();

//		
//		driver.findElement(By.cssSelector("#btnAdd")).click();
//		
//		//adding data in the fields and click on SAVE
//		Select sel = new Select(driver.findElement(By.cssSelector("#systemUser_userType")));
//		sel.selectByVisibleText("Admin");
//		
//		driver.findElement(By.cssSelector("#systemUser_employeeName_empName")).sendKeys("Kallyani Bhute");
//		driver.findElement(By.cssSelector("#systemUser_userName")).sendKeys("ThinkONDelete111");
//		
//		Select sel2 = new Select(driver.findElement(By.cssSelector("#systemUser_status")));
//		sel2.selectByValue("0");
//		
//		driver.findElement(By.cssSelector("#systemUser_password")).sendKeys("TestIng@12341");
//		driver.findElement(By.cssSelector("#systemUser_confirmPassword")).sendKeys("TestIng@12341");
//		
//		driver.findElement(By.cssSelector("#btnSave")).click();
//						
//		System.out.println(driver.getCurrentUrl());
//		Thread.sleep(8000);
//		// verify the record get added in table.
//		List<WebElement> list =  driver.findElements(By.cssSelector("#resultTable > tbody > tr > td:nth-child(2)"));
//
//		for (WebElement webElement : list) {
//			if (webElement.getText().equals("ThinkONDelete111")) {
//				System.out.println("found in database" + webElement.getText());
//				System.out.println(webElement);
//				System.out.println(webElement.toString());
//				
//			}
//		}
//		
//		
		
		
		int i=1;
		int k=1;
		
		List<WebElement> collectedRow=	driver.findElements(By.xpath("//tbody/tr["+i+"]"));
		List<WebElement> collectCheckedBoxList = 	driver.findElements(By.xpath("//tbody/tr["+i+"]/td["+k+"]"));
	
																//tbody/tr[2]/td[1]
		HashMap<WebElement, WebElement> listofWebelement = new HashMap<WebElement, WebElement>();
			
		
		for (int m = 0; m < collectCheckedBoxList.size(); m++) {
			WebElement ele = collectCheckedBoxList.get(m);
			System.out.println(ele.getText());
			if (ele.getText().equals("Anthony.Nolan")) {
				System.out.println("Enters inside the if loop");
				
				driver.findElements(By.xpath("//tbody/tr["+i+"]"));
				
			}
		}
		
		
		
		
		
		
	
		
		
		
		
		driver.quit();

	}

}
