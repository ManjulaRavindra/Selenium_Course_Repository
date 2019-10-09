package com.DropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shine_Mobile_STDCodes_DropDown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rgondyala\\workspace\\WebApplicationTesting\\DriverFiles\\chromedriver.exe");
		WebDriver driver=null;
		String url="https://shine.com/";
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement Register= driver.findElement(By.linkText("Register Free"));
		Register.click();
		WebElement Mobile_STD_Code=driver.findElement(By.id("id_country_code"));
		List<WebElement>Mobile_STD_Codes_Values=Mobile_STD_Code.findElements(By.tagName("option"));
		int Mobile_STD_Codes_Values_Count = Mobile_STD_Codes_Values.size();
		
		System.out.println(Mobile_STD_Codes_Values_Count);
		
		for(int i=0;i<Mobile_STD_Codes_Values_Count;i++)
		{
			System.out.println(i+""+Mobile_STD_Codes_Values.get(i).getText());
		}
		driver.quit();
	}
	
}
