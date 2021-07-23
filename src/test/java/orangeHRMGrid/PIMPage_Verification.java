package orangeHRMGrid;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import arunMGridBase.BaseTest;
import utility.ExcelOperations;

//   https://www.selenium.dev/exceptions/#invalid_selector_exception.html

public class PIMPage_Verification extends BaseTest{

	

	

	@BeforeClass
	public void setUp() throws MalformedURLException {
		//System.setProperty("webdriver.chrome.driver",
			//	System.getProperty("user.dir") + "\\src\\test\\resources\\execuatables\\chromedriver.exe");
		openBrowser("chrome");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
		// Login Here
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

	}

	// verify when user click on PIM the user land on employees list page
	// verify the list of Menu is working as expected
	// verify the menu Under COnfiguration Mneu

	@Test(priority = 1,enabled = false)
	public void verifyMenusOnPIMPage() {

		driver.findElement(By.cssSelector("#menu_pim_viewPimModule")).click();
		String actual_EmployeeInfo = driver.findElement(By.xpath("//h1[contains(text(),'Employee Information')]"))
				.getText();
		System.out.println("Expected label: " + actual_EmployeeInfo);
		Assert.assertEquals(actual_EmployeeInfo, "Employee Information");

		// verify ToggleForm were click on Employee Information it will expand and hide
		System.out.println("Before click On Employee info ");

		System.out.println(driver.findElement(By.cssSelector("#searchBtn")).isDisplayed());
		driver.findElement(By.xpath("//a[contains(text(),'>')]")).click();

		System.out.println("After click On Employee info ");
		System.out.println(driver.findElement(By.cssSelector("#searchBtn")).isDisplayed());

	}

