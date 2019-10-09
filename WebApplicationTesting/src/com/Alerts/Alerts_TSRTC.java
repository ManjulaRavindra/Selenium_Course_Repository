package com.Alerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts_TSRTC {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rgondyala\\workspace\\WebApplicationTesting\\DriverFiles\\chromedriver.exe");
		WebDriver driver=null;
		String url="http://demo.guru99.com/test/delete_customer.php";
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//Thread.sleep(10000);
		
		driver.findElement(By.name("cusid")).sendKeys("2112");
		driver.findElement(By.name("submit")).click();
		
		Alert alert= driver.switchTo().alert();
		System.out.println("Focus Entered into the alert window");
		String alertMessageText=alert.getText();
		System.out.println(alertMessageText);
		
		alert.accept();
		alert= driver.switchTo().alert();
		alertMessageText=alert.getText();
		System.out.println(alertMessageText);
		alert.accept();
		driver.quit();

	}

}
