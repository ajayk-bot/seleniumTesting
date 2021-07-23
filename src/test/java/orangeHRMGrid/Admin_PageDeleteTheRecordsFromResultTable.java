package orangeHRMGrid;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import arunMGridBase.BaseTest;

public class Admin_PageDeleteTheRecordsFromResultTable extends BaseTest {
	//WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		//System.setProperty("webdriver.chrome.driver",
				//System.getProperty("user.dir") + "\\src\\test\\resources\\execuatables\\chromedriver.exe");
		//driver = new ChromeDriver();
		openBrowser("firefox");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
		// Login Here
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

	}

	public WebElement getCheckboxToDeleteTheRecords(String passUserName) throws InterruptedException {
		int q = 1;
		int r = 1;
		Thread.sleep(8000);
		int totalnumOfRow = driver.findElements(By.xpath("//tbody/tr")).size();
		int totalnumOfColumn = driver.findElements(By.xpath("//tbody/tr[1]/td")).size();
		System.out.println("Total row: " + totalnumOfRow);
		System.out.println("Total column : " + totalnumOfColumn);

		for (q = 1; q < totalnumOfRow; q++) {
			for (r = 1; r < totalnumOfColumn + 1; r++) {
				WebElement getlist = driver.findElement(By.xpath("//tbody/tr[" + q + "]/td[" + r + "]"));
				System.out.println("-------------------");
				System.out.println(getlist);
				System.out.println("getList Printed here: " + getlist.getText());
				String nameOfrecord = getlist.getText();
				System.out.println("Value of R: " + r);

				if (nameOfrecord.equals(passUserName)) {
					System.out.println("inside if loop");
					System.out.println(getlist);
					WebElement ele = driver.findElement(By.xpath("//tbody/tr[" + q + "]/td[1]"));
					System.out.println(ele);

					return ele;

				}

			}
		}
		System.out.println("Added user is not found");
		return null;

	}

	
	public static String generateDynamicUserName(int n) {

		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789"; // + "abcdefghijklmnopqrstuvxyz";

		System.out.println(AlphaNumericString.length());

		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));

		}
		return sb.toString();

	}
	
	
	@Test
	public void verifyDeleterecords() throws InterruptedException {

		driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();

		// adding records in resultset
		driver.findElement(By.cssSelector("#btnAdd")).click();
		// adding data in the fields and click on SAVE
		Select sel = new Select(driver.findElement(By.cssSelector("#systemUser_userType")));
		sel.selectByVisibleText("Admin");

		String user_Name = generateDynamicUserName(8);
		driver.findElement(By.cssSelector("#systemUser_employeeName_empName")).sendKeys("Aaliyah Haq");
		driver.findElement(By.cssSelector("#systemUser_userName")).sendKeys(user_Name);

		Select sel2 = new Select(driver.findElement(By.cssSelector("#systemUser_status")));
		sel2.selectByValue("0");

		driver.findElement(By.cssSelector("#systemUser_password")).sendKeys("IamNotPreset@12341");
		driver.findElement(By.cssSelector("#systemUser_confirmPassword")).sendKeys("IamNotPreset@12341");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#btnSave")).click();
		Thread.sleep(5000);
		// code to find record present in recordset
		List<WebElement> list = driver.findElements(By.cssSelector("#resultTable > tbody > tr > td:nth-child(2)"));
		for (WebElement webElement : list) {
			if (webElement.getText().equals(user_Name)) {
				System.out.println("Added employee found in database : " + webElement.getText());
				// System.out.println(webElement);
				// System.out.println(webElement.toString());

			}
		}

		// code to delete the records
		WebElement checked_box = getCheckboxToDeleteTheRecords(user_Name);
		System.out.println("geting return element " +checked_box);
		
		checked_box.click();
		System.out.println("clcik oon checkBox");
		driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
		System.out.println("clcik oon Delete");
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("#dialogDeleteBtn")).click();
		String getprintedmsgonDialog = driver.findElement(By.xpath("//p[contains(text(),'Delete records?')]")).getText();
		System.out.println(getprintedmsgonDialog);
		System.out.println("clcik oon dialogDelete");


	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