	/* Method to find out the broken links */
	public void verifyLinksIsActiveOrBad(String linkUrl) {

		try {
			URL url = new URL(linkUrl);

			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();

			if (httpURLConnect.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}

			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_NOT_FOUND);
			}

		} catch (Exception e) {
			System.out.println("---caught the exception here---");
		}
	}

	// Method for generate FirstName
	public static String generateDynamicFirstName(int n) {

		String AlphaNumericFirstName = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789"; // + "abcdefghijklmnopqrstuvxyz";
		System.out.println(AlphaNumericFirstName.length());
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericFirstName.length() * Math.random());
			sb.append(AlphaNumericFirstName.charAt(index));
		}
		return sb.toString();
	}

	// Method for generate middleName
	public static String generateDynamicMiddleName(int n) {
		String AlphaNumericMiddleName = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789"; // + "abcdefghijklmnopqrstuvxyz";
		System.out.println(AlphaNumericMiddleName.length());
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericMiddleName.length() * Math.random());
			sb.append(AlphaNumericMiddleName.charAt(index));
		}
		return sb.toString();
	}

	// Method for generate lastName
	public static String generateDynamicLastName(int n) {
		String AlphaNumericLastName = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789"; // + "abcdefghijklmnopqrstuvxyz";
		System.out.println(AlphaNumericLastName.length());
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericLastName.length() * Math.random());
			sb.append(AlphaNumericLastName.charAt(index));
		}
		return sb.toString();
	}

	// Method for generate FirstName
	public static String generateDynamicEmployeeID(int n) {

		String AlphaNumericEMpID = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789"; // + "abcdefghijklmnopqrstuvxyz";
		System.out.println(AlphaNumericEMpID.length());
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericEMpID.length() * Math.random());
			sb.append(AlphaNumericEMpID.charAt(index));
		}
		return sb.toString();
	}

	/* verified all Menus of PIM page */

	@Test(priority = 2,enabled = false)
	public void verifyAllMenusOnPIMPage() {
		driver.findElement(By.cssSelector("#menu_pim_viewPimModule")).click();
		List<WebElement> listOfPIMmenus = driver
				.findElements(By.cssSelector("li.current.main-menu-first-level-list-item > ul"));
		List<String> menuslist = new ArrayList<String>();
		// print the Menus
		for (WebElement webElement : listOfPIMmenus) {
			String m = webElement.getText();
			menuslist.add(m);
		}

		System.out.println("Menus Under PIMPage : " + menuslist);

		// code for COnfiguration Menu
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.cssSelector("#menu_pim_Configuration"))).perform();
		List<WebElement> listConfigMenu = driver
				.findElements(By.cssSelector("li.current.main-menu-first-level-list-item >ul > li"));
		List<String> configList = new ArrayList<String>();

		for (WebElement webElement : listConfigMenu) {
			configList.add(webElement.getText());
		}
		System.out.println("Menus Under PIMPage :" + configList);

		// write the code here to verify menus under PIM is working or not.

		// Lets test the Status code for this links are broken or not
		List<WebElement> collect = driver
				.findElements(By.cssSelector("li.current.main-menu-first-level-list-item > ul > li > a"));
		for (int i = 0; i < collect.size(); i++) {
			WebElement ele = collect.get(i);
			// System.out.println(ele.getAttribute("href"));
			String url = ele.getAttribute("href");
			verifyLinksIsActiveOrBad(url);

		}

	}

	//Data Driven approach here
	ExcelOperations excel = new ExcelOperations("LoginTest");
	
	@Test(priority = 3,dataProvider = "dataForPIMPage")
	public void verifyAddEmployee(Object obj1) throws InterruptedException {
		
		HashMap<String, String> hm = (HashMap<String, String>) obj1;
		System.out.println(hm);
		driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
		driver.findElement(By.cssSelector("#btnAdd")).click();
		//driver.findElement(By.cssSelector("#firstName")).sendKeys(generateDynamicFirstName(7));
		//driver.findElement(By.cssSelector("#middleName")).sendKeys(generateDynamicMiddleName(7));
		//driver.findElement(By.cssSelector("#lastName")).sendKeys(generateDynamicLastName(7));
		//driver.findElement(By.cssSelector("#employeeId")).sendKeys(generateDynamicEmployeeID(5));
		
		//getting data from excel here using hashMap
		driver.findElement(By.cssSelector("#firstName")).sendKeys(hm.get("first_name"));
		driver.findElement(By.cssSelector("#middleName")).sendKeys(hm.get("middle_name"));
		driver.findElement(By.cssSelector("#lastName")).sendKeys(hm.get("last_name"));
		driver.findElement(By.cssSelector("#employeeId")).sendKeys(hm.get("employee_id"));
		

		// driver.findElement(By.cssSelector("#photofile")).click(); //click will lead
		// you to error
		// learn AutoIT here also today target
		WebElement chooseFIle = driver.findElement(By.cssSelector("#photofile"));
		chooseFIle.sendKeys(
				"E:\\NewIDEEclipse\\NewIDEWorkspace\\seleniumGridTesting\\src\\test\\resources\\dummyFolder\\download.jpg");
		driver.findElement(By.cssSelector("#btnSave")).click();
		driver.findElement(By.cssSelector("#btnSave")).click();
		driver.findElement(By.cssSelector("#personal_txtOtherID")).sendKeys(hm.get("other_id"));
		driver.findElement(By.cssSelector("#personal_txtLicenNo")).sendKeys(hm.get("driver's_license_no"));
		driver.findElement(By.cssSelector("#personal_txtLicExpDate")).click();
		System.out.println(hm.get("license_expiry_date"));
		//driver.findElement(By.cssSelector("#personal_txtLicExpDate")).sendKeys(hm.get("license_expiry_date"));
		
		driver.findElement(By.cssSelector("#personal_optGender_1")).click();
		
		
		System.out.println("Martial status:"+hm.get("marital_status"));
		Select sc2 = new Select(driver.findElement(By.cssSelector("#personal_cmbMarital")));
		sc2.selectByValue(hm.get("marital_status"));
		
		System.out.println("Nationality:"+hm.get("nationality"));
		Select sc3 = new Select(driver.findElement(By.cssSelector("#personal_cmbNation")));
		sc3.selectByValue(hm.get("nationality"));
		//sc3.selectByVisibleText(null)
		//driver.findElement(By.cssSelector("#personal_DOB")).click();
		//driver.findElement(By.cssSelector("#personal_DOB")).clear();
		//driver.findElement(By.cssSelector("#personal_DOB")).sendKeys(hm.get("date_of_birth"));
		
		driver.findElement(By.cssSelector("#btnSave")).click();
	}

	@DataProvider(name="dataForPIMPage")
	public Object[][] dataSupplier() throws Exception {
		Object[][] obj = new Object[excel.getRowCount()][1];
		
		for (int i = 1; i <= excel.getRowCount(); i++) {
			HashMap<String, String> testdata =  excel.getTestDataInMap(i);
			obj[i-1][0] = testdata;
		}
		
		
		return obj;
		
	}
		
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
