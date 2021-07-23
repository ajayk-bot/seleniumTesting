package arunMGrid;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import arunMGridBase.BaseTest;

public class TestSitewithTestNG extends BaseTest{

	@Test
	public void TestA() throws MalformedURLException, InterruptedException {
		System.out.println("started TestA()");
		openBrowser("chrome");
		Thread.sleep(5000);
		driver.get("https://www.flipkart.com/");
		
		System.out.println("Ended TestA()");
	}
	
	
	
	
}
