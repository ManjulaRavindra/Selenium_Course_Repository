package com.ScreenShots;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTours_ScreenShot_HomePageLinks {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rgondyala\\workspace\\WebApplicationTesting\\DriverFiles\\chromedriver.exe");
		WebDriver driver=null;		
		driver=new ChromeDriver();
		String url="http://newtours.demoaut.com/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		List<WebElement>LinkName=driver.findElements(By.tagName("a"));
		int TotalHomePageLinksCount=LinkName.size();
		System.out.println("Total number of links on Home Page are : "+TotalHomePageLinksCount);
		for(int i=0;i<TotalHomePageLinksCount;i++){
			String LinkText=LinkName.get(i).getText();
					LinkName.get(i).click();
			File ScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(ScreenShot, new File("./ScreenShots/"+LinkText+".png"));
			driver.navigate().back();
			LinkName=driver.findElements(By.tagName("a"));
		}
	}

}
