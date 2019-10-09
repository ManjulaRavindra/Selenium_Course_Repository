package com.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest_OHRM_App {
	
	public WebDriver driver;
	public String url = null;
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rgondyala\\workspace\\WebApplicationTesting\\DriverFiles\\chromedriver.exe");
		driver=new ChromeDriver();
		url="https://opensource-demo.orangehrmlive.com";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
