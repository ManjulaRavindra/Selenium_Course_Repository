package com.JavaSamplePgms;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
public class SamplePgm {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./FIrstJavaPgm/DriverFiles/chromedriver.exe");
		WebDriver driver=null;
		String url="http://amazon.in";
		driver=new ChromeDriver();
		System.out.println(url);
		driver.get(url);

	}

}
