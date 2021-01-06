package com.Tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import OOPs_Pages.Abstract_Page;
import OOPs_Pages.BasePage;

public class baseTest1 {
	public static HtmlUnitDriver driver;
	
	public static ExtentTest logger;
	public static ExtentReports report;

	public Abstract_Page page;

	@BeforeClass
	public void CreateReport() {
	String fileName = new SimpleDateFormat("'XeroReport_'YYYYMMddHHmm'.html'").format(new Date());
	String path = "src/test/Resources/Report/ "+ fileName;
	report = new ExtentReports(path);
	}
	@BeforeMethod
	@Parameters(value = { "browser" })
	public void setUp(String browser) throws InterruptedException {

		if (browser.equals("chrome")) {
			//Running in headless mode in chrome browser
			driver=new HtmlUnitDriver(BrowserVersion.CHROME);
		}

		else if (browser.equals("firefox")) {
			
			driver=new HtmlUnitDriver(BrowserVersion.FIREFOX);
		} else
			System.out.println("No browser is difined in textng.xml file");
		
		

		// Launch the URL
		driver.get("https://login.xero.com/");

		Thread.sleep(6000);

		// We cannot create an object of abstract class,so use its child class constructor

		page = new BasePage(driver);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@AfterClass
	public void closReport() {
		report.endTest(logger);
		report.flush(); 
		
	}

}
