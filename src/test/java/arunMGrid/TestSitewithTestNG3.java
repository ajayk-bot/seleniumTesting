package arunMGrid;

import java.net.MalformedURLException;
import java.sql.Driver;

import org.testng.annotations.Test;

import arunMGridBase.BaseTest;

public class TestSitewithTestNG3 extends BaseTest{

	@Test
	public void TestC() throws InterruptedException {
		System.out.println("started TestC()");
		try {
			openBrowser("chrome");
			Thread.sleep(5000);
			driver.get("https://www.google.com/");
		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.out.println("Ended Testc()");
		
		
		
	}
	
	

	}
	
	

