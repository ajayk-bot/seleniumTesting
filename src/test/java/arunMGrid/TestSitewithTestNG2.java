package arunMGrid;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import arunMGridBase.BaseTest;

public class TestSitewithTestNG2 extends BaseTest{

	@Test
	public void TestB() throws InterruptedException {
		System.out.println("started TestB()");
		try {
			openBrowser("firefox");
			Thread.sleep(5000);
			driver.get("https://www.amazon.in/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.out.println("Ended TestB()");
	}
	
	
}
